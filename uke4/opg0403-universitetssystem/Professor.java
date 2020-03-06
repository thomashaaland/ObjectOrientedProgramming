class Professor extends Forsker {
    protected String undervisningsKurs;

    public Professor (String navnet,
		      int alderen,
		      int timelonnen,
		      String fagomraadet,
		      String undervisningsKurset) {
	super(navnet, alderen, timelonnen, fagomraadet);
	undervisningsKurs = undervisningsKurset;
    }

    public void skrivInfo() {
	System.out.println("Professor: " + navn + " -Alder: " + alder +
			   "\nFagområde: " + fagomraade + " - kurs: " + undervisningsKurs);
    }
}
