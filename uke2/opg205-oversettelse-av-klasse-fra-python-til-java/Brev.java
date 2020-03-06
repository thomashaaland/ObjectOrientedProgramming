import java.util.ArrayList;

class Brev {
    private String avsender;
    private String mottaker;
    private ArrayList<String> linjer;
    
    public Brev(String avsenderen, String mottakeren) {
	avsender = avsenderen;
	mottaker = mottakeren;
	linjer = new ArrayList<String>();
    }

    public void skrivLinje(String linje) {
	linjer.add(linje);
    }

    public void lesBrev() {
	System.out.println("Hei, " + mottaker);
	System.out.println();
	for (String linje : linjer) {
	    System.out.println(linje);
	}
	System.out.println();
	System.out.println("Hilsen fra, ");
	System.out.println(avsender);
    }
}
