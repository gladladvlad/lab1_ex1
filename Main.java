/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AerialManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author C4theWin
 */
public class Main {
    public static void cleanFile (String fileName) throws IOException {
        Writer fileWriter = new FileWriter(fileName, false);
        fileWriter.close();
    }
    
    public static void serialize (Object obj, String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            System.out.println("datele salvate in " + fileName);
        } catch (IOException exc) {
            System.err.println("ich bin kaput");
        }   
    }
    
    public static Aeroport deserializeAeroport (Aeroport aeroport, String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            aeroport = (Aeroport) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("noch einmal ich bin kaput, da' nu oleak");
            c.printStackTrace();
            return null;
        }
        
        return aeroport;
    }
    
    public static Dwelling deserializeDwelling (Dwelling dwelling, String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            dwelling = (Dwelling) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("noch einmal ich bin kaput, da' nu oleak");
            c.printStackTrace();
            return null;
        }
        
        return dwelling;
    }
    
    public static Aeronava deserializeAeronava (Aeronava aeronava, String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            aeronava = (Aeronava) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("noch einmal ich bin kaput, da' nu oleak");
            c.printStackTrace();
            return null;
        }
        
        return aeronava;
    }
    
    public static void main (String[] args) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("file.txt");
        
        Aeroport maer = new Aeroport(2);
        Dwelling area51 = new Hangar("area 51", 2);
        maer.addDwelling(area51);
        maer.getDwellingById("area 51").addAeronava(new Avion("Avion1", "Boing123"));
        maer.getDwellingById("area 51").addAeronava(new Elicopter("hematosfer2", "apacher_roadkill"));
        
        cleanFile("file.txt");
        maer.dump("file.txt");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String command;
        String[] parts;
        //String newline = System.getProperty("line.separator");
        do {
            try {
                System.out.print(">");
                command = reader.readLine();
                parts = command.split(" ");
                if (parts[0].equals("exit")) {
                    return;
                }else if (parts[0].equals("dump")){
                    maer.dump(parts[1]);
                }
            } catch (ArrayIndexOutOfBoundsException aiob) {
                System.out.println("Command error in phoneme! Something went wrong...");
            }
        
        }while (true);
        
        serialize(maer, "my_serial.ser");
        
        //mavion = null;
        maer = null;
        
        maer = deserializeAeroport(maer, "my_serial.ser");
        
        System.out.println ("Ia, ca avionu' meo ii:  id " + maer.getDwellingById("area 51").getAeronavaById("Avion1").getId() + " si model " + maer.getDwellingById("area 51").getAeronavaById("Avion1").getModel());
    }
}
