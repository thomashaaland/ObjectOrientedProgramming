/** 
    Lenkeliste klasse.
**/

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

    // Metoder som er implementert i Liste<T>
    // Metode for å finne størrelsen på lenkelisten
    public int stoerrelse() {
	Node p = start;
	int n = 0;
	while (p != null) {
	    n++;
	    p = p.neste;
	}
	return n;
    }

    // LeggTil(pos) legger til et element i posisjon pos
    // og skyver alle senere elementer opp en plass
    public void leggTil(int pos, T x) {
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
    public void sett(int pos, T x) {
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
    public T hent(int pos) {
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
    public T fjern() {
	if (start == null) { throw new UgyldigListeIndeks(-1); }
	T tempData = start.data;
	start = start.neste;
	return tempData;
    }
    
    // fjern(pos) fjerner elementet med indeks pos
    public T fjern(int pos) {
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
    protected T fjernSiste() {
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
