package endpoint;

import common.Endpoint;
import common.RESTSteps;

public class Countries extends RESTSteps{

	public Countries() {
		init_request();
	}
	
	public void getCountries() {
		request_GET(Endpoint.COUNTRIES.getEndpoint());
	}
}
