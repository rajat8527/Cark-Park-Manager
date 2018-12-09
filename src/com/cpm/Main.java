package com.cpm;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer,String> carDataMap = new HashMap<Integer,String>(  );
        HashMap<Integer,String> carDataMapClone = new HashMap<Integer,String>(  );

        ArrayList<String> carDataList = new ArrayList<>(  );


        ArrayList<String> parkingSlots = new ArrayList<>(Arrays.asList(new String[11]));

        int ticketNo = 5000;
        String output = "";
        String result = "";

        String input = "pABC,pDEF,pGHI,u5000,c,pXYZ";

        String[] splitLicensePlate = input.split( "," );

        int i = 0;

        do{
            if(splitLicensePlate[i].startsWith( "p" )){
                String[] moreSplit = splitLicensePlate[i].split( "p" );
                parkingSlots.set(i,String.valueOf(ticketNo));
                carDataMap.put(ticketNo,moreSplit[1]);
                carDataMapClone.put(ticketNo,moreSplit[1]);
                ticketNo++;
            }
            if(splitLicensePlate[i].startsWith( "u" ) && splitLicensePlate[i+1].equalsIgnoreCase( "c" )){
                String[] moreSplit = splitLicensePlate[i].split( "u" );
                int key = Integer.parseInt( moreSplit[1] );
                if(carDataMap.containsKey(key)){
                    parkingSlots.remove( String.valueOf( key ) );
                    carDataMap.remove(key);
                } else {
                    System.out.println("Car with ticket no"+" "+key+" "+"is not parked here !");
                }
            }
            i++;
        }while (i<splitLicensePlate.length);

        for (String values : carDataMap.values()) {
            result += values + ",";
            output = result.replace( "p","" );
        }

        String freeSpace = "";
        String takenSpace = "";

        for(int w=0; w<parkingSlots.size(); w++){
            if((parkingSlots.get( w ) == null )){
                freeSpace += "Slot" + " " + String.valueOf(w) + ",";
            }
            else{
                takenSpace += "Slot" + " " + String.valueOf(w) + ",";
            }
        }

        System.out.println( "Free Parking Slot => " + " " + freeSpace );
        System.out.println( "Taken Parking Slot => " + " " + takenSpace );
        System.out.println( "Car Parking Map (Before) => " + " " + carDataMapClone );
        System.out.println( "Car Parking Map (After)  => " + " " + carDataMap );
        System.out.println( "Input => " + " " + input );
        System.out.println( "Output => " + " " + output );

    }
}
