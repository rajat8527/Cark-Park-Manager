package com.cpm;

import java.util.ArrayList;
import java.util.HashMap;

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

        String input = "pABC,pDEF,pGHI,u5000,c,pXYZ,pLOM,pGSI,pWHI,pJHI,pMHI,u5005,c,pGHI,pGHX,pGHW";

        String[] splitLicensePlate = input.split( "," );

        int i = 0;

        do{
            if(splitLicensePlate[i].startsWith( "p" )){
                String[] licensePlate = splitLicensePlate[i].split( "p" );
                carDataMap.put( ticketNo, licensePlate[1] );
                carDataMapClone.put( ticketNo, licensePlate[1] );
                ticketNo++;
            }
            if(splitLicensePlate[i].startsWith( "u" ) && splitLicensePlate[i+1].equalsIgnoreCase( "c" )){
                String[] licensePlate = splitLicensePlate[i].split( "u" );
                int key = Integer.parseInt( licensePlate[1] );
                if(carDataMap.containsKey(key)){
                    carDataMap.remove(key);
                } else {
                    System.out.println("Car with ticket no"+" "+key+" "+"is not parked here !");
                }
            }
            i++;
        }while (i<parkingSlots.length);

        for (String values : carDataMap.values()) {
            result += values + ",";
            output = result.replace( "p","" );
        }

        System.out.println( "Car Parking Map (Before) => " + " " + carDataMapClone );
        System.out.println( "Car Parking Map (After)  => " + " " + carDataMap );
        System.out.println( "Input => " + " " + input );
        System.out.println( "Output => " + " " + output );

    }
}
