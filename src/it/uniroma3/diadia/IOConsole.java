package it.uniroma3.diadia;

import java.util.Scanner;

public class IOConsole {
     public void mostraMessaggio(String msg) {
    	 System.out.println(msg);
     }
     public String leggiRiga() {
    	Scanner ScannerDiLinee = new Scanner(System.in);
    	String riga = ScannerDiLinee.nextLine();
    	return riga;
     }
}
