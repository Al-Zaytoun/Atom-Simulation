package src.main.java.com.zanoon.model;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

// ArrayList<Particles>
public class Nucleus {
    private int numOfNeutrons;
    private int numOfProtons;
    private double cx; // Center x-coordinate
    private double cy; // Center y-coordinate

    private List<Particle> particles;

    public Nucleus(int numOfNeutrons, int numOfProtons, double cx, double cy) {
        this.numOfNeutrons = numOfNeutrons;
        this.numOfProtons = numOfProtons;
        this.cx = cx;
        this.cy = cy;
        this.particles = new ArrayList<>();
    }

    // Function to randomly place particles around center point radius
    private void initialPlacement(double cx, double cy) {

        int maxRadiusPlacement = 20; // Arbitrary value to indicate how far from the center a particle can be placed at
        Random rand = new Random();

        for (int i = 0; i < particles.size(); i++) {
            Particle particle = particles.get(i);

            
        }

    }


    public void update() {
        initialPlacement(cx, cy);
    }

}
