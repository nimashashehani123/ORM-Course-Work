package lk.Ijse.dao.custom;

import lk.Ijse.dao.CrudDAO;
import lk.Ijse.entity.Enrollment;

import java.sql.SQLException;
import java.util.List;

public interface EnrollmentDAO extends CrudDAO<Enrollment> {
    public List<String> getAllEnrollmentIds() throws SQLException, ClassNotFoundException;
}
