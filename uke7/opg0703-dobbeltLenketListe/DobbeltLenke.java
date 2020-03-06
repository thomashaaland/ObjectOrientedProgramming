public class DobbeltLenke<T> {
    private Node forste = null;
    
    private class Node {
	Node neste = null;
	Node forrige = null;
	T data;
	private Node(T x) {
	    data = x;
	}
    }

    public void leggTil(T x) {
	if (forste == null) {
	    forste = new Node(x);
	} else {
	    Node p = forste;
	    while (p.neste != null) {
		p = p.neste;
	    }
	    p.neste = new Node(x);
	    p.neste.forrige = p;
	}
    }

    public T fjernSiste() {
	if (forste == null) {
	    return null;
	} else if (forste.neste == null) {
	    T temp = forste.data;
	    forste = null;
	    return temp;
	} else {
	    Node p = forste;
	    while (p.neste != null) {
		p = p.neste;
	    }
	    T temp = p.data;
	    p.forrige.neste = null;
	    return temp;
	}
    }
}
