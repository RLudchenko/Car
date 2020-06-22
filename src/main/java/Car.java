import java.time.LocalDate;
import java.util.Arrays;

public class Car {
    private final LocalDate localDate = LocalDate.now();
    private String engineType;
    private int maxSpeed = 250;
    private int accelerationTime = 3;
    private int passengerCapacity = 4;
    private int passengerQuantity = 0;
    private int currentSpeed = 0;

    private CarWheel carWheel1 = new CarWheel();
    private CarWheel carWheel2 = new CarWheel();
    private CarWheel carWheel3 = new CarWheel();
    private CarWheel carWheel4 = new CarWheel();
    private CarWheel[] wheels = { carWheel1, carWheel2, carWheel3, carWheel4 };

    private CarDoor carDoor1 = new CarDoor();
    private CarDoor carDoor2 = new CarDoor();
    private CarDoor carDoor3 = new CarDoor();
    private CarDoor carDoor4 = new CarDoor();
    private CarDoor[] doors = { carDoor1, carDoor2, carDoor3, carDoor4 };

    public LocalDate getLocalDateTime() {
        return localDate;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getAccelerationTime() {
        return accelerationTime;
    }

    public void setAccelerationTime(int accelerationTime) {
        this.accelerationTime = accelerationTime;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerQuantity() {
        return passengerQuantity;
    }

    public void setPassengerQuantity(int passengerQuantity) {
        this.passengerQuantity = passengerQuantity;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public CarWheel[] getWheels() {
        return wheels;
    }

    public void setWheels(CarWheel[] wheels) {
        this.wheels = wheels;
    }

    public CarDoor[] getDoors() {
        return doors;
    }

    public void setDoors(CarDoor[] doors) {
        this.doors = doors;
    }

    public void changeCurrentSpeed() {
        currentSpeed += 50;
    }

    public void addOnePassenger() {
        if (passengerQuantity > passengerCapacity) {
            System.out.println("Not possible to add more people!");
            return;
        }
        passengerQuantity += 1;
    }

    public void removeOnePassenger() {
        if (passengerQuantity < 0) {
            System.out.println("There's no one to remove from the car!");
            return;
        }
        passengerQuantity -= 1;
    }

    public CarDoor getDoorByIndex(int index) {
        if (index > doors.length) {
            System.out.println("Such door doesn't exist");
            return null;
        }

        Car car = new Car();
        car.setDoors(doors);
        CarDoor[] carDoors = car.getDoors();

        return carDoors[index];
    }

    public CarWheel getCarWheelByIndex(int index) {

        if (index > this.wheels.length) {
            System.out.println("Such wheel doesn't exist");
            return null;
        }

        Car car = new Car();
        car.setWheels(wheels);
        CarWheel[] carWheels = car.getWheels();

        return carWheels[index];
    }

    public void removeAllWheels() {
        wheels = new CarWheel[0];
    }

    public void installWheels(int wheelQuantity) {
        if (wheelQuantity < 1) {
            System.out.println("Can't install!");
            return;
        }
        wheels = new CarWheel[wheels.length + wheelQuantity];
    }

    public int currentMaxSpeed() {
        CarWheel carWheel = new CarWheel();
        int currMaxSpeed = maxSpeed;

        if (passengerQuantity == 0) {
            return 0;
        }

        for (CarWheel wheel : wheels) {
            if (carWheel.getWheelCondition() > wheel.getWheelCondition()) {
                carWheel.setWheelCondition(wheel.getWheelCondition());
            }
        }

        currMaxSpeed *= carWheel.getWheelCondition();

        return currMaxSpeed;
    }

    @Override
    public String toString() {
        return "Car{"
                + "localDate=" + localDate
                + ", engineType='" + engineType + '\''
                + ", maxSpeed=" + maxSpeed
                + ", accelerationTime=" + accelerationTime
                + ", passengerCapacity=" + passengerCapacity
                + ", passengerQuantity=" + passengerQuantity
                + ", currentSpeed=" + currentSpeed
                + ", carWheel1=" + carWheel1
                + ", carWheel2=" + carWheel2
                + ", carWheel3=" + carWheel3
                + ", carWheel4=" + carWheel4
                + ", wheels=" + Arrays.toString(wheels)
                + ", carDoor1=" + carDoor1
                + ", carDoor2=" + carDoor2
                + ", carDoor3=" + carDoor3
                + ", carDoor4=" + carDoor4
                + ", doors=" + Arrays.toString(doors)
                + '}';
    }
}
