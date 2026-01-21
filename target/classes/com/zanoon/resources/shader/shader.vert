#version 440

attribute vec4 vertexPosition; // Initial positions of the vertices before they are transformed upon

uniform mat4 modelMatrix; // Responsible for moving the objects
uniform mat4 viewMatrix; // Responsible for moving the camera
uniform mat4 projectionMatrix; // Responsible for the distortion of the camera

layout(location = 0) in vec3 position;


void main() {
    gl_Position = projectionMatrix * viewMatrix * modelMatrix * vertexPosition;
}