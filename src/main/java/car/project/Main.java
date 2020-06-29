package car.project;

import car.project.config.AppConfig;
import car.project.model.Car;
import car.project.model.CarDoor;
import car.project.model.CarWheel;
import car.project.service.CarDoorService;
import car.project.service.CarService;
import car.project.service.CarWheelService;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

    private static CarService carService =
            (CarService) context.getBean(CarService.class);
    private static final CarDoorService carDoorService =
            (CarDoorService) context.getBean(CarDoorService.class);
    private static final CarWheelService carWheelService =
            (CarWheelService) context.getBean(CarWheelService.class);

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
