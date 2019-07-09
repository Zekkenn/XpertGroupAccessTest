/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xpertgroup.technical.model;

/**
 *
 * @author sebastian.moreno-r
 */
public class Point3D {
    
    private int x, y, z;
    
    public Point3D(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
    
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return this.toString().hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (this == obj) return true; 
        if (obj == null) return false; 
        if (this.getClass() != obj.getClass()) return false;
        Point3D pt = (Point3D) obj;
        if ( !( pt.getX() == this.x && pt.getY() == this.y && pt.getZ() == this.z)) return false; 
        return true;
    }
    
    @Override
    public String toString(){
        return (x + "_" + y + "_" + z);
    }
}
