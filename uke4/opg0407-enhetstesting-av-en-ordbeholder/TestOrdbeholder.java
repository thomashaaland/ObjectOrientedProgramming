class TestOrdbeholder {
    
    public static void main(String[] args) {

	Ordbeholder obh = new Ordbeholder();

	if (obh.pop() == null) {
	    System.out.println("Riktig 1");
	}
	else {
	    System.out.println("Feil 1");
	}
	
	if (obh.settInn("Nytt")) {
	    System.out.println("Riktig 2");
	}
	else {
	    System.out.println("Feil 2");
	}
	
	if (!obh.settInn("Nytt")) {
	    System.out.println("Riktig 3");
	}
	else {
	    System.out.println("Feil 3");
	}
	
	obh.settInn("Gammel");
	obh.settInn("Trist");

	System.out.println("Ordbeholderen har " + obh.antallOrd() + " ord beholdt. Forventer 3 ord.");
	
	System.out.println("Pop returnerer " + obh.pop() + ". Forventer at Trist skal bli returnert.");
    }
}
