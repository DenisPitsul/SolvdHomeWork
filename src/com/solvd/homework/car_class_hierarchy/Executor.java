package com.solvd.homework.car_class_hierarchy;

import com.solvd.homework.car_class_hierarchy.menu.MainMenu;

import java.util.Scanner;

public class Executor {
    private static Scanner in;

    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        mainMenu.openMainMenu();

    }
}
