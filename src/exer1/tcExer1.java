package exer1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class tcExer1 {

public static void main(String[] args) throws AWTException {

	Robot robot = new Robot();
	
	Scanner sc = new Scanner(System.in);
	int v_casos = sc.nextInt();
	int v_budget = 0;
	String[] v_precios;
	String v_text = "";

	
	for (int j = 0; j < v_casos; j++) {
				
		v_budget = sc.nextInt();
		sc.nextLine();
		v_text = sc.nextLine();
		v_precios = v_text.split(" ");
		System.out.println(howMuchpasta(v_precios, v_budget));
		
		if (j == 8) {
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
		}
		
	}	
	
}

public static int howMuchpasta(String[] p_precios, int p_budget) {

	int v_money = p_budget;
	int v_BC = 0;

	for (int i = 0; i < p_precios.length; i++) {
	
			//Buy i you have money enought, next price is higher and you have time to sell
			if (Integer.parseInt(p_precios[i]) <= v_money) {
				if ((i+1)< p_precios.length) {
					if (Integer.parseInt(p_precios[i+1]) > Integer.parseInt(p_precios[i])) {
						v_BC = (int)v_money/Integer.parseInt(p_precios[i]); 
						v_money = v_money - v_BC*Integer.parseInt(p_precios[i]);
					}					
				}
			}
		
			//Sell if you have something to
			if (v_BC > 0) {
				
				//Mientras el precio siguiente sea mayor y no sea el ultimo no se vende
				//While the next price still higher and not last we dont sell
				if ((i+1) >= p_precios.length) {
					v_money = v_money +(v_BC * Integer.parseInt(p_precios[i]));
					v_BC = 0;

				} else if (Integer.parseInt(p_precios[i+1])<Integer.parseInt(p_precios[i])) {
					v_money = v_money + (v_BC * Integer.parseInt(p_precios[i]));
					v_BC = 0;
				}
			}
		
	}
	
	return v_money;

}

}