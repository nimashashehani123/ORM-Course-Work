package lk.Ijse.bo.custom.impl;

import lk.Ijse.bo.custom.StudentBo;
import lk.Ijse.dao.DAOFactory;
import lk.Ijse.dao.custom.StudentDAO;
import lk.Ijse.dao.custom.UserDAO;
import lk.Ijse.dto.StudentDTO;
import lk.Ijse.dto.UserDTO;
import lk.Ijse.entity.Student;
import lk.Ijse.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBoImpl implements StudentBo {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DaoType.Student);
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DaoType.User);
    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
        User user = userDAO.findUserById(dto.getUserid());
        return studentDAO.save(new Student(dto.getSid(),dto.getName(),dto.getAddress(),dto.getTel(),dto.getEmail(),user));
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
        User user = userDAO.findUserById(dto.getUserid());
        return studentDAO.update(new Student(dto.getSid(),dto.getName(),dto.getAddress(),dto.getTel(),dto.getEmail(),user));
    }

    @Override
    public boolean deleteStudent(String ID) throws Exception {
        return studentDAO.delete(ID);
    }

    @Override
    public List<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException {
        List<Student> students = studentDAO.getAll();
        List<StudentDTO> dtos = new ArrayList<>();
        for (Student student : students) {
            String userId = student.getUser() != null ? student.getUser().getUserid() : null;
            dtos.add(new StudentDTO(student.getSid(), student.getName(), student.getAddress(), student.getTel(), student.getEmail(), userId));
        }
        return dtos;
    }

    @Override
    public String generateNewStudentID() throws SQLException, ClassNotFoundException, IOException {
        return studentDAO.generateNewID();
    }

    @Override
    public boolean StudentIdExists(String studentId) throws SQLException, ClassNotFoundException {
        return studentDAO.IdExists(studentId);
    }
}
