package car.project.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 11)
    private Long carId;
    private final LocalDate localDate = LocalDate.now();
    private String engineType;
    private int maxSpeed;
    private int accelerationTime;
    private int passengerCapacity;
    private int passengerQuantity;
    private int currentSpeed;

    @OneToMany
    private List<CarWheel> wheels;
    @OneToMany
    private List<CarDoor> doors;

    public Car(CarBuilder carBuilder) {
        this.wheels = carBuilder.wheels;
        this.doors = carBuilder.doors;
    }

    public static class CarBuilder {
        private Long id;
        @Column(updatable = false)
        private LocalDate localDate;
        private String engineType;
        private int maxSpeed;
        private int accelerationTime;
        private int passengerCapacity;
        private int passengerQuantity;
        private int currentSpeed;

        private List<CarWheel> wheels;
        private List<CarDoor> doors;

        public CarBuilder() {
        }

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

        public LocalDate getLocalDate() {
            return localDate;
        }

        public void setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
        }
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
}
