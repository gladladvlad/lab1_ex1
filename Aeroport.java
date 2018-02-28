/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AerialManager;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author C4theWin
 */
public class Aeroport {
    private List<Dwelling> dwellings = new ArrayList<>();
    
    Aeroport () {

    }
    
    public boolean addDwelling (Dwelling newDwelling) {
        this.dwellings.add(newDwelling);
        return true;
    }
    
    public boolean addAeronava (Aeronava aeronavaToAdd) {
        boolean validation = false;
        if (validation) {
            return false;
        }
        
        for (int i = 0; i < dwellings.size(); i++) {
            //if (dwellings.get())
        }
        
        return true;
    }
    
    public Dwelling getDwellingById (String lookId) {
        if (lookId == null)
            return null;
        
        for (int i = 0; i < dwellings.size(); i++) {
            if (dwellings.get(i).getId().equals(lookId)) {
                return dwellings.get(i);
            }
        }
        
        return null;
    }
}
