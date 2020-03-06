/** 
    Klassen stabel arver fra Lenkeliste
**/

public class Stabel<T> extends Lenkeliste<T> {
    // LeggPaa legger på et element som får indeks 0
    public void leggPaa(T x) {
	super.leggTil(x);
    }

    // TaAv fjerner elementet med indeks 0
    public T taAv() {
	return super.fjernSiste();
    }
}
