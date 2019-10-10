package midterm;

import java.util.Observable;

/**
 * @author Devdutt
 *
 */
@SuppressWarnings("deprecation")
public class GunSlinger extends Observable{

	private String state;
	GunSlinger target;
	String name;
	
	/**
	 * @param newName name of the Gunslinger
	 */
	public GunSlinger(String newName) {
		name = newName;
	}

	public String getState() {
		return state;
	}
	
	private void setState(String newState) {
		state = newState;
		setChanged();
		notifyObservers(target);
	}
	
	public void setTarget(GunSlinger newTarget) {
		target = newTarget;
		setState("Duel");
	}
	
	public void shot() {
		setState("Dead");
	}
	
	public void shoot() {
		setState("Shooting");
		target.shot();
	}
	
	public void blink() {
		setState("Blink");
	}
	

}
