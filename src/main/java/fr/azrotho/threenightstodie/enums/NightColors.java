package fr.azrotho.threenightstodie.enums;

public enum NightColors {

    GREEN("§a"),
    YELLOW("§e"),
    RED("§c");


    private final String color;

    NightColors(String color) {
        this.color = color;
    }

    public String colorForBukkit() {
        return color;
    }
    
}