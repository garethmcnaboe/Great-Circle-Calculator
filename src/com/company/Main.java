package com.company;

import java.util.Scanner;

public class Main {

    //average circumference of the earth
    final static int radius = 6371;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //Take in four inputs being lat, long x 2
        double latd1 = sc.nextDouble();
        double longd1 = sc.nextDouble();
        double latd2 = sc.nextDouble();
        double longd2 = sc.nextDouble();

        //Calculate absolute difference between longtitude
        double longdiffd = longd1 - longd2;

        //Convert from degrees to radians
        double longdiffr = Math.toRadians(longdiffd);
        double latr1 = Math.toRadians(latd1);
        double latr2 = Math.toRadians(latd2);

        //Calculate sine and cosine from radian inputs
        double sinlat1 = Math.sin(latr1);
        double sinlat2 = Math.sin(latr2);
        double coslat1 = Math.cos(latr1);
        double coslat2 = Math.cos(latr2);
        double coslongdiff = Math.cos(longdiffr);

        //Main formula from https://en.wikipedia.org/wiki/Great-circle distance
        double temp = (sinlat1 * sinlat2)+(coslat1 * coslat2 * coslongdiff);
        double angle = Math.acos(temp);

        //multiply the angle by the radius of the earth to get the distance
        double distance = angle * radius;

        //round to nearest 100km
        double result = Math.round((distance)/100)*100;

        //print out result
        System.out.print(result);
    }
}
