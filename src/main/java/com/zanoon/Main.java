package com.zanoon;
import javax.swing.*;
import com.zanoon.render.AtomSimulation3D;





public class Main 
{
    public static void main(String[] args )
    {
        SwingUtilities.invokeLater(() -> {

            AtomSimulation3D sim = new AtomSimulation3D();
            
            JFrame frame = new JFrame("Atom Simulation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);

            frame.add(sim.getCanvas());

            frame.setVisible(true);
        });         
        // Window Creation
        

        // SimulationPanel canvas = new SimulationPanel();
        // SimulationEngine engine = new SimulationEngine(canvas);
        // canvas.setEngine(engine);
        // canvas.setBackground(Color.BLACK);

        // frame.add(canvas);
    }
}
