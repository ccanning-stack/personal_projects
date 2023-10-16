/**
 * 
 */
package smartHome;

/**
 * @author christophercanning
 *
 */
public abstract class AllDevices {

	// declaring constants for business rules - using 2 instead of 4 as business
	// rules
	// are the same for name and manufacturer

	private static final int MIN_LENGTH = 3;
	private static final int MAX_LENGTH = 20;

	// instance vars

	
	private String name;
	private String manufacturer;
	private Room room;
	private Powerstate powerstate;

	// constructor only using args
	//all linked to setters

	public AllDevices(String name, String manufacturer, Room room, Powerstate powerstate) {
		
		this.setName(name);
		this.setManufacturer(manufacturer);
		this.setRoom(room);
		this.setPowerstate(powerstate);
	}

	// Getters & Setters


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter that checks name length within business rule bounds
	 * 
	 * @param name
	 * @throws IllegalArgumentException if name is null or too long/short
	 */
	public void setName(String name) throws IllegalArgumentException {

		if (name == null) {

			throw new IllegalArgumentException("Device name cannot be null");

		}

		if (name.length() >= MIN_LENGTH && name.length() <= MAX_LENGTH) {

			this.name = name;

		} else {

			throw new IllegalArgumentException("Invalid device name length");

		}
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Setter that checks manufacturer name length against business rule bounds
	 * 
	 * @param manufacturer
	 * @throws IllegalArgumentException for null or invalid length manufacturer
	 *                                  parameter
	 */
	public void setManufacturer(String manufacturer) throws IllegalArgumentException {

		if (manufacturer == null) {

			throw new IllegalArgumentException("Manufacturer name cannot be null");

		}

		if (manufacturer.length() >= MIN_LENGTH && manufacturer.length() <= MAX_LENGTH) {

			this.manufacturer = manufacturer;

		} else {

			throw new IllegalArgumentException("Invalid manufacturer name length");

		}
	}

	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * @return the powerstate
	 */
	public Powerstate getPowerstate() {
		return powerstate;
	}

	/**
	 * Setter using Enum but throws IllegalArgumentException for null 
	 * @param powerstate
	 * @throws IllegalArgumentException
	 */
	public void setPowerstate(Powerstate powerstate) throws IllegalArgumentException {
		if (powerstate == null) {

			throw new IllegalArgumentException("Powerstate cannot be null");
		} else {
			this.powerstate = powerstate;
		}

	}
	
	/**
	 * Method to display all details of a certain device
	 */
	public void showAll() {
		
		System.out.println("NAME          :"+this.name);
		System.out.println("MANUFACTURER  :"+this.name);
		System.out.println("ROOM     	  :"+this.name);
		System.out.println("POWERSTATE    :"+this.name);
		
	}
	
	/**
	 * Abstract method to enforce all extending classes to implement method, which returns String
	 * @return String 
	 */
	public abstract String status();

}
