package com.company;

public class Television {
    private Channel[] channels;
    private Channel currentChannel;
    private int maxChannels;

    public Television(int channel) {
        this.currentChannel = this.channels[channel];
    }
    public Television(int channel, int maxChannels) {
        this.channels = new Channel[maxChannels];
        this.maxChannels = maxChannels;
        for(int i = 0; i < this.channels.length; i++) {
            String name = "Channel-" + i;
            Channel c = new Channel();
            c.setNumber(i);
            c.setName(name);
            this.addChannel(c, i);
        }
        this.currentChannel = this.channels[channel];
    }
    public void nextChannel() {
        int current = (this.currentChannel.getChannelNumber() + 1) % this.maxChannels;
        this.currentChannel = this.channels[current];
        this.showCurrentChannel();
    }
    public void prevChannel() {
        int current = (this.currentChannel.getChannelNumber() - 1 + this.maxChannels) % this.maxChannels;
        this.currentChannel = this.channels[current];
        this.showCurrentChannel();
    }

    public void switchChannel(int number) {
        if (isValidChannel(number)) {
            this.currentChannel = this.channels[number];
        } else {
            System.out.printf("Could not switch channel to %d\n", number);
        }
    }
    public void showCurrentChannel() {
        System.out.println("-".repeat(30));
        System.out.printf("Current channel number on TV is %d\n", this.currentChannel.getChannelNumber());
        showCurrentChannelName();
    }
    public void showCurrentChannelName() {
        System.out.printf("Current channel name on TV is %s\n", this.currentChannel.getChannelName());
    }
    private boolean isValidChannel(int channel) {
        return channel >= 0 && channel < this.channels.length ? true : false;
    }
    public Channel getChannel(int number) {
        return this.channels[number];
    }
    public int getMaxChannels() {
        return this.maxChannels;
    }
    public void addChannel(Channel channel, int i) {
        this.channels[i] = channel;
    }
    public void setCurrentChannel(int n) {
        this.currentChannel = this.channels[n];
        this.showCurrentChannel();
    }
}
