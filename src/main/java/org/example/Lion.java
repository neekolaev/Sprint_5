package com.example;

import java.util.List;

public class Lion {
    private boolean hasMane;
    private final Feline feline;

    // Единственный конструктор с инъекцией зависимости
    public Lion(String sex, Feline feline) throws Exception {
        if (feline == null) {
            throw new IllegalArgumentException("Feline не может быть null");
        }
        this.feline = feline;

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - Самец или Самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.eatMeat();
    }
}