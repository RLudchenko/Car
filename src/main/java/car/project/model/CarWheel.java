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
@Table(name = "wheels")
public class CarWheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true, length = 11)
    private Long carWheelId;

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
            System.out.println("Percentage for the wheel erasure cannot "
                    + "be more than 100 or less than 0!");
            return;
        }

        double removePercentage = wheelCondition * (percentage / 100);
        wheelCondition = wheelCondition - removePercentage;
        System.out.println("Current wheel condition is: " + wheelCondition);
    }

    @Override
    public String toString() {
        return "car.project.model.CarWheel{"
                + "wheelCondition=" + wheelCondition
                + '}';
    }
}
