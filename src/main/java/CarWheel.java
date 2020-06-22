public class CarWheel {
    private double wheelCondition = 1.0;

    public double getWheelCondition() {
        return wheelCondition;
    }

    public void setWheelCondition(double wheelCondition) {
        this.wheelCondition = wheelCondition;
    }

    public void changeTire() {
        wheelCondition = 1.0;
    }

    public void wearOutTire(double percentage) {
        if (percentage > 100 || percentage < 0) {
            System.out.println("Percentage for the wheel erasure cannot be more than 100 or less than 0!");
            return;
        }

        double removePercentage = wheelCondition * (percentage / 100);
        wheelCondition = wheelCondition - removePercentage;
        System.out.println("Current wheel condition is: " + wheelCondition);
    }

    @Override
    public String toString() {
        return "CarWheel{"
                + "wheelCondition=" + wheelCondition
                + '}';
    }
}
