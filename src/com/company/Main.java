package com.company;

import java.util.Random;

public class Main {

    public static int bossHealth = 1000;
    public static int bossDamage = 100;
    public static int[] heroesHealths = {250, 250, 250, 205, 500};
    public static int[] heroesDamage = {50, 30, 25, 0, 50};
    public static String[] heroesType = {"Warrior", "Wizzard", "Kinetic", "Medic", "Golem"};

    public static void main(String[] args) {
        printStatistic();
        while (!gameIsFinished()) {
            Fight();
            scripts();
            round();
        }
    }

    public static void round() {
        bossAttack();
        heroesAttack();
        heroesSpecial();
        printStatistic();
        scripts();
    }

    private static void heroesSpecial() {
        specialWarrior();
        specialMagic();
        specialKinetic();
        specialMedic();

    }

    private static void specialMedic() {
        for (int i = 0; i < heroesType.length; i++) {
            if(heroesHealths[i] < 100 && heroesHealths[3] > 0){
                int randomNum = new Random().nextInt(10) + 1;
                if(randomNum == 1){
                    System.out.println("Team is healing " + heroesType[i] + " on 5");
                    heroesHealths[i] = heroesHealths[i] + 5;
                    return;
                }
            }
        }
    }


    private static boolean sharinganIsAwakened = false;

    private static void specialKinetic() {
        if (heroesHealths[2] < 100 && heroesHealths[2] > 0 && !sharinganIsAwakened) {
            System.out.println("Kinetic will awakened SHARINGAN");
            bossHealth =- heroesDamage[2];
            sharinganIsAwakened = true;
        }

        if (sharinganIsAwakened) {
            System.out.println("Kinetic using AMATERASU");
            bossHealth = -25;
        }
    }

    private static void specialMagic() {
        if (heroesHealths[1] < 250) {
            int randomNum = new Random().nextInt(10) + 1;
            if (randomNum == 1) {
                System.out.println("Wizzard eat magic apple");
                heroesHealths[1] = heroesHealths[1] + 250;
            }
        }
    }

    private static void specialWarrior() {
        if (heroesHealths[0] > 0 && bossHealth > 0) {
            int randomNum = new Random().nextInt(2) + 1;
            if (randomNum == 1) {
                System.out.println("Warrior is angry");
                bossHealth = bossHealth - 150;
                System.out.println("Warrior attack boss on 150");
            }
        }
    }

    private static void heroesAttack() {
        for (int i = 0; i < heroesHealths.length; i++) {
            if (heroesHealths[i] > 0 && bossHealth > 0) {
                bossHealth = bossHealth - heroesDamage[i];
                if (bossHealth < 0) {
                    bossHealth = 0;
                    break;
                }
            }
        }
    }

    private static void bossAttack() {
        if (bossHealth > 0) {
            for (int i = 0; i < heroesHealths.length; i++) {
                if (heroesHealths[i] > 0) {
                    heroesHealths[i] = heroesHealths[i] - bossDamage;
                    if (heroesHealths[i] < 0) {
                        heroesHealths[i] = 0;
                    }
                }
            }
        }
    }

    public static boolean gameIsFinished() {
        if (bossHealth < 0) {
            System.out.println("Heroes is won");
            System.out.println("Boss is death");
            return true;
        }

        boolean allIsHeroesDeath = true;
        for (int i = 0; i < heroesHealths.length; i++) {
            if (heroesHealths[i] > 0) {
                allIsHeroesDeath = false;
                break;
            }
        }

        if (allIsHeroesDeath) {
            System.out.println("Boss is won");
            System.out.println("All heroes is death");
            return true;
        }

        return false;
    }

    public static void printStatistic() {
        System.out.println("____________________");
        System.out.println("Boss health = " + bossHealth);
        for (int i = 0; i < heroesHealths.length; i++) {
            System.out.println(heroesType[i] + " health = " + heroesHealths[i]);
        }
        System.out.println("____________________");

    } public static void scripts(){
        if(heroesHealths[0] < 1){
            System.out.println("Warriors is dead");
        } if(heroesHealths[1] < 1){
            System.out.println("Wizzard is dead");
        } if(heroesHealths[2] < 1){
            System.out.println("Kinetic is dead");
        } if(heroesHealths[3] < 1){
            System.out.println("Medic is dead");
        }
    } public static void Fight(){
        System.out.println("Heroes attack boss");
        System.out.println("boss attack heroes");
    }


}
