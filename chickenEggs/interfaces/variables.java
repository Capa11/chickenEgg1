package chickenEggs.interfaces;
import javax.media.opengl.GL;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.sound.sampled.*;


import Texture.TextureReader;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.objects.Pages.CustomScreen;

public abstract class variables implements GLEventListener {
    //sounds
    public static float globalVolume = 0.9f; // Default volume set to 90%
    private static String soundsPath="chickenEggs//Assets//Sounds//";
    public static String[] isounds = {"gameover.wav","button.wav","fire1.wav","fire2.wav","fire3.wav","respawn.wav","DeadChickenSoundEffect.wav"};
    public static Sound[] sounds=new Sound[isounds.length];
    public static void preparingSounds() {
        for (int i = 0; i < sounds.length; i++) {
            sounds[i]= Sound.loadFromFile(soundsPath+isounds[i]);
        }
    }
    public static int[] player1Controller={KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_RIGHT,KeyEvent.VK_LEFT,KeyEvent.VK_SPACE};//only for single play death match
    public static int[] player2Controller={KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_RIGHT,KeyEvent.VK_LEFT,KeyEvent.VK_SPACE};
    public static int[] player3Controller={KeyEvent.VK_W,KeyEvent.VK_S,KeyEvent.VK_D,KeyEvent.VK_A,KeyEvent.VK_V};
    public static int[] player4Controller={KeyEvent.VK_O,KeyEvent.VK_L,KeyEvent.VK_SEMICOLON,KeyEvent.VK_K,KeyEvent.VK_M};
    public static String[] arr = new String[5];
    public static BitSet controllerBits = new BitSet(256);
    public static ArrayList<String[]> controllers=new ArrayList<>(4);
    public static File scoreBoard = new File("chickenEggs//Assets//scoreboard.txt");
    public static Page runningPage;
    public static float xtranslation=0,ytranslation=0;
    public static float xmouse=1000,ymouse=500;
    public static BitSet keyBits = new BitSet(256);
    public static float lastMouseX, lastMouseY;
    public static boolean dragging = false;
    public static float convertX(float x, float width) {
        return -xaxis + (x / width) * xaxis *2;
    }

    public static float convertY(float y, float height) {
        return (1 - y / height) * yaxis *2- yaxis;
    }
    public static int playerController = 1;
    public static GL gl;
    public static float xaxis =1000;
    public static float yaxis =600;
    public static boolean Operations = true;
    public static boolean action = false;
    public static boolean isGameRunning=true;
    public static boolean showCoolEffect = false;
    public boolean winning=false;
    private static drawable[] youWin;
    private static drawable[] youLose;

    public static int numPlayers =1;
    public static int numHuman =1;
    public static int numAi =0;
    public static String level ="easy";




    //paths
    private static String[] ikeyboard={"0.png", "1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png", "9.png","","","","","","","","a.png", "b.png", "c.png", "comma.png", "comma-lt.png", "context-menu.png", "ctrl.png", "ctrl-2.png", "cursor-down.png", "cursor-left.png", "cursor-right.png", "cursor-up.png", "d.png", "delete.png", "e.png", "end.png", "enter.png", "equals-plus.png", "esc.png", "f.png", "f1.png", "f2.png", "f3.png", "f4.png", "f5.png", "f6.png", "f7.png", "f8.png", "f9.png", "f10.png", "f11.png", "f12.png", "g.png", "h.png", "home.png", "i.png", "insert.png", "j.png", "k.png", "keypad-0.png", "keypad-1.png", "keypad-2.png", "keypad-3.png", "keypad-4.png", "keypad-5.png", "keypad-6.png", "keypad-7.png", "keypad-8.png", "keypad-9.png", "keypad-asterix.png", "keypad-enter.png", "keypad-minus.png", "keypad-period.png", "keypad-plus.png", "keypad-slash.png", "l.png", "locks.png", "m.png", "minus.png", "n.png", "num-lock.png", "o.png", "p.png", "page-down.png", "page-up.png", "pause.png", "period-gt.png", "power.png", "print.png", "q.png", "r.png", "s.png", "scroll-lock.png", "semicolon-dble.png", "shift.png", "shift-right.png", "slash-questionmark.png", "sleep.png", "spacebar.png", "specialkey-2.png", "t.png", "tab.png", "u.png", "v.png", "w.png", "wake-up.png", "x.png", "y.png", "z.png"};
    private static String folderKeyboard="chickenEggs//Assets//AllKeyBoard";
    private static String folderalphabet = "chickenEggs//Assets//Alphabet//";
    private static String folderchicken = "chickenEggs//Assets//chickenEggObjects//";
    private static String folderIcons = "chickenEggs//Assets//Icons//";

