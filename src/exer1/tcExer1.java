package exer1;

import java.util.Scanner;

public class tcExer1 {

/*	
2
2
1 2 10 4 10 1
5
3 4 6 7 8 2 4 5
*/

public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	int v_casos = sc.nextInt();
	int v_budget = 0;
	String[] v_precios;



	for (int i = 0; i < v_casos; i++) {
		v_budget = sc.nextInt();
		sc.nextLine();
		String v_text = sc.nextLine();
		v_precios = v_text.split(" ");
		System.out.println("BUDGET " + v_budget + " TEXTO " + v_text + "PASTA" + howMuchpasta(v_precios, v_budget));
	}	

	
}

public static int howMuchpasta(String[] p_precios, int p_budget) {

	int v_money = p_budget;
	int v_BC = 0;

	for (int i = 0; i < p_precios.length; i++) {


		System.out.println("PRECIO " + p_precios[i] + " PASTA " + v_money + " BC " + v_BC);

		if (v_BC == 0) { //Si no tengo BC comprar
			 //Si precio <= p_budget && precio < sig. && preciopos no ultimo
			if (Integer.parseInt(p_precios[i]) <= v_money) {
				if ((i+1)< p_precios.length) {
					if (Integer.parseInt(p_precios[i+1]) > Integer.parseInt(p_precios[i])) {
						v_BC = (int)v_money/Integer.parseInt(p_precios[i]); 
						/*OJO solo enteros? puedo comprar algunos y quedarme pasta?*/
						/*MAS OJO PUEDO COMPRAR MAS BC mientras TENGO BC!!*/						
						v_money = v_money - v_BC*Integer.parseInt(p_precios[i]);

						System.out.println("COMPRO " + v_BC + " A " + p_precios[i]);
					}					
				}
			}
		} else { //Si tengo BC tengo que vender
			//Mientras el precio siguiente sea mayor y no sea el ultimo no se vende
			if ((i+1) >= p_precios.length) {
				v_money = v_money +(v_BC * Integer.parseInt(p_precios[i]));

				System.out.println("1 VENDO " + v_BC + " A " + p_precios[i]);
				v_BC = 0;

			} else if (Integer.parseInt(p_precios[i+1])<Integer.parseInt(p_precios[i])) {
				v_money = v_money + (v_BC * Integer.parseInt(p_precios[i]));
				System.out.println("2 VENDO " + v_BC + " A " + p_precios[i]);
				v_BC = 0;
			}
		}
	}
	
	return v_money;

}

}