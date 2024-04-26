class GeneticAlgorithm {
    public static void main(String[] args) {
        calculateChargeConsumptionPerPixel(125,191,114);
    }

    static void calculateChargeConsumptionPerPixel(int R, int G, int B) {
        // charge consumption rate for each colour per hour in mAh
        int redConsumption = 131;
        int greenConsumption = 142;
        int blueConsumption = 241;

        int totalConsumption = redConsumption * R + greenConsumption * G + blueConsumption * B;
        System.out.println("calculating charge consumption: " + totalConsumption); 
    }

    // genetic operators
    static void swapMutation () {}
    static void onePointCrossover () {}

    static int calculateFitness () {}


}

// fitness function


/*
data representation:
- int [], length 81
- 27 colours, 3 values per colour (RGB) = 27 * 3 = 81 ints

colour consumption per hour:
- Red: 130.77428 mAh
- Green: 141.84873 mAh
- Blue: 241.22415 mAh


*/