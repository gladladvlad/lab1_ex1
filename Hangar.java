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
    Hangar () {
        super(DwellingType.Hangar);
    }
    
    Hangar (int newCapacity) {
        super(newCapacity, DwellingType.Hangar);
    }
}
