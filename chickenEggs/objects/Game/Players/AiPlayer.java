package chickenEggs.objects.Game.Players;

import chickenEggs.interfaces.Game.Chicken;
import chickenEggs.interfaces.Game.Player;
import  chickenEggs.interfaces.variables;
import  chickenEggs.objects.Game.eggs;
import java.util.ArrayList;
import java.util.Random;

import static chickenEggs.objects.Game.GamePage.*;

public class AiPlayer extends Player {
    int durationBetweenEverybullet = 60;
    public AiPlayer(String name) {
        super( name);
        moveRocket();
    }
    public eggs find_clstegg() {
        eggs minegg = new eggs(0,0) ;
        double minspace = Double.MAX_VALUE;
        for (int i = 0; i < eggsArray.size(); i++) {
            double currenteggspace = Math.sqrt(Math.pow((this.r.x - eggsArray.get(i).x),2) + (Math.pow((this.r.y - eggsArray.get(i).y),2)));
            if(currenteggspace < minspace) {
                minspace = currenteggspace;
                minegg = (eggs) eggsArray.get(i);
            }
        }
        return minegg;
    }
    public Chicken find_mostDamaged_Closest_Chicken() {
        Chicken most_damaged_chicken = new Chicken(0,0,60,60,variables.chicken[0],4,4,80);
        double minspace = Double.MAX_VALUE;
        double minhealth = Double.MAX_VALUE;
        ArrayList<Chicken> mostDamagedchickens = new ArrayList<>();
        for (int i = 0; i < chickens.size(); i++) {
            minhealth = Math.min(minhealth, chickens.get(i).health);
        }
        for (int i = 0; i < chickens.size(); i++) {
            if(chickens.get(i).health == minhealth) {
                mostDamagedchickens.add(chickens.get(i));
            }
        }
        for (int i = 0; i < mostDamagedchickens.size(); i++) {
            double curr_chicken_space = Math.sqrt(Math.pow((mostDamagedchickens.get(i).x - r.x),2) + Math.pow((mostDamagedchickens.get(i).y - r.y),2));
            if(curr_chicken_space < minspace) {
                minspace = curr_chicken_space;
                most_damaged_chicken = mostDamagedchickens.get(i);
            }
        }
        return most_damaged_chicken;
    }
    public void moveRocket(){// this mehtod is responsible to make the rocket take deciction between avoiding the egg or attacking the chicken
        eggs clstegg = find_clstegg();
        Random rand = new Random();
        if(rand.nextInt(100) < 5)return; // make the ai make adelay in taking decicion
        else if(Math.sqrt(Math.pow((clstegg.x - r.x),2) + Math.pow((clstegg.y - r.y),2))<=20)move_to_safe();
        else attack_chicken();
    }
    public void attack_chicken(){ // to make the rocket move to attack the most damaged closest chicken
        Chicken most_D_C = find_mostDamaged_Closest_Chicken();
        if(most_D_C.x > r.x+10)while(r.x + 10 < most_D_C.x)r.moveright();
        else while(r.x - 10 > most_D_C.x)r.moveleft();
        if(Math.abs(r.x - most_D_C.x) <= 10) {
            if (durationBetweenEverybullet == 0) {
                r.fire();
                durationBetweenEverybullet = 60;
            }
            else durationBetweenEverybullet--;
        }

    }
    public void move_to_safe(){// to make the rocket avoid the fallen egg
        int space = 30;
        eggs clstegg = find_clstegg();
        if(clstegg.x <= r.x + space){
            r.moveleft();
        }
        else{
            r.moveright();
        }
    }

}