package chickenEggs.objects.Game;

public class Player {
    public int[] controller; rocket r;boolean isMouse=false;
    Player(int[] controller,rocket r){
        this.controller=controller;
        this.r=r;
    }
    Player(rocket r){
        this.r=r;
        isMouse=true;
    }
}
