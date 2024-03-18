package org.example.repozitory;

import org.example.entity.*;

import java.util.List;

public class BDWork {

    public static void printMasters1(Masters masters) {
        System.out.println(masters.getId() + " " + masters.getName() + " "+ masters.getSurname());
    }
    public static void printClient1(Clients client) {
        System.out.println(client.getId() + " " + client.getName()+" " + client.getSurname());
    }
    public static void printClientMasters1(Clients client) {
        System.out.print(client.getId() + " " + client.getName() + " " + client.getSurname() + " ");
        printMasters1(client.getIdMasters());
    }
    public static void printMasters(List<Masters> masters) {
        for (Masters master : masters) {
            printMasters1(master);
        }
    }
    public static void printClients(List<Clients> clients) {
        for (Clients client : clients) {
            printClient1(client);
        }
    }
    public static void printClientsMasters(List<Clients> clients) {
        for (Clients client : clients) {
            printClientMasters1(client);
        }
    }
}
