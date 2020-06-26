package car.project.dao.impl;

import car.project.dao.CarDoorDao;
import car.project.exceptions.DataProcessingException;
import car.project.lib.Dao;
import car.project.model.CarDoor;
import car.project.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class CarDoorDaoImpl implements CarDoorDao {
    private static final Logger LOGGER = LogManager.getLogger(CarDaoImpl.class);

    @Override
    public CarDoor add(CarDoor carDoor) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long carId = (Long) session.save(carDoor);
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
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<CarDoor> criteriaQuery = session
                    .getCriteriaBuilder().createQuery(CarDoor.class);
            criteriaQuery.from(CarDoor.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all cars ", e);
        }
    }
}
