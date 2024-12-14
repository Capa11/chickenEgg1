package chickenEggs.objects.Game;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class GetRandChickns {

    public static Map<String, Integer> generateChickenDistribution(int level) {
        int targetPoints;
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
                break;
        }

        int[] chickenPoints = {20, 40, 60, 80};
        Random random = new Random();
        Map<String, Integer> chickenDistribution = new LinkedHashMap<>(); // hashmap order
        int currentTotal = 0;

        while (true) {
            chickenDistribution.clear();
            currentTotal = 0;

            for (int i = 0; i < 4; i++) {
                int chickenCount = random.nextInt(15);
                chickenDistribution.put("chicken" + (i + 1), chickenCount);
                currentTotal += chickenCount * chickenPoints[i];
            }

            if (Math.abs(currentTotal - targetPoints) <= 50) {
                break;
            }
        }

        chickenDistribution.put("TotalPoints", currentTotal);  
        return chickenDistribution;
    }

    public static void main(String[] args) {
        // Test for levels 1 to 4
        for (int level = 1; level <= 4; level++) {
            System.out.println("Level " + level + ":");
            Map<String, Integer> distribution = generateChickenDistribution(level);
            distribution.forEach((key, value) -> System.out.println(key + ": " + value + " chickens"));
            System.out.println();
        }

        // Additional test case for level 2
        System.out.println("Test Case - Level 2:");
        Map<String, Integer> testCaseResult = generateChickenDistribution(2);
        testCaseResult.forEach((key, value) -> System.out.println(key + ": " + value + " chickens"));
    }
}
