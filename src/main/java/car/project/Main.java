package car.project;

import car.project.lib.Injector;
import car.project.model.Car;
import car.project.model.CarDoor;
import car.project.model.CarWheel;
import car.project.service.CarDoorService;
import car.project.service.CarService;
import car.project.service.CarWheelService;
import java.util.List;

public class Main {
    private static Injector injector = Injector.getInstance("car.project");
    private static CarDoorService carDoorService
            = (CarDoorService) injector.getInstance(CarDoorService.class);
    private static CarService carService
            = (CarService) injector.getInstance(CarService.class);
    private static CarWheelService carWheelService
            = (CarWheelService) injector.getInstance(CarWheelService.class);

    public static void main(String[] args) {
        CarDoor carDoor1 = new CarDoor();
        carDoor1.openCarDoor();
        carDoorService.add(carDoor1);
        CarDoor carDoor2 = new CarDoor();
        carDoorService.add(carDoor2);
        CarDoor carDoor3 = new CarDoor();
        carDoor3.openCarDoor();
        carDoorService.add(carDoor3);
        CarDoor carDoor4 = new CarDoor();
        carDoorService.add(carDoor4);

        List<CarDoor> carDoorList;
        carDoorList = carDoorService.getAll();

        CarWheel carWheel1 = new CarWheel();
        carWheelService.add(carWheel1);
        CarWheel carWheel2 = new CarWheel();
        carWheelService.add(carWheel2);
        CarWheel carWheel3 = new CarWheel();
        carWheelService.add(carWheel3);
        CarWheel carWheel4 = new CarWheel();
        carWheelService.add(carWheel4);
        CarWheel carWheel5 = new CarWheel();
        carWheelService.add(carWheel5);
        CarWheel carWheel6 = new CarWheel();
        carWheelService.add(carWheel6);

        List<CarWheel> carWheels;
        carWheels = carWheelService.getAll();

        Car car = new Car();
        car.setAccelerationTime(10);
        car.setDoors(carDoorList);
        car.setAccelerationTime(10);
        car.setMaxSpeed(250);
        car.setPassengerCapacity(8);
        car.setWheels(carWheels);
        carService.add(car);
    }
}
