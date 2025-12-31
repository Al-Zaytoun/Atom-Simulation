package src.main.java.com.zanoon.model;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

// ArrayList<Particles>
public class Nucleus {
    private double cx; // Center x-coordinate
    private double cy; // Center y-coordinate

    private List<Particle> particles;
    private Random rand;

    public Nucleus(double cx, double cy) {

        this.cx = cx;
        this.cy = cy;
        this.particles = new ArrayList<>();
        this.rand = new Random();
    }

    public void initializeParticlePositions(double maxRadius) {
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
    public void updatePhysics() {
        double dampingFactor = 0.95; // Global velocity damping
        double collisionDamping = 0.3; // Energy loss during collisions
        double centerStrength = 0.015; // Center attraction of center
        double restThreshold = 0.5; // Velocity below this is considered "at rest"
        double thermalVibration = 0.25; // Amplitude of random thermal motion
        
        // Collision resolution iterations
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < particles.size(); j++) {
                Particle a = particles.get(j);
                
                for (int k = j + 1; k < particles.size(); k++) {
                    Particle b = particles.get(k);
                    
                    double dx = a.getX() - b.getX();
                    double dy = a.getY() - b.getY();
                    double dist = Math.sqrt(dx * dx + dy * dy);
                    double minDist = a.getR() + b.getR();
                    
                    if (dist < minDist && dist > 0) {
                        // Normal vector
                        double nx = dx / dist;
                        double ny = dy / dist;
                        
                        // Separate particles
                        double overlap = minDist - dist;
                        double separationFactor = 0.5;
                        
                        a.setPosition(
                            a.getX() + nx * overlap * separationFactor,
                            a.getY() + ny * overlap * separationFactor
                        );
                        b.setPosition(
                            b.getX() - nx * overlap * separationFactor,
                            b.getY() - ny * overlap * separationFactor
                        );
                        
                        // Calculate relative velocity along collision normal
                        double dvx = a.vx - b.vx;
                        double dvy = a.vy - b.vy;
                        double relativeVelocity = dvx * nx + dvy * ny;
                        
                        // Only resolve if particles are moving toward each other
                        if (relativeVelocity < 0) {
                            double impulse = relativeVelocity * collisionDamping;
                            
                            a.vx -= impulse * nx;
                            a.vy -= impulse * ny;
                            b.vx += impulse * nx;
                            b.vy += impulse * ny;
                        }
                    }
                }
            }
        }
        
        // Update positions and apply damping
        for (Particle p : particles) {
            // General velocity damping
            p.vx *= dampingFactor;
            p.vy *= dampingFactor;
            
            // Center attraction
            double dx = cx - p.getX();
            double dy = cy - p.getY();
            p.vx += dx * centerStrength;
            p.vy += dy * centerStrength;
            
            // If moving slowly, add thermal vibration (quantum fluctuations)
            double speed = Math.sqrt(p.vx * p.vx + p.vy * p.vy);
            if (speed < restThreshold) {
                p.vx += (rand.nextDouble() - 0.5) * thermalVibration;
                p.vy += (rand.nextDouble() - 0.5) * thermalVibration;
            }
            
            // Update position
            p.x += p.vx;
            p.y += p.vy;
        }
    }

    public void addParticle(Particle p) {
        particles.add(p);
    }

    public List<Particle> getParticles() {
        return particles;
    }

}
