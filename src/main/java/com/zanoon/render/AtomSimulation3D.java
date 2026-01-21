package com.zanoon.render;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;


public class AtomSimulation3D implements GLEventListener {
    
    private GLCanvas glCanvas;

    
    public AtomSimulation3D() {
        final GLProfile profile = GLProfile.get(GLProfile.GL4); // Version GL4
        GLCapabilities capabilities = new GLCapabilities(profile);

        glCanvas = new GLCanvas(capabilities);
        glCanvas.addGLEventListener(this);


    }

    // Helper method to load shader source code from file
    public String loadShaderAsString(String filePath) {
        StringBuilder result = new StringBuilder();
        
        try (InputStream in = AtomSimulation3D.class.getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Could not load shader file: " + filePath);
            e.printStackTrace();
        }
        return result.toString();
        
    }



    @Override
    public void init(GLAutoDrawable drawable) {

        // Retrieve the GL Object from the drawable
        GL gl = drawable.getGL().getGL4();

        // Load shader source code
        String vertexShaderSource = loadShaderAsString("/shaders/vertex_shader.glsl");
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