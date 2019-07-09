/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xpertgroup.technical.controllers;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xpertgroup.technical.services.AccessTestServices;

/**
 *
 * @author sebastian.moreno-r
 */

@RestController
@Service
@RequestMapping(value = "/public/services")
public class AccessTestAPIController {
    
    private static AccessTestServices services  = AccessTestServices.getInstance();
    
    @RequestMapping(method = RequestMethod.POST, path ="/solution")
    public ResponseEntity<?> solveProblem(@RequestBody Map<String, ?> body) {
        try {
            return new ResponseEntity<>(services.solve(body), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
