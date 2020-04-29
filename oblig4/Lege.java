/*
  Klasse for leger arver Person og implementerer Comparable
  Sammenlignbar med andre leger med tanke på navn.

  Kan skrive resepter. En metode for hver type resept:
  Hvitresept()
  Millitaerresept()
  Presept()
  Blaaresept()
*/
public class Lege extends Person implements Comparable<Lege> {

    // Variabler
    private Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<>();
    
    // Konstruktør
    public Lege(String legensNavn) {
	super(legensNavn);
    }

    //Compareto:
    public int compareTo(Lege annen) {
	String a = this.hentNavn();
	String b = annen.hentNavn();
	return a.compareTo(b);
    }

    // Funksjonalitet for resepter:
    // Lokal hjelpemetode, legger til resepter på stabelen
    protected void leggTilResept(Resept resept) {
	utskrevedeResepter.leggTil(resept);
    }

    // Alle reseptmetoder sjekker om legen har lov til å skrive ut resept
    // Legger til en hvit resept
    public Hvitresept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit)
	throws UlovligUtskrift {
	if (legemiddel instanceof Narkotisk) { throw new UlovligUtskrift(this, legemiddel); }
	Hvitresept resept = new Hvitresept(legemiddel, this, pasient, reit);
	leggTilResept(resept);
	return resept;
    }
    
    // Legger til en militærresept
    public Militaerresept skrivMillitaerResept(Legemiddel legemiddel, Pasient pasient, int reit)
	throws UlovligUtskrift {
	if (legemiddel instanceof Narkotisk) { throw new UlovligUtskrift(this, legemiddel); }
	Militaerresept resept = new Militaerresept(legemiddel, this, pasient, reit);
	leggTilResept(resept);
	return resept;
    }

    // Legger til prevansjonsresept
    public Presept skrivPResept(Legemiddel legemiddel, Pasient pasient)
	throws UlovligUtskrift {
	if (legemiddel instanceof Narkotisk) { throw new UlovligUtskrift(this, legemiddel); }
	Presept resept = new Presept(legemiddel, this, pasient);
	leggTilResept(resept);
	return resept;
    }

    // Legger til blåresept
    public Blaaresept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit)
	throws UlovligUtskrift {
	if (legemiddel instanceof Narkotisk) { throw new UlovligUtskrift(this, legemiddel); }
	Blaaresept resept = new Blaaresept(legemiddel, this, pasient, reit);
	leggTilResept(resept);
	return resept;
    }
    
    public void skrivUtResepter() {
	Iterator<Resept> iterator = utskrevedeResepter.iterator();
	while (iterator.hasNext()) {
	    System.out.println(iterator.next());
	}
    }

    public Lenkeliste<Resept> hentResepter() {
	return utskrevedeResepter;
    }
	
    @Override
    public String toString() {
	return "Dr. " + hentNavn();
    }
}
