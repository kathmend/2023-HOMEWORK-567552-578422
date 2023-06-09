package it.uniroma3.diadia;

import java.util.Scanner;

public class IOConsole implements IO {
	
	Scanner scannerDiLinee;
     public void mostraMessaggio(String msg) {
    	 System.out.println(msg);
     }
    
     public IOConsole(Scanner scanner) {
 		this.scannerDiLinee = scanner;
 		//controlli artigianali prima della consegna
 		
 	}
 	
 	public String leggiRiga() {
 		//Scanner scannerDiLinee = new Scanner(System.in);
 		String riga = scannerDiLinee.nextLine();
 		return riga;
 	}
}
