package Task3;

import java.util.ArrayList;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private ArrayList<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, ArrayList<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {

        return this.model;
    }


    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }


    public ArrayList<Tire> getTires() {
        return tires;
    }

    @Override
    public String toString(){
        return this.model;
    }
}

