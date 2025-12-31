package src.main.java.com.zanoon.model;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

// ArrayList<Particles>
public class Nucleus {
    private double cx; // Center x-coordinate
    private double cy; // Center y-coordinate

    private List<Particle> particles;

    public Nucleus(double cx, double cy) {

        this.cx = cx;
        this.cy = cy;
        this.particles = new ArrayList<>();
    }

    private void randomParticlePlacement(double cx, double cy, int maxRadius) {
        // Generate points within maxRadius
        Random rand = new Random();

        for (int i = 0; i < particles.size(); i++) {
            Particle particle = particles.get(i);
            
            double a = rand.nextDouble() * (2 * Math.PI);
            double r = particle.getR() * maxRadius;
            double x = cx + r * Math.cos(a);
            double y = cy + r * Math.sin(a);
            
            particle.setPosition(x, y);

        }

    }

    // Function to organically cluster nucleon particles together, it follows a 2-step process of randomly generating particles within a radius, and handling collisions with every particle
    private void collisionParticleResolution(double cx, double cy) {

        double overlapMagnitutde = 0.05;

        // Resolve collisions with every particle pair

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < particles.size(); j++) {
                Particle a = particles.get(j);
                for (int k = j + 1; k < particles.size(); k++) {
                    Particle b = particles.get(k);

                    double dx = a.getX() - b.getX();
                    double dy = a.getY() - b.getY();

                    double dist = Math.sqrt(dx * dx + dy * dy);
                    double minDist = a.getR() + b.getR();

                    if (dist < minDist && dist > 0) { // Overlapping occured, move both particles outwards based on the nx/ny directions
                        double overlap = minDist - dist;
                        double nx = dx / dist;
                        double ny = dy / dist;

                        a.setPosition(a.getX() + (nx * overlap * overlapMagnitutde), a.getY() + (ny * overlap * overlapMagnitutde)); // New position = old position + displacement
                        b.setPosition(b.getX() - (nx * overlap * overlapMagnitutde), b.getY() - (ny * overlap * overlapMagnitutde));

                    }
                }
            }
        }

    }

    public void organicCluster(int maxRadius) {
        randomParticlePlacement(cx, cy, maxRadius);
        collisionParticleResolution(cx, cy);
    }

    public void addParticle(Particle p) {
        particles.add(p);
    }

    public List<Particle> getParticles() {
        return particles;
    }

}
