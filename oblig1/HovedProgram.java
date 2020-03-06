/**
   Klassen hovedprogram er laget for aa teste klassene Dataklynge,
   Rack og Node. De testes ved to overlastede konstruktorene til 
   Dataklynge, ved manuelt aa sette inn noder og deretter ved filen
   dataklynge.txt.
 **/

class HovedProgram {
    static public void main(String[] args) throws Exception {

	// Gjoer klar og initierer dataklynge med manuell innsetting
	// av noder. 
	Dataklynge abel = new Dataklynge(10);
	Node nodeType01 = new Node(32, 8);
	Node nodeType02 = new Node(64, 4);
	Node nodeType03 = new Node(128, 2);

	// Setter inn 10 noder med 32GB
	for (int i = 0; i < 10; i++) {
	    abel.settInnNode(nodeType01);
	}
	// Setter inn 10 noder med 64GB 
	for (int i=0; i < 10; i++) {
	    abel.settInnNode(nodeType02);
	}
	// Setter inn 10 noder med 128GB
	for (int i=0; i < 10; i++) {
	    abel.settInnNode(nodeType03);
	}

	// Sjekker om systemet oppfoerer seg som det skal
	System.out.print("Noder med minst 32GB: ");
	System.out.println(abel.noderMedNokMinne(32));
	System.out.print("Noder med minst 64GB: ");
	System.out.println(abel.noderMedNokMinne(64));
	System.out.print("Noder med minst 128GB: ");
	System.out.println(abel.noderMedNokMinne(128));
	System.out.println("");
	System.out.print("Antall prosessorer: ");
	System.out.println(abel.antProsessorer());
	System.out.print("Antall rack: ");
	System.out.println(abel.antRacks());

	// initierer en dataklynge med filen dataklynge.txt
	Dataklynge abel2 = new Dataklynge("dataklynge.txt");

	// Sjekker om systemet oppfoerer seg som det skal
	System.out.println("For abel2: ");
	System.out.print("Noder med minst 32GB: ");
	System.out.println(abel2.noderMedNokMinne(32));
	System.out.print("Noder med minst 64GB: ");
	System.out.println(abel2.noderMedNokMinne(64));
	System.out.print("Noder med minst 128GB: ");
	System.out.println(abel2.noderMedNokMinne(128));
	System.out.println("");
	System.out.print("Antall prosessorer: ");
	System.out.println(abel2.antProsessorer());
	System.out.print("Antall rack: ");
	System.out.println(abel2.antRacks());
    }
}
