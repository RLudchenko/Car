package car.project.service.impl;

import car.project.dao.CarWheelDao;
import car.project.lib.Inject;
import car.project.lib.Service;
import car.project.model.CarWheel;
import car.project.service.CarWheelService;
import java.util.List;

@Service
public class CarWheelServiceImpl implements CarWheelService {
    @Inject
    CarWheelDao carWheelDao;

    @Override
    public CarWheel add(CarWheel carWheel) {
        return carWheelDao.add(carWheel);
    }

    @Override
    public List<CarWheel> getAll() {
        return carWheelDao.getAll();
    }
}
