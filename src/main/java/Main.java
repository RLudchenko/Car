import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Random random = new Random();
        CarWheel carWheel1 = new CarWheel();
        CarWheel carWheel2 = new CarWheel();
        CarWheel carWheel3 = new CarWheel();
        CarWheel carWheel4 = new CarWheel();

        carWheel1.wearOutTire(30);
        carWheel2.wearOutTire(20);
        carWheel3.wearOutTire(15);
        carWheel4.wearOutTire(10);

        CarWheel[] wheels = { carWheel1, carWheel2, carWheel3, carWheel4 };
        car.setWheels(wheels);
        car.addOnePassenger();
        car.currentMaxSpeed();
        car.installWheels(1);
        car.getCarWheelByIndex(5);
    }
}
