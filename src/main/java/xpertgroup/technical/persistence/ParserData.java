/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xpertgroup.technical.persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import xpertgroup.technical.model.Cube3D;
import xpertgroup.technical.model.Point3D;

/**
 *
 * @author sebastian.moreno-r
 */
public class ParserData {
    
    public ParserData(){
        
    }
    
    public String solveAndViewAllData(Map<String, ?> data) throws PersistenceException{
        String answer = "";
        
        if ( data == null || !( data.containsKey("data") ) || !(data.get("data") instanceof String) ){
            throw new PersistenceException(PersistenceException.FORMATERROR);
        }
        
        BufferedReader in = new BufferedReader(new StringReader( (String) data.get("data") ));
        
        try {
            int cases = Integer.parseInt( in.readLine().trim() ), M, points[] = new int[6];
            String[] line; Cube3D cube;
            while ( cases > 0 ){
                line = in.readLine().trim().split(" ");
                cube = new Cube3D( Integer.parseInt(line[0]) );
                M = Integer.parseInt(line[1]);

                for ( int i = 0; i < M; i++ ){
                    line = in.readLine().trim().split(" ");
                    for (int j = 1; j < line.length; j++) points[j-1] = Integer.parseInt( line[j] );
                    if ( line[0].equals("UPDATE") ){
                        cube.updateCube(new Point3D(points[0], points[1], points[2]), points[3]);
                    } else {
                        answer += cube.queryCube(new Point3D(points[0], points[1], points[2]), 
                                new Point3D(points[3], points[4], points[5])) + "\n";
                    }
                }
                cases--;
            } 
        } catch( IOException e ){
            throw new PersistenceException(PersistenceException.FORMATERROR);
        }
        
        return answer;
    }
    
}
