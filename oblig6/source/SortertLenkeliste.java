public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {

    // Skal legge til i sortert rekkefølge.
    // mao skal sjekke om this.data.compareTo(other.data)
    // er mindre enn 0, er det det skal this.data legges
    // til etter other.data, kaller da leggTil(x, pos)
    @Override
    public void leggTil(T x) {
	int i = 0;
	if (start != null) {
	    Node p = start;
	    while (p != null && x.compareTo(p.data) >= 0) {
		i++;
		p = p.neste;
	    }
	}
	super.leggTil(i, x);
    }

    // Skal fjerne siste elementet, og ikke det første,
    // Så må kalle fjern for fjernSiste
    @Override
    public T fjern() {
	return super.fjernSiste();
    }

    // Overskriv sett(int pos, T x) og leggTil(int pos, T x)
    // slik at man ikke kan sette inn elementer vilkårlig,
    // men sørger for at listen forblir sortert
    @Override
    public void sett(int pos, T x) {
	throw new UnsupportedOperationException();
    }

    @Override
    public void leggTil(int pos, T x) {
	throw new UnsupportedOperationException();
    }
}
