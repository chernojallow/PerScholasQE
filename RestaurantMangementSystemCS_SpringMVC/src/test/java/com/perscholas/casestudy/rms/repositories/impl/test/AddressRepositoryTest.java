package com.perscholas.casestudy.rms.repositories.impl.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
//import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.perscholas.casestudy.rms.models.Address;
import com.perscholas.casestudy.rms.repositories.AddressRepository;
import com.perscholas.casestudy.rms.repositories.impl.MariaDbAddressRepository;

public class AddressRepositoryTest {
	//private static List<Address> mAddrList;
	private static Address mAddr;
	private static AddressRepository mst;

	@BeforeClass
	public static void setUp() {
		mAddr = Mockito.mock(Address.class, Mockito.CALLS_REAL_METHODS);
		mst = new MariaDbAddressRepository();
	}
	
	@Test
	public void getByIdTest() throws ClassNotFoundException, IOException, SQLException {
		mAddr = mst.getById(1);
		assertThat(mAddr.getAddressId(), is(1));
		System.out.println(mAddr.toString());
		
	}
}
