package org.example;

import org.example.entity.*;
import org.example.repozitory.*;
import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        IRepo<Clients> clientsRepozitory = new ClientsRepozitory();
        IRepo<Masters> mastersRepozitory = new MastersRepozitory();


        List<Clients> clients;
        List<Masters> masters;

        mastersRepozitory.insert(new Masters(null,"Башкиров", "Альберт", null));
        mastersRepozitory.insert(new Masters(null,"Русов", "Ящер", null));
        mastersRepozitory.insert(new Masters(null,"Пивной", "Богдан", null));

        masters = mastersRepozitory.getList();

        clientsRepozitory.insert(new Clients(null,"Ромбов", "Антон", masters.get(1), null));
        clientsRepozitory.insert(new Clients(null,"Кубов", "Виталий", masters.get(2), null));

        clients = clientsRepozitory.getList();

        System.out.println("---------Список Клиентов---------");

            BDWork.printClient((Clients) clients); // Print information about clients

        System.out.println("---------Список Мастеров---------");
            BDWork.printMasters((Masters) masters); // Print information about stylists

        System.out.println("------Клиенты и их мастера-------");

            BDWork.printClientMasters((Clients) clients); // Print information about client-stylist





    }
}