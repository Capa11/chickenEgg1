package Texture;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.io.InputStream;

/**
 * Windows bitmap file loader.
 * Works safely with JOGL 2.6+ and modern Java.
 * @author Abdul
 * @author Pepijn
 */
public class BitmapLoader {

    public static BufferedImage loadBitmap(String file) throws IOException {
        try (InputStream input = ResourceRetriever.getResourceAsStream(file)) {
            int bitmapFileHeaderLength = 14;
            int bitmapInfoHeaderLength = 40;

            byte[] bitmapFileHeader = new byte[bitmapFileHeaderLength];
            byte[] bitmapInfoHeader = new byte[bitmapInfoHeaderLength];

            readBuffer(input, bitmapFileHeader);
            readBuffer(input, bitmapInfoHeader);

            int nWidth = bytesToInt(bitmapInfoHeader, 4);
            int nHeight = bytesToInt(bitmapInfoHeader, 8);
            int nBitCount = bytesToShort(bitmapInfoHeader, 14);
            int nSizeImage = bytesToInt(bitmapInfoHeader, 20);
            int nColoursUsed = bytesToInt(bitmapInfoHeader, 32);

            if (nBitCount == 24) {
                return read24BitBitmap(nSizeImage, nHeight, nWidth, input);
            } else if (nBitCount == 8) {
                return read8BitBitmap(nColoursUsed, nBitCount, nSizeImage, nWidth, nHeight, input);
            } else {
                throw new IOException("Unsupported BMP format (only 8 or 24-bit supported): " + nBitCount);
            }
        }
    }

    private static BufferedImage read8BitBitmap(int nColoursUsed, int nBitCount, int nSizeImage, int nWidth, int nHeight, InputStream input) throws IOException {
        int nNumColors = (nColoursUsed > 0) ? nColoursUsed : (1 & 0xff) << nBitCount;

        if (nSizeImage == 0) {
            nSizeImage = ((((nWidth * nBitCount) + 31) & ~31) >> 3) * nHeight;
        }

        int[] npalette = new int[nNumColors];
        byte[] bpalette = new byte[nNumColors * 4];
        readBuffer(input, bpalette);
        int nindex8 = 0;

        for (int n = 0; n < nNumColors; n++) {
            npalette[n] = (255 & 0xff) << 24 |
                    (bpalette[nindex8 + 2] & 0xff) << 16 |
                    (bpalette[nindex8 + 1] & 0xff) << 8 |
                    (bpalette[nindex8] & 0xff);
            nindex8 += 4;
        }

        int npad8 = (nSizeImage / nHeight) - nWidth;
        BufferedImage bufferedImage = new BufferedImage(nWidth, nHeight, BufferedImage.TYPE_INT_ARGB);
        DataBufferInt dataBuffer = (DataBufferInt) bufferedImage.getRaster().getDataBuffer();
        int[] bankData = dataBuffer.getData();
        byte[] bdata = new byte[(nWidth + npad8) * nHeight];
        readBuffer(input, bdata);

        nindex8 = 0;
        for (int j8 = nHeight - 1; j8 >= 0; j8--) {
            for (int i8 = 0; i8 < nWidth; i8++) {
                bankData[j8 * nWidth + i8] = npalette[bdata[nindex8] & 0xff];
                nindex8++;
            }
            nindex8 += npad8;
        }

        return bufferedImage;
    }

    private static BufferedImage read24BitBitmap(int nSizeImage, int nHeight, int nWidth, InputStream input) throws IOException {
        int npad = (nSizeImage / nHeight) - nWidth * 3;
        if (npad < 0) npad = 0;
        int nindex = 0;

        BufferedImage bufferedImage = new BufferedImage(nWidth, nHeight, BufferedImage.TYPE_4BYTE_ABGR);
        DataBufferByte dataBuffer = (DataBufferByte) bufferedImage.getRaster().getDataBuffer();
        byte[] bankData = dataBuffer.getData();
        byte[] brgb = new byte[(nWidth + npad) * 3 * nHeight];
        readBuffer(input, brgb);

        for (int j = nHeight - 1; j >= 0; j--) {
            for (int i = 0; i < nWidth; i++) {
                int base = (j * nWidth + i) * 4;
                bankData[base] = (byte) 255;
                bankData[base + 1] = brgb[nindex];
                bankData[base + 2] = brgb[nindex + 1];
                bankData[base + 3] = brgb[nindex + 2];
                nindex += 3;
            }
            nindex += npad;
        }

        return bufferedImage;
    }

    private static int bytesToInt(byte[] bytes, int index) {
        return (bytes[index + 3] & 0xff) << 24 |
                (bytes[index + 2] & 0xff) << 16 |
                (bytes[index + 1] & 0xff) << 8 |
                (bytes[index] & 0xff);
    }

    private static short bytesToShort(byte[] bytes, int index) {
        return (short) (((bytes[index + 1] & 0xff) << 8) | (bytes[index] & 0xff));
    }

    private static void readBuffer(InputStream in, byte[] buffer) throws IOException {
        int bytesRead = 0;
        while (bytesRead < buffer.length) {
            int read = in.read(buffer, bytesRead, buffer.length - bytesRead);
            if (read < 0) throw new IOException("Unexpected end of file while reading BMP");
            bytesRead += read;
        }
    }
}
