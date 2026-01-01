package com.zanoon;
import java.awt.*;
import javax.swing.*;

import com.zanoon.engine.SimulationEngine;
import com.zanoon.render.SimulationPanel;




public class Main 
{
    public static void main( String[] args )
    {
        // Window Creation
        JFrame frame = new JFrame("Atom Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        

        SimulationPanel canvas = new SimulationPanel();
        SimulationEngine engine = new SimulationEngine(canvas);
        canvas.setEngine(engine);
        canvas.setBackground(Color.BLACK);

        frame.add(canvas);
        frame.setVisible(true);
    }
}
