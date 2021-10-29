package ru.sapteh.dao.impl;

import ru.sapteh.dao.Dao;
import ru.sapteh.model.ModelCar;
import ru.sapteh.utils.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class modelDaoImpl implements Dao<ModelCar,Integer> {

    private final Connection connection;

    public modelDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ModelCar findByID(Integer id) {
        String sql = "SELECT * FROM model WHERE id=?";
        ModelCar model = new ModelCar();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                model = new ModelCar(
                    resultSet.getInt("id"),
                        resultSet.getString("mark"),
                        resultSet.getString("body_type"),
                        resultSet.getString("type_gasoline")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }

    @Override
    public List<ModelCar> findAll() {
        List<ModelCar> model = new ArrayList<>();
        String sql = "SELECT * FROM model";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                model.add(
                        new ModelCar(
                                resultSet.getInt("id"),
                                resultSet.getString("mark"),
                                resultSet.getString("body_type"),
                                resultSet.getString("type_gasoline")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public void save(ModelCar modelCar) {
        String sql = "INSERT INTO model (mark,body_type,type_gasoline) VALUES (?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,modelCar.getMark());
            statement.setString(2,modelCar.getBodyType());
            statement.setString(3,modelCar.getTypeGasoline());
            int result = statement.executeUpdate();
            System.out.println(result==1? "Save success" : "Save failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ModelCar modelCar) {
        String  sql = "UPDATE model SET mark=?,body_type=?,type_gasoline=? WHERE id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,modelCar.getMark());
            statement.setString(2,modelCar.getBodyType());
            statement.setString(3,modelCar.getTypeGasoline());
            statement.setInt(4,modelCar.getId());
            int result = statement.executeUpdate();
            System.out.println(result==1?"Update success":"Update failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteByKey(Integer id) {
        String sql = "DELETE FROM model WHERE id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int result = statement.executeUpdate();
            System.out.println(result == 1? "Delete success":"Delete failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
