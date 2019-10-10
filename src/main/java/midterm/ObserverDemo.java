package midterm;

import java.util.Scanner;

@SuppressWarnings("deprecation")
public class ObserverDemo extends Object {
	
	private DigitalClockView clockView;
	private ClockTimerModel clockModel;

	public ObserverDemo() {
		// create the View object
		clockView = new DigitalClockView();
		// create the Model object
		clockModel = new ClockTimerModel();
		// connect the View object to the Model object
		clockModel.addObserver(clockView);
	};

	public static void main(String[] av) {
		ObserverDemo od = new ObserverDemo();
		od.demo();
	};

	public void demo() {
		Scanner kbd = new Scanner(System.in);
		int secs = kbd.nextInt();
		clockModel.start(secs);
		kbd.close();
		clockModel.deleteObserver(clockView);
	};
	
};
