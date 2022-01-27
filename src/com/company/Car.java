package com.company;

import java.util.Random;

import static com.company.Main.DISTANCE;
import static com.company.Main.STEP;

public class Car implements Runnable {
    private String name;
    public Car(String name){
        this.name = name;
    }
    @Override
    public void run() {
        int runDistance = 0;
        long startTime = System.currentTimeMillis();
        while (runDistance < DISTANCE){
            int speed = (new Random()).nextInt(20);
            runDistance += speed;
            String log = "|";
            int perccentTravel = (runDistance * 100) / DISTANCE;
            for (int i = 0; i < DISTANCE; i+= STEP) {
                if (perccentTravel >= i + STEP){
                    log += "=";
                }else if (perccentTravel >= i && perccentTravel < i + STEP){
                    log += "o";
                }else {
                    log += "-";
                }
            }
            log += "|";
            System.out.println("Car" + this.name + ": " + log + " " + Math.min(DISTANCE,runDistance)+ "KM");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car" + this.name + " broken...");
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }
}
