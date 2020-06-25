import java.time.LocalDate;
import java.util.List;

public class Car {
    private final LocalDate localDate = LocalDate.now();
    private String engineType;
    private int maxSpeed;
    private int accelerationTime;
    private int passengerCapacity;
    private int passengerQuantity;
    private int currentSpeed;
    private List<CarWheel> wheels;
    private List<CarDoor> doors;

    public Car(CarBuilder carBuilder) {
        this.wheels = carBuilder.wheels;
        this.doors = carBuilder.doors;
    }

    public static class CarBuilder {
        private final LocalDate localDate = LocalDate.now();
        private String engineType;
        private int maxSpeed;
        private int accelerationTime;
        private int passengerCapacity;
        private int passengerQuantity;
        private int currentSpeed;

        private List<CarWheel> wheels;
        private List<CarDoor> doors;

        public CarBuilder setEngineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        public CarBuilder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public CarBuilder setAccelerationTime(int accelerationTime) {
            this.accelerationTime = accelerationTime;
            return this;
        }

        public CarBuilder setPassengerCapacity(int passengerCapacity) {
            this.passengerCapacity = passengerCapacity;
            return this;
        }

        public CarBuilder setPassengerQuantity(int passengerQuantity) {
            this.passengerQuantity = passengerQuantity;
            return this;
        }

        public CarBuilder setCurrentSpeed(int currentSpeed) {
            this.currentSpeed = currentSpeed;
            return this;
        }

        public CarBuilder setWheels(List<CarWheel> wheels) {
            this.wheels = wheels;
            return this;
        }

        public CarBuilder setDoors(List<CarDoor> doors) {
            this.doors = doors;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public LocalDate getLocalDate() {
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

    public List<CarWheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<CarWheel> wheels) {
        this.wheels = wheels;
    }

    public List<CarDoor> getDoors() {
        return doors;
    }

    public void setDoors(List<CarDoor> doors) {
        this.doors = doors;
    }

    public int putOnePassenger() {
        return passengerQuantity++;
    }

    public int removeOnePassenger() {
        return passengerQuantity--;
    }

    public int removeAllPassengers() {
        passengerQuantity = 0;
        return passengerQuantity;
    }

    public CarDoor getDoorByIndex(int index) {
        return doors.get(index);
    }

    public CarWheel getWheelByIndex(int index) {
        return wheels.get(index);
    }

    public boolean removeAllWheels(List<CarWheel> wheels) {
        wheels.clear();
        return true;
    }

    public List<CarWheel> addWheels(int wheelQuantity) {
        for (int i = 0; i < wheelQuantity; i++) {
            wheels.add(new CarWheel());
        }

        return wheels;
    }

    public double currentMaxSpeed(int maxSpeed) {
        double worseWheel = 0.0;

        for (int i = 1; i < wheels.size(); i++) {
            if (wheels.get(i).getWheelCondition() < wheels.get(0).getWheelCondition()) {
                worseWheel = wheels.get(i).getWheelCondition();
            }
        }
        return passengerQuantity > 0 ? maxSpeed * worseWheel : 0.0;
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
                + ", wheels=" + wheels
                + ", doors=" + doors
                + '}';
    }
}
