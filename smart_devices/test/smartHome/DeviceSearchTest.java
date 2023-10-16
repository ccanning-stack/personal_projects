package smartHome;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeviceSearchTest {

	// test data

	double tempNowValidLow, tempNowValidMid, tempNowValidHigh;
	double tempNowInvalidLow, tempNowInvalidHigh;
	double tempTargetValidLow, tempTargetValidMid, tempTargetValidHigh;
	double tempTargetInvalidLow, tempTargetInvalidHigh;

	// will be used for both name and manufacturer as business rules are the same
	// for both currently
	String nameValidLow, nameValidMid, nameValidHigh;
	Powerstate on, off;
	Room bedroom, kitchen, lounge, house, bathroom;
	SmartRadiators sr;

	ArrayList<SmartRadiators> aR;
	SmartRadiators sr1, sr2, sr3, sr4, sr5, sr6, sr7, sr8, sr9, sr10;

	@BeforeEach
	void setUp() throws Exception {

		tempNowValidLow = -10;
		tempNowValidMid = 10;
		tempNowValidHigh = 30;
		tempNowInvalidLow = -10.01;
		tempNowInvalidHigh = 30.01;
		tempTargetValidLow = 5;
		tempTargetValidMid = 16;
		tempTargetValidHigh = 26;
		tempTargetInvalidLow = 4.99;
		tempTargetInvalidHigh = 26.01;
		nameValidLow = "X".repeat(3);
		nameValidMid = "X".repeat(12);
		nameValidHigh = "X".repeat(20);
		on = Powerstate.ON;
		off = Powerstate.OFF;
		bedroom = Room.BEDROOM;
		kitchen = Room.KITCHEN;
		lounge = Room.LOUNGE;
		house = Room.HOUSE;
		bathroom = Room.BATHROOM;

		aR = new ArrayList<SmartRadiators>();

		sr1 = new SmartRadiators(nameValidLow, nameValidLow, house, on, tempNowValidLow, tempTargetValidLow);
		sr2 = new SmartRadiators(nameValidMid, nameValidLow, lounge, off, tempNowValidMid, tempTargetValidHigh);
		sr3 = new SmartRadiators(nameValidHigh, nameValidLow, bathroom, on, tempNowValidHigh, tempTargetValidHigh);
		sr4 = new SmartRadiators(nameValidLow, nameValidLow, house, on, tempNowValidLow, tempTargetValidMid);
		sr5 = new SmartRadiators(nameValidLow, nameValidMid, kitchen, off, tempNowValidHigh, tempTargetValidLow);
		sr6 = new SmartRadiators(nameValidLow, nameValidHigh, bedroom, on, tempNowValidMid, tempTargetValidMid);
		sr7 = new SmartRadiators(nameValidLow, nameValidLow, house, off, tempNowValidLow, tempTargetValidLow);
		sr8 = new SmartRadiators(nameValidLow, nameValidHigh, house, on, tempNowValidHigh, tempTargetValidHigh);
		sr9 = new SmartRadiators(nameValidLow, nameValidLow, bedroom, off, tempNowValidLow, tempTargetValidLow);
		sr10 = new SmartRadiators(nameValidLow, nameValidLow, kitchen, on, tempNowValidMid, tempTargetValidLow);

		aR.add(sr1);
		aR.add(sr2);
		aR.add(sr3);
		aR.add(sr4);
		aR.add(sr5);
		aR.add(sr6);
		aR.add(sr7);
		aR.add(sr8);
		aR.add(sr9);
		aR.add(sr10);

	}

	@Test
	void testSearchByRoom() {

		ArrayList<SmartRadiators> results = new ArrayList<SmartRadiators>();

		results = DeviceSearch.searchByRoom(aR, house);

		assertTrue(results.contains(sr1));
		assertTrue(results.contains(sr4));
		assertTrue(results.contains(sr7));
		assertTrue(results.contains(sr8));
		assertTrue(results.size() == 4);

		ArrayList<SmartRadiators> results2 = new ArrayList<SmartRadiators>();

		results2 = DeviceSearch.searchByRoom(aR, lounge);

		assertTrue(results2.contains(sr2));
		assertTrue(results2.size() == 1);

		ArrayList<SmartRadiators> results3 = new ArrayList<SmartRadiators>();

		results3 = DeviceSearch.searchByRoom(aR, kitchen);

		assertTrue(results3.contains(sr5));
		assertTrue(results3.contains(sr10));
		assertTrue(results3.size() == 2);

		ArrayList<SmartRadiators> results4 = new ArrayList<SmartRadiators>();

		results4 = DeviceSearch.searchByRoom(aR, bathroom);

		assertTrue(results4.contains(sr3));
		assertTrue(results4.size() == 1);

		ArrayList<SmartRadiators> results5 = new ArrayList<SmartRadiators>();

		results5 = DeviceSearch.searchByRoom(aR, bedroom);

		assertTrue(results5.contains(sr6));
		assertTrue(results5.contains(sr9));
		assertTrue(results5.size() == 2);

	}

	@Test
	void testSearchByTemp() {
		
		ArrayList<SmartRadiators> results = new ArrayList<SmartRadiators>();

		results = DeviceSearch.searchByTemp(aR, -10, 3);

		assertTrue(results.contains(sr1));
		assertTrue(results.contains(sr4));
		assertTrue(results.contains(sr7));
		assertTrue(results.contains(sr9));
		assertTrue(results.size() == 4);
		
		ArrayList<SmartRadiators> results2 = new ArrayList<SmartRadiators>();

		results2 = DeviceSearch.searchByTemp(aR, 6, 30);

		assertTrue(results2.contains(sr2));
		assertTrue(results2.contains(sr3));
		assertTrue(results2.contains(sr5));
		assertTrue(results2.contains(sr6));
		assertTrue(results2.contains(sr8));
		assertTrue(results2.contains(sr10));
		assertTrue(results2.size() == 6);
		
		ArrayList<SmartRadiators> results3 = new ArrayList<SmartRadiators>();

		results3 = DeviceSearch.searchByTemp(aR, 20, 30);

		assertTrue(results3.contains(sr3));
		assertTrue(results3.contains(sr5));
		assertTrue(results3.contains(sr8));
		assertTrue(results3.size() == 3);
		
		
	}

}
