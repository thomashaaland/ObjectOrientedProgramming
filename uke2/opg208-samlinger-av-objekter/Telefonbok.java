import java.util.ArrayList;
import java.util.HashMap;

class Telefonbok {
    public static void main(String[] args) {
	Person p1 = new Person("Anne", "22334455", "Loveien 1");
	Person p2 = new Person("Nils", "22324252", "Yralle 0");
	Person p3 = new Person("Arne", "93633313", "Galleveien 13");
	Person p4 = new Person("Anne", "34455667", "Alleen 1");

	HashMap<String, Person> oppslag = new HashMap<>();
	oppslag.put(p1.hentNavn(), p1);
	oppslag.put(p2.hentNavn(), p2);
	oppslag.put(p3.hentNavn(), p3);
	oppslag.put(p4.hentNavn(), p4);

	for (Person person : oppslag.values()) {
	    person.skrivInfo();
	}

	/*
	ArrayList<Person> oppslag = new ArrayList<Person>();

	oppslag.add(p1);
	oppslag.add(p2);
	oppslag.add(p3);

	for (Person person : oppslag) {
	    person.skrivInfo();
	}
	*/
	
	/*
	int maxAntallPersoner = 10;
	Person[] oppslag = new Person[maxAntallPersoner];
	
	oppslag[0] = p1;
	oppslag[1] = p2;
	oppslag[2] = p3;

	int i = 0;
	while ((oppslag[i] != null) && (i < maxAntallPersoner)){
	    oppslag[i].skrivInfo();
	    i++;
	}
	*/

	
    }
}
