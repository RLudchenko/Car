package car.project.model.dto;

import lombok.Data;

@Data
public class CarDoorResponseDto {
    private Long id;
    private boolean isDoorOpen;
    private boolean isWindowOpen;
}
