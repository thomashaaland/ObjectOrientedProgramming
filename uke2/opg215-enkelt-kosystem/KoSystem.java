import java.util.ArrayList;
public class KoSystem{

    private ArrayList<KoLapp>koSystem = new ArrayList<KoLapp>();
    private int sistIKo = 0;
    private int forstIKo = 0;
    
    // Lager et nytt objekt av KoLapp, printer ut informasjon om den
    // og legger den til i listen over koLapper.
    public void trekkKoLapp(){
	koSystem.add(new KoLapp(sistIKo));
	System.out.println("Du har fått tildelt billettnr " + koSystem.get(sistIKo).hentNummer() + ".");
	System.out.println("Det står " + (sistIKo - forstIKo) + " foran deg.");
	sistIKo += 1;
    }

    // Henter ut, printer ut informasjon og fjerner den forste kolappen
    // i lista. Gir feilmelding dersom ingen kunder staar i ko.
    public void betjentKunde(){
	System.out.println("Kunde med billettnr. " + forstIKo + " er betjent.");
	forstIKo += 1;
    }

    // Returnerer antall kunder som er i ko.
    public int antKunder(){
	return sistIKo - forstIKo;

    }

    // Printer alle kunder i ko.
    public void printKunderIKo(){
	
    }

}
