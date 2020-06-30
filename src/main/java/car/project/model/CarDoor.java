package car.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "doors")
public class CarDoor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 11)
    private Long carDoorId;
    private boolean openCarDoor;
    private boolean openCarWindow;

    public boolean isOpenCarDoor() {
        if (openCarDoor) {
            System.out.println("car.project.model.Car door is opened!");
        } else {
            System.out.println("car.project.model.Car door is closed!");
        }
        return openCarDoor;
    }

    public void setOpenCarDoor(boolean openCarDoor) {
        this.openCarDoor = openCarDoor;
    }

    public boolean isOpenCarWindow() {
        if (openCarWindow) {
            System.out.println("car.project.model.Car window is opened!");
        } else {
            System.out.println("car.project.model.Car window is closed!");
        }
        return openCarWindow;
    }

    public void setOpenCarWindow(boolean openCarWindow) {
        this.openCarWindow = openCarWindow;
    }

    public void openCarDoor() {
        openCarDoor = true;
        System.out.println("You just opened car door!");
    }

    public void closeCarDoor() {
        openCarDoor = false;
        System.out.println("You just closed car door!");
    }

    public void openCloseCarDoor() {
        if (openCarDoor) {
            openCarDoor = false;
            System.out.println("car.project.model.Car door was closed!");
        } else {
            openCarDoor = true;
            System.out.println("car.project.model.Car door was opened!");
        }
    }

    public void openCarWindow() {
        openCarWindow = true;
        System.out.println("You just opened a window!");
    }

    public void closeCarWindow() {
        openCarWindow = false;
        System.out.println("You just closed a window!");
    }

    public boolean openCloseCarWindow() {
        if (openCarWindow) {
            System.out.println("car.project.model.Car window is opened!");
        } else {
            System.out.println("car.project.model.Car window is closed!");
        }
        return openCarWindow;
    }
}
