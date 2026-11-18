package com.mycompany.assignment02_benjamin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRaceModel {
    public static final double TRACK_LENGTH = 435.0;
 
    private final List<Car> cars = new ArrayList<>();
    private final List<Car> finishOrder = new ArrayList<>();
 
    public void addCar(Car car) {
        cars.add(car);
    }
 
    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
 
    public void prepareRace() {
        finishOrder.clear();
        for (Car car : cars) {
            car.setxPosition(0);
        }
    }
 
    public void assignRaceTime(Car car, double time) {
        car.setTime(time);
        car.setSpeed(TRACK_LENGTH / time);
    }

}
