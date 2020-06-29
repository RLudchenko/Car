package car.project.service.impl;

import car.project.dao.CarDoorDao;
import car.project.model.CarDoor;
import car.project.service.CarDoorService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarDoorServiceImpl implements CarDoorService {
    private final CarDoorDao carDoorDao;

    @Override
    public CarDoor add(CarDoor carDoor) {
        return carDoorDao.add(carDoor);
    }

    @Override
    public List<CarDoor> getAll() {
        return carDoorDao.getAll();
    }
}
