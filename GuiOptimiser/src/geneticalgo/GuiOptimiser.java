package geneticalgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.List;

/**
 *
 * @author Mahmoud-Uni
 */
public class GuiOptimiser {
    private static String TARGET_APP = "calculator.jar";
    //private static final String TARGET_APP = "simpleApp.jar";
    private static final String TARGET_APP_COLOR = "color.csv";
    private static final int TARGET_APP_RUNNINGTIME = 1000;
    private static final String JAVA_COMMAND = "java -jar ";
    private static String parentDir = "";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // first run the target app
        switch (args[0]) {
            case "calculator.jar":
                TARGET_APP = args[0].trim();
                System.out.println(args[0]);
                break;
            case "simpleApp.jar":
                TARGET_APP = args[0].trim();
                System.out.println(args[0]);
                break;
            default:
                System.out.println(args[0]);
                return;
        }
        parentDir = getParentDir();
        //System.out.println(parentDir.concat(TARGET_APP));
        for (int i = 0; i < 1; i++) //RunTargetApp runTargetApp = new RunTargetApp(parentDir.concat(TARGET_APP), TARGET_APP_RUNNINGTIME);
        {
            //runApp(parentDir.concat(TARGET_APP), TARGET_APP_RUNNINGTIME);
            runApp(TARGET_APP, TARGET_APP_RUNNINGTIME);
            changeColorAll();

            //save screenshot
        }

    }

    public static void runApp(String path, int targetAppRunningtime) {
        try {
            //java -jar C:\Users\Mahmoud-Uni\Documents\NetBeansProjects\calculator\dist\calculator.jar

            //path = "\""+path+"\"";
            System.out.println("Target App" + path);

            Runtime runTime = Runtime.getRuntime();
            Process process = runTime.exec(JAVA_COMMAND.concat(path));
            try {
                Thread.sleep(targetAppRunningtime);
                Capture capture = new Capture();
                capture.takeScreenShoot();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Target App");
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changeColorAll() {
        try {
            // guiComponents contains GUI components' name.
            ArrayList<String> guiComponents = new ArrayList<>();
            guiComponents.add("mainFrameColor"); // both apps
            guiComponents.add("jButton1");// both apps
            guiComponents.add("jButton2");
            guiComponents.add("jButton3");
            guiComponents.add("jButton4");
            guiComponents.add("jButton5");
            guiComponents.add("jButton6");
            guiComponents.add("jButton7");
            guiComponents.add("jButton8");
            guiComponents.add("jButton9");
            guiComponents.add("jButton10");
            guiComponents.add("jButton11");
            guiComponents.add("jButton12");
            guiComponents.add("jButton13");
            guiComponents.add("jButton14");
            guiComponents.add("jButton15");
            guiComponents.add("jButton16");
            guiComponents.add("jButton17");
            guiComponents.add("jButton18");
            
            guiComponents.add("jTextField1");// both apps
            guiComponents.add("jTextField1TextColor");// both apps

            guiComponents.add("jLabel1");// both apps

            guiComponents.add("jPanel1");// both apps
            guiComponents.add("jPanel2");
            guiComponents.add("jPanel3");
            guiComponents.add("jPanel4");
            guiComponents.add("jPanel5");

            ArrayList<ArrayList<Integer>> RGB = new ArrayList<>();
            Random randomInt = new Random();

            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));

            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{randomInt.nextInt(256), randomInt.nextInt(256), randomInt.nextInt(256)})));

            saveToCSV(parentDir.concat(TARGET_APP_COLOR), guiComponents, RGB);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void changeColorAll(List<Integer> genes) {
        try {
            // guiComponents contains GUI components' name.
            ArrayList<String> guiComponents = new ArrayList<>();
            guiComponents.add("mainFrameColor"); // both apps
            guiComponents.add("jButton1");// both apps
            guiComponents.add("jButton2");
            guiComponents.add("jButton3");
            guiComponents.add("jButton4");
            guiComponents.add("jButton5");
            guiComponents.add("jButton6");
            guiComponents.add("jButton7");
            guiComponents.add("jButton8");
            guiComponents.add("jButton9");
            guiComponents.add("jButton10");
            guiComponents.add("jButton11");
            guiComponents.add("jButton12");
            guiComponents.add("jButton13");
            guiComponents.add("jButton14");
            guiComponents.add("jButton15");
            guiComponents.add("jButton16");
            guiComponents.add("jButton17");
            guiComponents.add("jButton18");
            
            guiComponents.add("jTextField1");// both apps
            guiComponents.add("jTextField1TextColor");// both apps

            guiComponents.add("jLabel1");// both apps

            guiComponents.add("jPanel1");// both apps
            guiComponents.add("jPanel2");
            guiComponents.add("jPanel3");
            guiComponents.add("jPanel4");
            guiComponents.add("jPanel5");

            ArrayList<ArrayList<Integer>> RGB = new ArrayList<>();
            Random randomInt = new Random();

            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(0), genes.get(1), genes.get(2)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(3), genes.get(4), genes.get(5)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(6), genes.get(7), genes.get(8)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(9), genes.get(10), genes.get(11)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(12), genes.get(13), genes.get(14)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(15), genes.get(16), genes.get(17)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(18), genes.get(19), genes.get(20)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(21), genes.get(22), genes.get(23)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(24), genes.get(25), genes.get(26)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(27), genes.get(28), genes.get(29)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(30), genes.get(31), genes.get(32)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(33), genes.get(34), genes.get(35)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(36), genes.get(37), genes.get(38)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(39), genes.get(40), genes.get(41)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(42), genes.get(43), genes.get(44)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(45), genes.get(46), genes.get(47)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(48), genes.get(49), genes.get(50)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(51), genes.get(52), genes.get(53)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(54), genes.get(55), genes.get(56)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(57), genes.get(58), genes.get(59)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(60), genes.get(61), genes.get(62)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(63), genes.get(64), genes.get(65)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(66), genes.get(67), genes.get(68)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(69), genes.get(70), genes.get(71)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(72), genes.get(73), genes.get(74)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(75), genes.get(76), genes.get(77)})));
            RGB.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{genes.get(78), genes.get(79), genes.get(80)})));

            saveToCSV(parentDir.concat(TARGET_APP_COLOR), guiComponents, RGB);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void saveToCSV(String filePath, ArrayList<String> guiComponents, ArrayList<ArrayList<Integer>> RGB) {
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(new File(filePath)));
            String line = "";
            for (int i = 0; i < guiComponents.size(); i++) {
                line += guiComponents.get(i).concat(",").concat(RGB.get(i).toString().replace("[", "").replace("]", "").replaceAll("\\s", "")) + "\n";
                //System.out.println(line);
            }
            br.write(line);
            br.flush();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getParentDir() {
        String dir = "";
        try {
            File temp = new File("temp");
            dir = temp.getAbsolutePath().replace("temp", "");
            //System.out.println(dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dir;
    }

    public static void test() {
        System.out.println("I can run!");
    }
}
