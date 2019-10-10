package midterm;

// A Sub-class of Observable: a Clock Timer
//

import java.util.Observable;

@SuppressWarnings("deprecation")
class ClockTimerModel extends Observable {
	 
	public int GetHour(){return hour;};
	public int GetMinute(){return minute;};
	public int GetSecond(){return second;}; 
	
	public void tick(){
        	// update internal state
        	second ++;
        	if (second >= 60){
        		minute++;
        		second = 0;
        		if (minute >=60){
        			hour++;
        			minute=0;
        			if (hour >= 24){
        				hour=0;
        			};
        		};
        	};
        	// specify that my state was changed  
        	setChanged();
        	// notify all attached Observers of a change
        	notifyObservers(this);
   		};
   		
   		void start(int secs){
        	for (int i = 1; i <= secs; i++)
        		tick();
   		};
   	
   	private int hour;
   	private int minute;
   	private int second;
   	
};
