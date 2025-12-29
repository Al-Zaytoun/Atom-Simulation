package src.main.java.com.zanoon.model;

// For now, we will use a 2D model then upgrade into better 3D model after
public class Electron extends Particle{

    private double orbitRadius;

    public Electron(double x, double y, double vx, double vy, double m, double a, double r) {
        super(x, y, vx, vy, m, a, r);
    }


    // Function to rotate the electron around the center-point
    public void orbit(double cx, double cy, double omega) {

        double dx = x - cx;
        double dy = y - cy;
        orbitRadius = Math.sqrt(dx * dx + dy * dy);

        a += omega;

        x = cx + orbitRadius * Math.cos(a);
        y = cy + orbitRadius * Math.sin(a);

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
