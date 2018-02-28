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
public abstract class Dwelling {
    protected enum DwellingType {Hangar, Pista};
    DwellingType dwellingType;
    
    private final String id;
    
    private List<Aeronava> aeronave;
    private final int capacity;
    private final int aeronaveStored;
    
    protected Dwelling (String newId, int newCapacity, DwellingType newType) {
        this.id = newId;

        this.capacity = newCapacity;
        aeronave = new ArrayList<>(newCapacity);
        this.aeronaveStored = 0;
    
        this.dwellingType = newType;
    }
    
    protected Dwelling (String newId, DwellingType newType) {
        this(newId, 1, newType);
    }
    
    public String getId () {
        return this.id;
    }
    
    public int getTotalCapacity () {
        return this.capacity - this.aeronaveStored;
    }
    
    public DwellingType getType () {
        return this.dwellingType;
    }
    
    protected boolean addAeronava (Aeronava newAeronava) {
        if (this.aeronaveStored >= this.capacity) {
            return false;
        }
        
        aeronave.add(newAeronava);
        return true;
    }
}