    private static String folderbullets = "chickenEggs//Assets//bullets//";
    private static String folderRockets = "chickenEggs//Assets//Rockets//";

    private static final String[] inumbers = {"0.png", "1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png", "9.png"};
    private static final String[] iletters = {"a.png", "b.png", "c.png", "d.png", "e.png", "f.png", "g.png", "h.png", "i.png", "j.png", "k.png", "l.png", "m.png", "n.png", "o.png", "p.png", "q.png", "r.png", "s.png", "t.png", "u.png", "v.png", "w.png", "x.png", "y.png", "z.png", "blank.png"};
    private static final String[] ihealth = {"HealthB.png", "Health.png"};
    //    private static String[] ibackgrounds= {"Back.png"};
    private static final String[] iegg = {"egg.png"};
    private static final String[] ichicken = {"OrdinaryChicken.png", "UnordinaryChicken.png", "SuperChicken.png", "UltimateChicken.png",
            "SuperChicken.png","wingl.png","wingr.png","chickenblack.png",
            "chickenblue.png", "chickengreen.png","chickenred.png","heart.png"};

    private static final String[] iconsCustom = {"add1.png", "add2.png", "minus1.png", "play.png",
            "minus2.png", "right1.png", "right2.png", "left1.png",
            "left2.png", "RocketIcon.png", "instructions.png", "customIcon.png",
            "top3.png" , "settings.png","shield.png","reset.png","lose.png", "win.png","pause.png"};
    private static final String[] ibackground = {"spacee.png", "kindpng_6159643.png",};


    //    private static String[] iconsCustom ={"add1.png","add2.png","minus1.png","minus2.png","right1.png","right2.png","left1.png","left2.png"};
    private static final String[] ibullets = {"bullet1.png"};
    private static final String[] irockets = {"rocket1.png","rocket2.png","rocket3.png", "rocket4.png", "rocket5.png", "rocket6.png"};

    //texters
    public static int[] numbers = new int[inumbers.length];
    public static int[] Letters = new int[iletters.length];
    public static int[] health = new int[ihealth.length];
    //    public static int[] background = new int[ibackgrounds.length];
    public static int[] egg = new int[iegg.length];
    public static int[] chicken = new int[ichicken.length];
    public static int[] icons = new int[iconsCustom.length];

    public static int[] background = new int[ibackground.length];


    public static int[] bullets = new int[ibullets.length];
    public static int[] rockets = new int[irockets.length];



    protected static  void init(GL gl) {
        gl.glOrtho( -xaxis, xaxis, -yaxis, yaxis,-1.0, 1.0);
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f); // This Will Clear The Background Color To White
        gl.glEnable(GL.GL_TEXTURE_2D); // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        prepareimage(folderalphabet, inumbers, numbers, gl);
        prepareimage(folderalphabet, iletters, Letters, gl);
        prepareimage(folderalphabet, ihealth, health, gl);
//        prepareimage(folderalphabet,ibackgrounds,background,gl);
        prepareimage(folderchicken, iegg, egg, gl);
        prepareimage(folderchicken, ichicken, chicken, gl);
        //____________________________
        prepareimage(folderIcons, iconsCustom, icons, gl);

        prepareimage(folderchicken, ibackground, background, gl);


        prepareimage(folderbullets, ibullets, bullets, gl);
        prepareimage(folderRockets, irockets, rockets, gl);

