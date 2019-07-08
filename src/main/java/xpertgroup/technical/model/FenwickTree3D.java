/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xpertgroup.technical.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sebastian.moreno-r
 */
public class FenwickTree3D {
    
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    
    private static long[][][] cube;
    private static Map<String, Integer> updates;
    
    public static int LSOne(int i){
        return ( i & (-i) );
    }
    
    public static void solveUpdate( int[] data, int N ){
        
        long val = data[3]; String point = data[0] + "_" + data[1] + "_" + data[2];
        if ( updates.containsKey(point) ) val = val - updates.get(point);
        
        updates.put(point, data[3]);
        
        for ( int x = data[0]; x < N; x += LSOne(x)){
            for ( int y = data[1]; y < N; y += LSOne(y)){
                for (int z = data[2]; z < N; z += LSOne(z)){
                    cube[x][y][z] += val;
                }
            }
        }
    }
    
    //Calculates the internal sum of a cube with (0,0,0) and (x,y,z) expreme points
    public static long stdCube( int x, int y, int z ){
        long sum = 0;
        for ( int i = x; 0 < i; i -= LSOne(i)){
            for ( int j = y; 0 < j; j -= LSOne(j)){
                for (int k = z; 0 < k; k -= LSOne(k)){
                    sum += cube[i][j][k];
                }
            }
        }
        return sum;
    }
    
    //
    public static long solveQuery( int[] data, int N ){
        int x1 = data[0], y1 = data[1], z1 = data[2], x0 = data[3], y0 = data[4], z0 = data[5];
        long val1 = stdCube(x0, y0, z0) - stdCube(x1-1,y0,z0) 
                - stdCube(x0,y1-1,z0) + stdCube(x1-1,y1-1,z0);
        long val2 = stdCube(x0, y0, z1-1) - stdCube(x1-1,y0,z1-1)
                - stdCube(x0,y1-1,z1-1) + stdCube(x1-1,y1-1,z1-1);
        return val1 - val2;
    }
    
    public static void main(String[] args) throws Exception{
        int cases = Integer.parseInt( in.readLine().trim() ), N, M, points[] = new int[6];
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
        out.close();
    }
    
}
