import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class kuy {
    public static void main(String[] args) throws IOException {
        Point startAndEnd = new Point("99999999", "99999999999");
        // Point startAndEnd;
        int pointCount = 0;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            String lines;
            int countLine = 0;
            Point keepOldEndPoint = new Point("99999999999", "999999999999");
            List<Point> oldEndPoint = new ArrayList<>();
            // String findFirstline;
            while ((lines = br.readLine()) != null) {
                pointCount = 0;
                lines = lines.split("to: ")[1];
                if (countLine == 0) {
                    String[] arr = lines.split(",");
                    arr[0] = arr[0].substring(arr[0].indexOf("x:") + 2);
                    arr[1] = arr[1].substring(arr[1].indexOf("y:") + 2, arr[1].indexOf(")"));
                    startAndEnd = new Point(arr[0], arr[1]);
                    // System.out.println(startAndEnd.x + " " + startAndEnd.y);
                    countLine++;
                    // break;
                    continue;
                }
                String[] cgArr = lines.split("CGPoint\\(");
                
                for (int i = 0; i < cgArr.length; i++) {
                    if (cgArr[i].trim().equals(""))
                    continue;
                    cgArr[i] = cgArr[i].substring(0, cgArr[i].indexOf(")"));
                    // list.add(cgArr[i]);
                    
                }
                // System.out.println(list);
                String[] cgArr2 = new String[cgArr.length - 1];
                for (int i = 1; i < cgArr.length; i++) {
                    cgArr2[i - 1] = cgArr[i];
                }
                // System.out.println(Arrays.toString(cgArr2));
                List<Point> list = new ArrayList<>();
                for (String pointStr : cgArr2) {
                    // System.out.println("PointStr: " + pointStr);
                    // System.out.println();
                    if (pointCount == 0) {
                        String endx = pointStr.substring(2, pointStr.indexOf(","));
                        String endy = pointStr.substring(pointStr.indexOf("y:") + 2);
                        Point endPoint = new Point(endx, endy);
                        oldEndPoint.add(endPoint);
                        list.add(endPoint);
                        // System.out.println("not add"+list);
                        // System.out.println("e:" + endPoint.x);
                        // System.out.println("e:" + endPoint.y);
                        // System.out.println("test");
                    } else if (pointCount == 1) {
                        String endx = pointStr.substring(2, pointStr.indexOf(","));
                        String endy = pointStr.substring(pointStr.indexOf("y:") + 2);
                        Point controlPoint1 = new Point(endx, endy);
                        list.add(controlPoint1);
                        // System.out.println("not add"+list);
                        // System.out.println("c1:" + controlPoint1.x);
                        // System.out.println("c1:" + controlPoint1.y);
                    } else if (pointCount == 2) {
                        String endx = pointStr.substring(2, pointStr.indexOf(","));
                        String endy = pointStr.substring(pointStr.indexOf("y:") + 2);
                        Point controlPoint2 = new Point(endx, endy);
                        list.add(controlPoint2);
                        // System.out.println("not add"+list);
                        // System.out.println("c2:" + controlPoint2.x);
                        // System.out.println("c2:" + controlPoint2.y);
                    }
                    // System.out.println("old ENd"+oldEndPoint);
                    
                    //  bezier_CurveTest(g2d, 446.0638, 9.9947, 446.2331, 9.9007, 446.9245, 10.8454,447.2128, 11);
                    // System.out.println("||||||||||||||||");
                    pointCount++;
                    
                }
                // StringBuffer sb = new StringBuffer("bezier_CurveTest(g2d,");
                // String text = String.format("bezier_CurveTest(g2d, %d, %d, %d, %d, %d, %d, %d, %d, %d)",startAndEnd.x, startAndEnd.y,)
                // sb.append(startAndEnd.x + ","+ startAndEnd.y+ ","+);
                System.out.println(list.toString());
                System.out.println(countLine);
                // System.out.println("old END:"+oldEndPoint);
                String str = "";
                if (countLine == 1) {
                    System.out.println("start"+startAndEnd);
                    System.out.println("c1"+list.get(1));
                    System.out.println("c2"+list.get(2));
                    System.out.println("end"+list.get(0));
                    // str = String.format("bezier_CurveTest(g2d, %d, %d, %d, %d, %d, %d, %d, %d);\n", startAndEnd.x, startAndEnd.y, list.get(1).x, list.get(1).y, list.get(2).x, list.get(2).y, list.get(0).x, list.get(0).y);
                    str = String.format("bezier_Curve(g2d, new int[]{%d+x, %d+x, %d+x, %d+x}, new int[]{%d+y, %d+y, %d+y, %d+y});\n",startAndEnd.x,list.get(1).x,list.get(2).x, list.get(0).x, startAndEnd.y, list.get(1).y, list.get(2).y, list.get(0).y);
                } else {
                    System.out.println("oldEnd:"+oldEndPoint.get(countLine-2));
                    System.out.println("c1"+list.get(1));
                    System.out.println("c2"+list.get(2));
                    System.out.println("end"+list.get(0));
                    // str = String.format("bezier_CurveTest(g2d, %d, %d, %d, %d, %d, %d, %d, %d);\n", oldEndPoint.get(countLine-2).x, oldEndPoint.get(countLine-2).y, list.get(1).x, list.get(1).y, list.get(2).x, list.get(2).y, list.get(0).x, list.get(0).y);
                    str = String.format("bezier_Curve(g2d, new int[]{%d+x, %d+x, %d+x, %d+x}, new int[]{%d+y, %d+y, %d+y, %d+y});\n",oldEndPoint.get(countLine-2).x,list.get(1).x,list.get(2).x, list.get(0).x, oldEndPoint.get(countLine-2).y, list.get(1).y, list.get(2).y, list.get(0).y);
                }
                System.out.println(str);
                bw.append(str);
                // System.out.println(Arrays.toString(cgArr));
                System.out.println("********");
                System.out.println();
                countLine++;
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Point {

    int x;
    int y;

    Point(String x, String y) {
        this.x = (int) Math.round(Double.parseDouble(x));
        this.y = (int) Math.round(Double.parseDouble(y));
    }

    @Override
    public String toString() {
        return "Point [x=" + x + "| y=" + y + "]";
    }
}