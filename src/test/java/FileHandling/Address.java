package FileHandling;

public class Address {
	String street;
	String city;
	String state;
	
	//Setters and getters can be generated from source->Generate setters and getters methods
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String toString() {
		return getState()+" "+getCity()+" "+getStreet();
		
	}
	
}
