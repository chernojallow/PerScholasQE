package com.perscholas.unit_testing_6_test;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.perscholas.unit_testing_6.Product;
import com.perscholas.unit_testing_6.ProductDAO;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

// Annotate class with @RunWith(Parameterized.class)
@RunWith(Parameterized.class)
public class ProductDAOParameterizedTest {
	
	// Declare attributes
	private static ProductDAO p_dao;
	private String name;
	private double price;

	/* Create the constructor. The order of arguments in the parentheses
	 * determines the parameter position in the two-dimensional Object arrays.
	 * Parameter1 = argument num1, Parameter2 = argument num2,
	 * Parameter3 = argument testSum, Parameter4 = argument confirmation*/
	public ProductDAOParameterizedTest(String name, double price) {
		this.name = name;
		this.price = price;
	}

	/* Set up the parameters. The confirmation parameter is null and will
	 * be assigned in the actual test method depending on accuracy of
	 * the addition result. */
	@Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                		{ "Phone", 499.90 },
                		{ "Laptop", 799.00 },
                		{ "Smart Television", 699.00 },
                		{ "Tablet", 399.00 }
                		});
    }

    // Create the static class variable additionClass to run the test methods
    @BeforeClass
    public static void setUp() {
    	p_dao = new ProductDAO();
    }
    
    // Run the test
    @Test
    public void productDAOTest() {
    	Product p = new Product();
    	p.setName(name);
    	p.setPrice(price);
    	
    	try {
			assertNotNull(p_dao.registerProduct(p));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}

    	System.out.printf("Product:%s\tPrice: $%.2f", p.getName(), p.getPrice());

    }
    
}
