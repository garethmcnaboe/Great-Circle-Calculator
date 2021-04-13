package com.company;

import java.util.Scanner;

public class Main {

    //average circumference of the earth
    final static int radius = 6371;

    public static void main (String[]args){

        Scanner sc = new Scanner(System.in);

        //Take in four inputs being lat, long x 2
        double latd1 = sc.nextDouble();
        double longd1 = sc.nextDouble();
        double latd2 = sc.nextDouble();
        double longd2 = sc.nextDouble();

        //Calculate absolute difference between longtitude and lattitude
        double longdiffd = longd1 - longd2;
        double latdiffd = latd1 - latd2;

        //Convert from degrees to radians as formula takes in radians
        double longdiffr = Math.toRadians(longdiffd);
        double latdiffr = Math.toRadians(latdiffd);
        double latr1 = Math.toRadians(latd1);
        double latr2 = Math.toRadians(latd2);

        //Haversine Formula
        double part1 = Math.sin(latdiffr / 2) * Math.sin(latdiffr / 2);
        double part2 = Math.cos(latr1) * Math.cos(latr2) * Math.sin(longdiffr / 2) * Math.sin(longdiffr / 2);
        double subtotal = Math.sqrt(part1 + part2);
        double angle = 2 * Math.asin(subtotal);

        //Calculate the distance by mutliplying the angle at the centre of the earth by the radius of the earth
        double distance = (angle * radius);

        //Round to nearest 100km and print the result
        int result = (int)Math.round((distance)/100)*100;
        System.out.println(result);
    }
}
