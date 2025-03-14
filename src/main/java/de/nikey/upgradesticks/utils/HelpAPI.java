package de.nikey.upgradesticks.utils;

import java.util.Random;

public class HelpAPI {
    public static boolean calculateChance(double amount, double percent) {
        // Multipliziere den amount mit 7.5
        double chance = amount * percent;

        // Erstelle einen Random-Generator
        Random random = new Random();

        // Generiere eine Zahl zwischen 0 und 100
        double randomValue = random.nextDouble() * 100;

        // Überprüfe, ob die zufällige Zahl kleiner ist als die berechnete Chance
        return randomValue < chance;
    }
}
