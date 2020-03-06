import java.util.Iterator;

public class EnkelArrayListe implements Iterable<String> {
    private String[] liste;
    private int maxKap;
    private int p;
    public EnkelArrayListe(int maxKapasitet) {
	p = 0;
	maxKap = maxKapasitet;
	liste = new String[maxKapasitet];
    }

    public void putt(String string) {
	if (p < maxKap) {
	    liste[p++] = string;
	} else {
	    throw new IllegalStateException("Ikke plass til flere");
	}
    }

    public Iterator<String> iterator() {
	return new ListeIterator();
    }

    private class ListeIterator implements Iterator<String> {
	private int gjeldendeIndeks = 0;

	public String next() {
	    return liste[gjeldendeIndeks++];
	}

	public boolean hasNext() {
	    return gjeldendeIndeks < p;
	}
    }
}
