package lk.Ijse.dao.custom.impl;

import lk.Ijse.dao.custom.CourseDAO;
import lk.Ijse.entity.Course;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean save(Course entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Course entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String ID) throws Exception {
        return false;
    }

    @Override
    public List<Course> getAll() throws SQLException, ClassNotFoundException {
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
