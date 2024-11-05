package lk.Ijse.dao.custom.impl;

import lk.Ijse.dao.custom.EnrollmentDAO;
import lk.Ijse.entity.Enrollment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EnrollmentDAOImpl implements EnrollmentDAO {
    @Override
    public boolean save(Enrollment entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Enrollment entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String ID) throws Exception {
        return false;
    }

    @Override
    public List<Enrollment> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public boolean IdExists(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
