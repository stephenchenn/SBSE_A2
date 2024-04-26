import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class fitnessFunction {
    public static double calculateChargeConsumptionPerPixel(double r, double g, double b) {
        // average charge consumption per hour showing ENTIRE SCREEN on Nexus 6
        double RED = 131;
        double GREEN = 142;
        double BLUE = 241;

        // Nexus 6 screen resolution
        double RESOLUTION = 1440 * 2560;

        return ((r * RED) + (g * GREEN) + (b * BLUE)) / RESOLUTION;
    }

    public static void main(String args[]) throws IOException {
        File file = new File("test.bmp");
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
        System.out.println(totalChargeConsumption);
    }
}