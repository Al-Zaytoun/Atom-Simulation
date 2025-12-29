package src.main.java.com.zanoon.render;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.Timer;

import src.main.java.com.zanoon.model.Electron;

public class SimulationPanel extends JPanel {

    private Electron electron;

    // center of orbit (nucleus)
    private final double cx = 200;
    private final double cy = 200;

    public SimulationPanel() {

        electron = new Electron(
            cx + 80,
            cy,
            0, 0,
            1,
            0,
            8
        );

        // animation timer (~60 FPS)
        Timer timer = new Timer(16, e -> {
            electron.orbit(cx, cy, 0.03); // angular speed
            repaint();
        });

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw nucleus center
        g.setColor(Color.RED);
        g.fillOval((int) cx - 4, (int) cy - 4, 8, 8);

        // draw electron
        g.setColor(Color.CYAN);
        g.fillOval(
            (int) (electron.getX() - electron.getR()),
            (int) (electron.getY() - electron.getR()),
            (int) (2 * electron.getR()),
            (int) (2 * electron.getR())
        );
    }
}
