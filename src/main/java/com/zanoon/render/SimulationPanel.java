package src.main.java.com.zanoon.render;
import java.awt.*;
import javax.swing.JPanel;

public class SimulationPanel extends JPanel{
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // we create the different things we need using the parameter g
        g.fillRect(50, 50, 100, 100);
        g.setColor(Color.WHITE);



    }
}
