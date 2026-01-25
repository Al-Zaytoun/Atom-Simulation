package com.zanoon;
import java.awt.*;
import javax.swing.*;

import com.zanoon.engine.SimulationEngine;
import com.zanoon.render.AtomSimulation3D;
import com.zanoon.render.SimulationPanel;




public class Main 
{
    public static void main( String[] args )
    {
        // Window Creation
        JFrame frame = new JFrame("Atom Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        AtomSimulation3D sim = new AtomSimulation3D();
        frame.add(sim.getCanvas());
        

        // SimulationPanel canvas = new SimulationPanel();
        // SimulationEngine engine = new SimulationEngine(canvas);
        // canvas.setEngine(engine);
        // canvas.setBackground(Color.BLACK);

        // frame.add(canvas);
        frame.setVisible(true);
    }
}
