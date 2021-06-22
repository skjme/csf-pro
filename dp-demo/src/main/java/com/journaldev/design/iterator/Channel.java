package com.journaldev.design.iterator;

public class Channel {

    private double frequency;
    private ChannelTypeEnum TYPE;

    public Channel(double frequency, ChannelTypeEnum type) {
        this.frequency = frequency;
        this.TYPE = type;
    }

    public double getFrequency() {
        return frequency;
    }

    public ChannelTypeEnum getTYPE() {
        return TYPE;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "frequency=" + frequency +
                ", TYPE=" + TYPE +
                '}';
    }


}
