class Hovedprogram {
    public static void main(String[] args) {

	// Initier leger
	Lege lege = new Lege("Hansen");
	Spesialist spesialist = new Spesialist("Lesteberg", 123);

	// Initier legemidler
	Vanlig vanlig = new Vanlig("Vanlig", 100, 200);
	Vanedannende vanedannende = new Vanedannende("Vanedannende", 200, 300, 5);
	Narkotisk narkotisk = new Narkotisk("Narkotisk", 300, 400, 10);
	
	// Initier resepter
	Hvitresept hvitresept = new Hvitresept(vanlig, lege, 5, 10);
	Militaerresept militaerresept = new Militaerresept(narkotisk, spesialist, 5, 10);
	Presept presept = new Presept(vanedannende, spesialist, 5);
	Blaaresept blaaresept = new Blaaresept(vanlig, lege, 5, 10);
	
	// Skriv ut info
	// Leger
	System.out.println("Leger: ");
	System.out.println(lege.toString());
	System.out.println(spesialist.toString());

	//Legemidler
	System.out.println("\nLegemidler:");
	System.out.println(vanlig.toString());
	System.out.println(vanedannende.toString());
	System.out.println(narkotisk.toString());
	
	// Resepter
	System.out.println("\nResepter:");
	System.out.println(hvitresept.toString());
	System.out.println(militaerresept.toString());
	System.out.println(presept.toString());
	System.out.println(blaaresept.toString());
    }
}
