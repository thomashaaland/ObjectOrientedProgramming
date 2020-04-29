/* 
   Vanedannende arver Legemiddel. I tillegg til Legemiddel sin
   funksjonalitet tar Vanedannende vare på variabelen 
   int styrke som forteller hvor vanedannende legemiddelet er.
*/

public class Vanedannende extends Legemiddel {
    // Variabler knyttet til denne klassen alene.
    protected int styrke;
    
    // Konstruktør sender String navn, double pris of double virkestoff
    // videre til superklassen Legemiddel
    public Vanedannende(String navn, double pris, double virkestoff, int styrken) {
	super(navn, pris, virkestoff);
	styrke = styrken;
    }

    // returnerer variabelen styrke
    public int hentVanedannendeStyrke() {
	return styrke;
    }

    // toString override
    @Override
    public String toString() {
	return "Vanedannende \t" + super.toString()  + "\t- Vanedannende styrke: " + hentVanedannendeStyrke();
    }           
}
