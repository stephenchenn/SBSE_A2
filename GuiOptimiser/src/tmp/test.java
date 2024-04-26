import java.util.Random;
import java.util.List;
import java.util.ArrayList;

class Individual {
    private List<Integer> genes;
    private Random random = new Random();

    public Individual() {
        genes = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            genes.add(random.nextInt(100)); // Random integers between 0 and 99
        }
    }
    
    public List<Integer> getGenes() {
        return genes;
    }

    public Individual crossover(Individual other) {
        Individual child = new Individual();
        int crossoverPoint = random.nextInt(5); // Select random crossover point

        System.out.println(crossoverPoint);

        // Use single-point crossover to create the child
        for (int i = 0; i < 5; i++) {
            if (i <= crossoverPoint) {
                child.genes.set(i, this.genes.get(i));
            } else {
                child.genes.set(i, other.genes.get(i));
            }
        }

        return child;
    }

    public void test() {
        System.out.println("test");
    }

    public void mutate() {
        // Randomly mutate a single gene
        int index = random.nextInt(5);
        genes.set(index, random.nextInt(100));
    }
}



class Test {
    public static void main(String[] args) {
        // Random random = new Random();
        // System.out.println(random.nextDouble());

        // List<Integer> genes = new ArrayList<>(5);
        // genes.add(77);
        // genes.add(83);
        // System.out.println(genes.get(1));

        Individual individual1 = new Individual();
        System.out.println(individual1.getGenes());

        Individual individual2 = new Individual();
        System.out.println(individual2.getGenes());

        Individual child = individual1.crossover(individual2);
        System.out.println(child.getGenes());

        child.mutate();
        System.out.println(child.getGenes());

        fitnessFunction test = new fitnessFunction();
    } 
}