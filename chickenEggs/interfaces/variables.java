package chickenEggs.interfaces;
import javax.media.opengl.GL;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import java.io.IOException;

import Texture.TextureReader;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.objects.Pages.CustomScreen;

public abstract class variables implements GLEventListener {
    public static Page runningPage;
    public static float xtranslation=0,ytranslation=0;
    public static float xmouse=1000,ymouse=500;
    public static float lastMouseX, lastMouseY;
    public static boolean dragging = false;
    public static float convertX(float x, float width) {
        return -xaxis + (x / width) * xaxis *2;
    }

    public static float convertY(float y, float height) {
        return (1 - y / height) * yaxis *2- yaxis;
    }
    public static GL gl;
    public static float xaxis =1000;
    public static float yaxis =600;
    public static boolean Operations = true;
    public static boolean isGameRunning=true;
    public static boolean showCoolEffect = false;
    public boolean winning=false;
    private static drawable[] youWin;
    private static drawable[] youLose;

    //paths
    private static String folderalphabet = "chickenEggs//Assets//Alphabet//";
    private static String foldermonster = "chickenEggs//Assets//monsters//";
    private static String folderchicken = "chickenEggs//Assets//chickenEggObjects//";
    private static String folderIcons = "chickenEggs//Assets//Icons//";


    private static String[] inumbers = {"0.png", "1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png", "9.png"};
    private static String[] iman = {"Man1.png", "Man2.png", "Man3.png", "Man4.png","back.png"};
    private static String[] iletters = {"a.png", "b.png", "c.png", "d.png", "e.png", "f.png", "g.png", "h.png", "i.png", "j.png", "k.png", "l.png", "m.png", "n.png", "o.png", "p.png", "q.png", "r.png", "s.png", "t.png", "u.png", "v.png", "w.png", "x.png", "y.png", "z.png","blank.png"};
    private static String[] ihealth = {"HealthB.png", "Health.png"};
    //private static String[] ibackgrounds= {"Back.png",};
    private static String[] inumbers2 = {"tile000.png", "tile001.png", "tile002.png", "tile003.png", "tile004.png", "tile005.png", "tile006.png", "tile007.png", "tile008.png", "tile009.png"};
    private static String[] imonsters = {"1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png", "9.png", "10.png", "11.png", "12.png", "13.png", "14.png", "15.png", "16.png", "17.png", "18.png", "19.png", "20.png", "21.png", "22.png", "23.png", "24.png", "25.png", "26.png", "27.png", "28.png", "29.png", "30.png", "31.png", "32.png", "33.png", "34.png", "35.png", "36.png", "37.png", "38.png", "39.png", "40.png"};
    private static String[] ibaskets = {"basket1.png","basket2.png","basket3.png","basket4.png"};
    private static String[] iegg = {"egg.png"};
    private static String[] ichicken = {"OrdinaryChicken.png","UnordinaryChicken.png","SuperChicken.png","UltimateChicken.png"};
    private static String[] iconsCustom ={"add1.png","add2.png","minus1.png","minus2.png","right1.png","right2.png","left1.png","left2.png"};

    //texters
    public static int[] numbers = new int[inumbers.length];
    public static int[] man = new int[iman.length];
    public static int[] Letters = new int[iletters.length];
    public static int[] health = new int[ihealth.length];
    //public static int[] background = new int[backgrounds.length];
    public static int[] numbers2 = new int[inumbers2.length];
    public static int[] monsters = new int[imonsters.length];
    public static int[] baskets = new int[ibaskets.length];
    public static int[] egg = new int[iegg.length];
    public static int[] chicken = new int[ichicken.length];
    public static int[] icons = new int[iconsCustom.length];



