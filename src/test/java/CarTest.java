import org.junit.Assert;
import org.junit.Test;

public class CarTest {
    private Car car = new Car();
    private static final Double DELTA = 0.0;
    private final CarWheel carWheel1 = new CarWheel();
    private final CarWheel carWheel2 = new CarWheel();
    private final CarWheel carWheel3 = new CarWheel();
    private final CarWheel carWheel4 = new CarWheel();
    CarWheel[] wheels = { carWheel1, carWheel2, carWheel3, carWheel4 };
    private final CarDoor carDoor1 = new CarDoor();
    private final CarDoor carDoor2 = new CarDoor();
    private final CarDoor carDoor3 = new CarDoor();
    private final CarDoor carDoor4 = new CarDoor();
    private final CarDoor[] doors = { carDoor1, carDoor2, carDoor3, carDoor4 };

    @Test
    public void addWheelsTest() {
        Assert.assertEquals(4.0, wheels.length, DELTA);
    }

    @Test
    public void wearOutTireTest() {
        carWheel1.wearOutTire(20);
        Assert.assertEquals(carWheel1.getWheelCondition(), carWheel1.getWheelCondition(), DELTA);
    }

    @Test
    public void addPassengerTest() {
        car.addOnePassenger();
        car.addOnePassenger();
        Assert.assertEquals(2.0, car.getPassengerQuantity(), DELTA);
    }

    @Test
    public void removePassengerTest() {
        car.addOnePassenger();
        car.addOnePassenger();
        car.removeOnePassenger();
        Assert.assertEquals(1.0, car.getPassengerQuantity(), DELTA);
    }

    @Test
    public void installWheelsTest() {
        car.installWheels(2);
        Assert.assertEquals(6.0, car.getWheels().length, DELTA);
    }

    @Test
    public void currentMaxSpeedTest() {
        Car car1 = new Car();
        car1.addOnePassenger();
        car1.setWheels(wheels);
        car1.getCarWheelByIndex(2).wearOutTire(40);
        Assert.assertEquals(150, car1.currentMaxSpeed(), DELTA);
    }

    @Test
    public void getDoorByIndexTest() {
        car.setDoors(doors);
        Assert.assertNotNull(car.getDoorByIndex(1));
    }

    @Test
    public void getWheelByIndexTest() {
        car.setWheels(wheels);
        Assert.assertNotNull(car.getCarWheelByIndex(2));
    }

    @Test
    public void changeCurrentSpeedTest() {
        car.changeCurrentSpeed();
        Assert.assertEquals(50, car.getCurrentSpeed());
    }

    @Test
    public void checkDateTest() {
        Assert.assertNotNull(car.getLocalDateTime());
    }

    @Test
    public void checkEngineType() {
        car.setEngineType("Fuel");
        Assert.assertEquals("Fuel", car.getEngineType());
    }

    @Test
    public void checkMaxSpeed() {
        car.setMaxSpeed(300);
        Assert.assertEquals(300, car.getMaxSpeed());
    }

    @Test
    public void checkAccelerationTime() {
        car.setAccelerationTime(2);
        Assert.assertEquals(2, car.getAccelerationTime());
    }

    @Test
    public void testWindowWork() {
        car.setDoors(doors);
        CarDoor doorByIndex = car.getDoorByIndex(2);
        doorByIndex.openCarDoor();
        Assert.assertTrue("You just opened car door!", true);
    }
}
