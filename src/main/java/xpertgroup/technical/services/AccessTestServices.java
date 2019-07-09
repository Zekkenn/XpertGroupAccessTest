/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xpertgroup.technical.services;

import java.util.Map;
import xpertgroup.technical.persistence.PersistenceException;
import xpertgroup.technical.services.impl.AccessTestServicesImpl;

/**
 *
 * @author sebastian.moreno-r
 */
public abstract class AccessTestServices {
    
    private static AccessTestServices instance = new AccessTestServicesImpl();
    
    public static AccessTestServices getInstance(){
        return instance;
    }
    
    public abstract String solve( Map<String, ?> data ) throws PersistenceException;
    
}
