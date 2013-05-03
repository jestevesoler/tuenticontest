package exer2;

import java.io.*;
import java.util.Scanner;

/*
Sample input
************************
#Dictionary file
dictionary
#Suggestion numbers
3
#Find the suggestions
elvis
lactoprotein
nosuggestion

Sample output
************************
elvis -> lives velis
lactoprotein -> protectional
nosuggestion ->
Sample dictionary

gainly
laying
protectional
lactoprotein
elvis
lives
velis
nosuggestion*/


public class tcExer2 {

	static Scanner sc = new Scanner(System.in);
	static FileReader fr = null;
	static String v_dict = "";

	public static void main(String[] args) {

				  	   
	    int v_numwords = 0;
	    String[] v_words;
	    String v_output = "";
	    String v_line = "";		
	    
	    /** Parsing input **/
	    sc.nextLine();
	    v_dict = sc.nextLine();
	    sc.nextLine();
	    v_numwords = sc.nextInt();
	    sc.nextLine();
	    sc.nextLine();

	    for (int i = 0; i < v_numwords; i++) {

	    	v_line = sc.nextLine();
	   		if (v_line !=null && v_line.trim() !="") {

	   			v_output = v_output + v_line + "\n";

	   		}	   		
	    }

	    v_words = v_output.split("\n");
	    v_output = "";

	    /** Looking for suggestions **/

	    try {	    	
	    	
			System.out.println(" DICCIONARIO " + v_dict + " CASOS "  + v_numwords);

			for (int i = 0; i < v_words.length; i++) {
				v_output = v_output + givemeSuggesstions(v_words[i]);
			}

			System.out.println(" SUGERENCIAS " + v_output);
			
		}
  			catch(Exception e){
     			e.printStackTrace();
  			}	finally{         	
     			try{                    
       	 			if( null != fr ){   
           			fr.close();     
        		}                  
     			}catch (Exception e2){ 
        			e2.printStackTrace();
         		}
	  		}
		
	}


	public static String givemeSuggesstions(String p_word) throws IOException  {

		/* Posibles variaciones de la palabra dada ej. lives elvis velis seliv ... */
		String[] v_vari = givemeVariations(p_word);

		String v_sugg = p_word + " -> " ;		

		/*  Buscar el patron en la en fichero */

		for (int i = 0; i > v_vari.length ; i++) {

			v_sugg = v_vari + searchDictionary(v_vari[i]);

		}

		return v_sugg + "\n";

	}

	/* Devuelve las posibles variaciones de la palabra en orden alfabetico*/
	public static String[] givemeVariations(String p_word) {

		String[] v_vari = "Loren ipsum a".split(" ");

		return v_vari;

	}


	/* Devuelve la palabra si la encuentra en el diccionario.*/
	public static String searchDictionary (String p_word) throws IOException  {

		fr = new FileReader(new File("./exer2/"+v_dict+".txt"));
		sc = new Scanner(fr);

		String v_is = p_word;

		do {

			if (sc.nextLine().contains(p_word)) {
				v_is = p_word;
				} else {
					 v_is = "";
					}
							

		} while (sc.hasNextLine());

		return v_is;

	}

}
