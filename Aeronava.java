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
public class Aeronava {
    protected enum AeronavaType {Elicopter, Avion};
    private final AeronavaType aeronavaType;
    private final int id;
    private final String model;
    
    Aeronava (int newId, String newModel, AeronavaType newType) {
        this.id = newId;
        this.model = newModel;
        this.aeronavaType = newType;
    }
    
}
