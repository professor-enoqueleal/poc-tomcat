package br.com.example.dao;

import br.com.example.config.ConnectionPoolConfig;
import br.com.example.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarDao {

    public void createCar(Car car) {

        String SQL = "INSERT INTO CAR (NAME, COLOR) VALUES (?, ?)";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Sucesso ao se conectar com o DB!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(2, car.getColor());
            preparedStatement.setString(1, car.getName());

            preparedStatement.execute();

            System.out.println("Sucesso ao inserir o carro no DB!");

            connection.close();

        } catch (Exception e) {

            System.out.println("Falha ao gravar o carro no DB: " + e.getMessage());

        }

    }

    public List<Car> findAllCars(){

        String SQL  = "SELECT * FROM CAR";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Sucesso ao se conectar com o DB!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Car> allCars = new ArrayList<>();

            while (resultSet.next()) {

                String id = resultSet.getString("ID");
                String name = resultSet.getString("NAME");
                String color = resultSet.getString("COLOR");

                Car car = new Car(id, name, color);

                allCars.add(car);

            }

            System.out.println("Sucesso ao consultar os dados na tabela CAR");

            connection.close();

            return allCars;

        } catch (Exception e) {

            System.out.println("Falha ao consultar os carros na tabela CAR: " + e.getMessage());

        }


        return Collections.emptyList();

    }

    public void deleteCarById(String id) {

//        int idInt = Integer.parseInt(id);

        String SQL = "DELETE CAR WHERE ID = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Sucesso ao se conectar com o DB!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, id);

            preparedStatement.execute();

            System.out.println("Sucesso ao deletar o carro pelo ID:");

            connection.close();

        } catch (Exception e) {

            System.out.println("Erro ao deleter o carro pelo ID: " + e.getMessage());

        }


    }

    public void updateCar(Car car) {

        String SQL = "UPDATE CAR SET NAME = ? WHERE ID = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            System.out.println("Sucesso ao se conectar com o DB!");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getId());

            preparedStatement.execute();

            System.out.println("Sucesso ao atualizar o carro");

            connection.close();

        } catch (Exception e) {

            System.out.println("Falha ao atualizar o carro: " + e.getMessage());

        }


    }


}
