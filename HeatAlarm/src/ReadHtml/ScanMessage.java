package ReadHtml;

import java.util.Scanner;
import java.util.regex.*;


public class ScanMessage {
String resposta;
public Pattern pattern = Pattern.compile("[sn]");
	
public String check(){
	try{
	Scanner in = new Scanner(System.in);
	System.out.println("desligar alarme? Digite s ou n");
	resposta = in.next("[sn]");
}
	catch (java.util.InputMismatchException e) {
		System.err.println("Digite s ou n !");
	}
	
	return resposta;
}
}
