package com.zanoon.model;


// Holds common values for each particle
public abstract class Particle {
    protected double x;
    protected double y;
    protected double vx;
    protected double vy;
    protected double m;
    protected double a; // Angle
    protected double r;

    public Particle(double x, double y, double vx, double vy, double m, double a, double r) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.m = m;
        this.a = a;
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double updatex();
    public abstract double updatey();

}
