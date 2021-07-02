import com.google.inject.internal.util.Lists;
import org.junit.Test;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

public class TestFlight {
	
	@Test
	public void testFlightDepartingPast() {
		
		var flights = FlightBuilder.createFlights();
		
		List<Flight> list = Lists.newArrayList(flights);
		List<Flight> answer = Lists.newArrayList(flights);
		answer.remove(2);
		
		CheckFlightDepartingPast checkFlightDepartingPast =  new CheckFlightDepartingPast();
		
		Check check = new Check();
		check.check(list, checkFlightDepartingPast);
		
		assertTrue(Objects.equals(list, answer));
	}
	
	@Test
	public void testDepartsBeforeArrives() {
		
		var flights = FlightBuilder.createFlights();
		List<Flight> list = Lists.newArrayList(flights);
		List<Flight> answer = Lists.newArrayList(flights);
		answer.remove(3);
		
		DepartsBeforeArrives departsBeforeArrives = new DepartsBeforeArrives();
		
		Check check = new Check();
		check.check(list, departsBeforeArrives);
		
		assertTrue(Objects.equals(list, answer));
	}
	
	@Test
	public void testMoreThanTwoHoursGroundTime() {
		
		var flights = FlightBuilder.createFlights();
		List<Flight> list = Lists.newArrayList(flights);
		List<Flight> answer = Lists.newArrayList(flights);
		answer.remove(5);
		answer.remove(4);
		
		MoreThanTwoHoursGroundTime moreThanTwoHoursGroundTime = new MoreThanTwoHoursGroundTime();
		
		Check check = new Check();
		check.check(list, moreThanTwoHoursGroundTime);
		
		assertTrue(Objects.equals(list, answer));
	}
	
	@Test
	public void testAll() {
		
		var flights = FlightBuilder.createFlights();
		List<Flight> list = Lists.newArrayList(flights);
		List<Flight> answer = Lists.newArrayList(flights);
		answer.remove(5);
		answer.remove(4);
		answer.remove(3);
		answer.remove(2);
		
		CheckFlightDepartingPast checkFlightDepartingPast =  new CheckFlightDepartingPast();
		DepartsBeforeArrives departsBeforeArrives = new DepartsBeforeArrives();
		MoreThanTwoHoursGroundTime moreThanTwoHoursGroundTime = new MoreThanTwoHoursGroundTime();
		
		Check check = new Check();
		
		check.check(list, checkFlightDepartingPast);
		check.check(list, departsBeforeArrives);
		check.check(list, moreThanTwoHoursGroundTime);
		
		assertTrue(Objects.equals(list, answer));
	}
}

