class Hovedprogram {
    public static void main(String[] args) {
	// Initier pasienter
	Pasient p1 = new Pasient("Charles Boot", "112233");
	Pasient p2 = new Pasient("Hanna Marges", "332211");
	Pasient p3 = new Pasient("Fiodor Glennsen", "113322");
	
	// Initier leger
	Lege lege = new Lege("Hansen");
	Spesialist spesialist = new Spesialist("Lesteberg", 123);

	// Initier legemidler
	int virkestoff1 = 1;
	int virkestoff2 = 2;
	int virkestoff3 = 3;
	Vanlig vanlig = new Vanlig("Vanlig", 100, virkestoff1);
	Vanedannende vanedannende = new Vanedannende("Vanedannende", 200, 300, virkestoff2);
	Narkotisk narkotisk = new Narkotisk("Narkotisk", 300, 400, virkestoff3);
	
	// Initier resepter
	Hvitresept hvitresept = new Hvitresept(vanlig, lege, p1, 10);
	Militaerresept militaerresept = new Militaerresept(narkotisk, spesialist, p2, 10);
	Presept presept = new Presept(vanedannende, spesialist, p1);
	Blaaresept blaaresept = new Blaaresept(vanlig, lege, p3, 10);
	
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