        //prearing sounds;
        preparingSounds();



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
//                System.out.println(e);
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
    public static void DrawSprite(int x, int y, int w, int h, int texture,int rotate) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, texture); // Turn Blending On

        gl.glPushMatrix();
        gl.glTranslated(x, y, 0);
        gl.glRotated(rotate,0,0,1);
        gl.glBegin(GL.GL_QUADS);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-w / 2.0f, -h / 2.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(w / 2.0f, -h / 2.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(w / 2.0f, h / 2.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-w / 2.0f, h / 2.0f, -1.0f);

        gl.glEnd();
        gl.glPopMatrix();
        gl.glDisable(GL.GL_BLEND);
    }

    public static boolean isClickInside() {
        if (lastMouseX <= xaxis && lastMouseX >= -xaxis && lastMouseY <= yaxis && lastMouseY >= -yaxis) {
            return true;
        } else return false;
    }
    public static boolean isMouseInside() {
        if (xmouse <= xaxis && xmouse >= -xaxis && ymouse <= yaxis && ymouse >= -yaxis) {
            return true;
        } else return false;
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
    public static void initGridNoWH(drawable[] arr, float xs, float xf, float ys,float yf, int gapX, int gapY){//no width and height require
        float availableWidth = xf - xs;//right - left
        float availableHeight = ys - yf;//up - down

        int size;
        for ( size = 0; size < 2000; size+=10) {
            int numberOfRows= (int) Math.ceil(((size+gapX)*arr.length)/availableWidth);
            if(numberOfRows*size+gapY*(size-1)>availableHeight){
                size-=10;
                break;
            }
        }
        initGridindex(arr, xs, xf, ys,size,size, gapX, gapY, 0, arr.length-1);

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
//                System.out.println(lastxf);
                ys-=h+gapY;
                initGridindex(arr,lastxf,lastxf+(j-starting+1)*w,ys,w,h,0,gapY,starting,j);

            }
            lastxf=arr[j].x+w/2;
        }
        return arr;
    }
    public static drawable[] initwriteString(ArrayList<Character> str, float xs, float xf, float ys, int w, int h, int gapY){
        char[] arr = new char[str.size()];
        for (int i = 0; i < str.size(); i++) {
            arr[i]=str.get(i);
        }
        return initwriteString(new String(arr),xs,xf,ys,w,h,gapY);
    }
    public static class Pair{
        String s;Integer in;
        Pair(String s,Integer in){
            this.s=s;this.in=in;
        }

        public String getS() {
            return s;
        }

        public Integer getIn() {
            return in;
        }
    }
    public static class Pairii{
        public Integer f;public Integer s;
        public Pairii(Integer f, Integer s){
            this.f=f;this.s=s;
        }
    }
    public static void clearScoreBoard(){
        scoreBoard.delete();
        try {
            scoreBoard.createNewFile();
        } catch (IOException e) {
            System.out.println("file doesn't create new one");
        }
    }
    public static ArrayList<Pair> getScoreBoard(){
        ArrayList<Pair> arr = new ArrayList<>();
        Scanner in = null;
        try {
            in = new Scanner(scoreBoard);
            String str="";int sc;
            boolean b=false;
            while(in.hasNext()){
                if(b){
                    sc=in.nextInt();
                    arr.add(new Pair(str,sc));
                }
                else{
                    str=in.next();
                }
                b=!b;
            }
            in.close();

        } catch (FileNotFoundException e) {
            System.out.println("file scoreBoard doesn't exist");
        }
        return arr;

    }

    public static void updateScoreBoard(String s,int score){
        System.out.println("yes");
        try {
            ArrayList<Pair> arr = getScoreBoard();
            //making names distinct
            boolean check=true;
            for (int i = 0; i < arr.size(); i++) {
                if(arr.get(i).s.equals(s)){
                    check=false;
                    arr.get(i).in=Math.max(score,arr.get(i).in);
                }
            }
            if(check)arr.add(new Pair(s,score));
            arr.sort((x,y)->y.in-x.in);//sort descending
            PrintWriter printWriter = new PrintWriter(scoreBoard);
            for (int i = 0; i < arr.size(); i++) {
                printWriter.println(arr.get(i).s+" "+arr.get(i).in);
            }
            printWriter.close();
        }
        catch (Exception e){
            System.out.println("file scoreBoard doesn't exist");
        }
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