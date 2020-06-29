package car.project.service.impl;

import car.project.dao.CarWheelDao;
import car.project.model.CarWheel;
import car.project.service.CarWheelService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarWheelServiceImpl implements CarWheelService {
    private final CarWheelDao carWheelDao;

    @Override
    public CarWheel add(CarWheel carWheel) {
        return carWheelDao.add(carWheel);
    }

    @Override
    public List<CarWheel> getAll() {
        return carWheelDao.getAll();
    }
}
