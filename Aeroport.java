/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AerialManager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author C4theWin
 */
public class Aeroport implements java.io.Serializable {
    private List<Dwelling> dwellings;
    
    Aeroport (int numDwellings) {
        if (numDwellings < 1) {
            throw new IllegalArgumentException("In `Aeroport (int numDwellings)`: Number of dwellings can't be less than 1");
        }
        
        dwellings = new ArrayList<>(numDwellings);
    }
    
    Aeroport () {
        this (1);
    }
    
    public boolean addDwelling (Dwelling newDwelling) {
        if (newDwelling == null)
            throw new IllegalArgumentException("In `addDwelling (Dwelling newDwelling)`: newDwelling can't be null");
        
        this.dwellings.add(newDwelling);
        return true;
    }
    
    /*
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
    */
    
    public Dwelling getDwellingById (String lookId) {
        if (lookId == null)
            throw new IllegalArgumentException("In `getDwellingById (String lookId)`: lookId can't be null");
        
        for (int i = 0; i < dwellings.size(); i++) {
            if (dwellings.get(i).getId().equals(lookId)) {
                return dwellings.get(i);
            }
        }
        
        return null;
    }
    
    protected void dump (String fileName) throws IOException {
        Writer fileOut = new FileWriter(fileName, true);
        
        String newline = System.getProperty("line.separator");
        
        fileOut.write("++Aeroport ce contine:" + newline);
        
        fileOut.close();
        
        for (int i = 0; i < dwellings.size(); i++) {
            dwellings.get(i).dump(fileName);
        }
    }
}
