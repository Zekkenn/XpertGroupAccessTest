/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xpertgroup.technical.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sebastian.moreno-r
 */
public class Cube3D {
    
    private FenwickTree3D fenwickTree;
    private Map<Point3D, Long> updates;
    private long[][][] cube;
    private int N;
    
    public Cube3D(int N){
        this.N = N+5;
        this.cube = new long[this.N][this.N][this.N];
        this.updates = new HashMap<Point3D, Long>();
    }

    public long[][][] getCube() {
        return cube;
    }

    public int getN() {
        return N;
    }
    
    public void addValue( Point3D pt, long val ){
        this.cube[pt.getX()][pt.getY()][pt.getZ()] += val;
    }
    
    public long getValue( Point3D pt ){
        return this.cube[pt.getX()][pt.getY()][pt.getZ()];
    }
    
    public void updateCube( Point3D pt, long val ){
        long valUpd = 0;
        if ( updates.containsKey(pt) ) valUpd = val - updates.get(pt);
        updates.put(pt, val);
        fenwickTree.solveUpdate(this, pt, val);
    }
    
    public long queryCube( Point3D pt1, Point3D pt2 ){
        return fenwickTree.solveQuery(this, pt1, pt2);
    }
    
}
