package ReadHtml;

public class SirenThread extends Thread{
	
	public void run() {
		
		while(true){
		ReadHtmlFinal readHtml = new ReadHtmlFinal();
		readHtml.printDate();
		readHtml.getURLContent();
		try {
		Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}
}
