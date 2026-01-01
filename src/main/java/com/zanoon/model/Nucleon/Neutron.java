package com.zanoon.model.Nucleon;

import com.zanoon.model.Particle;

public class Neutron extends Particle {


    public Neutron(double x, double y, double vx, double vy, double m, double a, double r) {
        super(x, y, vx, vy, m, a, r);
    }

    @Override
    public double updatex() {
        return r * Math.cos(a);
    }

    @Override
    public double updatey() {
        return r * Math.sin(a);
    }
    
}
