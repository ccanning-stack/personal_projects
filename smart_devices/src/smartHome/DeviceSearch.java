/**
 * 
 */
package smartHome;

import java.util.ArrayList;

/**
 * @author christophercanning
 *
 */
public class DeviceSearch {

	/**
	 * Search through a given ArrayList of any type of Device, return a different ArrayList made up of all
	 * Devices that match the specified room searched for
	 * 
	 * @param inputList
	 * @param room
	 * @return
	 */
	public static ArrayList<AllDevices> searchByRoom(ArrayList<AllDevices> inputList, Room room) {

		ArrayList<AllDevices> results = new ArrayList<AllDevices>();

		for (AllDevices r : inputList) {

			if (r.getRoom() == room) {

				results.add(r);

			}

		}

		return results;

	}

	/**
	 * Search through an ArrayList of SmartRadiators and return a different ArrayList of all SmartRadiators
	 * that have a current temperature within the specified range
	 * @param inputList
	 * @param tempLower
	 * @param tempUpper
	 * @return
	 */
	public static ArrayList<SmartRadiators> searchByTemp(ArrayList<SmartRadiators> inputList, double tempLower,
			double tempUpper) {

		ArrayList<SmartRadiators> results = new ArrayList<SmartRadiators>();

		for (SmartRadiators r : inputList) {

			if (r.getTempNow() >= tempLower && r.getTempNow() <= tempUpper) {

				results.add(r);

			}

		}

		return results;

	}

}
