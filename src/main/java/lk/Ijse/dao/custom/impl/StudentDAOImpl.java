package lk.Ijse.dao.custom.impl;

import lk.Ijse.config.FactoryConfiguration;
import lk.Ijse.dao.custom.StudentDAO;
import lk.Ijse.entity.Student;
import lk.Ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student entity) throws Exception {
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

        User user = session.get(User.class, ID);
        if (user != null) {
            session.delete(user);
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
    public List<Student> getAll() throws SQLException, ClassNotFoundException {
        List<Student> all = new ArrayList<>();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        all = session.createQuery("from Student").list();
        transaction.commit();
        session.close();
        return all;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException, IOException {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            String lastID = (String) session.createQuery("SELECT s.sid FROM Student s ORDER BY s.sid DESC")
                    .setMaxResults(1)
                    .uniqueResult();

            if (lastID != null) {
                int id = Integer.parseInt(lastID.replace("S", "")) + 1;
                return "S" + String.format("%03d", id);
            } else {
                return "S001";
            }
        }
    }

    @Override
    public boolean IdExists(String id) throws SQLException, ClassNotFoundException {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            String hql = "SELECT COUNT(s.sid) FROM Student s WHERE s.sid = :id";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("userId", id);
            Long count = query.uniqueResult();
            return count != null && count > 0;
        }
    }
}
