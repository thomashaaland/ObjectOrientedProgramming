class Pappemballasje extends Emballasje {
    int vekt;

    public Pappemballasje(int volum, String prodID, int vekt) {
	super(volum, prodID);
	this.vekt = vekt;
	System.out.println("Konstruktoren til klassen \"Pappemballasje\" utfores");
    }
}
