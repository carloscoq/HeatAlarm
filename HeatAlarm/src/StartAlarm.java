import ReadHtml.SirenThread;
public class StartAlarm {


	public static void main(String[] args) {
		SirenThread thread = new SirenThread();

		thread.start();
	}

}
