package org.example.repozitory;

import org.example.entity.*;
public class BDWork {
    public static void printMasters(Masters masters) {
        System.out.println(masters.getId() + " " + masters.getName() + " "+ masters.getSurname());
    }
    public static void printClient(Clients client) {
        System.out.println(client.getId() + " " + client.getName()+" " + client.getSurname());
    }
    public static void printClientMasters(Clients client) {
        System.out.print(client.getId() + " " + client.getName() + " " + client.getSurname() + " ");
        printMasters(client.getIdMasters());
    }
}
