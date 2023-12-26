import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;
// import java.util.Queue;
import java.util.Random;

public class Expe extends JPanel {
    public static void main(String[] args) {
        Expe m = new Expe();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Assignment1_521_870");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);

    }

    public void paintComponent(Graphics g) {
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = buffer.createGraphics();

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 600, 600);
        // sky
        sky(g2d, buffer);
        // star
        star(g2d);
        // graass
        grass(g2d, buffer);
        // table
        table(g2d, buffer);
        // computer
        computer(g2d, buffer);
        // cup
        cup(g2d,buffer, 0, -35);
        // mattress
//        mattress(g2d);
        firework(g2d, buffer);

        girl(g2d, buffer,0,0);
        boy(g2d, buffer, 0, 0);

        cat(g2d, buffer, 30);
        ballOnChristmas(g2d, buffer, 0,0, Color.decode("#9BD0DD"));
        ballOnChristmas(g2d, buffer, 0,-30, Color.decode("#8984BF"));
        ballOnChristmas(g2d, buffer, 16,-26, Color.decode("#D7482E"));
        christmasTree(g2d, buffer, 0, 0);
        lineOfLamp1(g2d, buffer,7,-29);
        lineOfLamp2(g2d, buffer,12,-50);
        lineOfLamp3(g2d, buffer,28,-69);


        girl(g2d, buffer,0,0);
        boy(g2d, buffer, 0, 0);



        gift(g2d, buffer, 0, 0-30, Color.decode("#F2F03B"));
//        gift(g2d, buffer, -12, -16-30);
//        gift(g2d, buffer, 18, -12-30);
//        gift(g2d, buffer, 50, -12-30);
//        gift(g2d, buffer, 77, -21-30);



