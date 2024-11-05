package lk.Ijse.dao.custom.impl;

import lk.Ijse.config.FactoryConfiguration;
import lk.Ijse.dao.custom.CourseDAO;
import lk.Ijse.entity.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean save(Course entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Course entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String ID) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();

        Course course = session.get(Course.class, ID);
        if (course != null) {
            session.delete(course);
            tx.commit();
            session.close();
            return true;
        } else {
            tx.rollback();
            session.close();
            return false;
        }
    }

    @Override
    public List<Course> getAll() throws SQLException, ClassNotFoundException {
        List<Course> all = new ArrayList<>();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        all = session.createQuery("from Course").list();
        transaction.commit();
        session.close();
        return all;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException, IOException {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            String lastID = (String) session.createQuery("SELECT c.cid FROM Course c ORDER BY c.cid DESC")
                    .setMaxResults(1)
                    .uniqueResult();

            if (lastID != null) {
                int id = Integer.parseInt(lastID.replace("C", "")) + 1;
                return "C" + String.format("%03d", id);
            } else {
                return "C001";
            }
        }
    }

    @Override
    public boolean IdExists(String id) throws SQLException, ClassNotFoundException {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            String hql = "SELECT COUNT(c.cid) FROM Course c WHERE c.cid = :id";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("id", id);
            Long count = query.uniqueResult();
            return count != null && count > 0;
        }
    }
}
