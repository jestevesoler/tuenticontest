package exer1;

import java.io.*;
import java.util.Scanner;

public class tcExer1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int v_casos = sc.nextInt();
		int v_budget = 0;
		String[] v_precios;
		String v_text = "";

		String v_output = "";

		for (int j = 0; j < v_casos; j++) {

			v_budget = sc.nextInt();
			sc.nextLine();			
			v_precios = sc.nextLine().split(" ");
			v_output = v_output + howMuchpasta(v_precios, v_budget) + ("\n");

		}

		System.out.println(v_output);

	}
	
	public static int howMuchpasta(String[] p_precios, int p_budget) {

		int v_money = p_budget;
		int v_BC = 0;

		for (int i = 0; i < p_precios.length; i++) {

			// Buy i you have money enough, next price is higher than yours and you have
			// time to sell
			if (Integer.parseInt(p_precios[i]) <= v_money) {
				if ((i + 1) < p_precios.length) {
					if (Integer.parseInt(p_precios[i + 1]) > Integer
							.parseInt(p_precios[i])) {
						v_BC = (int) v_money / Integer.parseInt(p_precios[i]);
						v_money = v_money - v_BC
								* Integer.parseInt(p_precios[i]);
					}
				}
			}

			// Sell if you have something to
			if (v_BC > 0) {

				// While the next price still higher than yours and not last we don't sell
				if ((i + 1) >= p_precios.length) {
					v_money = v_money + (v_BC * Integer.parseInt(p_precios[i]));
					v_BC = 0;
				} else if (Integer.parseInt(p_precios[i + 1]) < Integer
						.parseInt(p_precios[i])) {
					v_money = v_money + (v_BC * Integer.parseInt(p_precios[i]));
					v_BC = 0;
				}
			}

		}

		return v_money;

	}

}