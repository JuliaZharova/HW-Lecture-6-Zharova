package com.company;

import java.util.ArrayList;
import java.util.Arrays;

abstract class Insect {
   int numberOfLegs;
   String color;
   ArrayList<String> food;

    Insect (int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
        this.food = new ArrayList<String>();
    }

    Insect (String color) {
        this.color = color;
        this.food = new ArrayList<String>();
    }

  Insect (int numberOfLegs, String color, ArrayList<String> food) {   // конструктор
       this.numberOfLegs = numberOfLegs;
       this.color = color;
       this.food = food;
   }

   abstract void Eat();
}

class Winged extends Insect {

    int numberOfWings;

    Winged(int numberOfLegs, String color, int numberOfWings, ArrayList<String> food) {
        super(numberOfLegs, color, food);
        this.numberOfWings = numberOfWings;
    }

    void Eat() {
        System.out.println("Крылатые насекомые едят: " + food);
    }

    void Eat(String product) {
        System.out.println("Сейчас крылатое насекомое ест: " + product);
    }
}

class Bee extends Winged {

    int gramsOfHoney;

    Bee(int numberOfLegs, String color, int numberOfWings, ArrayList<String> food) {
        super(numberOfLegs, color, numberOfWings, food);
    }

    Bee(int numberOfLegs, String color, int numberOfWings, ArrayList<String> food, int gramsOfHoney) {
        super(numberOfLegs, color, numberOfWings, food);
        this.gramsOfHoney = gramsOfHoney;
    }

    @Override
    void Eat() {
        System.out.println("Пчелы едят: " + food);
        if(gramsOfHoney != 0){
            System.out.println("А еще, пчела может съесть  " + gramsOfHoney + " грамм меда в день! О_О");
        }
    }
}

class Fly extends Winged {

    double flySpeed;

    Fly(int numberOfLegs, String color, int numberOfWings, ArrayList<String> food, double flySpeed) {
        super(numberOfLegs, color, numberOfWings, food);
        this.flySpeed = flySpeed;
    }

    @Override
    void Eat() {
        System.out.println("Мухи едят:" + food);
    }

    void GetSpeedInfo () {
        System.out.println("Мухи очень быстрые, они летают со скоростью " + flySpeed + " км/ч!");
    }
}

class Dragonfly  extends Winged {

    boolean isBitePeople;

    Dragonfly(int numberOfLegs, String color, int numberOfWings, ArrayList<String> food, boolean isBitePeople) {
        super(numberOfLegs, color, numberOfWings, food);
        this.isBitePeople = isBitePeople;
    }

    @Override
    void Eat() {
        System.out.println("Стрекозы едят: " + food);
        System.out.println(isBitePeople
                ? "Стрекозы не кусают людей без причины, но если их разозлить, могут укусить до крови."
                : "Стрекозы не кусают людей, их не интересует человечина.");
    }
}

public class Main {

    public static void main(String[] args) {
        Winged myInsect = new Winged(4, "red", 4, new ArrayList<>(Arrays.asList("Мелкие насекомые", "Пыльца")));
        Bee ourInsect = new Bee(3, "black", 6, new ArrayList<>(Arrays.asList("Мелкие насекомые", "Пыльца", "Жидкая пища")),2);
        Fly ins1 = new Fly(6, "yellow", 4, new ArrayList<>(Arrays.asList("Пыльца", "Жидкая пища")), 15);
        Dragonfly ins2 = new Dragonfly(5, "blue", 4, new ArrayList<>(Arrays.asList("Мелкие насекомые")), true );
        
        myInsect.Eat();
        myInsect.Eat("яблочко");
        ourInsect.Eat();
        ins1.GetSpeedInfo();
        ins1.Eat();
        ins2.Eat();
        ins2.Eat("ромашку");
    }
}



