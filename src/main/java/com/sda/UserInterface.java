package com.sda;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.SortedMap;

public class UserInterface {
    LocationController locationController = new LocationController();

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Aplikacja jest uruchomiona\n");

        while (true) {
            System.out.println("Witaj w aplikacji pogodewej");
            System.out.println("Co chcesz zrobić?");
            System.out.println("0. Zamknąć aplikacje");
            System.out.println("1. Dodać lokalizacje");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    createLocation();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void createLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj lokalizacje");
        String city = scanner.nextLine();
        String region = scanner.nextLine();
        String country = scanner.nextLine();
        Integer longitude = scanner.nextInt();
        Integer latitude = scanner.nextInt();
        String json = String.format("{\"city\": \"%s\", \"region\": \"%s\", \"country\": \"%s\", \"longitude\": \"%s\", \"latitude\": \"%s\"}", city, region, country, longitude, latitude);
        System.out.println("Wysyłam request HTTP: " + json);
        String httpResponse = locationController.createLocation(json);
        System.out.println("Odpowiedz z serwera: " + httpResponse);
    }
}
