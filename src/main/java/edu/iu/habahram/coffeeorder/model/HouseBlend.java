package edu.iu.habahram.coffeeorder.model;

public class HouseBlend extends Beverage{

    @Override
    public float cost() {
        return 1.99F;
    }

    @Override
    public String getDescription() {
        return "House Blend Coffee";
    }
}