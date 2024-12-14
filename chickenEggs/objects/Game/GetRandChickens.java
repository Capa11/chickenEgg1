package chickenEggs.objects.Game;

import java.util.Random;

public class GetRandChickens {

    public static int[] generateChickenDistribution(int level) {
        int targetPoints;

        // Determine target points based on the level
        switch (level) {
            case 1:
                targetPoints = 400;
                break;
            case 2:
                targetPoints = 600;
                break;
            case 3:
                targetPoints = 800;
                break;
            case 4:
                targetPoints = 1000;
                break;
            default:
                targetPoints = 400;
        }

        int[] chickenPoints = {20, 40, 60, 80};
        Random random = new Random();

        // Array  hold  the chicken
        int[] chickenCounts = new int[4];

        // Generate distribution
        while (true) {
            int currentTotal = 0;


            for (int i = 0; i < 4; i++) {
                chickenCounts[i] = random.nextInt(15);
                currentTotal += chickenCounts[i] * chickenPoints[i];
            }


            if (Math.abs(currentTotal - targetPoints) <= 50) {
                break;
            }
        }

        return chickenCounts;
    }

    public static void main(String[] args) {
        int[] chickenDistribution = generateChickenDistribution(4);

        System.out.println("Chicken 1: " + chickenDistribution[0]);
        System.out.println("Chicken 2: " + chickenDistribution[1]);
        System.out.println("Chicken 3: " + chickenDistribution[2]);
        System.out.println("Chicken 4: " + chickenDistribution[3]);

        // Optionally, print the entire array for verification
        System.out.println("Chicken Distribution Array: [" +
                chickenDistribution[0] + ", " +
                chickenDistribution[1] + ", " +
                chickenDistribution[2] + ", " +
                chickenDistribution[3] + "]");


        int[] chickenDistribution2 = generateChickenDistribution(4);

        System.out.println("Chicken 1: " + chickenDistribution2[0]);
        System.out.println("Chicken 2: " + chickenDistribution2[1]);
        System.out.println("Chicken 3: " + chickenDistribution2[2]);
        System.out.println("Chicken 4: " + chickenDistribution2[3]);

        // Optionally, print the entire array for verification
        System.out.println("Chicken Distribution Array: [" +
                chickenDistribution2[0] + ", " +
                chickenDistribution2[1] + ", " +
                chickenDistribution2[2] + ", " +
                chickenDistribution2[3] + "]");
    }
}
