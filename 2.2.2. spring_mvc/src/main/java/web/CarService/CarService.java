package web.CarService;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CarService {

    private List<Car> cars = new ArrayList();

    {
        cars.add(new Car(100, "Nissan", "Red"));
        cars.add(new Car(101, "Pego", "White"));
        cars.add(new Car(213, "Audi", "Black"));
        cars.add(new Car(214, "Lada", "Pink"));
        cars.add(new Car(214, "Ferrari", "Green"));

    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> allCars() {
        return cars;
    }

    public List<Car> carListByRequest(int quantityOfCars) {
        return cars.stream().limit(quantityOfCars > 0 ? quantityOfCars : cars.size()).collect(Collectors.toList());

    }
}
