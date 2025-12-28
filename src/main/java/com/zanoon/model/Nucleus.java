package src.main.java.com.zanoon.model;

import java.awt.List;
import java.util.ArrayList;

// ArrayList<Particles>
public class Nucleus {
    private int numOfNeutrons;
    private int numOfProtons;
    private double cx;
    private double cy;

    public List<Particle> particles;

    public Nucleus(int numOfNeutrons, int numOfProtons, double cx, double cy) {
        this.numOfNeutrons = numOfNeutrons;
        this.numOfProtons = numOfProtons;
        this.cx = cx;
        this.cy = cy;
        this.particles = new ArrayList<>();
    }

    // Create a function for simple cluster of protons + neutrons

    public void createNucleusCluster(double cx, double cy) {

        


    }


}
