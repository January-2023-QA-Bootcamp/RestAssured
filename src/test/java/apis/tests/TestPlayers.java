package apis.tests;

import endpoint.Players;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Configuration;

public class TestPlayers {

    Players players;

    @BeforeTest
    public void init(){
        Configuration.loadProperties(TestPlayers.class);
        players = new Players();
    }

    @Test
    public void getPlayersTest(){
        players.logRequest();
        players.getPlayers();
        players.logResponse();
        players.responseCodeValidation(200);
        players.headerEqualValidation("Expires","-1");
        players.bodyEqualValidation("id[1]", 3);
    }
}
