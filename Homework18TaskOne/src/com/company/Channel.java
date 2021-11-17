package com.company;

public class Channel {
    private String name;
    private int number;

    public int getChannelNumber() {
        return number;
    }
    public String getChannelName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(int n) {
        this.number = n;
    }
    public void print() {
        System.out.println("-".repeat(30));
        System.out.printf("Channel name: %s\nChannel number: %s\n", this.name, this.number);
    }
}
