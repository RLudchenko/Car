package car.project.service.impl;

import car.project.dao.CarDoorDao;
import car.project.lib.Inject;
import car.project.lib.Service;
import car.project.model.CarDoor;
import car.project.service.CarDoorService;
import java.util.List;

@Service
public class CarDoorServiceImpl implements CarDoorService {
    @Inject
    CarDoorDao carDoorDao;

    @Override
    public CarDoor add(CarDoor carDoor) {
        return carDoorDao.add(carDoor);
    }

    @Override
    public List<CarDoor> getAll() {
        return carDoorDao.getAll();
    }
}
