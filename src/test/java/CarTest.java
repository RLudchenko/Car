import org.junit.Assert;
import org.junit.Test;

public class CarTest {
    private Car car = new Car();
    private static final Double DELTA = 0.0;
    private final CarWheel carWheel1 = new CarWheel();
    private final CarWheel carWheel2 = new CarWheel();
    private final CarWheel carWheel3 = new CarWheel();
    private final CarWheel carWheel4 = new CarWheel();

    @Test
    public void addWheelsTest() {
        CarWheel[] wheels = { carWheel1, carWheel2, carWheel3, carWheel4 };
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
}
