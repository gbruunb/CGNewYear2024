import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public class NewYear extends JPanel{
    public static void main(String[] args) {
        NewYear m = new NewYear();
        
        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("First Swing");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        // sky
        sky(g);
        // graass
        grass(g);
        // table
        table(g);
    }
    
    public void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }
    
    private static void sky(Graphics g) {
        g.setColor(new Color(9, 30, 60));
        g.fillRect(0, 0, 600, 300);
    }
    
    private static void grass(Graphics g) {
    // g.setColor(new Color(128, 192, 20));
        g.setColor(Color.decode("#80C014"));
        g.fillRect(0, 300, 600, 600);
        
    }

    private void table(Graphics g) {
        // body
        g.setColor(Color.decode("#AF6329"));
        // g.drawRoundRect(1,460 ,300 , 20 ,10 , 10);
        g.fillRoundRect(1, 460, 300, 20, 10, 10);
    }
    
}