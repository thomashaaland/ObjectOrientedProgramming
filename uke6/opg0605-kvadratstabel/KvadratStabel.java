class KvadratStabel {
    private Node top; // Top of stack

    class Node {
	private Kvadrat data;
	private Node neste;

	// Konstruktør
	private Node(Kvadrat d) {
	    data = d;
	}
    }
    
    public void leggPaa(Kvadrat kvadrat) {
	if (erTom()) {
	    top = new Node(kvadrat);
	} else {
	    Node temp = top;
	    top = new Node(kvadrat);
	    top.neste = temp;
	}
    }

    public Kvadrat taAv() {
	if (erTom()) {
	    return null;
	}
	Node temp = top;
	top = top.neste;
	return temp.data;
    }

    public boolean erTom() {
	return top == null;
    }
	
}
