package ReadHtml;


import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;


import javax.swing.JOptionPane;

public class ReadHtmlFinal {

	AudioPlay audioplay = new AudioPlay();
	ScanMessage scan = new ScanMessage();
	String resposta;

	public void getURLContent(){
     
		try { 
			//le o arquivo properties
			ReadProperties tempReader = new ReadProperties();
			double minTemp = 18;
			double maxTemp = 18;
			minTemp = tempReader.getminTemp(minTemp);
			maxTemp = tempReader.getmaxTemp(maxTemp);
			
			//le o codigo fonte do site
			URL url = new URL("http://www.termo.prodepa.psi.br:8080/index.html");
			URLConnection conn = url.openConnection();
			String encoding = conn.getContentEncoding();
			if (encoding == null) {
				encoding = "ISO-8859-1";
			}
			
			//le o codigo linha por linha
			LineNumberReader lnr = new LineNumberReader(new
					InputStreamReader(conn.getInputStream(), encoding));
			StringBuilder sb = new StringBuilder(16384);

			String line;
			int linha = 0;
			double temperatura1=20.0;
			double temperatura2=20.0;
			double temperatura3=20.0;
			String temperatura01="";
			String temperatura02="";
			String temperatura03="";
			while((line = lnr.readLine())!= null){
				linha++;

				if(linha == 83 ){
					temperatura1 = Double.parseDouble(line.substring(51, 53));
					if(temperatura1 <= minTemp  ){
						audioplay.playSound();
						JOptionPane.showMessageDialog(null, "A temperatura do Mainframe : "+temperatura1+"°C", "ATENÇÃO:", 2);
						System.err.println("Temperatura do Mainframe: "+temperatura1+"°C");
							
					}
					else if(temperatura1 >= maxTemp){
						audioplay.playSound();
						JOptionPane.showMessageDialog(null, "A temperatura do Mainframe : "+temperatura1+"°C", "ATENÇÃO:", 2);
						System.err.println("Temperatura do Mainframe: "+temperatura1+"°C");
						
					}
					else{System.out.println("Temperatura do Mainframe: "+temperatura1+"°C");}
				}
				if(linha == 94){
					temperatura2 = Double.parseDouble(line.substring(51, 53));
					if(temperatura2 <= minTemp ){
						audioplay.playSound();
						JOptionPane.showMessageDialog(null, "A temperatura do Telecomunicação : "+temperatura2+"°C", "ATENÇÃO:", 2);
						System.err.println("Temperatura do Telecomunicação: "+temperatura2+"°C");
							
					}
					else if(temperatura2 >= maxTemp){
						audioplay.playSound();
						JOptionPane.showMessageDialog(null, "Temperatura do Telecomunicação : "+temperatura2+"°C", "ATENÇÃO:", 2);
						System.err.println("Temperatura do Telecomunicação: "+temperatura2+"°C");
						
					}
					else{System.out.println("Temperatura do Telecomunicação: "+temperatura2+"°C");}
				}
				if(linha == 105){
					temperatura3 = Integer.parseInt(line.substring(51, 53));
					if(temperatura3 <= minTemp  ){
						audioplay.playSound();
						JOptionPane.showMessageDialog(null, "Temperatura do Rack IBM  : "+temperatura3+"°C", "ATENÇÃO:", 2);
						System.err.println("Temperatura do Rack IBM: "+temperatura3+"°C");
							
					}
					else if(temperatura3 >= maxTemp){
						audioplay.playSound();
						JOptionPane.showMessageDialog(null, "Temperatura do Rack IBM: "+temperatura3+"°C", "ATENÇÃO:", 2);
						System.err.println("Temperatura do Rack IBM: "+temperatura3+"°C");
						
					}
					else{System.out.println("Temperatura do Rack IBM: "+temperatura3+"°C");}
				}
			}
			lnr.close();
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} 
	}

	public void printDate(){
		Date dNow = new Date( );
		SimpleDateFormat ft = 
			new SimpleDateFormat ("E dd.MM.yyyy 'às' hh:mm:ss");
		System.out.println("\nHora atual: " + ft.format(dNow));
	}
}


