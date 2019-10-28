package midterm;

// A specific Observer to observe ClockTimerModel: DigitalClockView
//

import java.util.Observable;
import java.util.Observer;

class DigitalClockView implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		
		//redraw my clocks reading after I was notified
    	int hour   = ((ClockTimerModel) o).GetHour();
    	int minute = ((ClockTimerModel) o).GetMinute();
    	int second = ((ClockTimerModel) o).GetSecond(); 
    	System.out.println(hour+":"+minute+":"+second);
		
	} 
    
};

