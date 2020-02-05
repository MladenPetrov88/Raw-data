package Task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int n = Integer.parseInt(reader.readLine());
        ArrayList<Car> carList = new ArrayList<>();
        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");

            String model = tokens[0];
            int speed = Integer.parseInt(tokens[1]);
            int power = Integer.parseInt(tokens[2]);
            int weight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            ArrayList<Tire> tireList = new ArrayList<>();
            for (int i = 5; i < 12 ; i+=2) {
                int a = i+1;
                Tire tire = new Tire(Double.parseDouble(tokens[i]),Integer.parseInt(tokens[a]));
                tireList.add(tire);
            }
            Engine engine = new Engine(speed, power);
            Cargo cargo = new Cargo(weight, cargoType);
            Car car = new Car(model, engine, cargo,tireList);
            carList.add(car);
        }
        String command = reader.readLine();
        switch (command) {
            case "fragile":
                carList.stream()
                        .filter(c -> c.getCargo().getCargoType().equals("fragile"))
                        .filter(c -> c.getTires().stream().anyMatch(tire -> tire.getTirePressure() < 1))
                        .forEach(System.out::println);
                break;

            case "flamable":
                carList.stream()
                        .filter(c -> c.getCargo().getCargoType().equals("flamable"))
                        .filter(c -> c.getEngine().getEnginePower() > 250)
                        .forEach(System.out::println);
                break;
        }
    }
}
