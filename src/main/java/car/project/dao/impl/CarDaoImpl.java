package car.project.dao.impl;

import car.project.dao.CarDao;
import car.project.exceptions.DataProcessingException;
import car.project.lib.Dao;
import car.project.model.Car;
import car.project.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class CarDaoImpl implements CarDao {
    private static final Logger LOGGER = LogManager.getLogger(CarDaoImpl.class);

    @Override
    public Car add(Car car) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long carId = (Long) session.save(car);
            LOGGER.info(car + " was successfully added to db!");
            return car;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("There was an error adding car: ", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Car> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Car> criteriaQuery
                    = session.getCriteriaBuilder().createQuery(Car.class);
            criteriaQuery.from(Car.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("There was an error retrieving cars ", e);
        }
    }
}
