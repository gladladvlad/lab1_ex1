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
public abstract class Aeronava {
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
    
}
