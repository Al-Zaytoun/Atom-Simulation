package com.zanoon.render;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.zanoon.engine.SimulationEngine;
import com.zanoon.model.Electron;
import com.zanoon.model.Nucleus;
import com.zanoon.model.Particle;
import com.zanoon.model.Nucleon.Proton;

public class SimulationPanel extends JPanel {

    SimulationEngine engine;

    // We avoid creating a constructur, to ensure circular dependency does not occur
    public void setEngine(SimulationEngine engine) {
        this.engine = engine;
    }

    private void drawElectron(Graphics g, Electron electron) {
        g.setColor(Color.CYAN);
        g.fillOval(
            (int) (electron.getX() - electron.getR()),
            (int) (electron.getY() - electron.getR()),
            (int) (2 * electron.getR()),
            (int) (2 * electron.getR())
        );
    }

    private void drawNucleus(Graphics g, Nucleus nucleus) {
        for (Particle p : nucleus.getParticles()) {
            if (p instanceof Proton) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.GRAY);
            }

            g.fillOval(
                (int)(p.getX() - p.getR()),
                (int)(p.getY() - p.getR()),
                (int)(2 * p.getR()),
                (int)(2 * p.getR())
            );
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    
        drawElectron(g, engine.getElectron());
        drawElectron(g, engine.getElectron2());
        drawNucleus(g, engine.getNucleus());
    }
}