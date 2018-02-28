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
public class Pista extends Dwelling {
    Pista (String newId) {
        super(newId, DwellingType.Pista);
    }
    
    Pista (String newId, int newCapacity) {
        super(newId, newCapacity, DwellingType.Pista);
    }
}
