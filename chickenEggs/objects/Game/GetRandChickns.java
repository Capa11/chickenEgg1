package chickenEggs.objects.Game;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GetRandChickns {
    public static Map<String, Integer> generateChickenDistribution(int level) {
        // Define total points for each level
        int[] levelPoints = {400, 600, 800, 1000};

        // Validate level input
        if (level < 1 || level > 4) {
            throw new IllegalArgumentException("Level must be between 1 and 4");
        }

        // Get the total points for the current level
        int totalPoints = levelPoints[level - 1];

        // Base chicken point values
        int[] chickenPoints = {20, 40, 60, 80};

        // Random number generator
        Random random = new Random();

        // Map to store chicken distribution
        Map<String, Integer> chickenDistribution = new HashMap<>();

        // Try to find a valid distribution
        int attempts = 0;
        while (attempts < 100) {
            // Reset distribution
            chickenDistribution.clear();
            int currentTotal = 0;

            // Generate random numbers for each chicken
            for (int i = 1; i <= 4; i++) {
                // Generate a random number of chickens
                int chickenCount = random.nextInt(10); // Adjust the range as needed
                int chickenValue = chickenCount * chickenPoints[i - 1];

                chickenDistribution.put("chicken" + i, chickenCount);
                currentTotal += chickenValue;
            }

            // Check if the total is close to the target points
            if (Math.abs(currentTotal - totalPoints) <= 100) {
                return chickenDistribution;
            }

            attempts++;
        }

        // Fallback: create a more balanced distribution if random attempts fail
        return createBalancedDistribution(level);
    }

    private static Map<String, Integer> createBalancedDistribution(int level) {
        int[] levelPoints = {400, 600, 800, 1000};
        int[] chickenPoints = {20, 40, 60, 80};

        Map<String, Integer> balancedDistribution = new HashMap<>();
        int totalPoints = levelPoints[level - 1];

        // Start with a base distribution
        balancedDistribution.put("chicken1", totalPoints / (20 * 4));
        balancedDistribution.put("chicken2", totalPoints / (40 * 4));
        balancedDistribution.put("chicken3", totalPoints / (60 * 4));
        balancedDistribution.put("chicken4", totalPoints / (80 * 4));

        return balancedDistribution;
    }

    // Example usage method
    public static void main(String[] args) {
        // Demonstrate the function with different levels
        for (int level = 1; level <= 4; level++) {
            System.out.println("Level " + level + " Chicken Distribution:");
            Map<String, Integer> distribution = generateChickenDistribution(level);

            // Calculate and print total points
            int totalPoints = distribution.entrySet().stream()
                    .mapToInt(entry -> {
                        int chickenNumber = Integer.parseInt(entry.getKey().replace("chicken", ""));
                        return entry.getValue() * new int[]{20, 40, 60, 80}[chickenNumber - 1];
                    })
                    .sum();

            distribution.forEach((key, value) ->
                    System.out.println(key + ": " + value + " chickens")
            );
            System.out.println("Total Points: " + totalPoints + "\n");
        }
    }
}