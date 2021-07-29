package com.company.gui;

import com.company.database.UsersRepository;

import java.util.Scanner;

public class GUI {

    private static Scanner scanner = new Scanner(System.in);

    public static void showMainMenu() {
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");

        switch (scanner.nextLine()) {
            case "1":
                showLoginScreen();
                showMainMenu();
                break;
            case "2":
                showRegisterScreen();
                showMainMenu();
                break;
            case "3":
                System.exit(0);
            default:
                System.out.println("Nieprawidłowy wybór");
                showMainMenu();
                break;
        }
    }

    private static void showLoginScreen() {
        System.out.println("Podaj login");
        String login = scanner.nextLine();
        System.out.println("Podaj hasło");
        String pass = scanner.nextLine();

        boolean authenticationResult = UsersRepository.getInstance().authenticate(login, pass);
        if (authenticationResult) {
            System.out.println("Zalogowano");
        } else {
            System.out.println("Błędne dane");
        }
    }

    private static void showRegisterScreen() {
        System.out.println("Podaj login");
        String login = scanner.nextLine();
        System.out.println("Podaj hasło");
        String pass = scanner.nextLine();

        boolean registerResult = UsersRepository.getInstance().register(login, pass);

        if (registerResult) {
            System.out.println("Rejestracja udana");
        } else {
            System.out.println("Login zajęty");
        }
    }
}
