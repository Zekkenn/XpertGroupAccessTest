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
public class FenwickTree3D {
    
    public FenwickTree3D(){
        
    }
    
    /***
     * Allows the navigation inside the binary tree
     * @param i the integer that we're going to use in the navigation
     * @return bit mask
     */
    public static int LSOne(int i){
        return ( i & (-i) );
    }
    
    /***
     * Update a position in the cube
     * @param cube The cube to be updated
     * @param pt Position 
     * @param val New value to be added (don't replace the value)
     */
    public static void solveUpdate( Cube3D cube, Point3D pt, long val ){
        
        for ( int x = pt.getX(); x < cube.getN(); x += LSOne(x)){
            for ( int y = pt.getY(); y < cube.getN(); y += LSOne(y)){
                for (int z = pt.getZ(); z < cube.getN(); z += LSOne(z)){
                    cube.addValue(new Point3D(x, y, z), val);
                }
            }
        }
    }
    
    /***
     * Calculates the internal sum of a cube with (0,0,0) and (x,y,z) end points
     * @param cube Cube to be calculated
     * @param pt End point
     * @return Total sum
     */
    public static long stdCube( Cube3D cube, Point3D pt ){
        long sum = 0;
        for ( int i = pt.getX(); 0 < i; i -= LSOne(i)){
            for ( int j = pt.getY(); 0 < j; j -= LSOne(j)){
                for (int k = pt.getZ(); 0 < k; k -= LSOne(k)){
                    sum += cube.getValue(new Point3D(i, j, k));
                }
            }
        }
        return sum;
    }
    
    /***
     * Gets the sum of a sub-cube given two points ( pt1 < pt2 )
     * @param cube Initial cube
     * @param pt1 Point 1
     * @param pt2 Point 2
     * @return Total sum
     */
    public static long solveQuery( Cube3D cube, Point3D pt1, Point3D pt2 ){
        
        int x1 = pt1.getX(), y1 = pt1.getY(), z1 = pt1.getZ(), 
                x0 = pt2.getX(), y0 = pt2.getY(), z0 = pt2.getZ();
        
        long val1 = stdCube(cube, new Point3D(x0, y0, z0)) - stdCube(cube, new Point3D(x1-1,y0,z0)) 
                - stdCube(cube, new Point3D(x0,y1-1,z0)) + stdCube(cube, new Point3D(x1-1,y1-1,z0));
        
        long val2 = stdCube(cube, new Point3D(x0, y0, z1-1)) - stdCube(cube, new Point3D(x1-1,y0,z1-1))
                - stdCube(cube, new Point3D(x0,y1-1,z1-1)) + stdCube(cube, new Point3D(x1-1,y1-1,z1-1));
        return val1 - val2;
    }
    
    public static void main(String[] args) throws Exception{
        /*int cases = Integer.parseInt( in.readLine().trim() ), N, M, points[] = new int[6];
        String[] data, query;
        while ( cases > 0 ){
            data = in.readLine().trim().split(" ");
            N = Integer.parseInt(data[0])+5; M = Integer.parseInt(data[1]);
            
            cube = new long[N][N][N]; updates = new HashMap<String, Integer>();
            
            for ( int i = 0; i < M; i++ ){
                query = in.readLine().trim().split(" ");
                for (int j = 1; j < query.length; j++) points[j-1] = Integer.parseInt( query[j] );
                if ( query[0].equals("UPDATE") ){
                    solveUpdate(points, N);
                } else {
                    System.out.print(solveQuery(points, N) + "\n");
                }
            }
            cases--;
        }
        out.close();*/
    }
    
}
