package com.zanoon.render;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;


public class AtomSimulation3D implements GLEventListener{
    
    private GLCanvas glCanvas;

    
    public AtomSimulation3D() {
        final GLProfile profile = GLProfile.get(GLProfile.GL4); // Version GL4
        GLCapabilities capabilities = new GLCapabilities(profile);

        glCanvas = new GLCanvas(capabilities);
        glCanvas.addGLEventListener(this);


    }

    @Override
    public void init(GLAutoDrawable drawable) {

        // Retrieve the GL Object from the drawable
        GL gl = drawable.getGL().getGL2();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        // rendering code here
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        // reshape code here
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        // resource cleanup code here
    }


}