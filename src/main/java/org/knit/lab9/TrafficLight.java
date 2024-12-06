package org.knit.lab9;

enum TrafficLight {
    RED, YELLOW, GREEN;

    public TrafficLight getNextLight() {
        return values()[(this.ordinal() + 1) % values().length];
    }
}
