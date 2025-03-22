package com.javaee.dao;

import com.javaee.entity.Country;
import com.javaee.utils.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAOImpl implements CountryDAO {
    @Override
    public List<Country> findAll(int offset, int recordPage) throws SQLException {
        List<Country> countries = new ArrayList<Country>();
        Connection connection = DatabaseConfig.getConnection();
        String SQL = "SELECT * FROM country ORDER BY country_id ASC LIMIT ?,?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1, offset);
        preparedStatement.setInt(2, recordPage);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Country country = new Country();
            country.setId(resultSet.getInt("country_id"));
            country.setName(resultSet.getString("name"));
            country.setContinent(resultSet.getString("continent"));
            countries.add(country);
        }
        return countries;
    }

    @Override
    public boolean save(Country country) throws SQLException {
        Connection connection = DatabaseConfig.getConnection();
        String SQL = "INSERT INTO country (country_name, continent) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, country.getName());
        preparedStatement.setString(2, country.getContinent());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean update(Country country) throws SQLException {
       Connection connection = DatabaseConfig.getConnection();
       String SQL = "UPDATE country SET country_name = ?, continent = ? WHERE country_id = ?";
       PreparedStatement preparedStatement = connection.prepareStatement(SQL);
       preparedStatement.setString(1, country.getName());
       preparedStatement.setString(2, country.getContinent());
       preparedStatement.setInt(3, country.getId());
       return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        Connection connection = DatabaseConfig.getConnection();
        String SQL = "DELETE FROM country WHERE country_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public Country findById(int id) throws SQLException {
       Country country = null;
       Connection connection = DatabaseConfig.getConnection();
       String SQL = "SELECT * FROM country WHERE country_id = ?";
       PreparedStatement preparedStatement = connection.prepareStatement(SQL);
       preparedStatement.setInt(1, id);
       ResultSet resultSet = preparedStatement.executeQuery();
       if (resultSet.next()) {
           int country_id = resultSet.getInt("country_id");
           String name = resultSet.getString("country_name");
           String continent = resultSet.getString("continent");
           country = new Country(country_id, name, continent);
       }
       return country;
    }

    @Override
    public int count() throws SQLException {
        int cont=0;
        Connection connection = DatabaseConfig.getConnection();
        String SQL = "SELECT COUNT(*) AS total FROM country";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            cont = resultSet.getInt("total");
        }
        return cont;
    }
}
