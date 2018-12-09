package com.cpm;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<Integer,String> carDataMap = new HashMap<Integer,String>(  );
        HashMap<Integer,String> carDataMapClone = new HashMap<Integer,String>(  );

        ArrayList<String> carDataList = new ArrayList<>(  );

        String[] parkingSlots;
        parkingSlots = new String[10];

        int ticketNo = 5000;
        String output = "";
        String result = "";

        String input = "pABC,pDEF,pGHI,u5000,c";

        String[] splitLicensePlate = input.split( "," );

        int i = 0;

        do{
            if(splitLicensePlate[i].startsWith( "p" )){
                String[] moreSplit = splitLicensePlate[i].split( "p" );
                parkingSlots[i] = String.valueOf( ticketNo );
                carDataMap.put(ticketNo,moreSplit[1]);
                carDataMapClone.put(ticketNo,moreSplit[1]);
                ticketNo++;
            }
            if(splitLicensePlate[i].startsWith( "u" ) && splitLicensePlate[i+1].equalsIgnoreCase( "c" )){
                String[] moreSplit = splitLicensePlate[i].split( "u" );
                int key = Integer.parseInt( moreSplit[1] );
                if(carDataMap.containsKey(key)){
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
        for(int w=0; w<parkingSlots.length; w++){
            if((parkingSlots[w] == null) || (parkingSlots[w].trim().length() == 0)){
                freeSpace += "Slot" + " " + String.valueOf(w) + ",";
            }
            else{
                takenSpace += "Slot" + " " + String.valueOf(w) + ",";
            }
        }

        String spaceStatus = freeSpace + takenSpace;

        System.out.println( "Free Parking Slot => " + " " + freeSpace );
        System.out.println( "Taken Parking Slot => " + " " + takenSpace );
        System.out.println( "Car Parking Map (Before) => " + " " + carDataMapClone );
        System.out.println( "Car Parking Map (After)  => " + " " + carDataMap );
        System.out.println( "Input => " + " " + input );
        System.out.println( "Output => " + " " + output );

    }
}
