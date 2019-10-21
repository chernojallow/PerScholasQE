package com.perscholas.cube;

public class Cube {
	private Integer cubeLength;
    private Integer cubeWidth;
    private Integer cubeHeight;
    
    public Cube() {}
    public Cube(Integer l, Integer w, Integer h) {
        this.cubeLength = l;
        this.cubeWidth = w;
        this.cubeHeight = h;
    }
    
    public Integer getCubeLength() {
        return cubeLength;
    }
    public void setCubeLength(Integer cubeLength) {
        this.cubeLength = cubeLength;
    }
    public Integer getCubeWidth() {
        return cubeWidth;
    }
    public void setCubeWidth(Integer cubeWidth) {
        this.cubeWidth = cubeWidth;
    }
    public Integer getCubeHeight() {
        return cubeHeight;
    }
    public void setCubeHeight(Integer cubeHeight) {
        this.cubeHeight = cubeHeight;
    }
    
    public Integer calculateVolume() {
        return this.cubeLength * this.cubeWidth * this.cubeHeight;
    }
}
