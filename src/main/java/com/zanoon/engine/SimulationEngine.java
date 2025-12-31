package src.main.java.com.zanoon.engine;

import javax.swing.Timer;

import src.main.java.com.zanoon.model.Electron;
import src.main.java.com.zanoon.model.Nucleus;
import src.main.java.com.zanoon.model.Nucleon.Neutron;
import src.main.java.com.zanoon.model.Nucleon.Proton;
import src.main.java.com.zanoon.render.SimulationPanel;

public class SimulationEngine {
    
    private SimulationPanel simulationPanel;
    
    // Electron object and its constant values
    private Electron electron;
    private Electron electron2;

    private int R = 150; // Initial orbital radius
    private double attraction = 0.88; // attraction magnitude force
    private double v = Math.sqrt(attraction * R);

    // Nucleus object and its constance values
    private Nucleus nucleus;

    // center of orbit (nucleus)
    private final double cx = 200;
    private final double cy = 200;

    public SimulationEngine(SimulationPanel simulationPanel) {
        
        this.simulationPanel = simulationPanel;

        electron = new Electron(cx + R, cy, 0, v, 1, 0, 8);
        electron2 = new Electron(cx, cy + R, -v, 0, 1, Math.PI, 8);

        nucleus = new Nucleus(cx, cy);
        
        // Add all particles to the nucleus
        nucleus.addParticle(new Proton(0, 0, 0, 0, 1, 0, 8));
        nucleus.addParticle(new Neutron(0, 0, 0, 0, 1, 0, 8));
        nucleus.addParticle(new Proton(0, 0, 0, 0, 1, 0, 8));
        nucleus.addParticle(new Neutron(0, 0, 0, 0, 1, 0, 8));
        nucleus.addParticle(new Proton(0, 0, 0, 0, 1, 0, 8));

        double spreadRadius = 2; // Adjust based on number of particles
        nucleus.initializeParticlePositions(spreadRadius);

        // animation timer (~60 FPS)
        Timer timer = new Timer(16, e -> {
            update();
        });
        timer.start();

    }

    private void update() {

        nucleus.updatePhysics();
        electron.orbit(cx, cy, attraction);
        electron2.orbit(cx, cy, attraction);

        simulationPanel.repaint();

    }

    public Nucleus getNucleus() {
        return nucleus;
    }

    public Electron getElectron() {
        return electron;
    }

    public Electron getElectron2() {
        return electron2;
    }

}
