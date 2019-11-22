package com.perscholas.casestudy.rms.repositories;

import java.io.IOException;
import java.sql.SQLException;

import com.perscholas.casestudy.rms.models.Address;

public interface AddressRepository {
	Integer create(Address address) throws SQLException, ClassNotFoundException, IOException;
	
	Address getById(Integer addressId) throws ClassNotFoundException, IOException, SQLException;
	
	Boolean update(Address address) throws SQLException, ClassNotFoundException, IOException;

	Boolean remove(Integer addressId) throws IOException, SQLException;
}
