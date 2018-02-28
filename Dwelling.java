/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AerialManager;

/**
 *
 * @author C4theWin
 */
public abstract class Dwelling {
    protected enum DwellingType {Hangar, Pista};
    DwellingType dwellingType;
    private final int capacity;
    
    Dwelling (DwellingType newType) {
        this.dwellingType = newType;
        this.capacity = 1;
    }
    
    Dwelling (int newCapacity, DwellingType newType) {
        this.dwellingType = newType;
        this.capacity = newCapacity;
    }
    
    public int getCapacity () {
        return this.capacity;
    }
    
    public DwellingType getType () {
        return dwellingType;
    }
}
