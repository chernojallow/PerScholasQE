package com.perscholas.sba;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.perscholas.sba_models.Chair;
import com.perscholas.sba_models.Furniture;
import com.perscholas.sba_models.Table;

public class SBA10 {

	public static void main(String[] args) {
		int main = -1,furn = -1, ts = -1, tsize = -1, color = -1, ctype = -1;
		Scanner sc = new Scanner(System.in);
		List<Furniture> Cart = new ArrayList<Furniture>();
		Random rand = new Random();
		String name = null;
			
		do {
			System.out.println("Selection:\n1) Add item to the cart\n2) Check out");
			main = sc.nextInt();
			
			if (main == 1) {
				System.out.println("Select which furniture would you like to buy:\n1) Table\n2) Chair");;
				furn = sc.nextInt();
				sc.nextLine();
				
				// Table
				if (furn == 1) {
					Table t = new Table();
					t.setId(rand.nextInt(10) + 1);
					
					System.out.println("Length of the table:\n1) 60 inches\n2) 84 inches");
					tsize = sc.nextInt();
					sc.nextLine();
					
					if (tsize == 1) {
						t.setLength(60);
						name = "60'";
					}
					else {
						t.setLength(84);
						name = "84'";
					}
					
					System.out.println("Color:\n1) Black\n2) Brown\n3) White");
					color = sc.nextInt();
					sc.nextLine();
					if (color == 1) {
						t.setColor("Black");
						name = name + " black";
					}
					else if (color == 2) {
						t.setColor("Brown");
						name = name + " brown";
					}
					else {
						t.setColor("White");
						name = name + " white";
					}
					
					System.out.println("Shape of the table:\n1) Rectangle\n2) Oval\n3) Square");
					ts = sc.nextInt();
					sc.nextLine();
					if (ts == 1) {
						t.setShape("Rectangle");
						name = name + " rectangle";
					}
					else if (ts == 2) {
						t.setShape("Over");
						name = name + " oval";
					}
					else {
						t.setShape("Square");
						name = name + " square";
					}
					
					System.out.println("Quantity: ");
					t.setQuantity(sc.nextInt());
					t.calculatePrice();
					t.setName(name + " table");
					
					Cart.add(t);
				}
				else {
					// Chair
					Chair c = new Chair();
					c.setId(rand.nextInt(10) + 1);
					
					System.out.println("Color:\n1) Black\n2) Brown\n3) White");
					color = sc.nextInt();
					sc.nextLine();
					if (color == 1) {
						c.setColor("Black");
						name = " black";
					}
					else if (color == 2) {
						c.setColor("Brown");
						name = " brown";
					}
					else {
						c.setColor("White");
						name = " white";
					}
				
					System.out.println("Type:\n1) Rocking\n2) Club\n3) Windsor");
					ctype = sc.nextInt();
					sc.nextLine();
					if(ctype == 1) {
						c.setType("Rocking");
						name = name + "Rocking";
					}
					else if (ctype == 2) {
						c.setType("Club");
						name = name + "Club";
					}
					else{
						c.setType("Windsor");
						name = name + "Windsor";
					}
					
					System.out.println("Quantity: ");
					c.setQuantity(sc.nextInt());
					sc.nextLine();
					
					c.calculatePrice();
					c.setName(name);
					Cart.add(c);
				}
				
			}
			else {
				// Check out
			}
		} while (main != 2);
		
		sc.close();

	}

}
