package com.fawry.service;


import com.fawry.model.*;
import java.util.List;

public class ShippingLogger{

    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Shippable item : items) {
            System.out.println(item.getName()+"   " +(int)(item.getWeight() * 1000) + "g");
            totalWeight += item.getWeight();
        }
        System.out.println("Total package weight " + totalWeight+((totalWeight >= 1) ? "kg" : "g"));

    }


}

