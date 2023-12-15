import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public class NewYear extends JPanel {
    public static void main(String[] args) {
        NewYear m = new NewYear();

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
        // sky
        sky(g);
        // graass
        grass(g);
        // table
        table(g);
        // computer
        computer(g);

        // cup
        cup(g);

        // mattress
        mattress(g);

        // cat
        cat(g);

    }

    public void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }

    private static void sky(Graphics g) {
        g.setColor(new Color(9, 30, 60));
        g.fillRect(0, 0, 600, 350);
    }

    private static void grass(Graphics g) {
        // g.setColor(new Color(128, 192, 20));
        g.setColor(Color.decode("#80C014"));
        g.fillRect(0, 350, 600, 240);

    }

    private void table(Graphics g) {
        // body
        g.setColor(Color.decode("#AF6329"));
        // g.drawRoundRect(1,460 ,300 , 20 ,10 , 10);
        g.fillRoundRect(1, 460 - 30, 300, 20, 10, 15);

        // left leg
        g.fillRect(15, 480 - 30, 20, 120);

        // middle part
        g.setColor(Color.decode("#A25424"));
        g.fillRect(35, 510 - 30, 160, 20);

        // red box
        g.setColor(Color.decode("#EC2C39"));
        g.fillRect(190, 480 - 30, 85, 120);

        // half box
        g.setColor(Color.decode("#CB1F2B"));
        g.fillRect(190, (480 + 120 / 2) - 30, 85, 10);

        // puller1
        g.setColor(Color.decode("#F6B74E"));
        g.fillRect(215, 495 - 30, 37, 10);
        // puller2
        g.setColor(Color.decode("#F6B74E"));
        g.fillRect(215, 567 - 30, 37, 10);
    }

    private void computer(Graphics g) {
        // base
        g.setColor(Color.decode("#353939"));
        g.fillRect(38, 450 - 30, 132, 10);

        // Monitor
        g.fillRoundRect(48, 360 - 30, 110, 85, 15, 15);

        // gray top tap
        g.setColor(Color.decode("#95A5A6"));
        g.fillRect(55, 367 - 30, 97, 10);
        // white top tap
        g.setColor(Color.WHITE);
        g.fillRect(55, 375 - 30, 97, 3);

        // bg
        g.setColor(Color.decode("#3F4E4D"));
        g.fillRect(55, 378 - 30, 97, 60);
        // long green
        g.setColor(Color.decode("#6B9C27"));
        g.fillRect(62, 378 - 30, 2, 60);

        // orange in screen
        g.setColor(Color.ORANGE);
        g.fillRect(68, 389 - 30, 4, 2);
        g.fillRect(68, 399 - 30, 9, 2);

        // Blue in screen
        g.setColor(Color.decode("#34A3E8"));
        g.fillRect(75, 389 - 30, 4, 2);
        g.fillRect(103, 399 - 30, 15, 2);
        g.fillRect(85, 420 - 30, 15, 2);

        // Purple in screen
        g.setColor(Color.decode("#864B9B"));
        g.fillRect(75, 412 - 30, 4, 2);
        g.fillRect(103, 420 - 30, 15, 2);
    }

    private void cup(Graphics g) {
        // white shadow
        g.setColor(Color.white);
        g.fillArc(185, 446 - 30, 35, 10, 0, 360);

        // g.setColor(Color.white);
        // g.fillOval(218, 428-30, 12, 12);

        g.setColor(Color.red);
        g.drawArc(210, 430 - 30, 20, 15, -80, 180);
        // outside cup handle
        g.drawArc(210, 430 - 30, 25, 16, -90, 180);

        // try outside cup handle fk this too hard
        // g.fillArc(220, 430-30, 20, 16, -90, 180);

        g.setColor(Color.black);
        g.fillRect(180, 424 - 30, 46, 2);

        // left of cup
        g.fillArc(180, 398 - 30, 25, 55, 180, 90);
        // right of cup
        g.fillArc(200, 398 - 30, 25, 55, 270, 90);
        // under of cup
        g.fillRect(193, 454 - 30, 20, -30);

        g.fillRect(190, 424 - 30, 25, 30);
        // eye
        g.setColor(Color.red);
        g.fillRect(210, 430 - 30, 2, 2);
        g.fillRect(190, 430 - 30, 2, 2);

        // lip
        g.drawArc(197, 440 - 30, 10, 10, 180, 180);

        // left of cup
        // g.drawArc(177, 398-30, 25, 55, 180, 90);
        // g.fillArc(177, 398-30, 25, 55, 180, 90);

        // right of cup
        // g.drawArc(210, 398-30, 25, 55, 0, -180);
        // g.fillArc(206, 398-30, 28, 55, 270, 90);

        // g.drawArc(210, 398-30, 60, 55, 0, -180);
        // g.fillArc(210, 398-30, 60, 70, 0, -180);

        // middle of cup
        // g.setColor(Color.black);
        // g.fillRect(188, 425-30, 40, 30);

        // g.drawRect(20, 20, 30, 30);
        // g.drawArc(20, 20, 30, 30,0 , 360);

        // handle base
        // g.setColor(Color.red);
        // g.drawArc(225, 430-30, 9*2, 9*2, 267, 180);

        // test
        // g.fillArc(210, 398-30, 60, 70, 0, -60);
        // g.fillArc(210, 398-30, 60, 70, 180, 60);

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
        g.drawArc(330, 440, 5, 25, 90, 180);
        g.drawArc(331, 465, 3, 15, 85, 175);
        g.drawArc(330, 480, 3, 50, 220, 50);
    }

    private void firework(Graphics g) {

    }

}