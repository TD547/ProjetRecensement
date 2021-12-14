package fr.epsi.b3.recensement;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        MenuService menuService = new MenuService();
        menuService.exec();
    }
}
