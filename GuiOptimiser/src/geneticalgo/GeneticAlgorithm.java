package geneticalgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

class FitnessFunction {
    public static double calculateChargeConsumptionPerPixel(double r, double g, double b) {
        // average charge consumption per hour showing ENTIRE SCREEN on Nexus 6
        double RED = 131;
        double GREEN = 142;
        double BLUE = 241;

        // Nexus 6 screen resolution
        double RESOLUTION = 1440 * 2560;

        return ((r * RED) + (g * GREEN) + (b * BLUE)) / RESOLUTION;
    }

    public static double getFitnessValue(String imageName) throws IOException {
        File file = new File("geneticalgo/test.bmp");
        BufferedImage image = ImageIO.read(file);

        int width = image.getWidth();
        int height = image.getHeight();

        double totalChargeConsumption = 0;

        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                // Getting pixel color by position x and y 
                int clr = image.getRGB(0,0);
                double red =   (clr & 0x00ff0000) >> 16;
                double green = (clr & 0x0000ff00) >> 8;
                double blue =   clr & 0x000000ff;

                totalChargeConsumption += calculateChargeConsumptionPerPixel(red, green, blue);
            }
        }
        return totalChargeConsumption;
    }
}

class Individual {
    private List<Integer> genes;
    private Random random = new Random();

    public Individual() {
        genes = new ArrayList<>(81);
        for (int i = 0; i < 81; i++) {
            genes.add(random.nextInt(256)); // Random integers between 0 and 99
        }
    }

    public List<Integer> getGenes() {
        return genes;
    }

    public int getFitness() {
        // Fitness is the sum of the genes. Lower is better.
        return genes.stream().mapToInt(Integer::intValue).sum();
    }

    public Individual crossover(Individual other) {
        Individual child = new Individual();
        int crossoverPoint = random.nextInt(81); // Select random crossover point

        // Use single-point crossover to create the child
        for (int i = 0; i < 81; i++) {
            if (i <= crossoverPoint) {
                child.genes.set(i, this.genes.get(i));
            } else {
                child.genes.set(i, other.genes.get(i));
            }
        }

        return child;
    }

    public void mutate() {
        // Randomly mutate a single gene
        int index = random.nextInt(81);
        genes.set(index, random.nextInt(256));
    }

    @Override
    public String toString() {
        return "Genes: " + genes.toString() + ", Fitness: " + getFitness();
    }
}

public class GeneticAlgorithm {
    private List<Individual> population;
    private Random random = new Random();

    public GeneticAlgorithm(int populationSize) {
        population = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            population.add(new Individual());
        }
    }

    public void evolve() {
        // Sort by fitness
        Collections.sort(population, Comparator.comparingInt(Individual::getFitness));

        // Create a new population through selection, crossover, and mutation
        List<Individual> newPopulation = new ArrayList<>();

        // Selection: Keep the top 50% of the population
        for (int i = 0; i < population.size() / 2; i++) {
            newPopulation.add(population.get(i));
        }

        // Crossover: Generate new individuals by crossing over top individuals
        while (newPopulation.size() < population.size()) {
            Individual parent1 = newPopulation.get(random.nextInt(newPopulation.size() / 2));
            Individual parent2 = newPopulation.get(random.nextInt(newPopulation.size() / 2));
            Individual child = parent1.crossover(parent2);

            // Mutation: Apply a small chance of mutation
            if (random.nextDouble() < 0.1) { // 10% chance of mutation
                child.mutate();
            }

            newPopulation.add(child);
        }

        // Replace the old population with the new population
        population = newPopulation;
    }

    public Individual getBestIndividual() {
        Collections.sort(population, Comparator.comparingInt(Individual::getFitness));
        return population.get(0); // Best individual has the lowest fitness
    }

    public static void main(String[] args) {

        int populationSize = 20; // Size of the population
        int generations = 5000;   // Number of generations to evolve

        GeneticAlgorithm ga = new GeneticAlgorithm(populationSize);

        // Evolve through generations
        for (int i = 0; i < generations; i++) {
            ga.evolve();
            System.out.println("Generation " + (i + 1) + ": Best Individual - " + ga.getBestIndividual());
        }

        // Get the best individual from the final generation
        Individual best = ga.getBestIndividual();
        System.out.println("Final Best Individual: " + best);



        GuiOptimiser GOtest = new GuiOptimiser();
        GOtest.changeColorAll(best.getGenes());






        FitnessFunction test = new FitnessFunction();
        try {
            System.out.println(test.getFitnessValue("test.bmp"));
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
