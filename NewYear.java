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
    }
    
    public void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }
    
    private static void sky(Graphics g) {
        g.setColor(new Color(9, 30, 60));
        g.fillRect(0, 0, 600, 250);
    }
    
    private static void grass(Graphics g) {
    // g.setColor(new Color(128, 192, 20));
        g.setColor(Color.decode("#80C014"));
        g.fillRect(0, 250, 600, 600);
        
    }
    
}