        g.drawImage(buffer, 0, 0, null);

    }

    private void gift(Graphics g, BufferedImage buffer, int x, int y, Color boxColor){
        g.setColor(Color.black);
        int[] xPoints = {22, 20, 20, 18, 15, 13, 12, 12, 15, 18, 18, 21, 21, 23, 24, 25, 26, 27, 27, 27, 28, 29, 31, 34, 36, 37, 38, 38, 37, 35, 34, 29, 28, 26, 27, 25, 23, 22, 22};
        int[] yPoints = {326, 327, 327, 327, 328, 326, 325, 322, 321, 321, 321, 323, 325, 325, 325, 325, 325, 325, 326, 326, 325, 323, 322, 321, 322, 323, 324, 326, 327, 327, 328, 328, 326, 327, 328, 329, 328, 328, 326};
        for (int i = 0; i < xPoints.length - 3; i+=3) {
            bezier_Curve(g, new int[] { xPoints[i]+x, xPoints[i+1]+x,  xPoints[i+2]+x, xPoints[i+3]+x}, new int[] { yPoints[i]+y, yPoints[i+1]+y, yPoints[i+2]+y, yPoints[i+3]+y});
        }
        plot(g,22 + x,327 + y);
        plot(g,22 + x,328 + y);

        xPoints = new int[]{11 + x, 24 + x, 39 + x, 39 + x, 24 + x, 11 + x};
        yPoints = new int[]{328 + y, 332 + y, 328 + y, 332 + y, 336 + y, 332 + y};

        g.drawPolygon(xPoints, yPoints, xPoints.length);
        bresenhamLine(g, 24 + x, 336 + y, 24 + x,332 + y);

        xPoints = new int[]{12 + x, 12 + x, 24 + x, 24 + x};
        yPoints = new int[]{333 + y, 347 + y, 353 + y, 336 + y};

        g.drawPolygon(xPoints, yPoints, xPoints.length);

        xPoints = new int[]{24 + x, 24 + x, 38 + x, 38 + x};
        yPoints = new int[]{336 + y, 353 + y, 346 + y, 332 + y};

        g.drawPolygon(xPoints, yPoints, xPoints.length);
        bresenhamLine(g, 11 + x, 328 + y,15 + x,327 + y);
        bresenhamLine(g, 39 + x, 328 + y,35 + x,327 + y);

        bresenhamLine(g,23+x,328+y,19+x, 330+y);
        bresenhamLine(g,21+x,326+y,16+x, 330+y);

        bresenhamLine(g,19+x,333+y,19+x, 330+y);
        bresenhamLine(g,16+x,333+y,16+x, 330+y);

        bresenhamLine(g,17+x,335+y,17+x, 350+y);
        bresenhamLine(g,20+x,336+y,20+x, 352+y);

        //right ribbon
        bresenhamLine(g,26+x,328+y,29+x, 331+y);
        bresenhamLine(g,27+x,327+y,32+x, 330+y);

        bresenhamLine(g,29+x,334+y,29+x, 331+y);
        bresenhamLine(g,32+x,333+y,32+x, 330+y);

        bresenhamLine(g,28+x,335+y,28+x, 351+y);
        bresenhamLine(g,31+x,334+y,31+x, 350+y);

        Color grassColor = Color.decode("#80C014");
        Color ribbon = Color.decode("#DB5A64");
        g.setColor(Color.BLUE);
        buffer = floodFill(buffer,31+x,328+y,grassColor,boxColor);
        buffer = floodFill(buffer,35+x,328+y,grassColor,boxColor);
        buffer = floodFill(buffer,34+x,331+y,grassColor,boxColor);
        buffer = floodFill(buffer,24+x,331+y,grassColor,boxColor);
        buffer = floodFill(buffer,26+x,333+y,grassColor,boxColor);
        buffer = floodFill(buffer,22+x,333+y,grassColor,boxColor);
        buffer = floodFill(buffer,15+x,332+y,grassColor,boxColor);
        buffer = floodFill(buffer,15+x,328+y,grassColor,boxColor);
        buffer = floodFill(buffer,19+x,327+y,grassColor,boxColor);
        buffer = floodFill(buffer,15+x,336+y,grassColor,boxColor);
        buffer = floodFill(buffer,22+x,336+y,grassColor,boxColor);
        buffer = floodFill(buffer,26+x,336+y,grassColor,boxColor);
        buffer = floodFill(buffer,33+x,336+y,grassColor,boxColor);

        buffer = floodFill(buffer,18+x,336+y,grassColor,ribbon);
        buffer = floodFill(buffer,18+x,332+y,grassColor,ribbon);
        buffer = floodFill(buffer,18+x,329+y,grassColor,ribbon);

        plot(g,18+x,332+y);




    }


    private void ballOnChristmas(Graphics g, BufferedImage buffer, int x, int y, Color color){
        int startX = 0;
        int startY = -30;
        g.setColor(Color.decode("#000000"));
        int[] xPoints = {44+startX+x, 46+startX+x, 49+startX+x, 51+startX+x, 52+startX+x, 52+startX+x, 51+startX+x, 50+startX+x, 48+startX+x, 46+startX+x, 44+startX+x, 43+startX+x, 42+startX+x, 43+startX+x, 44+startX+x};
        int[] yPoints = {268+startY+y, 267+startY+y, 267+startY+y, 269+startY+y, 271+startY+y, 273+startY+y, 275+startY+y, 276+startY+y, 277+startY+y, 277+startY+y, 276+startY+y, 274+startY+y, 272+startY+y, 270+startY+y, 268+startY+y};
        g.drawPolygon(xPoints, yPoints, xPoints.length);
        bresenhamLine(g,44+startX+x,268+startY+y, 44+startX+x, 265+startY+y);
        bresenhamLine(g,44+startX+x,265+startY+y, 50+startX+x, 265+startY+y);
        bresenhamLine(g,50+startX+x,265+startY+y, 50+startX+x, 268+startY+y);
        bresenhamLine(g,47+startX+x,265+startY+y, 47+startX+x, 261+startY+y);

        Color borderColor = Color.BLACK;

        buffer = floodFill2(buffer,46+startX+x,269+startY+y,borderColor, color);
        buffer = floodFill2(buffer,46+startX+x,266+startY+y,borderColor, Color.decode("#EFEA43"));



    }



    private void smallLamp(Graphics g, BufferedImage buffer, int x, int y){
        g.setColor(Color.decode("#98972B"));
        int[] xPoints = {21+x, 23+x, 24+x, 24+x, 23+x, 21+x, 20+x, 20+x, 21+x};
        int[] yPoints = {261+y, 261+y, 262+y, 264+y, 265+y, 265+y, 264+y, 262+y, 261+y};
        g.drawPolygon(xPoints,yPoints,xPoints.length);
        for (int i = 21; i <= 23; i++) {
            for (int j = 262; j <= 264; j++) {
                buffer = floodFill(buffer, i+x, j+y, Color.BLACK, Color.decode("#EFEA43"));
            }
        }

        Color border = Color.decode("#98972B");
        buffer = floodFill2(buffer, 21+x, 262+y, border, Color.decode("#EFEA43"));
        buffer = floodFill2(buffer, 23+x, 262+y, border, Color.decode("#EFEA43"));
        buffer = floodFill2(buffer, 23+x, 264+y, border, Color.decode("#EFEA43"));
        buffer = floodFill2(buffer, 21+x, 264+y, border, Color.decode("#EFEA43"));

        buffer = floodFill2(buffer, 21+x, 262+y, Color.decode("#19B24A"), Color.decode("#EFEA43"));
        buffer = floodFill2(buffer, 23+x, 262+y, Color.decode("#19B24A"), Color.decode("#EFEA43"));
        buffer = floodFill2(buffer, 23+x, 264+y, Color.decode("#19B24A"), Color.decode("#EFEA43"));
        buffer = floodFill2(buffer, 21+x, 264+y, Color.decode("#19B24A"), Color.decode("#EFEA43"));

    }

    private Color getColor(BufferedImage buffer, int x, int y){
        int pixel = buffer.getRGB(x, y);
        int r = (pixel >> 16) & 0xFF;
        int g = (pixel >> 8) & 0xFF;
        int b = pixel & 0xFF;
        return new Color(r, g, b);
    }

    private void lineOfLamp1(Graphics g, BufferedImage buffer, int x, int y){
        int firstX = 23;
        int firstY = 262;
        int[] diffX = {23-firstX,  25-firstX,  28-firstX,  31-firstX,  34-firstX,  37-firstX,  41-firstX,  44-firstX,  48-firstX,  51-firstX,  55-firstX,  59-firstX,  63-firstX,  67-firstX,  71-firstX,  75-firstX,  79-firstX, 83-firstX, 87-firstX, 91-firstX};
        int[] diffY = {262-firstY, 266-firstY, 269-firstY, 272-firstY, 275-firstY, 278-firstY, 280-firstY, 283-firstY, 285-firstY, 288-firstY, 290-firstY, 292-firstY, 294-firstY, 295-firstY, 297-firstY, 298-firstY, 299-firstY, 300-firstY, 300-firstY, 301-firstY};
        for (int i = 0; i < diffX.length; i++) {
            smallLamp(g,buffer,diffX[i] + x,diffY[i] + y);
        }
        System.out.println(diffY.length);

    }

    private void lineOfLamp2(Graphics g, BufferedImage buffer, int x, int y){
        int firstX = 34;
        int firstY = 211;
        int[] diffX = {34-firstX,  36-firstX,  39-firstX,  42-firstX,  45-firstX,  48-firstX,  51-firstX,  55-firstX,  58-firstX,  62-firstX,  65-firstX,  69-firstX,  73-firstX,  77-firstX,  81-firstX,  85-firstX,  89-firstX,  93-firstX};
        int[] diffY = {211-firstY, 215-firstY, 218-firstY, 221-firstY, 224-firstY, 227-firstY, 230-firstY, 232-firstY, 235-firstY, 237-firstY, 240-firstY, 242-firstY, 244-firstY, 246-firstY, 247-firstY, 248-firstY, 249-firstY, 249-firstY};

        for (int i = 0; i < diffX.length; i++) {
            smallLamp(g,buffer,diffX[i] + x,diffY[i] + y);
        }
        System.out.println(diffY.length);

    }

    private void lineOfLamp3(Graphics g, BufferedImage buffer, int x, int y){
        int firstX = 50;
        int firstY = 190;
        int[] diffX = {50-firstX,  53-firstX,  57-firstX,  61-firstX,  65-firstX,  69-firstX,  73-firstX};
        int[] diffY = {190-firstY, 193-firstY, 195-firstY, 197-firstY, 199-firstY, 201-firstY, 203-firstY};

        for (int i = 0; i < diffX.length; i++) {
            smallLamp(g,buffer,diffX[i] + x,diffY[i] + y);
        }
        System.out.println(diffY.length);

    }



    private void christmasTree(Graphics g, BufferedImage buffer, int x, int y) {
        g.setColor(Color.black);
        double[] xPoints = {12, 12.3455, 13.2721, 16.3005, 18.5576, 24.6485, 25.1167, 28.6134, 28.931, 31.686, 32.0698, 35.9322, 36.9498, 41.3041, 41.5605, 46.1792, 47.1407, 51.8008, 52.6668, 55.1776, 55.0872, 57.4208, 58.2147, 62.0222, 62.7171, 67.0826, 67.879, 71.8208, 71.9313, 76.3136, 77.3967, 82.0345, 82.3698, 86.0246, 86.6151, 89.4301, 89.2468, 93.1014, 94.9177, 99.9534, 101.6439, 102.3559, 101.3569};
        double[] yPoints = {280, 282.6668, 283.6118, 285.2269, 282.549, 283.347, 286.0635, 285.9456, 284.3062, 283.517, 287.7048, 288.2955, 284.8327, 285.188, 289.6872, 290.2794, 286.8385, 287.1017, 288.537, 287.5257, 286.1701, 285.7353, 288.9123, 289.0994, 285.1078, 284.9017, 288.1586, 287.8639, 285.4115, 284.5398, 287.3642, 286.7154, 284.8509, 285.1852, 288.162, 287.8327, 284.6062, 283.2734, 287.3722, 286.7641, 284.8257, 281.1758, 279.5796};

        for (int i = 0; i < xPoints.length - 3; i+=3) {
            bezier_Curve(g, new int[] { (int)Math.round(xPoints[i])+x, (int)Math.round(xPoints[i+1])+x,  (int)Math.round(xPoints[i+2])+x, (int)Math.round(xPoints[i+3])+x}, new int[] { (int)Math.round(yPoints[i])+y, (int)Math.round(yPoints[i+1])+y, (int)Math.round(yPoints[i+2])+y, (int)Math.round(yPoints[i+3])+y});
        }

        xPoints = new double[]{19, 19.5619, 20.4934, 24.2898, 26.1413, 29.8096, 29.4828, 32.4012, 33.4852, 36.5222, 36.6383, 39.4784, 40.3789, 43.7359, 44.2635, 47.6193, 48.503, 51.3989, 51.6067, 54.5028, 55.4789, 58.4221, 58.6975, 61.515, 62.3467, 65.6281, 66.2416, 69.5977, 70.2852, 73.699, 74.3085, 77.7199, 78.5001, 81.4501, 81.901, 84.1645, 84.1123, 87.8535, 89.3613, 93.345, 94.7638, 95.2366, 94.1809};
        yPoints = new double[]{251, 252.7323, 254.743, 255.3906, 251.4286, 252.5564, 256.7509, 257.2301, 253.7849, 254.2162, 257.8672, 258.1442, 253.942, 254.0621, 258.9379, 259.0579, 254.8643, 255.1268, 258.8775, 259.1321, 254.876, 255.1159, 258.9283, 259.0834, 253.9913, 254.0086, 258.9541, 259.0417, 254.9901, 255.0098, 258.9946, 259.0055, 254.8903, 255.1061, 259.0386, 258.9591, 254.5276, 253.482, 257.347, 256.8232, 255.5809, 252.4165, 251.2018};

        for (int i = 0; i < xPoints.length - 3; i+=3) {
            bezier_Curve(g, new int[] { (int)Math.round(xPoints[i])+x, (int)Math.round(xPoints[i+1])+x,  (int)Math.round(xPoints[i+2])+x, (int)Math.round(xPoints[i+3])+x}, new int[] { (int)Math.round(yPoints[i])+y, (int)Math.round(yPoints[i+1])+y, (int)Math.round(yPoints[i+2])+y, (int)Math.round(yPoints[i+3])+y});
        }

        xPoints = new double[]{27, 27.5597, 28.3201, 30.7225, 32.1643, 35.5726, 35.5188, 38.606, 39.7043, 42.207, 42.0671, 44.0834, 45.0087, 47.014, 46.8064, 49.2085, 50.3385, 53.5117, 54.0421, 56.0625, 56.0662, 57.9854, 58.7167, 61.262, 61.7613, 64.2421, 64.7786, 67.2103, 67.6634, 70.1782, 70.6937, 73.3063, 73.8218, 76.3387, 76.8137, 79.1636, 79.4628, 82.412, 83.071, 86.285, 87.9468, 88.038, 87.2498};
        yPoints = new double[]{226, 228.1188, 228.8246, 229.4444, 226.545, 227.3898, 229.7668, 230.2529, 227.6218, 228.3523, 230.8727, 231.1479, 227.8498, 228.1536, 231.7197, 232.2838, 228.8437, 229.1422, 232.1279, 231.8581, 228.0964, 227.8983, 232.0116, 231.9886, 228, 228, 232.0103, 231.9897, 228.0434, 227.9617, 231, 231, 227.9617, 228.0435, 232.0029, 231.9971, 228.186, 227.8291, 230.9344, 231.0437, 229.7322, 226.7646, 225.5717};

        for (int i = 0; i < xPoints.length - 3; i+=3) {
            bezier_Curve(g, new int[] { (int)Math.round(xPoints[i])+x, (int)Math.round(xPoints[i+1])+x,  (int)Math.round(xPoints[i+2])+x, (int)Math.round(xPoints[i+3])+x}, new int[] { (int)Math.round(yPoints[i])+y, (int)Math.round(yPoints[i+1])+y, (int)Math.round(yPoints[i+2])+y, (int)Math.round(yPoints[i+3])+y});
        }

        bresenhamLine(g, 12+x, 280+y, 28+x, 252+x);
        bresenhamLine(g, 102+x, 283+y, 86+x, 254+x);

        bresenhamLine(g, 19+x, 251+y, 34+x, 227+x);
        bresenhamLine(g, 94+x, 251+y, 81+x, 228+x);

        bresenhamLine(g, 27+x, 226+y, 58+x, 181+x);
        bresenhamLine(g, 88+x, 228+y, 57+x, 181+x);

        //star
        int[] xPointsInt = new int[]{58+x, 50+x, 51+x, 46+x, 53+x, 57+x, 61+x, 68+x, 63+x, 64+x};
        int[] yPointsInt = new int[]{181+y, 185+y, 177+y, 172+y, 170+y, 163+y, 170+y, 172+y, 177+y, 185+y};
        g.setColor(Color.decode("#EFEA43"));
        g.fillPolygon(xPointsInt, yPointsInt, xPointsInt.length);

        g.setColor(Color.WHITE);
        xPoints = new double[]{54, 54, 54, 56, 57, 57, 54};
        yPoints = new double[]{174, 174, 172, 170, 169, 169, 174};
        for (int i = 0; i < xPoints.length - 3; i+=3) {
            bezier_Curve(g, new int[] { (int)Math.round(xPoints[i])+x, (int)Math.round(xPoints[i+1])+x,  (int)Math.round(xPoints[i+2])+x, (int)Math.round(xPoints[i+3])+x}, new int[] { (int)Math.round(yPoints[i])+y, (int)Math.round(yPoints[i+1])+y, (int)Math.round(yPoints[i+2])+y, (int)Math.round(yPoints[i+3])+y});
        }

        xPoints = new double[]{54, 54, 53, 54, 55};
        yPoints = new double[]{177, 177, 179, 181, 181};
        for (int i = 0; i < xPoints.length - 3; i+=3) {
            bezier_Curve(g, new int[] { (int)Math.round(xPoints[i])+x, (int)Math.round(xPoints[i+1])+x,  (int)Math.round(xPoints[i+2])+x, (int)Math.round(xPoints[i+3])+x}, new int[] { (int)Math.round(yPoints[i])+y, (int)Math.round(yPoints[i+1])+y, (int)Math.round(yPoints[i+2])+y, (int)Math.round(yPoints[i+3])+y});
        }

        Color borderColor = Color.BLACK;
        Color treeColor = Color.decode("#19B24A");
        buffer = floodFill2(buffer, 56, 190,borderColor ,treeColor);
        buffer = floodFill2(buffer,70,240, borderColor ,treeColor);
        buffer = floodFill2(buffer,70,270, borderColor ,treeColor);
        buffer = floodFill2(buffer,70,280, borderColor ,treeColor);
//        g.setColor(Color.BLUE);
//        plot(g,70,270);


    }


    private void boy(Graphics2D g2d, BufferedImage buffer, int x, int y) {
        // Color c = Color.decode("#FFFFFF");
        Color c = Color.decode("#000000");
        g2d.setColor(c);

        // head
        int[] xPoints = {
                424, 424, 425, 426, 428, 429, 431, 433, 434, 436, 437, 438, 439, 440, 440, 441, 441,
                441, 440, 440, 440,
                440, 440, 439, 439, 438, 438, 438, 438, 437, 437, 437, 436, 435, 434, 433, 433, 432,
                433, 432, 432, 430,
                430, 430, 429, 429, 428, 428, 428, 428, 428, 427, 427, 426, 427, 427, 427, 426, 426,
                425, 425, 424, 424,
                424, 424, 423, 423, 423, 423, 424, 424, 424, 425, 425, 424, 424, 423, 423, 423, 423,
                423, 423, 423, 423,
                423 };

        int[] yPoints = {
                214, 214, 213, 211, 211, 211, 210, 210, 211, 212, 212, 213, 214, 216, 217, 220, 221,
                222, 222, 223, 223,
                224, 224, 226, 226, 227, 228, 228, 227, 227, 228, 229, 229, 230, 230, 231, 231, 231,
                230, 230, 230, 230,
                230, 230, 230, 230, 230, 229, 229, 228, 229, 229, 228, 228, 228, 227, 227, 227, 227,
                227, 227, 226, 226,
                226, 225, 224, 224, 223, 223, 222, 222, 221, 221, 221, 221, 220, 221, 221, 221, 219,
                218, 216, 216, 215,
                215 };

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

        // คอ
        xPoints = new int[] {
                427, 427, 427, 428, 428, 429, 429, 428, 428, 429, 430, 433, 433, 435, 436, 436, 436,
                435, 435, 435, 435,
                436, 437, 437, 437, 438, 438, 438, 438, 437, 436, 434, 433, 432, 431, 428, 427 };
        yPoints = new int[] {
                233, 233, 232, 232, 232, 231, 230, 230, 232, 233, 233, 234, 234, 234, 234, 233, 233,
                231, 231, 231, 231,
                232, 232, 232, 233, 234, 233, 234, 234, 235, 235, 236, 236, 236, 236, 235, 234 };
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

        xPoints = new int[] {
                426, 426, 425, 423, 423, 420, 419, 417, 417, 416, 415, 415, 415, 413, 413, 412, 412,
                412, 412, 411, 410,
                409, 409, 409, 410, 412, 412, 412, 413, 414, 415, 418, 419, 420, 420, 419, 419, 419,
                419, 419, 419, 418,
                418, 417, 417, 417, 417, 417, 417, 417, 416, 417, 418, 420, 422, 425, 425, 429, 430,
                436, 438, 442, 443,
                444, 445, 446, 446, 446, 446, 446, 446, 446, 446, 445, 445, 445, 445, 445, 445, 445,
                445, 445, 445, 445,
                445, 445, 446, 445, 445, 446, 446, 447, 448, 450, 451, 454, 454, 454, 454, 454, 453,
                453, 453, 452, 452,
                451, 451, 450, 450, 450, 449, 449, 448, 447, 447, 445, 445, 443, 443, 441, 441, 439,
                439, 438, 438, 438,
                437, 436, 436, 435, 434, 432, 431, 431, 430, 428, 427, 427, 426 };
        yPoints = new int[] {
                233, 233, 234, 235, 234, 236, 236, 237, 238, 238, 239, 240, 240, 243, 243, 246, 246,
                247, 248, 249, 250,
                251, 251, 252, 252, 255, 255, 256, 256, 257, 257, 257, 257, 257, 258, 260, 262, 267,
                266, 268, 269, 274,
                275, 277, 277, 281, 281, 284, 284, 287, 287, 288, 289, 290, 290, 290, 290, 289, 289,
                289, 288, 288, 288,
                288, 289, 288, 287, 286, 286, 283, 285, 281, 280, 277, 278, 275, 275, 274, 273, 271,
                270, 267, 266, 262,
                262, 261, 260, 258, 258, 257, 258, 258, 258, 257, 257, 255, 255, 255, 255, 254, 253,
                251, 251, 249, 249,
                247, 247, 244, 243, 242, 242, 240, 239, 239, 238, 237, 237, 236, 236, 235, 235, 234,
                234, 234, 234, 235,
                235, 236, 236, 236, 236, 236, 236, 236, 236, 235, 234, 234, 233 };
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
        xPoints = new int[] {
                426, 426, 425, 423, 423, 420, 419, 417, 417, 416, 415, 415, 415, 413, 413, 412, 412,
                412, 412, 411, 410,
                409, 409, 409, 410, 412, 412, 412, 413, 414, 415, 418, 419, 420, 420, 419, 419, 419,
                419, 419, 419, 418,
                418, 417, 417, 417, 417, 417, 417, 417, 416, 417, 418, 420, 422, 425, 425, 429, 430,
                436, 438, 442, 443,
                444, 445, 446, 446, 446, 446, 446, 446, 446, 446, 445, 445, 445, 445, 445, 445, 445,
                445, 445, 445, 445,
                445, 445, 446, 445, 445, 446, 446, 447, 448, 450, 451, 454, 454, 454, 454, 454, 453,
                453, 453, 452, 452,
                451, 451, 450, 450, 450, 449, 449, 448, 447, 447, 445, 445, 443, 443, 441, 441, 439,
                439, 438, 438, 438,
                437, 436, 436, 435, 434, 432, 431, 431, 430, 428, 427, 427, 426 };
        yPoints = new int[] {
                233, 233, 234, 235, 234, 236, 236, 237, 238, 238, 239, 240, 240, 243, 243, 246, 246,
                247, 248, 249, 250,
                251, 251, 252, 252, 255, 255, 256, 256, 257, 257, 257, 257, 257, 258, 260, 262, 267,
                266, 268, 269, 274,
                275, 277, 277, 281, 281, 284, 284, 287, 287, 288, 289, 290, 290, 290, 290, 289, 289,
                289, 288, 288, 288,
                288, 289, 288, 287, 286, 286, 283, 285, 281, 280, 277, 278, 275, 275, 274, 273, 271,
                270, 267, 266, 262,
                262, 261, 260, 258, 258, 257, 258, 258, 258, 257, 257, 255, 255, 255, 255, 254, 253,
                251, 251, 249, 249,
                247, 247, 244, 243, 242, 242, 240, 239, 239, 238, 237, 237, 236, 236, 235, 235, 234,
                234, 234, 234, 235,
                235, 236, 236, 236, 236, 236, 236, 236, 236, 235, 234, 234, 233 };
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

        xPoints = new int[] {
                420, 420, 420, 420, 420, 420, 420, 419, 420 };
        yPoints = new int[] {
                246, 246, 247, 251, 251, 255, 257, 257, 246 };
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

        // เสื้อขึ้นขวา
        xPoints = new int[] {
                446, 446, 446, 446, 446, 446, 446, 445, 446 };
        yPoints = new int[] {
                250, 250, 251, 253, 253, 257, 258, 258, 250 };

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

        // แขน ซ้าย
        xPoints = new int[] {
                450, 451, 450, 450, 450, 451, 451, 452, 452, 452, 452, 452, 452, 452, 452, 452, 452,
                452, 452, 452, 452,
                452, 452, 452, 452, 453, 453, 453, 453, 453, 453, 452, 452, 452, 452, 451, 450, 450,
                449, 449, 449, 449,
                449, 449, 449, 449, 449, 449, 449, 449, 449, 449, 448, 448, 448, 448, 448, 448, 448,
                447, 447, 447, 447,
                447, 447, 447, 447, 448, 448, 448, 448, 448, 448, 447, 447, 447, 447, 446, 446, 446,
                445, 445, 445, 445,
                445, 445, 445, 445, 445, 445, 446, 446, 446, 446, 446, 446, 446, 448, 448, 450, 450 };
        yPoints = new int[] {
                258, 258, 258, 260, 261, 264, 264, 265, 265, 270, 270, 272, 272, 274, 275, 279, 279,
                281, 281, 284, 284,
                285, 286, 287, 287, 288, 288, 290, 290, 291, 292, 293, 293, 295, 296, 296, 297, 297,
                297, 297, 297, 296,
                296, 295, 295, 294, 294, 293, 293, 292, 291, 291, 291, 291, 292, 293, 293, 294, 294,
                294, 293, 293, 292,
                290, 290, 289, 289, 287, 287, 286, 286, 283, 283, 281, 281, 278, 278, 276, 275, 273,
                273, 272, 271, 270,
                269, 267, 267, 266, 265, 262, 262, 261, 260, 259, 258, 258, 258, 258, 258, 258, 258 };

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

        // แขน ขวา
        xPoints = new int[] {
                414, 413, 413, 413, 413, 412, 412, 411, 411, 411, 411, 411, 411, 410, 410, 410, 410,
                410, 410, 409, 409,
                409, 409, 409, 409, 409, 409, 409, 409, 410, 410, 411, 412, 413, 414, 414, 413, 414,
                414, 414, 414, 413,
                413, 413, 413, 413, 412, 412, 413, 414, 414, 415, 416, 417, 417, 418, 418, 419, 419,
                419, 419, 419, 420,
                419, 419, 417, 417, 416, 416, 414, 414 };
        yPoints = new int[] {
                257, 257, 257, 259, 259, 260, 260, 264, 264, 265, 265, 267, 268, 270, 271, 273, 273,
                275, 275, 278, 278,
                280, 280, 281, 283, 286, 286, 290, 291, 292, 292, 292, 292, 291, 290, 288, 288, 287,
                287, 286, 286, 284,
                284, 283, 283, 281, 280, 279, 278, 274, 275, 271, 271, 268, 267, 265, 265, 262, 262,
                259, 259, 258, 257,
                257, 257, 257, 257, 257, 257, 257, 257 };

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

        // กางเกง
        xPoints = new int[] {
                417, 417, 417, 417, 417, 417, 417, 416, 416, 416, 415, 415, 415, 416, 416, 416, 417,
                416, 416, 417, 418,
                420, 421, 423, 424, 427, 427, 428, 428, 428, 428, 429, 429, 428, 428, 427, 427, 428,
                429, 429, 430, 430,
                430, 430, 431, 431, 431, 431, 431, 431, 431, 431, 431, 431, 431, 430, 431, 431, 431,
                430, 430, 431, 431,
                432, 433, 435, 435, 437, 438, 442, 442, 443, 443, 443, 443, 442, 442, 442, 442, 443,
                443, 443, 443, 443,
                444, 444, 444, 445, 445, 446, 446, 446, 446, 446, 446, 446, 445, 443, 444, 439, 439,
                436, 436, 434, 434,
                431, 430, 427, 427, 425, 424, 423, 422, 420, 419, 418, 417 };

        yPoints = new int[] {
                289, 289, 290, 292, 292, 295, 295, 299, 299, 302, 302, 304, 305, 309, 309, 314, 315,
                317, 317, 318, 317,
                316, 316, 316, 315, 315, 315, 314, 314, 311, 311, 308, 308, 306, 306, 305, 305, 303,
                303, 301, 300, 298,
                298, 298, 299, 300, 300, 303, 303, 305, 305, 308, 309, 310, 310, 312, 313, 315, 316,
                318, 319, 320, 320,
                320, 320, 320, 320, 320, 320, 320, 320, 319, 318, 318, 317, 316, 315, 313, 313, 310,
                310, 306, 306, 304,
                304, 301, 301, 298, 298, 294, 292, 291, 290, 289, 288, 288, 288, 288, 288, 289, 289,
                289, 289, 289, 289,
                289, 289, 289, 289, 289, 289, 289, 289, 289, 289, 289, 289 };

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

        // ขา
        // ซ้าย
        xPoints = new int[] { 418, 417, 418, 418, 418, 419, 418, 419, 419, 420, 420, 421, 421, 422, 422, 423,
                423, 423,
                423, 424, 424, 426, 426, 427, 426, 426, 426, 426, 426, 426, 426, 426, 426, 427, 427,
                427, 427, 427, 426,
                426, 425, 423, 424, 419, 418 };
        yPoints = new int[] { 318, 319, 319, 321, 321, 323, 323, 325, 325, 327, 328, 330, 330, 333, 333, 335,
                336, 336,
                335, 334, 334, 332, 332, 332, 331, 330, 329, 327, 327, 324, 324, 323, 323, 320, 320,
                319, 318, 316, 316,
                315, 315, 316, 315, 317, 317 };
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
        // ขวา
        xPoints = new int[] { 432, 432, 431, 431, 431, 431, 431, 431, 431, 431, 431, 431, 431, 431, 431, 431,
                431, 430,
                429, 429, 430, 432, 433, 433, 435, 436, 435, 435, 435, 436, 436, 437, 436, 437, 438,
                438, 438, 439, 439,
                440, 440, 440, 440, 440, 439, 438, 437, 433, 432 };
        yPoints = new int[] { 321, 321, 321, 323, 323, 326, 327, 328, 328, 332, 332, 334, 335, 338, 338, 341,
                341, 342,
                342, 342, 343, 343, 344, 344, 344, 342, 342, 340, 339, 337, 337, 335, 335, 332, 332,
                330, 330, 326, 325,
                325, 324, 321, 321, 321, 321, 321, 321, 321, 320 };
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

        // รองเท้า
        // left
        xPoints = new int[] { 423, 423, 422, 422, 422, 421, 421, 421, 421, 418, 418, 417, 417, 417, 417, 418,
                419, 420,
                421, 423, 424, 426, 426, 426, 426, 426, 426, 427, 428, 429, 429, 430, 430, 431, 431,
                430, 430, 429, 428,
                427, 427, 426, 424 };
        yPoints = new int[] { 336, 337, 338, 338, 339, 341, 341, 342, 343, 346, 346, 346, 347, 350, 350, 352,
                352, 353,
                352, 352, 352, 351, 350, 349, 348, 345, 344, 343, 343, 342, 342, 341, 341, 339, 339,
                338, 337, 335, 335,
                332, 332, 332, 334 };
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

        // right
        xPoints = new int[] { 429, 429, 429, 428, 428, 428, 428, 428, 428, 428, 429, 432, 432, 433, 434, 435,
                435, 436,
                437, 438, 439, 439, 439, 438, 438, 437, 437, 436, 436, 435, 434, 431, 430 };
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
        // g2d.fillRect(435, 217, 1, 1);
        Color borderColor = Color.decode("#000000");
        // hair
        buffer = floodFill2(buffer, 435, 217, borderColor, Color.decode("#472915"));
        // neck
        Color neckColor = Color.decode("#FDEEEF");
        buffer = floodFill2(buffer, 430, 231, borderColor, neckColor);
        // shirt neck
        Color shirtNeck = Color.decode("#1A5D78");
        buffer = floodFill2(buffer, 433, 234, borderColor, shirtNeck);
        // shirt
        Color shirt= Color.decode("#B1E2F9");
        buffer = floodFill2(buffer, 423+x, 250, borderColor, shirt);
        // arm
        //      l
        buffer = floodFill2(buffer, 415+x, 262, borderColor, neckColor);
        //      r
        buffer = floodFill2(buffer, 447+x, 268, borderColor, neckColor);
        // pant
        buffer = floodFill2(buffer, 421+x, 297, borderColor, shirtNeck);
        // leg
        //      l
        buffer = floodFill2(buffer, 422+x, 321, borderColor, neckColor);
        //      r
        buffer = floodFill2(buffer, 435+x, 327, borderColor, neckColor);
        // shoe
        Color shoe = Color.decode("#0C1235");
        //      l
        buffer = floodFill2(buffer, 426, 335, borderColor, shoe);
        //      r
        buffer = floodFill2(buffer, 431, 345, borderColor, shoe);



    }

    private void girl(Graphics2D g2d, BufferedImage buffer, int x, int y) {
        // hair
        // Color c = Color.decode("#563C2B");
        // Color c = Color.decode("#FFFFF");
        Color c = Color.decode("#000000");
        g2d.setColor(c);
        bezier_Curve(g2d, new int[] { 375, 370, 369 }, new int[] { 220, 223, 228 });

        bezier_Curve(g2d, new int[] { 369, 369, 369 }, new int[] { 228, 233, 235 });

        bezier_Curve(g2d, new int[] { 369, 369, 368 }, new int[] { 235, 238, 242 });

        bezier_Curve(g2d, new int[] { 368, 369, 372 }, new int[] { 242, 244, 246 });

        bezier_Curve(g2d, new int[] { 372, 373, 376 }, new int[] { 246, 249, 249 });
        // g2d.setColor(Color.decode("#F15E62"));

        bezier_Curve(g2d, new int[] { 376, 379, 381 }, new int[] { 249, 250, 247 });

        // g2d.setColor(c);
        bezier_Curve(g2d, new int[] { 381, 381, 383 }, new int[] { 247, 244, 244 });

        bezier_Curve(g2d, new int[] { 383, 384, 385 }, new int[] { 244, 241, 238 });

        bezier_Curve(g2d, new int[] { 386, 384, 383 }, new int[] { 238, 231, 224 });

        bezier_Curve(g2d, new int[] { 383, 380, 375 }, new int[] { 224, 220, 220 });
        // buffer = floodFill(buffer, 375, 230,c);

        // shirt
        c = Color.decode("#F15E62");
        // g2d.setColor(c);
        // left part
        bezier_Curve(g2d, new int[] { 368, 366, 365 }, new int[] { 244, 244, 245 });
        bezier_Curve(g2d, new int[] { 365, 361, 356 }, new int[] { 245, 252, 257 });
        bezier_Curve(g2d, new int[] { 356, 357, 359 }, new int[] { 257, 259, 260 });
        bezier_Curve(g2d, new int[] { 359, 360, 362 }, new int[] { 260, 262, 262 });
        bezier_Curve(g2d, new int[] { 362, 362, 365 }, new int[] { 262, 264, 264 });

        bezier_Curve(g2d, new int[] { 367, 366, 366 }, new int[] { 249, 264, 263 });
        bezier_Curve(g2d, new int[] { 365, 366, 364 }, new int[] { 263, 270, 274 });
        bezier_Curve(g2d, new int[] { 365, 366, 364 }, new int[] { 263, 270, 274 });
        bezier_Curve(g2d, new int[] { 364, 369, 376 }, new int[] { 274, 275, 275 });
        bezier_Curve(g2d, new int[] { 376, 384, 388 }, new int[] { 275, 275, 274 });
        // middle
        bezier_Curve(g2d, new int[] { 370, 373, 389 }, new int[] { 246, 257, 271 });

        // right part
        bezier_Curve(g2d, new int[] { 382, 388, 389 }, new int[] { 244, 246, 248 });
        bezier_Curve(g2d, new int[] { 384, 388, 389 }, new int[] { 244, 246, 248 });
        bezier_Curve(g2d, new int[] { 389, 390, 397 }, new int[] { 248, 254, 261 });
        bezier_Curve(g2d, new int[] { 397, 394, 391 }, new int[] { 261, 264, 265 });
        bezier_Curve(g2d, new int[] { 391, 389, 389 }, new int[] { 265, 262, 260 });
        bezier_Curve(g2d, new int[] { 391, 390, 388 }, new int[] { 265, 267, 267 });
        bezier_Curve(g2d, new int[] { 386, 387, 388 }, new int[] { 256, 266, 276 });
        // buffer = floodFill(buffer, 372, 260, c);
        // plot(g2d, 372, 260,1);

        // skirt
        bezier_Curve(g2d, new int[] { 365, 363, 362 }, new int[] { 275, 279, 284 });
        bezier_Curve(g2d, new int[] { 362, 362, 360 }, new int[] { 284, 290, 294 });
        bezier_Curve(g2d, new int[] { 360, 364, 369 }, new int[] { 294, 296, 298 });
        bezier_Curve(g2d, new int[] { 369, 372, 375 }, new int[] { 298, 296, 297 });
        bezier_Curve(g2d, new int[] { 369, 372, 375 }, new int[] { 298, 296, 297 });
        bezier_Curve(g2d, new int[] { 375, 380, 385 }, new int[] { 297, 298, 297 });
        bezier_Curve(g2d, new int[] { 385, 390, 392 }, new int[] { 297, 297, 296 });
        bezier_Curve(g2d, new int[] { 392, 393, 395 }, new int[] { 296, 294, 294 });

        bezier_Curve(g2d, new int[] { 372, 370, 369 }, new int[] { 276, 280, 288 });
        bezier_Curve(g2d, new int[] { 380, 383, 386 }, new int[] { 275, 280, 287 });

        // right side
        bezier_Curve(g2d, new int[] { 388, 389, 391 }, new int[] { 273, 280, 283 });
        bezier_Curve(g2d, new int[] { 391, 393, 395 }, new int[] { 283, 288, 294 });

        // leg
        // left leg
        bezier_Curve(g2d, new int[] { 365, 366, 366 }, new int[] { 297, 302, 309 });
        bezier_Curve(g2d, new int[] { 366, 365, 365 }, new int[] { 309, 314, 317 });
        bezier_Curve(g2d, new int[] { 365, 365, 365 }, new int[] { 317, 326, 338 });
        bezier_Curve(g2d, new int[] { 365, 367, 365 }, new int[] { 338, 341, 343 });
        bezier_Curve(g2d, new int[] { 365, 365, 363 }, new int[] { 343, 346, 347 });
        bezier_Curve(g2d, new int[] { 363, 368, 371 }, new int[] { 347, 350, 348 });
        bezier_Curve(g2d, new int[] { 371, 373, 373 }, new int[] { 348, 345, 344 });
        bezier_Curve(g2d, new int[] { 373, 373, 372 }, new int[] { 344, 342, 337 });
        bezier_Curve(g2d, new int[] { 373, 373, 372 }, new int[] { 344, 342, 337 });
        bezier_Curve(g2d, new int[] { 371, 369, 367 }, new int[] { 338, 338, 338 });
        bezier_Curve(g2d, new int[] { 372, 371, 371 }, new int[] { 337, 334, 330 });
        bezier_Curve(g2d, new int[] { 371, 369, 366 }, new int[] { 330, 328, 330 });
        bezier_Curve(g2d, new int[] { 371, 372, 374 }, new int[] { 330, 322, 316 });
        bezier_Curve(g2d, new int[] { 374, 374, 373 }, new int[] { 316, 313, 311 });
        bezier_Curve(g2d, new int[] { 373, 373, 374 }, new int[] { 311, 306, 298 });
        bresenhamLine(g2d, 373, 297, 374, 303);
        // right leg
        bezier_Curve(g2d, new int[] { 380, 379, 380 }, new int[] { 298, 303, 308 });
        bezier_Curve(g2d, new int[] { 380, 380, 380 }, new int[] { 308, 312, 318 });
        bezier_Curve(g2d, new int[] { 380, 378, 378 }, new int[] { 318, 324, 331 });
        bezier_Curve(g2d, new int[] { 378, 378, 377 }, new int[] { 331, 338, 347 });
        bezier_Curve(g2d, new int[] { 377, 376, 382 }, new int[] { 347, 349, 350 });
        bezier_Curve(g2d, new int[] { 382, 379, 378 }, new int[] { 341, 341, 340 });
        bezier_Curve(g2d, new int[] { 382, 382, 382 }, new int[] { 350, 344, 340 });
        bezier_Curve(g2d, new int[] { 382, 382, 384 }, new int[] { 340, 336, 333 });
        bezier_Curve(g2d, new int[] { 384, 385, 386 }, new int[] { 333, 326, 314 });
        bezier_Curve(g2d, new int[] { 386, 389, 388 }, new int[] { 314, 305, 297 });
        bezier_Curve(g2d, new int[] { 374+4, 377+4, 380+4 }, new int[] { 332, 333, 332 });
        bezier_Curve(g2d, new int[]{367+x, 367+x, 367+x, 368+x}, new int[]{339+y, 339+y, 339+y, 339+y});
        bezier_Curve(g2d, new int[]{368+x, 368+x, 369+x, 369+x}, new int[]{339+y, 338+y, 338+y, 338+y});
        bezier_Curve(g2d, new int[]{369+x, 370+x, 370+x, 371+x}, new int[]{338+y, 338+y, 338+y, 338+y});
        bezier_Curve(g2d, new int[]{371+x, 372+x, 372+x, 372+x}, new int[]{338+y, 338+y, 338+y, 338+y});
        bezier_Curve(g2d, new int[]{372+x, 372+x, 371+x, 371+x}, new int[]{338+y, 338+y, 338+y, 338+y});
        bezier_Curve(g2d, new int[]{371+x, 370+x, 370+x, 368+x}, new int[]{338+y, 338+y, 338+y, 338+y});
        bezier_Curve(g2d, new int[]{368+x, 368+x, 368+x, 367+x}, new int[]{338+y, 338+y, 338+y, 338+y});
        bezier_Curve(g2d, new int[]{367+x, 367+x, 367+x, 367+x}, new int[]{338+y, 339+y, 339+y, 339+y});


        // arm
        // left arm
        // bezier_Curve(g2d, new int[]{363-5, 361-5, 363-5 }, new int[]{262,266, 272});
        // bezier_Curve(g2d, new int[]{363-5, 367-5, 368-5 }, new int[]{272,271, 270});
        // bezier_Curve(g2d, new int[]{368-5, 368-5, 367-5 }, new int[]{265,266, 268});
        bezier_Curve(g2d, new int[] { 360, 358, 360 }, new int[] { 262, 266, 271 });
        bezier_Curve(g2d, new int[] { 360, 364, 365 }, new int[] { 271, 272, 270 });
        bezier_Curve(g2d, new int[] { 365, 364, 365 }, new int[] { 268, 267, 266 });

        // right arm
        bezier_Curve(g2d, new int[] { 391, 393, 395 }, new int[] { 265, 268, 270 });
        bezier_Curve(g2d, new int[] { 395, 399, 407 }, new int[] { 270, 276, 283 });
        bezier_Curve(g2d, new int[] { 407, 407, 407 }, new int[] { 283, 286, 288 });
        bezier_Curve(g2d, new int[] { 407, 407, 407 }, new int[] { 283, 286, 288 });
        bezier_Curve(g2d, new int[] { 407, 411, 414 }, new int[] { 288, 291, 290 });
        bezier_Curve(g2d, new int[] { 414, 414, 414 }, new int[] { 290, 287, 280 });
        bezier_Curve(g2d, new int[] { 414, 412, 409 }, new int[] { 280, 284, 282 });
        bezier_Curve(g2d, new int[] { 414, 412, 409 }, new int[] { 280, 284, 282 });
        bezier_Curve(g2d, new int[] { 409, 404, 400 }, new int[] { 282, 274, 268 });
        bezier_Curve(g2d, new int[] { 400, 397, 396 }, new int[] { 268, 265, 263 });

        // hair
        Color borderColor = Color.decode("#000000");
        Color hairColor = Color.decode("#563C2B");
        g2d.setColor(hairColor);
        buffer = floodFill2(buffer, 378, 233,borderColor ,hairColor);
        // shirt
        Color shirtColor = Color.decode("#F15E62");
        g2d.fillRect(370, 258, 2, 2);
        buffer = floodFill2(buffer, 370, 258, borderColor, shirtColor);
        buffer = floodFill2(buffer, 382, 258, borderColor, shirtColor);
        // hand
        Color handColor = Color.decode("#FDEEEF");
        // // Color handColor = Color.decode("#D88D8D");
        buffer = floodFill2(buffer, 361, 267, borderColor, handColor);
        buffer = floodFill2(buffer, 399, 271, borderColor, handColor);
        // skirt
        Color skirtColor = Color.decode("#F5842A");
        buffer = floodFill2(buffer, 378, 284, borderColor, skirtColor);
        // // leg
        buffer = floodFill2(buffer, 368, 315, borderColor, handColor);
        buffer = floodFill2(buffer, 383, 331, borderColor, handColor);
        // sock
        Color sockColor = Color.decode("#666AB0");
        buffer = floodFill2(buffer, 368, 334, borderColor, sockColor);
        buffer = floodFill2(buffer, 380, 336, borderColor, sockColor);
        // // shoe
        Color shoeColor = Color.decode("#F4823F");
        buffer = floodFill2(buffer, 370, 345, borderColor, shoeColor);
        // g2d.setColor(Color.red);
        // // g2d.fillRect(380, 345, 1, 1);
        buffer = floodFill2(buffer, 379, 345, borderColor, shoeColor);

    }

    private void star(Graphics2D g2d) {
        g2d.setColor(Color.white);
        Random ran = new Random();
        for (int i = 0; i <= 50; i++) {
            int x = ran.nextInt(600);
            int y = ran.nextInt(200);

            plot(g2d, x + 10, y + 10, 1);
        }

    }

    private void firework(Graphics2D g2d,BufferedImage buffer) {
        fireworkPoint1(g2d,buffer,  0, 0, Color.decode("#EA4645"));
    }

    private void fireworkPoint1(Graphics2D g2d, BufferedImage buffer, int x, int y, Color color) {
        g2d.setColor(color);

        // 1
        bezier_Curve(g2d, new int[] { 446 + x, 446 + x, 449 + x, 450 + x },
                new int[] { 10 + y, 10 + y, 13 + y, 17 + y });
        bezier_Curve(g2d, new int[] { 450 + x, 453 + x, 454 + x, 454 + x },
                new int[] { 17 + y, 23 + y, 29 + y, 29 + y });
        bezier_Curve(g2d, new int[] { 450 + x, 453 + x, 453 + x, 453 + x },
                new int[] { 17 + y, 29 + y, 28 + y, 28 + y });
        bezier_Curve(g2d, new int[] { 453 + x, 452 + x, 452 + x, 450 + x },
                new int[] { 28 + y, 25 + y, 25 + y, 20 + y });
        bezier_Curve(g2d, new int[] { 450 + x, 448 + x, 446 + x, 446 + x },
                new int[] { 20 + y, 15 + y, 10 + y, 10 + y });
        // bezier_Curve(g2d, new int[]{}, new int[]{});
        // bezier_Curve(g2d, new int[]{}, new int[]{});
        // bezier_Curve(g2d, new int[]{}, new int[]{});
        // bezier_Curve(g2d, new int[]{}, new int[]{});
        // 2
        bezier_Curve(g2d, new int[] { 432 + x, 440 + x, 452 + x }, new int[] { 21 + y, 31 + y, 42 + y });
        bezier_Curve(g2d, new int[] { 432 + x, 445 + x, 452 + x }, new int[] { 21 + y, 28 + y, 42 + y });
        // 3
        bezier_Curve(g2d, new int[] { 418 + x, 429 + x, 440 + x }, new int[] { 39 + y, 36 + y, 38 + y });
        bezier_Curve(g2d, new int[] { 418 + x, 429 + x, 440 + x }, new int[] { 39 + y, 40 + y, 38 + y });
        // 4
        bezier_Curve(g2d, new int[] { 419 + x, 431 + x, 442 + x }, new int[] { 47 + y, 45 + y, 46 + y });
        bezier_Curve(g2d, new int[] { 419 + x, 431 + x, 442 + x }, new int[] { 47 + y, 49 + y, 46 + y });
        // 5
        bezier_Curve(g2d, new int[] { 409 + x, 417 + x, 430 + x }, new int[] { 62 + y, 55 + y, 54 + y });
        bezier_Curve(g2d, new int[] { 409 + x, 419 + x, 430 + x }, new int[] { 62 + y, 58 + y, 54 + y });
        // 6
        bezier_Curve(g2d, new int[] { 404 + x, 412 + x, 427 + x }, new int[] { 75 + y, 65 + y, 59 + y });
        bezier_Curve(g2d, new int[] { 404 + x, 416 + x, 427 + x }, new int[] { 75 + y, 69 + y, 59 + y });
        // 7
        bezier_Curve(g2d, new int[] { 416 + x, 421 + x, 431 + x }, new int[] { 75 + y, 66 + y, 62 + y });
        bezier_Curve(g2d, new int[] { 416 + x, 424 + x, 431 + x }, new int[] { 75 + y, 69 + y, 62 + y });
        // 8
        bezier_Curve(g2d, new int[] { 414 + x, 422 + x, 431 + x }, new int[] { 88 + y, 77 + y, 72 + y });
        bezier_Curve(g2d, new int[] { 414 + x, 424 + x, 431 + x }, new int[] { 88 + y, 81 + y, 72 + y });
        // 9
        bezier_Curve(g2d, new int[] { 427 + x, 429 + x, 436 + x }, new int[] { 87 + y, 79 + y, 72 + y });
        bezier_Curve(g2d, new int[] { 427 + x, 433 + x, 436 + x }, new int[] { 87 + y, 80 + y, 72 + y });
        // 10
        bezier_Curve(g2d, new int[] { 433 + x, 435 + x, 444 + x }, new int[] { 99 + y, 89 + y, 79 + y });
        bezier_Curve(g2d, new int[] { 433 + x, 439 + x, 444 + x }, new int[] { 99 + y, 90 + y, 79 + y });
        // 11
        bezier_Curve(g2d, new int[] { 439 + x, 440 + x, 444 + x }, new int[] { 110 + y, 99 + y, 88 + y });
        bezier_Curve(g2d, new int[] { 439 + x, 443 + x, 444 + x }, new int[] { 110 + y, 100 + y, 88 + y });
        // 12
        bezier_Curve(g2d, new int[] { 449 + x, 449 + x, 452 + x }, new int[] { 95 + y, 84 + y, 74 + y });
        bezier_Curve(g2d, new int[] { 449 + x, 453 + x, 452 + x }, new int[] { 95 + y, 85 + y, 74 + y });
        // 13
        bezier_Curve(g2d, new int[] { 457 + x, 456 + x, 457 + x }, new int[] { 109 + y, 99 + y, 88 + y });
        bezier_Curve(g2d, new int[] { 457 + x, 459 + x, 457 + x }, new int[] { 109 + y, 99 + y, 88 + y });
        // 14
        bezier_Curve(g2d, new int[] { 459 + x, 460 + x, 465 + x }, new int[] { 70 + y, 80 + y, 92 + y });
        bezier_Curve(g2d, new int[] { 459 + x, 463 + x, 465 + x }, new int[] { 70 + y, 80 + y, 92 + y });
        // 15
        bezier_Curve(g2d, new int[] { 469 + x, 470 + x, 476 + x }, new int[] { 79 + y, 91 + y, 104 + y });
        bezier_Curve(g2d, new int[] { 469 + x, 473 + x, 476 + x }, new int[] { 79 + y, 90 + y, 104 + y });
        // 16
        bezier_Curve(g2d, new int[] { 465 + x, 470 + x, 477 + x }, new int[] { 68 + y, 78 + y, 88 + y });
        bezier_Curve(g2d, new int[] { 465 + x, 473 + x, 477 + x }, new int[] { 68 + y, 75 + y, 88 + y });
        // 17
        bezier_Curve(g2d, new int[] { 477 + x, 480 + x, 487 + x }, new int[] { 72 + y, 80 + y, 88 + y });
        bezier_Curve(g2d, new int[] { 477 + x, 483 + x, 487 + x }, new int[] { 72 + y, 77 + y, 88 + y });
        // 18
        bezier_Curve(g2d, new int[] { 478 + x, 488 + x, 497 + x }, new int[] { 63 + y, 75 + y, 92 + y });
        bezier_Curve(g2d, new int[] { 478 + x, 491 + x, 497 + x }, new int[] { 63 + y, 72 + y, 92 + y });
        // 19
        bezier_Curve(g2d, new int[] { 477 + x, 488 + x, 498 + x }, new int[] { 56 + y, 62 + y, 71 + y });
        bezier_Curve(g2d, new int[] { 477 + x, 490 + x, 498 + x }, new int[] { 56 + y, 60 + y, 71 + y });
        // 20
        bezier_Curve(g2d, new int[] { 500 + x, 502 + x, 507 + x }, new int[] { 53 + y, 57 + y, 60 + y });
        bezier_Curve(g2d, new int[] { 500 + x, 504 + x, 507 + x }, new int[] { 53 + y, 55 + y, 60 + y });
        // 21
        bezier_Curve(g2d, new int[] { 473 + x, 486 + x, 496 + x }, new int[] { 52 + y, 50 + y, 51 + y });
        bezier_Curve(g2d, new int[] { 473 + x, 484 + x, 496 + x }, new int[] { 52 + y, 47 + y, 51 + y });
        // 22
        bezier_Curve(g2d, new int[] { 466 + x, 472 + x, 485 + x }, new int[] { 52 + y, 44 + y, 39 + y });
        bezier_Curve(g2d, new int[] { 466 + x, 476 + x, 485 + x }, new int[] { 52 + y, 45 + y, 39 + y });
        // 23
        bezier_Curve(g2d, new int[] { 460 + x, 461 + x, 464 + x }, new int[] { 37 + y, 29 + y, 23 + y });
        bezier_Curve(g2d, new int[] { 460 + x, 463 + x, 464 + x }, new int[] { 37 + y, 31 + y, 23 + y });
        // 24
        bezier_Curve(g2d, new int[] { 462 + x, 464 + x, 468 + x }, new int[] { 43 + y, 36 + y, 30 + y });
        bezier_Curve(g2d, new int[] { 462 + x, 466 + x, 468 + x }, new int[] { 43 + y, 38 + y, 30 + y });
        // 25
        bezier_Curve(g2d, new int[] { 456 + x, 456 + x, 458 + x }, new int[] { 37 + y, 40 + y, 43 + y });
        bezier_Curve(g2d, new int[] { 456 + x, 458 + x, 458 + x }, new int[] { 37 + y, 40 + y, 43 + y });
        // 26
        bezier_Curve(g2d, new int[] { 443 + x, 446 + x, 451 + x }, new int[] { 42 + y, 45 + y, 46 + y });
        bezier_Curve(g2d, new int[] { 443 + x, 448 + x, 451 + x }, new int[] { 42 + y, 42 + y, 46 + y });
        // 27
        bezier_Curve(g2d, new int[] { 436 + x, 441 + x, 445 + x }, new int[] { 53 + y, 51 + y, 52 + y });
        bezier_Curve(g2d, new int[] { 436 + x, 441 + x, 445 + x }, new int[] { 53 + y, 53 + y, 52 + y });
        // 28
        bezier_Curve(g2d, new int[] { 448 + x, 442 + x, 434 + x }, new int[] { 55 + y, 54 + y, 56 + y });
        bezier_Curve(g2d, new int[] { 448 + x, 442 + x, 434 + x }, new int[] { 55 + y, 56 + y, 56 + y });
        // 29 skip
        // 30
        bezier_Curve(g2d, new int[] { 451 + x, 441 + x, 435 + x }, new int[] { 60 + y, 60 + y, 67 + y });
        bezier_Curve(g2d, new int[] { 451 + x, 443 + x, 435 + x }, new int[] { 60 + y, 63 + y, 67 + y });
        // 31 skip
        // 32
        bezier_Curve(g2d, new int[] { 452 + x, 448 + x, 447 + x }, new int[] { 64 + y, 69 + y, 78 + y });
        bezier_Curve(g2d, new int[] { 452 + x, 451 + x, 447 + x }, new int[] { 64 + y, 71 + y, 78 + y });
        // 35
        bezier_Curve(g2d, new int[] { 459 + x, 465 + x, 470 + x }, new int[] { 62 + y, 63 + y, 68 + y });
        bezier_Curve(g2d, new int[] { 459 + x, 463 + x, 470 + x }, new int[] { 62 + y, 66 + y, 68 });

        bezier_Curve(g2d, new int[] { 462 + x, 465 + x, 469 + x }, new int[] { 58 + y, 56 + y, 56 + y });
        bezier_Curve(g2d, new int[] { 462 + x, 466 + x, 469 + x }, new int[] { 58 + y, 58 + y, 56 + y });

        bezier_Curve(g2d, new int[] { 461 + x, 459 + x, 459 + x }, new int[] { 49 + y, 52 + y, 55 + y });
        bezier_Curve(g2d, new int[] { 461 + x, 460 + x, 459 + x }, new int[] { 49 + y, 52 + y, 55 + y });

        bezier_Curve(g2d, new int[] { 452 + x, 450 + x, 445 + x }, new int[] { 51 + y, 48 + y, 48 + y });
        bezier_Curve(g2d, new int[] { 452 + x, 448 + x, 445 + x }, new int[] { 51 + y, 50 + y, 48 + y });

        // g2d.drawRect(442, 31, 1, 1);
        // g2d.drawRect(442, 31, 1, 1);
        // g2d.drawRect(442, 31, 1, 1);
        // g2d.drawRect(442, 31, 1, 1);
        buffer = floodFill(buffer, 442+x, 30+y, color);
        buffer = floodFill(buffer, 427+x, 38+y, color);
        buffer = floodFill(buffer, 431+x, 46+y, color);
        g2d.setColor(Color.magenta);
        g2d.drawRect(431, 46, 1, 1);

    }

    public static void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }


    private void cat(Graphics g, BufferedImage buffer, int y) {
        g.setColor(Color.black);
        //head
        bezier_Curve(g, new int[] { 338, 330,  325}, new int[] { 493, 487,  484});
        bezier_Curve(g, new int[] { 321, 324,  325}, new int[] { 484, 483,  484});
        bezier_Curve(g, new int[] { 321, 324,  321, 321}, new int[] { 484, 484,  485, 486});
        bezier_Curve(g, new int[] { 321, 321,  322}, new int[] { 486, 487,  488});
        bezier_Curve(g, new int[] { 322, 322, 322}, new int[] { 488, 490, 491});
        bezier_Curve(g, new int[] { 322, 323, 323}, new int[] { 491, 491, 492});
        bezier_Curve(g, new int[] { 323, 324,  324}, new int[] { 492, 493,  494});
        bezier_Curve(g, new int[] { 321, 324,  325, 326}, new int[] { 484, 495,  495, 498});
        bezier_Curve(g, new int[] { 326, 327,  327, 327}, new int[] { 498, 499,  500, 500});
        bezier_Curve(g, new int[] { 327, 328,  327, 328}, new int[] { 500, 502,  502, 504});
        bezier_Curve(g, new int[] { 328, 328,  328, 329}, new int[] { 504, 505,  505, 506});
        bezier_Curve(g, new int[] { 329, 330,  330, 330}, new int[] { 506, 507,  507, 508});
        bezier_Curve(g, new int[] { 330, 330,  330, 330}, new int[] { 508, 509,  509, 510});
        bezier_Curve(g, new int[] { 330, 329,  329, 329}, new int[] { 510, 511,  512, 514});
        bezier_Curve(g, new int[] { 329, 329,  329, 329}, new int[] { 514, 517,  517, 519});
        bezier_Curve(g, new int[] { 329, 329,  329, 329}, new int[] { 519, 520,  521, 522});
        bezier_Curve(g, new int[] { 329, 329,  328, 329}, new int[] { 522, 526,  527, 529});
        bezier_Curve(g, new int[] { 329, 329,  329, 329}, new int[] { 529, 529,  530, 530});
        bezier_Curve(g, new int[] { 329, 330,  329, 330}, new int[] { 530, 531,  531, 532});
        bezier_Curve(g, new int[] { 330, 330,  330, 331}, new int[] { 532, 532,  532, 533});
        bezier_Curve(g, new int[] { 331, 332,  331, 332}, new int[] { 533, 534,  534, 536});
        bezier_Curve(g, new int[] { 332, 333,  333, 333}, new int[] { 536, 537,  537, 538});
        bezier_Curve(g, new int[] { 333, 334,  334, 334}, new int[] { 538, 539,  539, 540});
        bezier_Curve(g, new int[] { 334, 334,  335, 335}, new int[] { 540, 541,  541, 542});
        bezier_Curve(g, new int[] { 335, 336,  336, 337}, new int[] { 542, 543,  544, 544});
        bezier_Curve(g, new int[] { 337, 337,  337, 337}, new int[] { 544, 544,  544, 544});
        bezier_Curve(g, new int[] { 337, 337,  337, 337}, new int[] { 544, 543,  543, 542});
        bezier_Curve(g, new int[] { 337, 337,  340, 341}, new int[] { 542, 541,  541, 540});
        bezier_Curve(g, new int[] { 341, 342,  342, 345}, new int[] { 540, 540,  540, 540});
        bezier_Curve(g, new int[] { 345, 346,  347, 348}, new int[] { 540, 540,  540, 539});
        bezier_Curve(g, new int[] { 348, 350,  351, 351}, new int[] { 539, 540,  539, 538});
        bezier_Curve(g, new int[] { 351, 351,  351, 352}, new int[] { 538, 538,  537, 538});
        bezier_Curve(g, new int[] { 352, 353,  353, 354}, new int[] { 538, 537,  538, 538});
        bezier_Curve(g, new int[] { 354, 356,  360, 361}, new int[] { 538, 540,  540, 538});
        bezier_Curve(g, new int[] { 361, 361,  361, 361}, new int[] { 538, 538,  538, 538});
        bezier_Curve(g, new int[] { 361, 363,  364, 365}, new int[] { 538, 537,  538, 537});
        bezier_Curve(g, new int[] { 365, 366,  366, 366}, new int[] { 537, 536,  536, 535});
        bezier_Curve(g, new int[] { 366, 367,  369, 372}, new int[] { 535, 537,  532, 530});
        bezier_Curve(g, new int[] { 372, 375,  376, 377}, new int[] { 530, 529,  529, 528});
        bezier_Curve(g, new int[] { 377, 378,  378, 379}, new int[] { 528, 528,  528, 528});
        bezier_Curve(g, new int[] { 379, 380,  380, 381}, new int[] { 528, 528,  528, 528});
        bezier_Curve(g, new int[] { 381, 382,  382, 382}, new int[] { 528, 528,  527, 527});
        bezier_Curve(g, new int[] { 382, 382,  382, 382}, new int[] { 527, 526,  526, 525});
        bezier_Curve(g, new int[] { 382, 382,  382, 383}, new int[] { 525, 525,  525, 524});
        bezier_Curve(g, new int[] { 383, 383,  383, 383}, new int[] { 524, 523,  523, 521});
        bezier_Curve(g, new int[] { 383, 383, 382}, new int[] { 521, 520, 519});
        bezier_Curve(g, new int[] { 382, 382,  383, 383}, new int[] { 519, 517,  517, 515});
        bezier_Curve(g, new int[] { 383, 382,  383, 383}, new int[] { 515, 517,  517, 515});
        bezier_Curve(g, new int[] { 383, 382,  382, 382}, new int[] { 515, 514,  513, 512});
        bezier_Curve(g, new int[] { 382, 382,  382, 382}, new int[] { 512, 510,  509, 509});
        bezier_Curve(g, new int[] { 382, 382,  382, 381}, new int[] { 509, 508,  507, 507});
        bezier_Curve(g, new int[] { 381, 381,  382, 382}, new int[] { 507, 506,  506, 506});
        bezier_Curve(g, new int[] { 382, 384,  384, 384}, new int[] { 506, 505,  505, 501});
        bezier_Curve(g, new int[] { 384, 384,  383, 384}, new int[] { 501, 501,  500, 499});
        bezier_Curve(g, new int[] { 384, 384,  384, 385}, new int[] { 499, 499,  499, 498});
        bezier_Curve(g, new int[] { 385, 385,  385, 387}, new int[] { 498, 498,  497, 494});
        bezier_Curve(g, new int[] { 387, 389,  389, 389}, new int[] { 494, 490,  490, 490});
        bezier_Curve(g, new int[] { 389, 390,  390, 391}, new int[] { 490, 488,  488, 487});
        bezier_Curve(g, new int[] { 391, 391,  392, 390}, new int[] { 487, 487,  484, 483});
        bezier_Curve(g, new int[] { 390, 390,  389, 389}, new int[] { 483, 483,  483, 483});
        bezier_Curve(g, new int[] { 389, 388,  388, 388}, new int[] { 483, 483,  483, 483});
        bezier_Curve(g, new int[] { 388, 381,  376}, new int[] { 483, 488,  491});
        bezier_Curve(g, new int[] { 376, 374,  373, 372}, new int[] { 491, 492,  493, 493});
        bezier_Curve(g, new int[] { 372, 371,  371, 370}, new int[] { 493, 493,  493, 493});
        bezier_Curve(g, new int[] { 370, 368,  368, 368}, new int[] { 493, 494,  494, 494});
        bezier_Curve(g, new int[] { 368, 366,  364, 362}, new int[] { 494, 495,  492, 493});
        bezier_Curve(g, new int[] { 362, 362,  362, 361}, new int[] { 493, 493,  493, 493});
        bezier_Curve(g, new int[] { 361, 360,  360, 359}, new int[] { 493, 493,  493, 492});
        bezier_Curve(g, new int[] { 359, 358,  358, 356}, new int[] { 492, 492,  492, 493});
        bezier_Curve(g, new int[] { 356, 355,  355, 353}, new int[] { 493, 493,  493, 493});
        bezier_Curve(g, new int[] { 353, 353,  352, 351}, new int[] { 493, 493,  493, 493});
        bezier_Curve(g, new int[] { 351, 348,  347, 346}, new int[] { 493, 493,  493, 493});
        bezier_Curve(g, new int[] { 346, 345,  345, 344}, new int[] { 493, 493,  494, 494});
        bezier_Curve(g, new int[] { 344, 342,  340, 339}, new int[] { 494, 496,  494, 494});
        bezier_Curve(g, new int[] { 339, 339,  338}, new int[] { 494, 493,  493});
        bezier_Curve(g, new int[] { 338, 330,  325}, new int[] { 493, 487,  484});
        bezier_Curve(g, new int[] { 325, 324,  321}, new int[] { 484, 483,  484});

        //left-eye
        bezier_Curve(g, new int[] { 341, 341,  342, 343}, new int[] { 510, 510,  510, 510});
        bezier_Curve(g, new int[] { 343, 344,  344, 346}, new int[] { 510, 510,  510, 510});
        bezier_Curve(g, new int[] { 346, 347,  348, 350}, new int[] { 510, 510,  510, 511});
        bezier_Curve(g, new int[] { 350, 351,  352, 352}, new int[] { 511, 511,  512, 513});
        bezier_Curve(g, new int[] { 352, 352,  352, 352}, new int[] { 513, 513,  514, 514});
        bezier_Curve(g, new int[] { 352, 352,  352, 350}, new int[] { 514, 514,  515, 515});
        bezier_Curve(g, new int[] { 350, 347,  344, 344}, new int[] { 515, 516,  514, 514});
        bezier_Curve(g, new int[] { 344, 342,  341, 341}, new int[] { 514, 512,  511, 511});
        bezier_Curve(g, new int[] { 341, 341,  341, 341}, new int[] { 511, 510,  510, 510});

        //inner-left-eye
        bezier_Curve(g, new int[] { 345, 345,  345, 345}, new int[] { 511, 509,  512, 512});
        bezier_Curve(g, new int[] { 345, 345,  345, 346}, new int[] { 512, 512,  514, 514});
        bezier_Curve(g, new int[] { 346, 347,  348, 348}, new int[] { 514, 514,  513, 512});
        bezier_Curve(g, new int[] { 348, 348,  348, 348}, new int[] { 512, 511,  511, 510});

        buffer = floodFill(buffer, 346, 512, Color.decode("#80C014"), Color.decode("#000000"));



        //right-eye
        bezier_Curve(g, new int[] { 364, 364,  364, 365}, new int[] { 514, 513,  513, 512});
        bezier_Curve(g, new int[] { 365, 366,  368, 369}, new int[] { 512, 510,  510, 510});
        bezier_Curve(g, new int[] { 369, 370,  370, 371}, new int[] { 510, 510,  510, 510});
        bezier_Curve(g, new int[] { 371, 374,  375, 375}, new int[] { 510, 510,  510, 510});
        bezier_Curve(g, new int[] { 375, 375,  374, 373}, new int[] { 510, 511,  512, 513});
        bezier_Curve(g, new int[] { 373, 372,  371, 369}, new int[] { 513, 514,  515, 515});
        bezier_Curve(g, new int[] { 369, 367,  364, 364}, new int[] { 515, 515,  515, 514});

        //inner right eye
        bezier_Curve(g, new int[] { 367, 367,  367, 368}, new int[] { 511, 510,  513, 513});
        bezier_Curve(g, new int[] { 368, 369,  369, 370}, new int[] { 513, 513,  513, 513});
        bezier_Curve(g, new int[] { 370, 371,  371, 370}, new int[] { 513, 512,  511, 510});
        buffer = floodFill(buffer, 369, 511, Color.decode("#80C014"), Color.decode("#000000"));

        //pre-nose
        bezier_Curve(g, new int[] { 351, 351,  352, 352}, new int[] { 514, 515,  516, 518});
        bezier_Curve(g, new int[] { 352, 353,  353, 354}, new int[] { 518, 522,  525, 525});
        bezier_Curve(g, new int[] { 363, 363,  364, 364}, new int[] { 526, 526,  525, 525});
        bezier_Curve(g, new int[] { 364, 365,  364, 364}, new int[] { 525, 524,  522, 521});
        bezier_Curve(g, new int[] { 364, 364,  363, 364}, new int[] { 521, 520,  518, 515});

        g.setColor(Color.decode("#5A3F2B"));
        g.drawPolygon(new int[]{354, 364, 359}, new int[]{525, 525, 530}, 3);
        g.setColor(Color.decode("#000000"));
        g.drawPolygon(new int[]{360, 361, 362, 361}, new int[]{527, 526, 527, 528}, 4);
        buffer = floodFill(buffer, 361, 527, Color.decode("#80C014"), Color.decode("#000000"));

        g.drawPolygon(new int[]{355, 356, 357, 356}, new int[]{526, 526, 526, 527}, 4);
        buffer = floodFill(buffer, 356, 526, Color.decode("#80C014"), Color.decode("#000000"));
        buffer = floodFill(buffer, 359, 526, Color.decode("#80C014"), Color.decode("#5A3F2B"));
//        buffer = floodFill(buffer, 360, 527, Color.decode("#80C014"), Color.decode("#5A3F2B"));

        //collar
        bezier_Curve(g, new int[] { 337, 337,  337, 337}, new int[] { 545, 542,  545, 547});
        bezier_Curve(g, new int[] { 337, 337,  338, 338}, new int[] { 547, 548,  547, 548});
        bezier_Curve(g, new int[] { 338, 338,  338, 338}, new int[] { 548, 549,  549, 550});
        bezier_Curve(g, new int[] { 338, 338,  339, 339}, new int[] { 550, 550,  551, 551});
        bezier_Curve(g, new int[] { 339, 340,  340, 340}, new int[] { 551, 551,  550, 550});
        bezier_Curve(g, new int[] { 340, 340,  340, 340}, new int[] { 550, 550,  551, 551});
        bezier_Curve(g, new int[] { 340, 341,  346, 347}, new int[] { 551, 552,  549, 549});
        bezier_Curve(g, new int[] { 347, 348,  348, 349}, new int[] { 549, 549,  549, 548});
        bezier_Curve(g, new int[] { 349, 356,  358, 359}, new int[] { 548, 544,  545, 543});
        bezier_Curve(g, new int[] { 359, 356,  358, 359}, new int[] { 543, 545,  545, 543});
        bezier_Curve(g, new int[] { 359, 359,  360, 361}, new int[] { 543, 542,  541, 541});
        bezier_Curve(g, new int[] { 361, 362,  362, 363}, new int[] { 541, 541,  541, 541});
        bezier_Curve(g, new int[] { 363, 364,  364, 365}, new int[] { 541, 541,  540, 540});
        bezier_Curve(g, new int[] { 365, 366,  367, 368}, new int[] { 540, 540,  539, 539});
        bezier_Curve(g, new int[] { 368, 372,  374, 376}, new int[] { 539, 538,  539, 537});
        bezier_Curve(g, new int[] { 376, 376,  377, 377}, new int[] { 537, 537,  536, 536});
        bezier_Curve(g, new int[] { 377, 378,  379, 379}, new int[] { 536, 535,  534, 533});
        bezier_Curve(g, new int[] { 379, 380,  380, 382}, new int[] { 533, 532,  531, 530});
        bezier_Curve(g, new int[] { 382, 382,  381, 381}, new int[] { 530, 530,  530, 529});
        bezier_Curve(g, new int[] { 381, 381,  381, 381}, new int[] { 529, 529,  528, 528});

        //body
        bezier_Curve(g, new int[] { 338, 337, 337}, new int[] { 550, 552, 553});
        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
        bezier_Curve(g, new int[] { 335, 335, 335, 335}, new int[] { 558, 559, 560, 562});
        bezier_Curve(g, new int[] { 335, 335, 335, 335}, new int[] { 562, 563, 565, 567});
        bezier_Curve(g, new int[] { 335, 336, 352, 394}, new int[] { 567, 570, 566, 568});
        bezier_Curve(g, new int[] { 394, 394, 394, 395}, new int[] { 568, 568, 568, 568});
        bezier_Curve(g, new int[] { 395, 399, 397, 394}, new int[] { 568, 567, 536, 532});
        bezier_Curve(g, new int[] { 394, 393, 392, 388}, new int[] { 532, 531, 532, 531});
        bezier_Curve(g, new int[] { 388, 385, 384, 382}, new int[] { 531, 530, 529, 530});







//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});

    }

    private static void sky(Graphics g, BufferedImage buffer) {
        g.setColor(new Color(9, 30, 60));
        bezier_Curve(g, new int[] { 0, 500, 620, }, new int[] { 280, 280, 320 });
        Color colorStart = new Color(39, 104, 151);
        Color colorEnd = new Color(4, 24, 57);

        float count = 1000;
        float height = 310f;
        float maxHeight = 310f;
        float step = height / count;
        float divider = 0.7f;

        int startX = 0;
        int startY = 0;
        int endX = 600;

        for (int i = 0; i <= count; i++) {
            float ratio = (float) i / count;
            if (i <= count * divider) {
                ratio = (float) i / (count * divider);
            } else {
                ratio = 1.0f;
            }
            Color colorCurrent = interpolateColor(colorStart, colorEnd, ratio);
            g.setColor(colorCurrent);
            double r = (double) (i / count) * height;
            // System.out.println(r );
            int currentY = (int) (maxHeight - ((i / count) * height));
            // int currentY = (int)(((i/count)*height));
            // System.out.println(currentY);
            // drawBezierCurveMine(g, -50, currentY, 200, currentY - 50, 400, currentY + 50,
            // 650, currentY, (int) step * 3,
            // colorCurrent);

            bresenhamLine(g, startX, currentY, endX, currentY);
            // floodFill(buffer, endX, currentY, colorEnd)
        }
    }


    private static void grass(Graphics g, BufferedImage buffer) {

        g.setColor(Color.decode("#80C014"));
        bezier_Curve(g, new int[] { 0, 500, 620, }, new int[] { 280, 280, 320 });
        buffer = floodFill(buffer, 0, 599 - 30, Color.decode("#80C014"));

    }

    private void drawRectToBresen(Graphics g, int x, int y, int width, int height) {
        // top
        int x1 = x;
        int y1 = y;
        int x2 = x1 + width;
        int y2 = y1;
        bresenhamLine(g, x1, y1, x2, y2);
        // left
        x2 = x1;
        y2 = y1 + height;
        bresenhamLine(g, x1, y1, x2, y2);
        // down
        x1 = x2;
        y1 = y2;
        x2 = x1 + width;
        y2 = y1;
        bresenhamLine(g, x1, y1, x2, y2);
        // right
        x1 = x2;
        y1 = y2;
        y2 = y2 - height;
        bresenhamLine(g, x1, y1, x2, y2);
    }


    private void table(Graphics g, BufferedImage buffer) {
        Color replaceColor;
        // body
        g.setColor(Color.decode("#AF6329"));
        // drawRectToBresen(g, 1, 460 - 30, 300, 20);
        drawRoundedRectToBresen(g, 1, 460 - 30, 300, 20, 7);
        buffer = floodFill(buffer, 3, 460 - 30 + 3, Color.decode("#AF6329"));
        // g.fillRect(2, 460 - 30 + 1, 1, 1);
        // Color.decode("#AF6329"));

        // left leg

        drawRectToBresen(g, 15, 480 - 30, 20, 120);
        buffer = floodFill(buffer, 16, 481 - 30, Color.decode("#80C014"), Color.decode("#AF6329"));

        // middle part
        g.setColor(Color.decode("#A25424"));
        replaceColor = Color.decode("#A25424");
        // g.fillRect(35, 510 - 30, 160, 20);
        drawRectToBresen(g, 35, 510 - 30, 155, 20);
        buffer = floodFill(buffer, 36, 511 - 30, Color.decode("#80C014"), replaceColor);

        // red box
        g.setColor(Color.decode("#EC2C39"));
        replaceColor = Color.decode("#EC2C39");
        // g.fillRect(190, 480 - 30, 85, 120);
        drawRectToBresen(g, 190, 481 - 30, 85, 120);
        buffer = floodFill(buffer, 191, 482 - 30, Color.decode("#80C014"), replaceColor);

        // half box
        g.setColor(Color.decode("#CB1F2B"));
        replaceColor = Color.decode("#CB1F2B");
        // g.fillRect(190, (480 + 120 / 2) - 30, 85, 10);
        drawRectToBresen(g, 190, (480 + 120 / 2) - 30, 85, 10);

        buffer = floodFill(buffer, 191, (481 + 120 / 2) - 30 + 1, Color.decode("#EC2C39"), replaceColor);

        // puller1
        g.setColor(Color.decode("#F6B74E"));
        replaceColor = Color.decode("#F6B74E");
        // g.fillRect(215, 495 - 30, 37, 10);
        drawRectToBresen(g, 215, 495 - 30, 37, 10);
        buffer = floodFill(buffer, 216, 496 - 30, Color.decode("#EC2C39"), replaceColor);

        // puller2
        g.setColor(Color.decode("#F6B74E"));
        replaceColor = Color.decode("#F6B74E");
        // g.fillRect(215, 567 - 30, 37, 10);
        drawRectToBresen(g, 215, 567 - 30, 37, 10);
        buffer = floodFill(buffer, 216, 568 - 30, Color.decode("#EC2C39"), replaceColor);
        // buffer = floodFill(buffer, 2, 461 - 30 , Color.decode("#AF6329"));
    }

    private void computer(Graphics g, BufferedImage buffer) {
        Color replaceColor;
        // base

        g.setColor(Color.decode("#353939"));
        replaceColor = Color.decode("#353939");
        // g.fillRect(38, 450 - 30, 132, 10);
        drawRectToBresen(g, 38, 450 - 30, 132, 10);
        buffer = floodFill(buffer, 40, 453 - 30, replaceColor);

        // Monitor
        // g.fillRoundRect(48, 360 - 30, 110, 85, 15, 15);
        // drawRectToBresen(g, 48, 360 - 30, 110, 85);
        drawRoundedRectToBresen(g, 48, 360 - 30, 110, 85, 10);
        buffer = floodFill(buffer, 52, 363 - 30, replaceColor);

        // gray top tap
        g.setColor(Color.decode("#95A5A6"));
        replaceColor = Color.decode("#95A5A6");
        // drawRectToBresen(g, 55, 367 - 30, 97, 10);
        drawRoundedRectToBresen(g, 55, 367 - 30, 97, 10, 5);
        buffer = floodFill(buffer, 58, 369 - 30, replaceColor);

        // white top tap
        g.setColor(Color.WHITE);
        // g.fillRect(55, 375 - 30, 97, 3);
        drawRectToBresen(g, 55, 375 - 30, 97, 3);
        buffer = floodFill(buffer, 58, 376 - 30, Color.WHITE);

        // bg
        g.setColor(Color.decode("#3F4E4D"));
        // g.fillRect(55, 378 - 30, 97, 60);
        // drawRectToBresen(g, 55, 378 - 30, 97, 60);
        drawRoundedRectToBresen(g, 55, 378 - 30, 97, 60, 5);
        buffer = floodFill(buffer, 57, 380 - 30, Color.decode("#3F4E4D"));

        // long green
        g.setColor(Color.decode("#6B9C27"));
        // g.fillRect(62, 378 - 30, 2, 60);
        drawRectToBresen(g, 62, 378 - 30, 2, 60);
        buffer = floodFill(buffer, 63, 379 - 30, Color.decode("#6B9C27"));

        // orange in screen
        g.setColor(Color.ORANGE);
        // g.fillRect(68, 389 - 30, 4, 2);
        drawRectToBresen(g, 68, 389 - 30, 4, 2);
        buffer = floodFill(buffer, 70, 390 - 30, Color.ORANGE);
        // g.fillRect(68, 399 - 30, 9, 2);
        drawRectToBresen(g, 68, 399 - 30, 9, 2);
        buffer = floodFill(buffer, 70, 400 - 30, Color.ORANGE);

        // Blue in screen
        g.setColor(Color.decode("#34A3E8"));
        // g.fillRect(75, 389 - 30, 4, 2);
        drawRectToBresen(g, 75, 389 - 30, 4, 2);
        buffer = floodFill(buffer, 77, 390 - 30, Color.decode("#34A3E8"));
        // g.fillRect(103, 399 - 30, 15, 2);
        drawRectToBresen(g, 103, 399 - 30, 15, 2);
        buffer = floodFill(buffer, 105, 400 - 30, Color.decode("#34A3E8"));
        // g.fillRect(85, 420 - 30, 15, 2);
        drawRectToBresen(g, 85, 420 - 30, 15, 2);
        buffer = floodFill(buffer, 88, 421 - 30, Color.decode("#34A3E8"));

        // Purple in screen
        g.setColor(Color.decode("#864B9B"));
        // g.fillRect(75, 412 - 30, 4, 2);
        drawRectToBresen(g, 75, 412 - 30, 4, 2);
        buffer = floodFill(buffer, 77, 413 - 30, Color.decode("#864B9B"));
        // g.fillRect(103, 420 - 30, 15, 2);
        drawRectToBresen(g, 103, 420 - 30, 15, 2);
        buffer = floodFill(buffer, 105, 421 - 30, Color.decode("#864B9B"));
    }

    private void cup(Graphics g2d,BufferedImage buffer, int x, int y) {
        // bezier_Curve(g, new int[]{188, 195,,}, new int[]{425, 426,,});
        // g2d.setColor(Color.gray);
        g2d.setColor(Color.WHITE);
        // เงา
        int[] xPoints = new int[]{188, 188, 187, 185, 184, 185, 186, 190, 193, 198, 201, 207, 210, 223, 221, 224, 226, 231, 233, 235, 235, 237, 236, 228, 220, 211, 203, 194, 188, 188, 188};
        int[] yPoints = new int[]{454, 455, 455, 457, 458, 459, 460, 461, 461, 462, 462, 461, 461, 461, 461, 461, 461, 460, 460, 459, 458, 456, 453, 453, 453, 453, 453, 454, 453, 456, 454};
        for (int i = 0; i < xPoints.length - 3; i += 3) {
            bezier_Curve(g2d,
                    new int[] { (int) Math.round(xPoints[i]) + x, (int) Math.round(xPoints[i + 1]) + x,
                            (int) Math.round(xPoints[i + 2]) + x, (int) Math.round(xPoints[i + 3]) + x },
                    new int[] { (int) Math.round(yPoints[i]) + y, (int) Math.round(yPoints[i + 1]) + y,
                            (int) Math.round(yPoints[i + 2]) + y, (int) Math.round(yPoints[i + 3]) + y });
        }

        buffer = floodFill(buffer, 200+x, 458+y, Color.WHITE);






        g2d.setColor(Color.black);
        xPoints = new int[] { 179, 179, 181, 187, 186, 203, 204, 218, 223, 230, 232, 237, 238, 239, 239,
                239, 239,
                237, 237, 236, 235, 233, 232, 230, 229, 228, 226, 222, 220, 211, 210, 196, 196, 191,
                190, 187, 180, 178,
                178, 178, 178 };
        yPoints = new int[] { 425, 424, 425, 425, 425, 425, 425, 425, 425, 425, 424, 425, 425, 426, 427,
                431, 432,
                437, 438, 442, 444, 448, 450, 454, 455, 457, 459, 460, 461, 462, 461, 461, 461, 459,
                457, 453, 443, 432,
                431, 426, 426 };
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

        // จับนอก
        xPoints = new int[] { 239, 239, 239, 242, 243, 246, 248, 251, 254, 257, 258, 259, 259, 259, 258, 257,
                256, 254,
                252, 249, 248, 246, 245, 237, 237, 234, 234, 231, 230, 229, 230, 232, 232, 234, 234,
                235, 236, 237, 237,
                238, 239, 239, 238 };
        yPoints = new int[] { 427, 427, 428, 429, 428, 427, 426, 426, 427, 430, 431, 434, 435, 440, 441, 443,
                444, 446,
                447, 448, 449, 450, 450, 453, 453, 454, 453, 454, 455, 454, 453, 450, 450, 446, 446,
                444, 442, 439, 439,
                432, 432, 429, 427 };
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

        // จับใน
        xPoints = new int[] { 238, 238, 239, 240, 241, 243, 244, 244, 246, 249, 250, 252, 254, 256, 255, 254,
                252, 251,
                250, 248, 247, 243, 243, 238, 237, 236, 236, 236, 236, 237, 237, 237, 237, 238, 237 };
        yPoints = new int[] { 438, 437, 438, 437, 437, 434, 433, 433, 431, 431, 431, 432, 432, 436, 438, 441,
                442, 444,
                444, 445, 445, 446, 447, 448, 448, 447, 447, 446, 445, 443, 442, 441, 440, 438, 438 };
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

        // ควัน

        // g2d.setColor(Color.gray);
        buffer = floodFill(buffer,250+x, 428+y, Color.black);
        // g2d.fillRect(230, 428-30, 2, 2);
        buffer = floodFill(buffer,232+x, 428+y, Color.black);

        // ควัน
        Color smokeColor = Color.decode("#D12734");
        g2d.setColor(Color.RED);
        g2d.fillRect(215, 380, 1, 1);
        // buffer = floodFill2(buffer, 215, 380, Color.BLACK,  smokeColor );
    }

    private void mattress(Graphics g) {
        g.setColor(Color.decode("#6F4E25"));
        // g.drawArc(220, 530, 200, 5, 0, 100);

        g.drawArc(330, 530, 100, 30, 0, 180); // line top
        g.drawArc(330, 525, 30, 40, 180, 30); // line left
        g.drawArc(332, 540, 100, 30, 180, 180); // line bottom
        g.drawArc(427, 545, 5, 15, 270, 180); // line bottom
        // g.drawRect(427, 545, 10, 10);

    }

    public static void bresenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
        double dx = Math.abs(x2 - x1);
        double dy = Math.abs(y2 - y1);

        double sx = (x1 < x2) ? 1 : -1;
        double sy = (y1 < y2) ? 1 : -1;
        boolean isSwap = false;
        if (dy > dx) {
            double tmp = dy;
            dy = dx;
            dx = tmp;
            isSwap = true;
        }

        double D = 2 * dy - dx;

        int x = x1;
        int y = y1;

        for (int i = 1; i <= dx; i++) {
            plot(g, x, y, 1);
            if (D >= 0) {
                if (isSwap)
                    x += sx;
                else
                    y += sy;

                D -= 2 * dx;
            }

            if (isSwap)
                y += sy;
            else
                x += sx;

            D += 2 * dy;
        }
    }

    public static void bezier_Curve(Graphics g, int[] controlsPointX, int[] controlsPointY) {
        double t = 0;
        int xt;
        int yt;
        if (controlsPointX.length == 4) {
            for (; t <= 1; t += 0.001) {
                xt = (int) (Math.pow(1 - t, 3) * controlsPointX[0] +
                        3 * t * Math.pow(1 - t, 2) * controlsPointX[1] +
                        3 * t * t * Math.pow(1 - t, 1) * controlsPointX[2] +
                        t * t * t * controlsPointX[3]);

                yt = (int) (Math.pow(1 - t, 3) * controlsPointY[0] +
                        3 * t * Math.pow(1 - t, 2) * controlsPointY[1] +
                        3 * t * t * Math.pow(1 - t, 1) * controlsPointY[2] +
                        t * t * t * controlsPointY[3]);

                plot(g, xt, yt);
            }
        } else {
            // System.out.println(" 8");
            for (; t <= 1; t += 0.001) {
                xt = (int) (Math.pow(1 - t, 2) * controlsPointX[0] +
                        2 * t * Math.pow(1 - t, 1) * controlsPointX[1] +
                        t * t * controlsPointX[2]);

                yt = (int) (Math.pow(1 - t, 2) * controlsPointY[0] +
                        2 * t * Math.pow(1 - t, 1) * controlsPointY[1] +
                        t * t * controlsPointY[2]);

                plot(g, xt, yt);
            }

        }
    }

    public static void plot(Graphics g, int x, int y, int size) {
        // System.out.println('w');
        g.fillRect(x, y, size, size);
    }

    public static BufferedImage floodFill(BufferedImage m, int x, int y, Color target_color, Color replacement_color) {
        Queue<int[]> q = new LinkedList<>();
        // Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { x, y });
        int targetRGB = target_color.getRGB();
        int replaceRGB = replacement_color.getRGB();
        // replaceRGB+=500;

        int[] currentPos;
        while (!q.isEmpty()) {
            currentPos = q.poll();

            int x1 = currentPos[0];
            int y1 = currentPos[1];

            if (m.getRGB(x1, y1) == targetRGB) {
                m.setRGB(x1, y1, replaceRGB);
                // south
                if (isInBound(x1, y1 + 1) && m.getRGB(x1, y1 + 1) == targetRGB) {
                    q.add(new int[] { x1, y1 + 1 });
                    // System.out.println("firsy");
                }
                // north
                if (isInBound(x1, y1 - 1) && m.getRGB(x1, y1 - 1) == targetRGB) {
                    q.add(new int[] { x1, y1 - 1 });
                    // System.out.println("f2irsy");
                }
                // east
                if (isInBound(x1 + 1, y1) && m.getRGB(x1 + 1, y1) == targetRGB) {
                    q.add(new int[] { x1 + 1, y1 });
                    // System.out.println("f3irsy");
                }
                // west
                if (isInBound(x1 - 1, y1) && m.getRGB(x1 - 1, y1) == targetRGB) {
                    q.add(new int[] { x1 - 1, y1 });
                    // System.out.println("fir4sy");
                }
            }
        }

        return m;
    }

    public static BufferedImage floodFill2(BufferedImage m, int x, int y, Color border_Color, Color replacement_Color) {
        // System.out.println("work");
        Queue<int[]> q = new LinkedList<>();
        // Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { x, y });
        int border_ColorRGB = border_Color.getRGB();
        int replace_ColorRGB = replacement_Color.getRGB();
        // System.out.println(x+"  "+y);
        // border_ColorRGB += 50;
        int[] currentPos;
        while (!q.isEmpty()) {
            currentPos = q.poll();


            int x1 = currentPos[0];
            int y1 = currentPos[1];

            if (m.getRGB(x1, y1) != border_ColorRGB && m.getRGB(x1, y1) != replace_ColorRGB) {
                m.setRGB(x1, y1, replace_ColorRGB);
                // System.out.println("x1 is:"+x1);
                // System.out.println("y1 is:"+y1);
                // south
                if (isInBound(x1, y1 + 1) && m.getRGB(x1, y1 + 1) != border_ColorRGB && m.getRGB(x1, y1 + 1) != replace_ColorRGB) {
                    q.add(new int[] { x1, y1 + 1 });
                    // System.out.println("firsy");
                }
                // north
                if (isInBound(x1, y1 - 1) && m.getRGB(x1, y1 - 1) != border_ColorRGB&& m.getRGB(x1, y1 - 1) != replace_ColorRGB) {
                    q.add(new int[] { x1, y1 - 1 });
                    // System.out.println("f2irsy");
                }
                // east
                if (isInBound(x1 + 1, y1) && m.getRGB(x1 + 1, y1) != border_ColorRGB&& m.getRGB(x1+1, y1) != replace_ColorRGB) {
                    q.add(new int[] { x1 + 1, y1 });
                    // System.out.println("f3irsy");
                }
                // west
                if (isInBound(x1 - 1, y1) && m.getRGB(x1 - 1, y1) != border_ColorRGB&& m.getRGB(x1-1, y1) != replace_ColorRGB) {
                    q.add(new int[] { x1 - 1, y1 });
                    // System.out.println("fir4sy");
                }
            }
        }

        return m;
    }


    public static BufferedImage floodFill(BufferedImage m, int x, int y, Color border_Color) {
        Queue<int[]> q = new LinkedList<>();
        // Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { x, y });
        int border_ColorRGB = border_Color.getRGB();
        // border_ColorRGB += 50;
        int[] currentPos;
        while (!q.isEmpty()) {
            currentPos = q.poll();

            int x1 = currentPos[0];
            int y1 = currentPos[1];

            if (m.getRGB(x1, y1) != border_ColorRGB) {
                m.setRGB(x1, y1, border_ColorRGB);
                // south
                if (isInBound(x1, y1 + 1) && m.getRGB(x1, y1 + 1) != border_ColorRGB) {
                    q.add(new int[] { x1, y1 + 1 });
                    // System.out.println("firsy");
                }
                // north
                if (isInBound(x1, y1 - 1) && m.getRGB(x1, y1 - 1) != border_ColorRGB) {
                    q.add(new int[] { x1, y1 - 1 });
                    // System.out.println("f2irsy");
                }
                // east
                if (isInBound(x1 + 1, y1) && m.getRGB(x1 + 1, y1) != border_ColorRGB) {
                    q.add(new int[] { x1 + 1, y1 });
                    // System.out.println("f3irsy");
                }
                // west
                if (isInBound(x1 - 1, y1) && m.getRGB(x1 - 1, y1) != border_ColorRGB) {
                    q.add(new int[] { x1 - 1, y1 });
                    // System.out.println("fir4sy");
                }
            }
        }

        return m;
    }

    static boolean isInBound(int x, int y) {
        return x >= 0 && y > 0 && x < 601 && y < 601;
    }

    private void drawRoundedRectToBresen(Graphics g, int x, int y, int width, int height, int curve) {
        // int curveHalf = curve / 2;
        // int curveHalf2 = curveHalf / 2;

        // top
        int x1 = x;
        int y1 = y;
        int x2 = x + width;
        int y2 = y;
        bresenhamLine(g, x1 + curve, y1, x2 - curve, y2);

        // top to left
        bezier_Curve(g, new int[] { x1 + curve, x1, x1 }, new int[] { y1, y1, y1 + curve });

        // left
        x1 = x;
        y1 = y;
        x2 = x;
        y2 = y + height;
        bresenhamLine(g, x1, y1 + curve, x2, y2 - curve);

        // left to down
        bezier_Curve(g, new int[] { x2, x2, x2 + curve }, new int[] { y2 - curve, y2 + 2, y2 });

        // down
        x1 = x;
        y1 = y + height;
        x2 = x + width;
        y2 = y + height;
        bresenhamLine(g, x1 + curve, y1, x2 - curve, y2);

        // down to right
        bezier_Curve(g, new int[] { x2 - curve, x2 + 2, x2 }, new int[] { y2, y2 + 2, y2 - curve });

        // right
        x1 = x + width;
        y1 = y;
        x2 = x + width;
        y2 = y + height;
        bresenhamLine(g, x1, y1 + curve, x2, y2 - curve);

        // right to top
        bezier_Curve(g, new int[] { x1, x1 + 2, x1 - curve }, new int[] { y1 + curve, y1 + 1, y1 });

    }

    private static Color interpolateColor(Color startColor, Color endColor, float ratio) {
        int red = (int) (startColor.getRed() + ratio * (endColor.getRed() - startColor.getRed()));
        int green = (int) (startColor.getGreen() + ratio * (endColor.getGreen() - startColor.getGreen()));
        int blue = (int) (startColor.getBlue() + ratio * (endColor.getBlue() - startColor.getBlue()));
        int alpha = interpolateNumber(startColor.getAlpha(), endColor.getAlpha(), ratio);

        return new Color(red, green, blue, alpha);

    }

    private static int interpolateNumber(int start, int end, float ratio) {
        int x = (int) (start + ratio * (end - start));
        return x;
    }

}