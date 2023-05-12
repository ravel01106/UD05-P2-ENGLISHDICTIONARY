package net.duolingo;

import java.util.Scanner;

import net.duolingo.dictionary.Dictionary;

public class MainDuolingo {
    final static Scanner KEYBOARD = new Scanner(System.in);

    public static void printMenu() {
        String msg = "\nWelcome to the English Dictionary\n";
        msg += "This menu has the following options:\n";
        msg += "\t1 -> Add Word.\n";
        msg += "\t2 -> Delete Word.\n";
        msg += "\t3 -> Exist Word.\n";
        msg += "\t4 -> Show initial available.\n";
        msg += "\t5 -> View words by initial.\n";
        msg += "\t6 -> Close program.";
        System.out.println(msg);
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        String option = "3";
        while (!option.equals("6")) {
            printMenu();
            option = KEYBOARD.nextLine();
            switch (option) {
                case "1":
                    dictionary.addWord();
                    break;
                case "2":
                    dictionary.deleteWord();
                    break;
                case "3":
                    dictionary.existWord();
                    break;
                case "4":
                    dictionary.showInitialAvailable();
                    break;
                case "5":
                    dictionary.showWordsWithInitial();
                    break;
                case "6":
                    System.out.println("Have a good day!");
                    break;

                default:
                    System.out.println("You must choose any of the above options.");
                    break;
            }
        }
    }
}
