package src.main.java.com.zanoon.render;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;
import src.main.java.com.zanoon.model.Electron;
import src.main.java.com.zanoon.model.Nucleus;
import src.main.java.com.zanoon.model.Particle;
import src.main.java.com.zanoon.model.Nucleon.Neutron;
import src.main.java.com.zanoon.model.Nucleon.Proton;

public class SimulationPanel extends JPanel {

    private Electron electron;
    private Electron electron2;

    private int R = 150; // Initial orbital radius
    private double attraction = 0.88; // attraction magnitude force
    private double v = Math.sqrt(attraction * R);
    private int maxRadius = 1;

    // center of orbit (nucleus)
    private final double cx = 200;
    private final double cy = 200;

    private Neutron neutron;
    private Proton proton;
    private Nucleus nucleus;

    public SimulationPanel() {

        electron = new Electron(cx + R, cy, 0, v, 1, 0, 8);
        electron2 = new Electron(cx, cy + R, -v, 0, 1, Math.PI, 8);

        proton = new Proton(0, 0, 0, 0, 1, 0, 8);
        neutron = new Neutron(0, 0, 0, 0, 1, 0, 8);

        nucleus = new Nucleus(cx, cy);
        
        nucleus.addParticle(proton);
        nucleus.addParticle(neutron);

        nucleus.organicCluster(maxRadius); // This is done, to prevent all nucleus particles starting off stacked, which will prevent performance drain

        // animation timer (~60 FPS)
        Timer timer = new Timer(16, e -> {
            nucleus.organicCluster(maxRadius);
            electron.orbit(cx, cy, attraction);
            electron2.orbit(cx, cy, attraction);
            repaint();
        });

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw nucleus center
        g.setColor(Color.RED);
        g.fillOval((int) cx - 4, (int) cy - 4, 8, 8);

        // draw electron
        g.setColor(Color.CYAN);
        g.fillOval(
            (int) (electron.getX() - electron.getR()),
            (int) (electron.getY() - electron.getR()),
            (int) (2 * electron.getR()),
            (int) (2 * electron.getR())
        );
    
            // draw electron2
        g.setColor(Color.CYAN);
        g.fillOval(
            (int) (electron2.getX() - electron2.getR()),
            (int) (electron2.getY() - electron2.getR()),
            (int) (2 * electron2.getR()),
            (int) (2 * electron2.getR())
        );

        // Drawing nucleus particles
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
}
