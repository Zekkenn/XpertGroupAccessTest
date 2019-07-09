/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xpertgroup.technical.services.impl;

import java.util.Map;
import xpertgroup.technical.persistence.ParserData;
import xpertgroup.technical.persistence.PersistenceException;
import xpertgroup.technical.services.AccessTestServices;

/**
 *
 * @author sebastian.moreno-r
 */
public class AccessTestServicesImpl extends AccessTestServices{
    
    private ParserData ps = new ParserData();
    
    public AccessTestServicesImpl(){
        
    }

    @Override
    public String solve(Map<String, ?> data) throws PersistenceException {
        return ps.solveAndViewAllData(data);
    }
    
}
