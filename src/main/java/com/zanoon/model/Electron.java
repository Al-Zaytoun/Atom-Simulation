package com.zanoon.model;

// For now, we will use a 2D model then upgrade into better 3D model after
public class Electron extends Particle{

    private double dist;

    public Electron(double x, double y, double vx, double vy, double m, double a, double r) {
        super(x, y, vx, vy, m, a, r);
    }


    // Function to rotate the electron around the center-point using circular motion calculations
    public void orbit(double cx, double cy, double attractionStrength) {

        // Compute vector to the center point
        double dx = cx - x;
        double dy = cy - y;

        dist = Math.sqrt(dx * dx + dy * dy);
        if (dist == 0) return; // To ensure crashing doesnt occur if particle at center

        // Unit vectors
        double nx = dx / dist;
        double ny = dy / dist;

        // Updating veloctity and position
        vx += attractionStrength * nx;
        vy += attractionStrength * ny;        
        x += vx;
        y += vy;

    }

    // When it comes to drawing this, we will include the center coordinate (which will be our nucleus)
    @Override
    public double updatex() {
        return r * Math.cos(a);
    }

    @Override
    public double updatey() {
        return r * Math.sin(a);
    }



}
