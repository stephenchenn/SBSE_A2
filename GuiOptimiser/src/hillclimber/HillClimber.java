import java.util.Arrays;
import java.util.Random;

public class HillClimber {

    public static void main(String[] args) {
        int setSize = 5;  // We need a set of 5 numbers
        int iterations = 1000;  // Number of iterations for the hill climber
        Random random = new Random();
        
        // Generate an initial random set of numbers
        int[] currentSet = random.ints(setSize, 1, 101).toArray();
        System.out.println("Initial set: " + Arrays.toString(currentSet));
        
        // Function to calculate the sum of a set
        int currentSum = Arrays.stream(currentSet).sum();

        // Perform hill climbing
        for (int i = 0; i < iterations; i++) {
            // Copy the current set to create a new candidate
            int[] candidateSet = Arrays.copyOf(currentSet, currentSet.length);
            
            // Modify one number in the candidate set
            int indexToChange = random.nextInt(setSize);  // Random index
            int newValue = random.nextInt(100) + 1;  // New random value (1-100)
            candidateSet[indexToChange] = newValue;

            // Calculate the sum of the candidate set
            int candidateSum = Arrays.stream(candidateSet).sum();
            
            // If the new set has a smaller sum, accept the change
            if (candidateSum < currentSum) {
                currentSet = candidateSet;
                currentSum = candidateSum;
            }

            System.out.println("\nCurrent set: " + Arrays.toString(currentSet));
            System.out.println("Current sum: " + currentSum);
        }
        
        System.out.println("Final set: " + Arrays.toString(currentSet));
        System.out.println("Final sum: " + currentSum);
    }
}
