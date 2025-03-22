package com.javaee.dao;

import com.javaee.entity.Country;

import java.sql.SQLException;
import java.util.List;

public interface CountryDAO {
    List<Country> findAll(int offset, int recordPage) throws SQLException ;
    boolean save(Country country) throws SQLException;
    boolean update(Country country)throws SQLException;
    boolean delete(int id)throws SQLException;
    Country findById(int id) throws SQLException;
    int count() throws SQLException;
}
