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
    private List<Dwelling> aeronaveStored = new ArrayList<>();
    private int capacity;
    
    Aeroport () {
        this.capacity = 1;
    }
    
    Aeroport (int newCapacity) {
        this.capacity = newCapacity;
    }
    
    public int getCapacity (){
        return this.capacity;
    }
    
    public boolean addAeronava (Aeronava aeronavaToAdd) {
        boolean validation = false;
        if (validation) {
            return false;
        }
        //add aeronava
        return true;
    }
    
}
