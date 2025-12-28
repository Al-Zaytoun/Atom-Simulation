package src.main.java.com.zanoon.model;

// For now, we will use a 2D model then upgrade into better 3D model after
public class Electron extends Particle{

    public Electron(double x, double y, double vx, double vy, double m, double a, double r) {
        super(x, y, vx, vy, m, a, r);
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
