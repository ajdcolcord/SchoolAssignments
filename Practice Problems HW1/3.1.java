// Practice Problem 3.1

// A House includes its kind, # rooms, Address, price
//	An Address includes its street#, streetname, city

/*
 +----------------+ 
 |      Home      | 
 +----------------+ 
 | String  kind   |--+
 | int     rooms  |  |
 | Address address|  |
 +----------------+  |
                     v
              +--------------------+
              |      Address       | 
              +--------------------+
              |int     streetNumber|
              |String  streetName  |
              |String  city        |
              +--------------------+
 */
//define House
class House {
	String kind;
	int rooms;
	Address address;

	House(String kind, int rooms, Address address) {
		this.kind = kind;
		this.rooms = rooms;
		this.address = address;
	}
}

//define Address
class Address {
	int streetNumber;
	String streetName;
	String city;

	Address(int streetNumber, String streetName, String city) {
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
	}
}

//----------------------------------------------------------------------------
//Examples

class ExamplesHouses {
	House house1 = new House(
		"Ranch", 7, 375000, new Address(23, "Maple Street", "Brookline"))
	House house2 = new House(
		"Colonial", 9, 450000, new Address(5, "Joye Road", "Newton"))
	House house3 = new House(
		"Cape", 6, 235000, new Address(83, "Winslow Road", "Waltham"))
}