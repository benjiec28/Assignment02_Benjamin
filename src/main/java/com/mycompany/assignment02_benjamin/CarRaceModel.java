package com.mycompany.assignment02_benjamin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRaceModel {
    public static final double trackLength = 435.0;
 
    private final List<Car> cars = new ArrayList<>();
    private final List<Car> finishOrder = new ArrayList<>();
 
    /**
     * Adds a car to the list of cars.
     * @param car the car.
     */
    public void addCar(Car car) {
        cars.add(car);
    }
 
    /**
     * Allows the user the read the list of cars without modifying it.
     * @return the list of cars.
     */
    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
 
    /**
     * Prepares the race. (Puts back the cars to their original position).
     */
    public void prepareRace() {
        finishOrder.clear();
        for (Car car : cars) {
            car.setxPosition(0);
        }
    }
    
    /**
     * Assigns the time and the speed of the car.
     * @param car the car.
     * @param time the time.
     */
    public void assignRaceTime(Car car, double time) {
        car.setTime(time);
        car.setSpeed(trackLength / time);
    }
 
    /**
     * Updates the position of the car.
     * @param car the car.
     * @param xPosition it's position on the x axis.
     */
    public void updatePosition(Car car, double xPosition) {
        car.setxPosition((int) Math.round(xPosition));
    }
 
    /**
     * Records when a car finishes the race.
     * @param car the car that finished the race.
     */
    public void recordFinish(Car car) {
        if (!finishOrder.contains(car)) {
            finishOrder.add(car);
        }
    }
    
    /**
     * Allows the user the read the list of the cars that finished the race in order without modifying it.
     * @return the list of ordered cars depending on their placement.
     */
    public List<Car> getFinishOrder() {
        return Collections.unmodifiableList(finishOrder);
    }
 
    /**
     * Checks the list of cars that have finished the race and grabs the winner.
     * @return the winner of the race.
     */
    public Car getWinner() {
        return finishOrder.isEmpty() ? null : finishOrder.get(0);
    }
 
    /**
     * Checks if all the cars have finished the race.
     * @return True = the race has finished ; False = either a race is happening or it hasn't started yet.
     */
    public boolean isRaceFinished() {
        return !cars.isEmpty() && finishOrder.size() == cars.size();
    }
 
    /**
     * Places the cars back to their original position and resets their speed and time.
     */
    public void reset() {
        finishOrder.clear();
        
        for (Car car : cars) {
            car.setxPosition(0);
            car.setSpeed(0);
            car.setTime(0);
        }
    }
}
