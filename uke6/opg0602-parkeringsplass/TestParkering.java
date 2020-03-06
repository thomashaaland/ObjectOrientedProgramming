class TestParkering {
    public static void main(String[] args) {
	Parkeringsplass<Bil> pBil = new Parkeringsplass<>();
	Parkeringsplass<Motorsykkel> pMotor = new Parkeringsplass<>();

	pBil.parker(new Bil(123, 3));
	pMotor.parker(new Motorsykkel(234, 200));

	System.out.println("Kjører ut bil med regnr: "
			   + pBil.kjorUt().hentRegNr() + ".");
	System.out.println("Kjører ut motorsykkel med regnr: "
			   + pMotor.kjorUt().hentRegNr() + ".");

	pBil.parker(new Motorsykkel(345, 400));
    }
}
