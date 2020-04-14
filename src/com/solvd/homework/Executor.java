package com.solvd.homework;

import com.solvd.homework.menu.MainMenu;

import java.util.Scanner;

public class Executor {
    private static Scanner in;

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.openMainMenu();
    }
}