    protected static  void init(GL gl) {
        gl.glOrtho( -xaxis, xaxis, -yaxis, yaxis,-1.0, 1.0);
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f); // This Will Clear The Background Color To White
        gl.glEnable(GL.GL_TEXTURE_2D); // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        prepareimage(folderalphabet,inumbers,numbers,gl);
        prepareimage(folderalphabet,iletters,Letters,gl);
        prepareimage(folderalphabet,ihealth,health,gl);
        //prepareimage(folderalphabet,ibackninjastarDigitsDotBlank,backninjastarDigitsDotBlank,gl);
        prepareimage(folderalphabet,inumbers2,numbers2,gl);
        prepareimage(foldermonster,imonsters,monsters,gl);
        prepareimage(folderalphabet,iman,man,gl);
        prepareimage(folderchicken , iegg , egg , gl);
        prepareimage(folderchicken , ichicken , chicken , gl);
        //____________________________
        prepareimage(folderchicken,ibaskets,baskets,gl);
        prepareimage(folderIcons,iconsCustom,icons,gl);




    }



    private static void prepareYouWin(int y){
        youWin = new drawable[6];
        for (int i = 0; i < 6; i++) {
            youWin[i] = new drawable();
        }
        youWin[0].path=Letters['y' - 'a'];
        youWin[1].path=Letters['o' - 'a'];
        youWin[2].path=Letters['u' - 'a'];
        youWin[3].path=Letters['w' - 'a'];
        youWin[4].path=Letters['i' - 'a'];
        youWin[5].path=Letters['n' - 'a'];
        initGrid(youWin,-xaxis,xaxis,y,250,250,0,0);
    }
    private static void prepareYouLose(int y){
        youLose=new drawable[7];
        for (int i = 0; i < 7; i++) {
            youLose[i] = new drawable();
        }
        youLose[0].path=Letters['y' - 'a'];
        youLose[1].path=Letters['o' - 'a'];
        youLose[2].path=Letters['u' - 'a'];
        youLose[3].path=Letters['l' - 'a'];
        youLose[4].path=Letters['o' - 'a'];
        youLose[5].path=Letters['s' - 'a'];
        youLose[6].path=Letters['e' - 'a'];
        initGrid(youLose,-xaxis,xaxis,y,250,250,0,0);
    }
    private static void prepareimage(String firstpath,String[] path,int[] textures,GL gl){
        TextureReader.Texture[] texture = new TextureReader.Texture[path.length];
        gl.glGenTextures(path.length,textures ,0);
        for (int i = 0; i < path.length; i++) {
            try {
                texture[i] = TextureReader.readTexture(firstpath+path[i], true);
                gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);
                new GLU().gluBuild2DMipmaps(
                        GL.GL_TEXTURE_2D,
                        GL.GL_RGBA,
                        texture[i].getWidth(),
                        texture[i].getHeight(),
                        GL.GL_RGBA,
                        GL.GL_UNSIGNED_BYTE,
                        texture[i].getPixels()
                );
            } catch (IOException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }

    }
    //x center y center
    public static void DrawSprite(int x, int y, int w, int h, int texture) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, texture); // Turn Blending On

        gl.glPushMatrix();
        gl.glTranslated(x, y, 0);
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2f(0.0f, 0.0f);gl.glVertex3f(-w/2.0f, -h/2.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);gl.glVertex3f(w/2.0f, -h/2.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);gl.glVertex3f(w/2.0f, h/2.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);gl.glVertex3f(-w/2.0f, h/2.0f, -1.0f);

        gl.glEnd();gl.glPopMatrix();gl.glDisable(GL.GL_BLEND);
    }
    public static void drawArray(drawable[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i].draw();
        }
    }
    public static void initGrid(drawable[] arr, float xs, float xf, float ys, int w, int h, int gapX, int gapY){
        initGridindex(arr,xs,xf,ys,w,h,gapX,gapY,0,arr.length-1);
    }
    public static void initGridindex(drawable[] arr, float xs, float xf, float ys, int w, int h, int gapX, int gapY,int sind,int eind){
        int maxEx= Math.min((int) ((xf-xs)/(w+gapX)),eind-sind+1);
        float xEmpty=(xf-xs)-((w*maxEx)+gapX*(maxEx-1));
        float start=xEmpty/2.0f+xs+w/2.0f;
        ys-=h/2.0;
        xs=start;
        int i=sind;
        int c=0;
        while(i<= eind) {
            arr[i].x= (int) xs;
            arr[i].y= (int) ys;
            arr[i].w=w;
            arr[i].h=h;
            if(++c==maxEx){
                ys-=h+gapY;
                xs=start;
                c=0;
            }
            else xs+=gapX+w;
            i++;
        }
    }

    //numbers and letters(no caps) and blank only in string all words must satisfy the width given
    //method is theta(n)
    public static drawable[] initwriteString(String str, float xs, float xf, float ys, int w, int h, int gapY){
        char[] s = str.toCharArray();
        drawable[] arr = new drawable[s.length];
        float lastxf=xs;
        for (int i = 0; i < s.length;) {
            int j = i,starting = i;
            while ( j < s.length&&s[j]!=' '){j++;}
            if(j == s.length)j--;
            while(i<=j) {
                arr[i] = new drawable();
                if (s[i] == ' ') arr[i].path = Letters[Letters.length - 1];
                else if (s[i] <= '9' && s[i] >= '0') arr[i].path = numbers[s[i] - '0'];
                else arr[i].path = Letters[s[i] - 'a'];
                i++;
            }
            if(xf-lastxf>=(j-starting+1)*w){
                initGridindex(arr,lastxf,lastxf+(j-starting+1)*w,ys,w,h,0,gapY,starting,j);
            }
            else {
                lastxf=xs;
                System.out.println(lastxf);
                ys-=h+gapY;
                initGridindex(arr,lastxf,lastxf+(j-starting+1)*w,ys,w,h,0,gapY,starting,j);

            }
            lastxf=arr[j].x+w/2;
        }
        return arr;
    }

    static boolean isYouWinPrepared=false;
    static boolean isYouLosePrepared=false;

    public static void youWin(int y){
        if(!isYouWinPrepared) {
            prepareYouWin(y);
            isYouWinPrepared=true;
        }
       drawArray(youWin);
    }
    public static void youLose(int y){
        if(!isYouLosePrepared) {
            prepareYouLose(y);
            isYouLosePrepared=true;
        }
        prepareYouLose(y);
        drawArray(youLose);
    }
    public static void rectangle(int x1,int y1,int x2,int y2){
        gl.glBegin(GL.GL_QUADS);
        gl.glVertex2d(x1,y1);
        gl.glVertex2d(x1,y2);
        gl.glVertex2d(x2,y2);
        gl.glVertex2d(x2,y1);
        gl.glEnd();
    }
    public static void circle(int x,int y,int r){
        gl.glBegin(9);
        for (int i = 0; i < 360; i++) {
            gl.glVertex2d(x+r*Math.cos(Math.toRadians(i)),y+r*Math.sin(Math.toRadians(i)));
        }
        gl.glEnd();
    }
}
