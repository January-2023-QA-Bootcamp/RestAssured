package common;

public enum Endpoint {

	COUNTRIES("countries"),
	PLAYERS("players");
	
	String name;
	
	Endpoint(String name) {
		this.name = name;
	}
	
	public String getEndpoint() {
		return name;
	}
}
