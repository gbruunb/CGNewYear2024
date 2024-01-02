import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IllustratorHack {
    public static void main(String[] args) {
        ArrayList<Integer> xPointArrl = new ArrayList<>();
        ArrayList<Integer> yPointArrl = new ArrayList<>();
        try (Scanner input = new Scanner(Paths.get("a.txt"))) {
            FileWriter myWriter = new FileWriter("filename.txt");
            while (input.hasNextLine()) {
                String[] splt = input.nextLine().split(" ");
                for (int i = 0; i < splt.length; i++) {
                    if (!splt[i].equals("c") && !splt[i].equals("m")&& !splt[i].equals("l")&& !splt[i].equals("y")) {
                        if(i%2==0)
                            xPointArrl.add((int)Math.round(Double.parseDouble(splt[i])));
                        else
                            yPointArrl.add((int)Math.round(Double.parseDouble(splt[i])));
                    }
                }
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println(Arrays.toString(xPointArrl.toArray()));
            System.out.println("=====-----");
            System.out.println(Arrays.toString(yPointArrl.toArray()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 65 - 90 /
    // 97 - 122
    // 40 - 41 /
    // 46,44,39 /

}
