package com.zanoon.render;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.FloatBuffer;
import java.nio.charset.StandardCharsets;

import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;


public class AtomSimulation3D implements GLEventListener {
    
    private GLCanvas glCanvas;
    private int renderingProgram;

    private int[] vao = new int[1]; // How the GPU should read the information in vbo
    private int[] vbo = new int[1]; // Buffer which contains the information of the vertex's

    
    public AtomSimulation3D() {
        final GLProfile profile = GLProfile.get(GLProfile.GL4); // Version GL4
        GLCapabilities capabilities = new GLCapabilities(profile);

        glCanvas = new GLCanvas(capabilities);
        glCanvas.addGLEventListener(this);


    }

    // Helper method to load shader source code from file
    private String loadShaderAsString(String filePath) {
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


    // Helper method to create the VAO and VBO with pre-defined data
    private void setupVertices(GL4 gl) {

        float[] vertexPositions = 
        {  // x, y, z
            -0.5f, -0.5f, 0.0f,
            0.5f, -0.5f, 0.0f,
            0.0f, 0.5f, 0.0f
        };

        FloatBuffer vertexBuffer = Buffers.newDirectFloatBuffer(vertexPositions);

        // Creation of VAO (For now we can simply create it as we dont have any necessary attributes needed onto the VBO)
        gl.glGenVertexArrays(vao.length, vao, 0);
        gl.glBindVertexArray(vao[0]);

        
        gl.glGenBuffers(vbo.length, vbo, 0);
        gl.glBindBuffer(GL4.GL_ELEMENT_ARRAY_BUFFER, vbo[0]);
        gl.glBufferData(GL4.GL_ARRAY_BUFFER, vertexPositions.length * 4, vertexBuffer, GL4.GL_STATIC_DRAW); // Size is in Bytes
        
        // Linking VBO to attributes
        
        // 0 = Layout Location in Shader
        // 3 = Size (3 components: x, y, z)
        // GL_FLOAT = Type of data
        // false = Don't normalize (we are already in float, we do not need to convert from float -> float)
        // 0 = Stride (0 means tightly packed)
        // 0 = offset (Start at the beginning)
        gl.glVertexAttribPointer(0, 3, GL4.GL_FLOAT, false, 0, 0);

        gl.glEnableVertexAttribArray(0);
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

        setupVertices(gl);

        // Creating program executible for shaders to link to
        renderingProgram = gl.glCreateProgram();

        gl.glAttachShader(renderingProgram, vShaderID);
        gl.glAttachShader(renderingProgram, fShaderID);
        gl.glLinkProgram(renderingProgram);

        // Clean up of shader files
        gl.glDeleteShader(vShaderID);
        gl.glDeleteShader(fShaderID);
        

        // Creation of VAO's and VBO'S 
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