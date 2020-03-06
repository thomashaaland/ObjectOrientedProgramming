import java.util.Iterator;

class TestEnkelArrayListe {
    public static void main(String[] args) {
	EnkelArrayListe liste = new EnkelArrayListe(10);
	liste.putt("En");
	liste.putt("To");
	liste.putt("Tre");

	Iterator<String> iterator = liste.iterator();
	
	try {
	    while (iterator.hasNext()) {
		System.out.println(iterator.next());
	    }
	} catch (IllegalStateException e) {
	    System.out.println(e.getMessage());
	}
    }
}
