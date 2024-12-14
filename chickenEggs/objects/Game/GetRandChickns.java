import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ChickenGame {
    public static Map<String, Integer> generateChickenDistribution(int level) {
        // Define total points for each level
        int[] levelPoints = {400, 600, 800, 1000};
        int[] chickenPoints = {20, 40, 60, 80}; // Chicken point values

        // Validate level input
        if (level < 1 || level > 4) {
            throw new IllegalArgumentException("Level must be between 1 and 4");
        }

        // Target total points for the level
        int targetPoints = levelPoints[level - 1];

        // Random number generator
        Random random = new Random();
        Map<String, Integer> chickenDistribution = new HashMap<>();

        // Generate random distribution
        int currentTotal = 0;
        while (true) {
            chickenDistribution.clear();
            currentTotal = 0;

            // Randomly assign chicken counts
            for (int i = 0; i < 4; i++) {
                int chickenCount = random.nextInt(15); // Randomly choose a number for each chicken type
                chickenDistribution.put("chicken" + (i + 1), chickenCount);
                currentTotal += chickenCount * chickenPoints[i];
            }

            // Break if the total points are close enough to the target
            if (Math.abs(currentTotal - targetPoints) <= 50) {
                break;
            }
        }

        // Add the total points to the output
        chickenDistribution.put("TotalPoints", currentTotal);
        return chickenDistribution;
    }

    public static void main(String[] args) {
        // Run the test twice
        for (int testRun = 1; testRun <= 2; testRun++) {
            System.out.println("Test Run " + testRun + ":");
            // Call the function for levels 1 through 4
            for (int level = 1; level <= 4; level++) {
                System.out.println("Level " + level + ":");
                // Call the function and store the result
                Map<String, Integer> distribution = generateChickenDistribution(level);

                // Print the result
                distribution.forEach((key, value) ->
                        System.out.println(key + ": " + value + " chickens")
                );
                System.out.println();
            }
        }
    }
}
