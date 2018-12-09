package com.cpm;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Map to store parked car data against its ticket number
        HashMap<Integer, String> carDataMap = new HashMap<Integer, String>();
        //Clone of the above map to show the changes in the map
        HashMap<Integer, String> carDataMapClone = new HashMap<Integer, String>();

        //Array List to track parking slots availability
        ArrayList<String> parkingSlots = new ArrayList<>( Arrays.asList( new String[10] ) );

        //ticket number initialized at 5000
        int ticketNo = 5000;

        //final output string
        String output = "";
        String result = "";
        String freeSpace = "";
        String takenSpace = "";

        //taking user input
        Scanner sc = new Scanner( System.in );
        System.out.println( "Enter an input string to process ....\n" );
        //storing the input string
        String input = sc.nextLine();


        String[] splitLicensePlate = input.split( "," );

        int i = 0;

        try {
            do {
                if ( splitLicensePlate[i].startsWith( "p" ) ) {
                    String[] licensePlate = splitLicensePlate[i].split( "p" );
                    parkingSlots.set( i, String.valueOf( ticketNo ) );
                    carDataMap.put( ticketNo, licensePlate[1] );
                    carDataMapClone.put( ticketNo, licensePlate[1] );
                    ticketNo++;
                }
                if ( splitLicensePlate[i].startsWith( "u" ) && splitLicensePlate[i + 1].equalsIgnoreCase( "c" ) ) {
                    String[] licensePlate = splitLicensePlate[i].split( "u" );
                    int key = Integer.parseInt( licensePlate[1] );
                    if ( carDataMap.containsKey( key ) ) {
                        parkingSlots.remove( String.valueOf( key ) );
                        carDataMap.remove( key );
                    } else {
                        System.out.println( "Car with ticket no" + " " + key + " " + " not found !" );
                    }
                }
                i++;
            } while (i < splitLicensePlate.length);
        } catch (Exception e) {
            throw e;
        }

        for (String values : carDataMap.values()) {
            result += values + ",";
            output = result.replace( "p", "" );
        }

        for (int w = 0; w < parkingSlots.size(); w++) {
            if ( (parkingSlots.get( w ) == null) ) {
                freeSpace += "Slot" + " " + String.valueOf( w ) + ",";
            } else {
                takenSpace += "Slot" + " " + String.valueOf( w ) + ",";
            }
        }

        System.out.println( "Input => " + " " + input );
        System.out.println( "Output => " + " " + output );
        System.out.println( "Free Parking Slot => " + " " + freeSpace );
        System.out.println( "Taken Parking Slot => " + " " + takenSpace );
        System.out.println( "Car Parking Map (Before) => " + " " + carDataMapClone );
        System.out.println( "Car Parking Map (After)  => " + " " + carDataMap );


    }
}
