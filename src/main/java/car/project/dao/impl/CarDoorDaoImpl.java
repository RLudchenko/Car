package car.project.dao.impl;

import car.project.dao.CarDoorDao;
import car.project.exceptions.DataProcessingException;
import car.project.model.CarDoor;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CarDoorDaoImpl implements CarDoorDao {
    private static final Logger LOGGER = LogManager.getLogger(CarDaoImpl.class);
    private final SessionFactory sessionFactory;

    @Override
    public CarDoor add(CarDoor carDoor) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Long carDoorId = (Long) session.save(carDoor);
            LOGGER.info(carDoor + " was successfully added to db!");
            return carDoor;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("There was an error adding car door: ", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<CarDoor> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<CarDoor> criteriaQuery = session
                    .getCriteriaBuilder().createQuery(CarDoor.class);
            criteriaQuery.from(CarDoor.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all cars ", e);
        }
    }
}
