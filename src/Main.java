// Project3
// Name: Yvonne Hsiao
// Class: CS 3345.501

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter the file name for origination and destination data: ");
        String flightData = scnr.next();
        System.out.print("Enter the file name for requested flights: ");
        String requestedData = scnr.next();
        
        Scanner flightDat = readFlightData(flightData);
        Scanner calPath = readRequestedData(requestedData);
        
        // create an adjacency list
        AdjList list = new AdjList();
        list.createAdjList(flightDat);
        list.print();
        System.out.println();

        //calculate the 3 shortest paths
        FlightCalc calc = new FlightCalc(list);
        calc.print(calPath);

        scnr.close();
    }

    // return scanner for flight data
    private static Scanner readFlightData(String flightData) {
        File flightFile = new File(flightData);
        Scanner openfile;
        try{
            openfile = new Scanner(flightFile);
            return openfile;
        }catch(IOException e){
            System.out.println("Error: file not found");
            return null;
        }
    }

    //return scanner for requested data
    private static Scanner readRequestedData(String requestedData) {
        File requestedFile = new File(requestedData);
        Scanner openfile;
        try{
            openfile = new Scanner(requestedFile);
            return openfile;
        }catch(IOException e){
            System.out.println("Error: file not found");
            return null;
        }
    }
}
