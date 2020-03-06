class TestBeholder {
    public static void main(String[] args) {
	// Opprett beholder
	Beholder<String> boks = new Beholder<String>();
	// Sett inn en String i boksen
	// Test1:
	if (boks.settInn("Element B") == null) {
	    System.out.println("Test1: OK");
	} else {
	    System.out.println("Test1: Feilet.");
	}
	// Test2:
	if (boks.settInn("Element A") == null) {
	    System.out.println("Test2: OK");
	} else {
	    System.out.println("Test2: Feilet.");
	}
	// Test3:
	if (boks.settInn("Element C") == "Element B") {
	    System.out.println("Test3: OK");
	} else {
	    System.out.println("Test3: Feilet.");
	}
    }
}
