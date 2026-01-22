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
    private int renderingProgram;

    
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

        GL4 gl = drawable.getGL().getGL4();

        String vertexShaderSource = loadShaderAsString("/resources/shader/shader.vert");
        String fragmentShaderSource = loadShaderAsString("/resources/shader/fragment.frag");
        int vShaderID = gl.glCreateShader(GL4.GL_VERTEX_SHADER);
        int fShaderID = gl.glCreateShader(GL4.GL_FRAGMENT_SHADER);
        
        // Upload source files & Compile
        gl.glShaderSource(vShaderID, 1, new String[] {vertexShaderSource}, null);
        gl.glShaderSource(fShaderID, 1, new String[] {fragmentShaderSource}, null);
        
        gl.glCompileShader(vShaderID);
        gl.glCompileShader(fShaderID);

        // Creating program executible for shaders to link to
        renderingProgram = gl.glCreateProgram();

        gl.glAttachShader(renderingProgram, vShaderID);
        gl.glAttachShader(renderingProgram, fShaderID);
        gl.glLinkProgram(renderingProgram);

        // Clean up of shader files
        gl.glDeleteShader(vShaderID);
        gl.glDeleteShader(fShaderID);
        


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