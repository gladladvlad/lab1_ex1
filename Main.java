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
        /*
        FileOutputStream file = new FileOutputStream("file.txt");
        
        Aeroport myAeroport = new Aeroport(2);
        myAeroport.addDwelling(new Hangar("area51", 3));
        myAeroport.getDwellingById("area51").addAeronava(new Avion("Avion1", "Boing123"));
        myAeroport.getDwellingById("area51").addAeronava(new Elicopter("hematosferonomicon2", "apacher_roadkill"));
        myAeroport.addDwelling(new Pista("bermuda", 100));
        myAeroport.getDwellingById("bermuda").addAeronava(new Avion("Avion2", "Matematica"));
        */
        
        Aeroport myAeroport = new Aeroport();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        //String newline = System.getProperty("line.separator");
        do {
            String command;
            String[] parts;
            try {
                System.out.print(">");
                command = reader.readLine();
                
                command = command.toLowerCase();
                parts = command.split(" ");
                
                if (parts[0].equals("exit")) {
                    return;
                }else if (parts[0].equals("dump")){
                    if (parts[1].equals("aeroport")) {
                        cleanFile(parts[2]);
                        myAeroport.dump(parts[2]);
                    }else if (parts[1].equals("dwelling")){
                        cleanFile(parts[3]);
                        myAeroport.getDwellingById(parts[2]).dump(parts[3]);
                    }else if (parts[1].equals("aeronava")){
                        if (!parts[3].equals("in"))
                            throw new IllegalArgumentException();
                        
                        cleanFile(parts[5]);
                        myAeroport.getDwellingById(parts[4]).getAeronavaById(parts[2]).dump(parts[5]);
                    }
                }else if (parts[0].equals("hangar")) {
                    if (parts.length == 3) {
                        myAeroport.addDwelling(new Hangar(parts[1], Integer.parseInt(parts[2], 10)));
                    }else {
                        myAeroport.addDwelling(new Hangar(parts[1]));
                    }
                }else if (parts[0].equals("pista")) {
                    if (parts.length == 3) {
                        myAeroport.addDwelling(new Pista(parts[1], Integer.parseInt(parts[2], 10)));
                    }else {
                        myAeroport.addDwelling(new Pista(parts[1]));
                    }
                }else if (parts[0].equals("avion")) {
                    if (!parts[3].equals("in"))
                        throw new IllegalArgumentException();
                       
                    if (myAeroport.getDwellingById(parts[4]).addAeronava(new Avion(parts[1], parts[2])))
                        System.out.println("Succes!");
                    else System.out.println("Esec!");
                }else if (parts[0].equals("elicopter")) {
                    if (!parts[3].equals("in"))
                        throw new IllegalArgumentException();
                       
                    if (myAeroport.getDwellingById(parts[4]).addAeronava(new Elicopter(parts[1], parts[2])))
                        System.out.println("Succes!");
                    else System.out.println("Esec!");
                }else if (parts[0].equals("aeroport")) { // reseteaza tot si creeaza aeroport nou cu parts[1] dwellinguri
                    if (parts.length != 2) {
                        myAeroport = new Aeroport();
                    }else { 
                        myAeroport = new Aeroport(Integer.parseInt(parts[1], 10));
                    }                
                }else if (parts[0].equals("save")) { // save aeroport file SAU save dwelling ID file
                    if (parts[1].equals("aeroport")) {
                        serialize(myAeroport, parts[2]);
                    }else if (parts[1].equals("dwelling")) {
                        serialize(myAeroport.getDwellingById(parts[2]), parts[3]);
                    }
                }else if (parts[0].equals("load")) {
                    if (parts[1].equals("aeroport")) {
                        myAeroport = deserializeAeroport(myAeroport, parts[2]);
                    }else if (parts[1].equals("hangar")) {
                        myAeroport.removeDwellingById(parts[2]);
                        myAeroport.addDwelling(deserializeDwelling(new Hangar(parts[2]), parts[3]));
                    }else if (parts[1].equals("pista")) {
                        myAeroport.removeDwellingById(parts[2]);
                        myAeroport.addDwelling(deserializeDwelling(new Pista(parts[2]), parts[3]));
                    /*}else if (parts[1].equals("aeronava")) {
                        serialize(myAeroport.get)
                    */
                    }
                }
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException exc) {
                System.out.println("Command error in phoneme! Something went wrong...");
            } catch (NullPointerException nexc) {
                System.out.println("Datele alea nu exista.");
            }
        
        }while (true);   
    }
}
