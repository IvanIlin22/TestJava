import com.google.inject.internal.util.Lists;
import java.util.List;

public class Main {
	
	public static void main(String[] argc) {
		var flights = FlightBuilder.createFlights();
		for (Flight flight : flights) {
			System.out.println(flight);
		}
		
		List<Flight> list = Lists.newArrayList(flights);
		
		CheckFlightDepartingPast checkFlightDepartingPast =  new CheckFlightDepartingPast();
		DepartsBeforeArrives departsBeforeArrives = new DepartsBeforeArrives();
		MoreThanTwoHoursGroundTime moreThanTwoHoursGroundTime = new MoreThanTwoHoursGroundTime();
		
		Check check = new Check();
		
		check.check(list, checkFlightDepartingPast);
		check.check(list, departsBeforeArrives);
		check.check(list, moreThanTwoHoursGroundTime);
	}
}
