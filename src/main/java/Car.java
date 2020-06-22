import java.time.LocalDate;
import java.util.Arrays;

public class Car {
    private final LocalDate localDate = LocalDate.now();
    private String engineType;
    private int maxSpeed = 250;
    private byte accelerationTime = 3;
    private int passengerCapacity = 4;
    private int passengerQuantity = 0;
    private int currentSpeed = 0;
    CarWheel carWheel1, carWheel2, carWheel3, carWheel4;
    private CarWheel[] wheels = { carWheel1, carWheel2, carWheel3, carWheel4 };
    CarDoor carDoor1, carDoor2, carDoor3, carDoor4;
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

    public byte getAccelerationTime() {
        return accelerationTime;
    }

    public void setAccelerationTime(byte accelerationTime) {
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

    public void getDoorByIndex(int index) {
        if (index > doors.length) {
            System.out.println("Such door doesn't exist");
            return;
        }
        System.out.println("You chose a door number: " + index);
    }

    public void getCarWheelByIndex(int index) {
        if (index > wheels.length) {
            System.out.println("Such wheel doesn't exist");
            return;
        }
        System.out.println("You chose a wheel number: " + index);
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

    public void currentMaxSpeed() {
        CarWheel carWheel = new CarWheel();
        int currMaxSpeed = maxSpeed;

        if (passengerQuantity == 0) {
            return;
        }

        for (CarWheel wheel : wheels) {
            if (carWheel.getWheelCondition() > wheel.getWheelCondition()) {
                carWheel.setWheelCondition(wheel.getWheelCondition());
            }
        }

        currMaxSpeed *= carWheel.getWheelCondition();
        System.out.println("Current max speed of the car is " + currMaxSpeed);
    }

    @Override
    public String toString() {
        return "Car{" +
                "localDate=" + localDate
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
