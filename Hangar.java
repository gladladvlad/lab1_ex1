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
public class Hangar extends Dwelling {
    Hangar (String newId) {
        super(newId, DwellingType.Hangar);
    }
    
    Hangar (String newId, int newCapacity) {
        super(newId, newCapacity, DwellingType.Hangar);
    }
}
