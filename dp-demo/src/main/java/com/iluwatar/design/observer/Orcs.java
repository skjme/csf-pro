package com.iluwatar.design.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * 半兽人 orcs
 */
@Slf4j
public class Orcs implements WeatherObserver {


    @Override
    public void update(WeatherType currentWeather) {
        log.info("The orcs are facing " + currentWeather.getDescription() + " weather now");
    }
}
