package lk.Ijse.bo.custom;

import lk.Ijse.bo.SuperBo;
import lk.Ijse.dto.StudentDTO;
import lk.Ijse.dto.UserDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface StudentBo extends SuperBo {
    public boolean saveStudent(StudentDTO dto) throws Exception;
    public boolean updateStudent(StudentDTO dto) throws Exception;
    public boolean deleteStudent(String ID) throws Exception;
    public List<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException;
    public String generateNewStudentID() throws SQLException, ClassNotFoundException, IOException;
    public boolean StudentIdExists(String studentId) throws SQLException, ClassNotFoundException;
}