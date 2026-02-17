package com.zanoon.render.Camera;
import java.awt.event.*;

public class CameraController extends MouseAdapter {

    private Camera camera;

    public CameraController(Camera camera) {
        this.camera = camera;
    }


    // MouseListener Methods
    @Override
    public void mouseReleased(MouseEvent e){};
    
    @Override
    public void mouseClicked(MouseEvent e){};
    
    @Override
    public void mouseExited(MouseEvent e){};
    
    @Override
    public void mouseEntered(MouseEvent e){};
    
    @Override
    public void mousePressed(MouseEvent e){};


    // MouseMotionListener Methods
    @Override
    public void mouseDragged(MouseEvent e){};

    @Override
    public void mouseMoved(MouseEvent e){};


    // MouseWheelListener Methods
    @Override
    public void mouseWheelMoved(MouseWheelEvent e){};

}
