class Bil {
    private String eier;
    private String merke;

    public Bil(String eieren, String merket) {
	eier = eieren;
	merke = merket;
    }

    public void skrivInfo() {
	System.out.println("Eier av bilen er " + eier +
			   " og merket er " + merke + ".");
    }
}
