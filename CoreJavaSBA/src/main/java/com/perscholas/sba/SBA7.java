package com.perscholas.sba;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.perscholas.sba_models.SBA7Car;

public class SBA7 {

	public static void main(String[] args) {
		List<SBA7Car> carList = new ArrayList<SBA7Car>();
		String[] carNames = new String[] {"Toyota Corolla", "Honda Civic", "Ford F-Series", "Nissan Altima",
				"Hyundai Elatra", "Subaru Outback"};
		String[] colors = new String[] {"Blue", "Red", "White", "Green", "Gray", "Blue"};
		Random rand = new Random ();
		SBA7Car car = null;
		double rng1 = -1, rng2 = -1, tax = -1, lFee = -1, total = -1;
		int input = -1;
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < carNames.length; i++) {
			car = new SBA7Car ();
			car.setId(i);
			rng1 = rand.nextDouble() * 100000;
			car.setPrice(rng1);
			rng1 = rand.nextInt(carNames.length);
			rng2 = rand.nextInt(colors.length);
			car.setDescription(carNames[(int) rng1] + " " + colors[(int) rng2]);
			carList.add(car);
		}
		
		System.out.println("Selection:");
		for (int i = 0; i < carList.size(); i++)
			System.out.println(i + ") " + carList.get(i).getDescription());
		
		System.out.print("Select the number of the car you want to buy: ");
		input = sc.nextInt();
		
		tax = carList.get(input).getPrice() * .06;
		lFee = carList.get(input).getPrice() * .015;
		total = carList.get(input).getPrice() + tax + lFee;
		System.out.printf("\nInvoice:\nCar = %s\nPrice = $%.2f\nTitle Fee = $150\nTax (6%%) = $%.2f\nLicense Fee (1.5%%)"
				+ " = $%.2f\nTotal = $%.2f", carList.get(input).getDescription(), carList.get(input).getPrice(), 
				tax, lFee, total);		
		
		sc.close();
	}

}
