public class CarDoor {
    private boolean openCarDoor;
    private boolean openCarWindow;

    public boolean isOpenCarDoor() {
        if (openCarDoor) {
            System.out.println("Car door is opened!");
        } else {
            System.out.println("Car door is closed!");
        }
        return openCarDoor;
    }

    public void setOpenCarDoor(boolean openCarDoor) {
        this.openCarDoor = openCarDoor;
    }

    public boolean isOpenCarWindow() {
        if (openCarWindow) {
            System.out.println("Car window is opened!");
        } else {
            System.out.println("Car window is closed!");
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
            System.out.println("Car door was closed!");
        } else {
            openCarDoor = true;
            System.out.println("Car door was opened!");
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
            System.out.println("Car window is opened!");
        } else {
            System.out.println("Car window is closed!");
        }
        return openCarWindow;
    }
}
