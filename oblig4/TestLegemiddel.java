class TestLegemiddel {
    public static void main(String[] args) {
	// Oppretter et objekt av hver klassetype
	Narkotisk n1 = new Narkotisk("Narko", 250.2, 2.2, 10);
	Vanedannende v1 = new Vanedannende("Vane", 200.1, 1.2, 20);
	Vanlig va1 = new Vanlig("Vanlig", 150.0, 0.2);

	System.out.println("Forventet utskrift for Narkotisk legemiddel:");
	System.out.println("Narkotisk    \tID: 1\t- Navn: Narko\t- Pris: 250.2\t- Virkestoff: 2.2\t- Narkotisk styrke: 10");
	System.out.println("Utskrift:");
	System.out.println("Narkotisk    \tID: " + n1.hentID() + "\t- Navn: " + n1.hentNavn() + "\t- Pris: " + n1.hentPris() + "\t- Virkestoff: " + n1.hentVirkestoff() + "\t- Narkotisk styrke: " + n1.hentNarkotiskStyrke());
	System.out.println("");
	
	System.out.println("Forventet utskrift for Vanedannende legemiddel:");
	System.out.println("Vanedannende \tID: 2\t- Navn: Vane\t- Pris: 200.1\t- Virkestoff: 1.2\t- Vanedannende styrke: 20");
	System.out.println("Utskrift:");
	System.out.println("Vanedannende \tID: " + v1.hentID() + "\t- Navn: " + v1.hentNavn() + "\t- Pris: " + v1.hentPris() + "\t- Virkestoff: " + v1.hentVirkestoff() + "\t- Vanedannende styrke: " + v1.hentVanedannendeStyrke());
	System.out.println("");

	System.out.println("Forventet utskrift for Vanlig legemiddel:");
	System.out.println("Vanlig       \tID: 3\t- Navn: Vanlig\t- Pris: 150.0\t- Virkestoff: 0.2");
	System.out.println("Utskrift:");
	System.out.println("Vanlig       \tID: " + va1.hentID() + "\t- Navn: " + va1.hentNavn() + "\t- Pris: " + va1.hentPris() + "\t- Virkestoff: " + va1.hentVirkestoff());
	System.out.println("");

	System.out.println("Utskrift med toString()");
	System.out.println(n1.toString());
	System.out.println(v1.toString());
	System.out.println(va1.toString());
    }
}
