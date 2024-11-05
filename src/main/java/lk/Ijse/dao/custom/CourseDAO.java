package lk.Ijse.dao.custom;

import lk.Ijse.dao.CrudDAO;
import lk.Ijse.entity.Course;
import lk.Ijse.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface CourseDAO extends CrudDAO<Course> {
    public Course findCourseById(String studentId) throws Exception;
    public List<String> getAllCourseIds() throws SQLException, ClassNotFoundException;
}
