package com.sda;

import java.util.Scanner;

public class UserInterface {
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Aplikacja jest uruchomiona\n");

        while (true){
            System.out.println("Witaj w aplikacji pogodewej");
            System.out.println("Co chcesz zrobić?\n" + "0. Zamknąć aplikacje");
            int option = scanner.nextInt();

            switch (option){
                case 0: return;
            }
        }
    }
}
