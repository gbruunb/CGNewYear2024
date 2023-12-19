import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class Expe extends JPanel {
    public static void main(String[] args) {
        Expe m = new Expe();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("First Swing");
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
        // sky(g2d,buffer);
        // graass
        grass(g2d, buffer);
        // table
        table(g2d, buffer);
        // computer
        computer(g2d, buffer);
        // cup
        // cup(g2);
        // mattress
        // mattress(g2);

        g.drawImage(buffer, 0, 0, null);

    }

    public void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }

    private static void sky(Graphics g, BufferedImage buffer) {
        g.setColor(new Color(9, 30, 60));
        bresenhamLine(g, 0, 350, 600, 350);
        buffer = floodFill(buffer, 0, 10, Color.WHITE, new Color(9, 30, 60));
   }

    private static void grass(Graphics g, BufferedImage buffer) {
        // g.setColor(new Color(128, 192, 20));
        // g.setColor(Color.decode("#80C014"));
        // g.fillRect(0, 350, 600, 240);
        // g.setColor(new Color(128, 192, 20 ));
        bresenhamLine(g, 0, 600-30, 600, 600-30);
        buffer = floodFill(buffer, 0, 599-30, Color.WHITE, Color.decode("#80C014"));

    }

    private void drawRectToBresen(Graphics g, int x, int y, int width, int height) {
        // top
        int x1 = x;
        int y1 = y;
        int x2 = x1 + width;
        int y2 = y1;
        bresenhamLine(g, x1, y1, x2, y2);
        // left 
        x2 = x1 ; 
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
        // g.drawRoundRect(1,460 - 30 ,300 , 20 ,0 , 0);
        // g.fillRoundRect(1, 460 - 30, 300, 20, 10, 15);
        // bresenhamLine(g, 1, 460 - 30, 300, 460 - 30);
        // bresenhamLine(g, 1, 480 - 30, 300, 480 - 30);
        drawRectToBresen(g, 1, 460 - 30, 300, 20);
        buffer = floodFill(buffer, 2, 461 - 30 , Color.decode("#80C014"),  Color.decode("#AF6329"));


        // left leg
        // g.fillRect(15, 480 - 30, 20, 120);
        // bresenhamLine(g, 15, 460-30, 15, 600 - 30);
        // bresenhamLine(g, 35, 460-30, 35, 600 - 30);
        drawRectToBresen(g, 15, 480-30, 20, 120);
        buffer = floodFill(buffer, 16, 481 - 30 , Color.decode("#80C014"),  Color.decode("#AF6329"));


        // middle part
        g.setColor(Color.decode("#A25424"));
        replaceColor = Color.decode("#A25424");
        // g.fillRect(35, 510 - 30, 160, 20);
        drawRectToBresen(g, 35, 510 - 30, 155,  20);
        buffer = floodFill(buffer, 36, 511 - 30 , Color.decode("#80C014"), replaceColor);

        // red box
        g.setColor(Color.decode("#EC2C39"));
        replaceColor = Color.decode("#EC2C39");
        // g.fillRect(190, 480 - 30, 85, 120);
        drawRectToBresen(g, 190, 481 - 30, 85, 120);
        buffer = floodFill(buffer, 191, 482 - 30 , Color.decode("#80C014"), replaceColor);
        
        
        // half box
        g.setColor(Color.decode("#CB1F2B"));
        replaceColor = Color.decode("#CB1F2B");
        // g.fillRect(190, (480 + 120 / 2) - 30, 85, 10);
        drawRectToBresen(g, 190, (480 + 120 / 2) - 30, 85, 10);
        
        buffer = floodFill(buffer, 191, (481 + 120 / 2) - 30 + 1 , Color.decode("#EC2C39"), replaceColor);

        // puller1
        g.setColor(Color.decode("#F6B74E"));
        replaceColor = Color.decode("#F6B74E");
        // g.fillRect(215, 495 - 30, 37, 10);
        drawRectToBresen(g, 215, 495 - 30, 37, 10);
        buffer = floodFill(buffer, 216, 496 - 30 , Color.decode("#EC2C39"), replaceColor);


        // puller2
        g.setColor(Color.decode("#F6B74E"));
        replaceColor = Color.decode("#F6B74E");
        // g.fillRect(215, 567 - 30, 37, 10);
        drawRectToBresen(g, 215, 567 - 30, 37, 10);
        buffer = floodFill(buffer, 216, 568- 30 , Color.decode("#EC2C39"), replaceColor);
    }

    private void computer(Graphics g, BufferedImage buffer) {
        Color replaceColor;
        // base

        g.setColor(Color.decode("#353939"));
        replaceColor = Color.decode("#F6B74E");
        // g.fillRect(38, 450 - 30, 132, 10);
        drawRectToBresen(g, 38, 450 - 30, 132, 10);
        buffer = floodFill(buffer, 216, 568- 30 , Color.decode("#EC2C39"), replaceColor);

        // Monitor
        // g.fillRoundRect(48, 360 - 30, 110, 85, 15, 15);
        drawRectToBresen(g, 48, 360 - 30, 110, 85);

        // gray top tap
        g.setColor(Color.decode("#95A5A6"));
        // g.fillRect(55, 367 - 30, 97, 10);
        drawRectToBresen(g, 55, 367 - 30, 97, 10);
        // white top tap
        g.setColor(Color.WHITE);
        // g.fillRect(55, 375 - 30, 97, 3);
        drawRectToBresen(g ,55, 375 - 30, 97, 3);

        // bg
        g.setColor(Color.decode("#3F4E4D"));
        // g.fillRect(55, 378 - 30, 97, 60);
        drawRectToBresen(g ,55, 378 - 30, 97, 60);
        // long green
        g.setColor(Color.decode("#6B9C27"));
        // g.fillRect(62, 378 - 30, 2, 60);
        drawRectToBresen(g, 62, 378 - 30, 2, 60);

        // orange in screen
        g.setColor(Color.ORANGE);
        // g.fillRect(68, 389 - 30, 4, 2);
        drawRectToBresen(g, 68, 389 - 30, 4, 2);
        // g.fillRect(68, 399 - 30, 9, 2);
        drawRectToBresen(g ,68, 399 - 30, 9, 2);

        // Blue in screen
        g.setColor(Color.decode("#34A3E8"));
        // g.fillRect(75, 389 - 30, 4, 2);
        drawRectToBresen(g ,75, 389 - 30, 4, 2);
        // g.fillRect(103, 399 - 30, 15, 2);
        drawRectToBresen(g, 103, 399 - 30, 15, 2);
        // g.fillRect(85, 420 - 30, 15, 2);
        drawRectToBresen(g, 85, 420 - 30, 15, 2);

        // Purple in screen
        g.setColor(Color.decode("#864B9B"));
        // g.fillRect(75, 412 - 30, 4, 2);
        drawRectToBresen(g, 75, 412 - 30, 4, 2);
        // g.fillRect(103, 420 - 30, 15, 2);
        drawRectToBresen(g, 103, 420 - 30, 15, 2);
    }

    private void cup(Graphics g) {
        // white shadow
        g.setColor(Color.white);
        g.fillArc(185, 446 - 30, 35, 10, 0, 360);

        // g.setColor(Color.white);
        // g.fillOval(218, 428-30, 12, 12);

        g.setColor(Color.red);
        g.drawArc(210, 430-30, 20, 15, -80, 180);
        //outside cup handle
        g.drawArc(210, 430-30, 25, 16, -90, 180);

        // try outside cup handle fk this too hard
        // g.fillArc(220, 430-30, 20, 16, -90, 180);
        
        g.setColor(Color.black);
        g.fillRect(180, 424 - 30, 46, 2);

        // left of cup
        g.fillArc(180, 398 - 30, 25, 55, 180, 90);
        // right of cup
        g.fillArc(200, 398 - 30, 25, 55, 270, 90);
        // under of cup
        g.fillRect(193, 454-30, 20, -30);


        g.fillRect(190, 424-30, 25, 30);
        // eye
        g.setColor(Color.red);
        g.fillRect(210, 430 - 30, 2, 2);
        g.fillRect(190, 430 - 30, 2, 2);

        // lip
        g.drawArc(197, 440-30, 10, 10, 180, 180);
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

    private void cat(Graphics g) {
        g.setColor(Color.black);
        g.drawPolygon(new int[] { 330, 335, 331 }, new int[] { 510, 513, 519 }, 3);
        g.drawPolygon(new int[] { 331, 334, 329 }, new int[] { 519, 523, 527 }, 3);

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

    public static void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }

    public static BufferedImage floodFill(BufferedImage m, int x, int y, Color target_color, Color replacement_color) {
        Queue<int[]> q = new LinkedList<>();
        // Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x,y});
        int targetRGB = target_color.getRGB();
        int replaceRGB = replacement_color.getRGB();
        
        int[] currentPos;
        while (!q.isEmpty()) {
            currentPos = q.poll();

            int x1 = currentPos[0];
            int y1 = currentPos[1];

            if (m.getRGB(x1, y1) != replaceRGB) {
                m.setRGB(x1, y1, replaceRGB);
                // south
                if (isInBound(x1, y1+1) && m.getRGB(x1, y1+1) != replaceRGB) {
                    q.add(new int[]{x1, y1+1});
                    // System.out.println("firsy");
                }
                // north
                if (isInBound(x1, y1-1) && m.getRGB(x1, y1-1) != replaceRGB) {
                    q.add(new int[]{x1, y1-1});
                    // System.out.println("f2irsy");
                }
                // east
                if (isInBound(x1+1, y1) && m.getRGB(x1+1, y1) != replaceRGB) {
                    q.add(new int[]{x1+1, y1});
                    // System.out.println("f3irsy");
                }
                // west
                if (isInBound(x1-1, y1) && m.getRGB(x1-1, y1) != replaceRGB) {
                    q.add(new int[]{x1-1, y1});
                    // System.out.println("fir4sy");
                }
            }
        }


        return m;
    }

    static boolean isInBound(int x, int y) {
        return x >=0  && y > 0 && x < 601 && y < 601;
    }
}