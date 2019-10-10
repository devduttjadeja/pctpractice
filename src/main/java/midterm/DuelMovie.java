package midterm;

@SuppressWarnings("deprecation")
public class DuelMovie {

	
	public static void main(String[] args) {

		GunSlinger gs1 = new GunSlinger("Lee vanCleef");
		GunSlinger gs2 = new GunSlinger("John Wayen");
		Camera cam1 = new Camera(gs1);
		Camera cam2 = new Camera(gs2);
		
		gs1.addObserver(cam1);
		gs2.addObserver(cam2);
		
		gs1.setTarget(gs1);
		gs2.setTarget(gs2);
		gs1.blink();
		
		gs2.setTarget(gs1);
		gs2.shoot();
	}

}
