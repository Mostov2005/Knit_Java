package org.knit.sem2.lab1.task2;

class Chocolate extends CoffeeDecorator {
    public Chocolate(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.00 * coffee.getSize();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", шоколад";
    }

    @Override
    public int getCalories() {
        return super.getCalories() + 25 * coffee.getSize();
    }
    @Override
    public void setSize(int size) {
        coffee.setSize(size);
    }
}
