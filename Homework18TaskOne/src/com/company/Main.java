package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int maxNumberOfChannels = random.nextInt(3) + 3;
        int currentChannel = random.nextInt(2) + 1;
        Television tv = new Television(currentChannel, maxNumberOfChannels);
        System.out.println("There are " + tv.getMaxChannels() + " channels in the TV.");

        // Setting the current channel
        tv.setCurrentChannel(currentChannel);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1) Press n: next channel\n2) Press p: previous channel\n3) Press any" +
                    " positive whole number for setting the channel");
            System.out.print("Your choice: ");
            Scanner scanner = new Scanner(System.in);
            int option = (int) scanner.next().charAt(0);
            if(option == 110) {
                tv.nextChannel();
            } else if (option == 112) {
                tv.prevChannel();
            } else if (option >= 48 && option <= 48 + maxNumberOfChannels - 1){
                tv.setCurrentChannel(option - 48);
            } else {
                System.out.println("No such channel...exiting...");
                break;
            }
        }

        // Show the current channel after switching
        tv.showCurrentChannel();
    }

}
