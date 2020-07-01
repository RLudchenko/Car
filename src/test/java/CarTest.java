import java.util.ArrayList;
import java.util.List;
import car.project.model.Car;
import car.project.model.CarDoor;
import car.project.model.CarWheel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class CarTest {
    private final double DELTA = 0.00001;
    private Car car;
    private List<CarWheel> wheels;
    private List<CarDoor> doors;

    @Before
    public void init() {
        wheels = new ArrayList<>();
        doors = new ArrayList<>();

        car = new Car.CarBuilder().setMaxSpeed(250)
                .setPassengerCapacity(4).setPassengerQuantity(4)
                .setDoors(doors).setWheels(wheels).setEngineType("Electric")
                .setAccelerationTime(2).setCurrentSpeed(60).build();
    }

    @Test
    public void testPutOnePassenger() {
        init();
        car.putOnePassenger();
        Assert.assertEquals(1, car.getPassengerQuantity());
    }

    @Test
    public void testRemoveOnePassenger() {
        car.putOnePassenger();
        car.putOnePassenger();
        car.putOnePassenger();
        car.putOnePassenger();
        car.putOnePassenger();
        car.removeOnePassenger();
        Assert.assertEquals(4, car.getPassengerQuantity());
    }

    @Test
    public void testRemoveAllPassengers() {
        car.putOnePassenger();
        car.putOnePassenger();
        car.putOnePassenger();
        car.removeAllPassengers();
        Assert.assertEquals(0, car.getPassengerQuantity());
    }

    @Test
    public void testGetDoorByIndex() {
        doors.add(new CarDoor());
        doors.add(new CarDoor());
        doors.add(new CarDoor());
        Assert.assertEquals(doors.get(1), car.getDoorByIndex(1));
    }

    @Test
    public void testGetWheelByIndex() {
        wheels.add(new CarWheel());
        wheels.add(new CarWheel());
        wheels.add(new CarWheel());
        wheels.add(new CarWheel());
        Assert.assertEquals(wheels.get(1), car.getWheelByIndex(1));
    }

    @Test
    public void testRemoveAllWheels() {
        Assert.assertEquals(wheels.size() == 0, car.removeAllWheels(wheels));
    }

    @Test
    public void testAddWheels() {
        car.addWheels(4);
        wheels.add(new CarWheel());
        wheels.add(new CarWheel());
        Assert.assertEquals(6, car.getWheels().size());
    }

    @Test
    public void testCurrentMaxSpeed() {
        car.putOnePassenger();
        CarWheel carWheel = new CarWheel();
        carWheel.setWheelCondition(1.0);
        CarWheel carWheel1 = new CarWheel();
        carWheel1.setWheelCondition(1.0);
        carWheel1.wearOutTire(20);
        wheels.add(carWheel);
        wheels.add(carWheel1);
        car.setWheels(wheels);
        car.setMaxSpeed(250);
        Assert.assertEquals(200, car.currentMaxSpeed(car.getMaxSpeed()), DELTA);
    }
}
