/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AerialManager;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author C4theWin
 */
public abstract class Aeronava implements java.io.Serializable {
    protected enum AeronavaType {Elicopter, Avion};
    private final AeronavaType aeronavaType;
    private final String id;
    private final String model;
    
    protected Aeronava (String newId, String newModel, AeronavaType newType) {
        if (newId == null) {
            throw new IllegalArgumentException("In `Aeronava (String newId, String newModel, AeronavaType newType)`: newId can't be null");
        }
        this.id = newId;
        
        if (newModel == null) {
            throw new IllegalArgumentException("In `Aeronava (String newId, String newModel, AeronavaType newType)`: newModel can't be null");
        }     
        this.model = newModel;
        
        this.aeronavaType = newType;
    }
    
    public String getId () {
        return this.id;
    }
    
    public String getModel () {
        return this.model;
    }
    
    /*
    protected void dump (OutputStream outStream) throws IOException {
        OutputStreamWriter  outputStreamWriter = new OutputStreamWriter(outStream);
        
        outputStreamWriter.write("Aeronava \"" + this.id + "\": model \"" + this.model + ""
                + "\" de tip \"" + this.aeronavaType + "\"");
        outputStreamWriter.close();
    }
    */
        
    protected void dump (String fileName) throws IOException {
        Writer fileOut = new FileWriter(fileName, true);
        
        String newline = System.getProperty("line.separator");
        
        fileOut.write("Aeronava \"" + this.id + "\": model \"" + this.model + ""
                + "\" de tip \"" + this.aeronavaType + "\"" + newline);
        
        fileOut.close();
    }
}
