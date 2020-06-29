package car.project.model.dto;

import lombok.Data;

@Data
public class CarDoorRequestDto {
    private boolean isDoorOpen;
    private boolean isWindowOpen;
}
