/** 
    Lenkeliste klasse.
**/

import java.util.*;

public class Lenkeliste<T> implements Liste<T> {
    
    // Private klasser
    // Lenkeliste node.
    protected class Node {
	public Node neste;
	public T data;
	public Node(T x) {
	    data = x;
	    neste = null;
	}
    }
    
    // List start
    protected Node start = null;

    // Iterator metoder:
    @Override
    public Iterator<T> iterator() {
	return new LenkeListeIterator();
    }

    class LenkeListeIterator implements Iterator<T> {
	private Node p;
	private Node pForrige;
	private boolean erEtterNeste;

	// Konstruer en lenkeListe iterator som peker på
	// det første elementet
	public LenkeListeIterator() {
	    p = null;
	    pForrige = null;
	    erEtterNeste = false;
	}

	// Beveger iteratoren til neste element
	public T next() throws UgyldigListeIndeks {
	    if (!hasNext()) {throw new UgyldigListeIndeks(42); }
	    pForrige = p;
	    erEtterNeste = true;

	    if (p == null) {
		p = start;
	    } else {
		p = p.neste;
	    }
	    return p.data;
	}

	// Sjekker om neste element finnes
	public boolean hasNext() {
	    if (p == null) {
		return start != null;
	    } else {
		return p.neste != null;
	    }
	}

	// Fjerner elementet p. Slike at pForrige -> p.neste;
	public void remove() throws IllegalStateException {
	    if (!erEtterNeste) {throw new IllegalStateException(); }
	    if (p == start) {
		fjern();
	    } else {
		pForrige.neste = p.neste;
	    }
	    p = pForrige;
	    erEtterNeste = false;
	}
    }

    
    // Metoder som er implementert i Liste<T>
    // Metode for å finne størrelsen på lenkelisten
    @Override
    public int stoerrelse() {
	Node p = start;
	int n = 0;
	while (p != null) {
	    n++;
	    p = p.neste;
	}
	return n;	
    }

    // Legger til metode for å kopiere fra en liste til en annen
    public void kopier(Liste<T> annen) {
	for (T x : annen) {
	    leggTil(x);
	}
    }
    
    // LeggTil(pos) legger til et element i posisjon pos
    // og skyver alle senere elementer opp en plass
    @Override
    public void leggTil(int pos, T x) throws UgyldigListeIndeks {
	if (pos < 0) { throw new UgyldigListeIndeks(pos); }
	else if (pos == 0) {
	    leggTilForst(x);
	}
	else if (start == null) { throw new UgyldigListeIndeks(pos); }
	else {
	    Node p = start;
	    Node pForrige = p;
	    for (int i = 0; i < pos; i++) {
		if (p == null) { throw new UgyldigListeIndeks(pos); }
		pForrige = p;
		p = p.neste;
	    }
	    Node nyNode = new Node(x);
	    pForrige.neste = nyNode;
	    nyNode.neste = p;
	}
    }

    // Legger til forst i listen
    protected void leggTilForst(T x) {
	Node nyNode = new Node(x);
	nyNode.neste = start;
	start = nyNode;
    }
    
    // Legger til Node bakerst i køen, altså på slutten av listen
    @Override
    public void leggTil(T x) {
	Node nyNode = new Node(x);
	if (start == null) {
	    start = nyNode;
	} else {
	    Node p = start;
	    while (p.neste != null) {
		p = p.neste;
	    }
	    p.neste = nyNode;
	}
    }

    // Sett endrer verdien til elemen pos
    @Override
    public void sett(int pos, T x) throws UgyldigListeIndeks {
	if (pos < 0) { throw new UgyldigListeIndeks(pos); }
	else if (pos == 0) {
	    if (start == null) { throw new UgyldigListeIndeks(-1); }
	    start.data = x;
	} else {
	    Node p = start;
	    for (int i = 0; i < pos; i++) {
		if (p.neste == null) { throw new UgyldigListeIndeks(i); }
		p = p.neste;
	    }
	    p.data = x;
	}
    }

    // Henter et element i position pos
    @Override
    public T hent(int pos) throws UgyldigListeIndeks {
	if (pos < 0) { throw new UgyldigListeIndeks(pos); }
	else if (pos == 0) {
	    if (start == null) { throw new UgyldigListeIndeks(-1); }
	    return start.data;
	} else {
	    Node p = start;
	    for (int i = 0; i < pos; i++) {
		if (p.neste == null) { throw new UgyldigListeIndeks(i); }
		p = p.neste;
	    }
	    return p.data;
	}
    }

    // Fjerner det siste elementet som ble lagt til, fungerer som en stack
    // sammen med leggTil(x). Fjerner element 0
    @Override
    public T fjern() throws UgyldigListeIndeks {
	if (start == null) { throw new UgyldigListeIndeks(-1); }
	T tempData = start.data;
	start = start.neste;
	return tempData;
    }
    
    // fjern(pos) fjerner elementet med indeks pos
    @Override
    public T fjern(int pos) throws UgyldigListeIndeks {
	if (pos < 0) { throw new UgyldigListeIndeks(pos); }
	else if (pos == 0)
	    return fjern();
	else {
	    Node p = start;
	    Node pForrige = null;
	    for (int i = 0; i < pos; i++) {
		if (p.neste == null) { throw new UgyldigListeIndeks(i); }
		pForrige = p;
		p = p.neste;
	    }
	    if (pForrige == null) { throw new UgyldigListeIndeks(pos); }
	    pForrige.neste = p.neste;
	    return p.data;
	}
    }

    // Fjerner elementet som står sist i lista.
    protected T fjernSiste() throws UgyldigListeIndeks {
	if (start == null) { throw new UgyldigListeIndeks(-1); }
	Node p = start;
	Node pForrige = null;
	if (start.neste == null) {
	    start = null;
	    return p.data;
	} else {
	    while (p.neste != null) {
		pForrige = p;
		p = p.neste;
	    }
	    pForrige.neste = null;
	    return p.data;
	}
    }
}
