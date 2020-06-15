/*
  --*java*--
  VeivalgTerreng utvider Terreng ved aa i stedetfor aa bygge opp
  en rett vei kan man med denne klassen bygge opp terreng med 
  flere retninger.
*/
import java.util.Random;
import java.util.Scanner;

class VeivalgTerreng extends Terreng {
    private Random rand;
    public VeivalgTerreng() {
	// Utfoer konstruktoren til Terreng forst
	super();

	
	// Gaa saa over alle stedene og tildel en hoyre og venstre vei
	rand = new Random();
	int trekkHoyre;
	int trekkVenstre;
	VeivalgSted her;
	VeivalgSted tilHoyre;
	VeivalgSted tilVenstre;
	// Iterer over alle ruter
	her = (VeivalgSted)start;
	for (int i = 0; i < super.lengde; i++) {
	    // Trekk tilfeldig antall steg rett frem og finn frem til det Sted
	    trekkHoyre = rand.nextInt(lengde);
	    tilHoyre = her;
	    for (int j = 0; j < trekkHoyre; j++) {
		tilHoyre = (VeivalgSted)tilHoyre.gaaRettFrem();
	    }
	    // Legger til dette Sted til hoyre sving
	    her.leggTilHoyre(tilHoyre);
	    // Trekk tilfeldig antall steg rett frem og finn frem til det Sted
	    trekkVenstre = rand.nextInt(lengde);
	    tilVenstre = her;
	    for (int k = 0; k < trekkVenstre; k++) {
		tilVenstre = (VeivalgSted)tilVenstre.gaaRettFrem();
	    }
	    her.leggTilVenstre(tilVenstre);
	    her = (VeivalgSted)her.gaaRettFrem();
	}	
    }
    // Metode som returnerer startstedet
    public VeivalgSted hentStart() {
	// trekk et tilfeldig tall som skal avgjoere hva som blir start
	Random rand = new Random();
	int skift = rand.nextInt(lengde);
	// Sykle gjennom og skift hele rekken
	while (skift-- > 0) {
	    siste = (VeivalgSted)siste.gaaRettFrem();
	    start = (VeivalgSted)start.gaaRettFrem();
	}
	return (VeivalgSted)start;
    }

    @Override
    protected void stedTildeling(Scanner fileScan) {
	// Begynn aa tildele beskrivelser til steder
	start = new VeivalgSted(fileScan.nextLine());
	siste = start;
	siste.plasserSkattkiste();
	lengde++;
	while (fileScan.hasNext()) {
	    siste.leggTilRettFrem(new VeivalgSted(fileScan.nextLine()));
	    siste = siste.gaaRettFrem();
	    siste.plasserSkattkiste();
	    lengde++;
	}
    }
}
