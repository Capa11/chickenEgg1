package Texture;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Utility class that allows transparent reading of files from
 * the current working directory or from the classpath.
 * Works with JOGL 2.6+ and modern Java versions.
 * @author Pepijn
 */
public class ResourceRetriever {

    public static URL getResource(final String filename) throws IOException {
        // Try to load resource from the application's classpath
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        URL url = cl.getResource(filename);

        // If not found in jar, then load from file system
        if (url == null) {
            if (Files.exists(Paths.get(filename))) {
                return Paths.get(filename).toUri().toURL();
            }
            throw new IOException("Resource not found: " + filename);
        }
        return url;
    }

    public static InputStream getResourceAsStream(final String filename) throws IOException {
        // Try to load resource from the classpath
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        InputStream stream = cl.getResourceAsStream(filename);

        // If not found in jar, try reading from disk
        if (stream == null) {
            if (Files.exists(Paths.get(filename))) {
                return new FileInputStream(filename);
            }
            throw new IOException("Resource not found: " + filename);
        }
        return stream;
    }
}
