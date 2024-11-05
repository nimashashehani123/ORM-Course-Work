package lk.Ijse.dao.custom.impl;

import lk.Ijse.dao.custom.PaymentDAO;
import lk.Ijse.entity.Payment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean save(Payment entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(Payment entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String ID) throws Exception {
        return false;
    }

    @Override
    public List<Payment> getAll() throws SQLException, ClassNotFoundException {
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
