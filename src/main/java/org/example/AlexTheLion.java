package com.example;

import java.util.List;

public class AlexTheLion extends Lion {

    public AlexTheLion(Feline feline) throws Exception {  // Changed from Predator to Feline
        super("Самец", feline);
    }

    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }
}