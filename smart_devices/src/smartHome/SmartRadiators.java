/**
 * 
 */
package smartHome;

/**
 * @author christophercanning
 *
 */
public class SmartRadiators extends AllDevices {

	// business rules

	private static final double MIN_TEMPNOW = -10;
	private static final double MAX_TEMPNOW = 30;
	private static final double MIN_TEMPTARGET = 5;
	private static final double MAX_TEMPTARGET = 26;

	// additional instance vars
	private double tempNow;
	private double tempTarget;

	/**
	 * Constructor inherited plus two additional values for temperature (now &
	 * target)
	 * Linked to all setters
	 * @param deviceType
	 * @param name
	 * @param manufacturer
	 * @param room
	 * @param powerstate
	 */
	public SmartRadiators(String name, String manufacturer, Room room, Powerstate powerstate,
			double tempNow, double tempTarget) {
		super(name, manufacturer, room, powerstate);
		this.setTempNow(tempNow);
		this.setTempTarget(tempTarget);

	}

	/**
	 * @return the tempNow
	 */
	public double getTempNow() {
		return tempNow;
	}

	/**
	 * Setter for current Temp turns Powerstate ON if lower than current target temp
	 * turns Powerstate OFF if higher or equal to current target temp
	 * @param tempNow
	 * @throws IllegalArgumentException
	 */
	public void setTempNow(double tempNow) throws IllegalArgumentException{

		if (tempNow < this.tempTarget) {

			this.setPowerstate(Powerstate.ON);

		}

		if (tempNow >= this.tempTarget) {

			this.setPowerstate(Powerstate.OFF);

		}
		
		if (tempNow >= MIN_TEMPNOW && tempNow <= MAX_TEMPNOW) {
			this.tempNow = tempNow;
			
		} else {
			
			throw new IllegalArgumentException("Temp not within range");
			
		}

		
	}

	/**
	 * @return the tempTarget
	 */
	public double getTempTarget() {
		return tempTarget;
	}

	/**
	 * Setter checks if target Temp is within business rules, if not throws IllegalArgumentException
	 * @param tempTarget
	 * @throws IllegalArgumentException
	 */
	public void setTempTarget(double tempTarget) throws IllegalArgumentException {
		if (tempTarget >= MIN_TEMPTARGET && tempTarget <=MAX_TEMPTARGET) {
			
			this.tempTarget = tempTarget;
			
		}else {
			
			throw new IllegalArgumentException("Temp target outside range");
		}
	}
	
	
	

	@Override
	/**
	 * Adds instance vars from this class to inherited method- displays all info for radiator device
	 */
	public void showAll() {
		super.showAll();
		System.out.println("TEMPNOW        :"+this.tempNow);
		System.out.println("TEMPTARGET     :"+this.tempTarget);
		
	}

	@Override
	public String status() {
		
		//try to round down to 1 decimal place and substitute in below String later***
		//tempN = (.1f) this.tempNow;
		//tempT = ()this.tempTarget;
	

		String status = "SR-"+getName().toUpperCase()+"-"+getRoom()+
				"-NOW:"+this.tempNow+"-TARGET:"+this.tempTarget+"-"+this.getPowerstate();
		
		return status;
	}

}
