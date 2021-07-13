package com.journaldev.design.build;

public class TestBuilderPattern {

    public static void main(String[] args) {
        Computer build = new Computer.ComputerBuilder("1T", "32G")
                .setBluetoothEnabled(true).setBluetoothEnabled(false).build();

        System.out.println(build);
    }
}
