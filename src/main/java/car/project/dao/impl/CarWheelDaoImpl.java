package car.project.dao.impl;

import car.project.dao.CarWheelDao;
import car.project.exceptions.DataProcessingException;
import car.project.model.CarWheel;
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
public class CarWheelDaoImpl implements CarWheelDao {
    private static final Logger LOGGER = LogManager.getLogger(CarDaoImpl.class);
    private final SessionFactory sessionFactory;

    @Override
    public CarWheel add(CarWheel carWheel) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Long carWheelId = (Long) session.save(carWheel);
            LOGGER.info(carWheel + " was successfully added to db!");
            return carWheel;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("There was an error adding car wheel: ", e);
        } finally {
            if (transaction != null) {
                session.close();
            }
        }
    }

    @Override
    public List<CarWheel> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<CarWheel> criteriaQuery
                    = session.getCriteriaBuilder().createQuery(CarWheel.class);
            criteriaQuery.from(CarWheel.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("There was an error retrieving car wheels ", e);
        }
    }
}
