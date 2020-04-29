class TestLegesystem {   
    public static void main(String[] args) {
	Legesystem legesystem = new Legesystem();
	legesystem.lesFraFil("pasienter.txt");

	legesystem.skrivPasientliste();
	legesystem.skrivLegemiddelliste();
	legesystem.skrivLegeliste();
	legesystem.skrivReseptliste();

	System.out.println("\nStatistikk: ");
	legesystem.visStatistikk();

	legesystem.skrivTilFil("utFil.txt");
    }
}
