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
public abstract class Dwelling implements java.io.Serializable {
    protected enum DwellingType {Hangar, Pista};
    protected final DwellingType dwellingType;
    
    private final String id;
    
    private List<Aeronava> aeronave;
    private final int capacity;
    private int aeronaveStored;
    
    protected Dwelling (String newId, int newCapacity, DwellingType newType) {
        if (newId == null) {
            throw new IllegalArgumentException("In `Dwelling (String newId, int newCapacity, DwellingType newType)`: newId can't be null");
        }
        this.id = newId;

        if (newCapacity < 1){
            throw new IllegalArgumentException("In `Dwelling (String newId, int newCapacity, DwellingType newType)`: newCapacity can't be null");
        }
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
    
    protected boolean removeAeronavaById (String removeId) {
        if (removeId == null) {
            throw new IllegalArgumentException("In `removeAeronavaById (String removeId)`: removeId can't be null");
        }
        
        for (int i = 0; i < aeronave.size(); i++) {
            Aeronava currentAeronava = aeronave.get(i);
            
            if (currentAeronava.getId().equals(removeId)) {
                aeronave.remove(i);
                return true;
            }
        }
        
        return false;
    }
    
    protected boolean removeAeronavaByInstance (Aeronava removeInstance) {
        if (removeInstance == null) {
            throw new IllegalArgumentException("In `removeAeronavaByInstance (Aeronava removeInstance)`: removeInstance can't be null");
        }
        
        return aeronave.remove(removeInstance);
    }
    
    protected boolean addAeronava (Aeronava newAeronava) {
        if (this.aeronaveStored >= this.capacity) {
            return false;
        }
        
        this.aeronave.add(newAeronava);
        this.aeronaveStored++;
        return true;
    }
    
    protected Aeronava getAeronavaById (String idAeronava) {
        if (idAeronava == null) {
            throw new IllegalArgumentException("In `removeAeronavaById (String removeId)`: idAeronava can't be null");
        }
        
        for (int i = 0; i < aeronave.size(); i++) {
            Aeronava currentAeronava = aeronave.get(i);
            
            if (currentAeronava.getId().equals(idAeronava)) {
                return currentAeronava;
            }
        }
        
        return null;
    }
    
    /*
    protected void dump (OutputStream outStream) throws IOException {
        OutputStreamWriter  outputStreamWriter = new OutputStreamWriter(outStream);
        
        String newline = System.getProperty("line.separator");
        
        outputStreamWriter.write("Dwelling \"" + this.id + "\": capacitate " + this.capacity + ""
                + " si " + this.aeronaveStored + " locuri ocupate");
        
        outputStreamWriter.close();
        
        for (int i = 0; i < aeronave.size(); i++) {
            aeronave.get(i).dump(outStream);
        }
    }
    */
    
    protected void dump (String fileName) throws IOException {
        Writer fileOut = new FileWriter(fileName, true);
        
        String newline = System.getProperty("line.separator");
        
        fileOut.write("+Dwelling \"" + this.id + "\": tip \"" + this.dwellingType
                + "\", capacitate " + this.capacity + ""
                + " si " + this.aeronaveStored + " locuri ocupate:" + newline);
        
        fileOut.close();
        
        for (int i = 0; i < aeronave.size(); i++) {
            aeronave.get(i).dump(fileName);
        }
    }
}
