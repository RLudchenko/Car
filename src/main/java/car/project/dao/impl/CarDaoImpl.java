package car.project.dao.impl;

import car.project.dao.CarDao;
import car.project.exceptions.DataProcessingException;
import car.project.model.Car;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class CarDaoImpl implements CarDao {
    private static final Logger LOGGER = LogManager.getLogger(CarDaoImpl.class);
    private final SessionFactory sessionFactory;

    @Override
    public Car add(Car car) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
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
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<Car> criteriaQuery
                    = session.getCriteriaBuilder().createQuery(Car.class);
            criteriaQuery.from(Car.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("There was an error retrieving cars ", e);
        }
    }
}
