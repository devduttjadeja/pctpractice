package midterm;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Devdutt
 * @see Observer
 */
@SuppressWarnings("deprecation")
public class Camera implements Observer{

	private GunSlinger shooter;
	
	public Camera(GunSlinger newGunSlinger) {
		shooter = newGunSlinger;
	}
	
	public void showClip() {
		
		switch(shooter.getState()) {
		
			case "Duel" :
				System.out.print(shooter.name + ": stands, tickly fingers \n");
				break;
			
			case "Blink" :
				System.out.print(shooter.name + ": sweating, blinks \n");
				break;
				
			case "Dead" :
				System.out.print(shooter.name + ": knees bend, falls dead \n");
				break;
				
			case "Shooting" :
				System.out.print(shooter.name + ": lightning-fast shot \n");
				break;
			
		}
		
	}

	@Override
	public void update(Observable obj, Object arg) {
		
		GunSlinger currentobj = (GunSlinger) obj;
		
		if(obj == arg || currentobj.getState().equals("Shooting")) {
			showClip();
		}
		
	}
	
	
}
