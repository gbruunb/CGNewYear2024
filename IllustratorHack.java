import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IllustratorHack {
    public static void main(String[] args) {
        int lineCount = 0;
        ArrayList<Integer> xPointArrl = new ArrayList<>();
        ArrayList<Integer> yPointArrl = new ArrayList<>();
        try (Scanner input = new Scanner(Paths.get("a.txt"))) {
            FileWriter myWriter = new FileWriter("filename.txt");
            while (input.hasNextLine()) {
                String[] splt = input.nextLine().split(" ");
                for (int i = 0; i < splt.length / 2; i += 2) {
                    if (!splt[i].equals("c") || !splt[i].equals("m")|| !splt[i].equals("l")) {
                        xPointArrl.add((int)Math.round(Double.parseDouble(splt[i])));
                        yPointArrl.add((int)Math.round(Double.parseDouble(splt[i+1])));
                    }
                }
                myWriter.write(xPointArrl+"\n"+yPointArrl+"\n");
                lineCount+=2;
            }
            myWriter.close();
            // System.out.println(Arrays.toString(xPointArrl.toArray()));
            // System.out.println("=====");
            // System.out.println(Arrays.toString(yPointArrl.toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String txt = """
                 xPoints = new int[] { ,
                };
        yPoints = new int[] { 343, 343, 344, 345, 345, 347, 348, 351, 351, 351, 351, 352, 352, 351, 351, 350,
                350, 349,
                349, 348, 348, 347, 347, 344, 344, 343, 342, 342, 343, 344, 344, 344, 343 };
        for (int i = 0; i < xPoints.length - 3; i += 3) {
            bezier_Curve(g2d,
                    new int[] { (int) Math.round(xPoints[i]) + x,
                            (int) Math.round(xPoints[i + 1]) + x,
                            (int) Math.round(xPoints[i + 2]) + x,
                            (int) Math.round(xPoints[i + 3]) + x },
                    new int[] { (int) Math.round(yPoints[i]) + y,
                            (int) Math.round(yPoints[i + 1]) + y,
                            (int) Math.round(yPoints[i + 2]) + y,
                            (int) Math.round(yPoints[i + 3]) + y });
        }
                    
                    """;
            // BufferedWriter
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            BufferedReader br = new BufferedReader(new FileReader("filename.txt"));
            int nowAt = 1;
            String lines = "";
            while ((lines = br.readLine()) != null) {
                // System.out.println(nowAt);
                nowAt++;
                if (nowAt > lineCount - 1&&  nowAt  <= lineCount+1 ) {
                    // System.out.println(lines);
                    lines = lines.replace("[", "{");
                    lines = lines.replace("]", "}");
                    System.out.println(nowAt+""+lines);
                }

            }
            System.out.println("aa"+lineCount);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    // 65 - 90 /
    // 97 - 122
    // 40 - 41 /
    // 46,44,39 /

}
