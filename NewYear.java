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
    }

    public void paintComponent(Graphics g) {
        // sky
        sky(g);
        // graass
        grass(g);
        // table
        table(g);
        // mattress
        mattress(g);

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
        g.fillRect(30, 510 - 30, 160, 20);

        // red box
        g.setColor(Color.decode("#EC2C39"));
        g.fillRect(190, 480 - 30, 85, 120);

        // half box
        g.setColor(Color.decode("#AF6329"));
        g.fillRect(190, (480 + 120 / 2) - 30, 85, 5);
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

    }

    private void firework(Graphics g) {

    }

}