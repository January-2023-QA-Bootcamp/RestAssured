package endpoint;

import common.Endpoint;
import common.RESTSteps;

public class Players extends RESTSteps{

    public Players(){
        init_request();
    }

    public void getPlayers(){
        request_GET(Endpoint.PLAYERS.getEndpoint());
    }
}
