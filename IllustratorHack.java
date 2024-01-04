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
                for (int i = 0; i < splt.length; i++) {
                    if (!splt[i].equals("c") && !splt[i].equals("m")&& !splt[i].equals("l")&& !splt[i].equals("y")&& !splt[i].equals("v")) {
                        if(i%2==0)
                            xPointArrl.add((int)Math.round(Double.parseDouble(splt[i])));
                        else
                            yPointArrl.add((int)Math.round(Double.parseDouble(splt[i])));
                    }
                }
                myWriter.write(xPointArrl+"\n"+yPointArrl+"\n");
                lineCount+=2;
            }
            myWriter.close();
            System.out.println(Arrays.toString(xPointArrl.toArray()));
            System.out.println("=====-----");
            System.out.println(Arrays.toString(yPointArrl.toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int nowAt = 1;
        try {
            BufferedReader br = new BufferedReader(new FileReader("filename.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("a2.txt"));
            String lines;
            while ((lines = br.readLine()) != null) {
                if (nowAt <= lineCount - 2) {
                    // System.out.println(nowAt);
                    nowAt++;
                    continue;
                }
                lines = lines.replace("[", "{");
                lines = lines.replace("]", "}");
                if (nowAt %2 != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("xPoints = new int[]" +lines+";\n");
                    bw.write(sb.toString());

                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("yPoints = new int[]" +lines+";\n");
                    bw.write(sb.toString());

                }
                nowAt++;

            }
            String str = """
                  for (int i = 0; i < xPoints.length - 3; i += 3) {
        bezier_Curve(g2d,
                new int[] { (int) Math.round(xPoints[i]) + x, (int) Math.round(xPoints[i + 1]) + x,
                        (int) Math.round(xPoints[i + 2]) + x, (int) Math.round(xPoints[i + 3]) + x },
                new int[] { (int) Math.round(yPoints[i]) + y, (int) Math.round(yPoints[i + 1]) + y,
                        (int) Math.round(yPoints[i + 2]) + y, (int) Math.round(yPoints[i + 3]) + y });
    }
                    
                    """;
                    bw.write(str);
            bw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    // 65 - 90 /
    // 97 - 122
    // 40 - 41 /
    // 46,44,39 /

}
