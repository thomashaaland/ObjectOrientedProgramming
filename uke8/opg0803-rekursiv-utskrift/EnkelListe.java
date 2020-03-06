class EnkelListe {
    private Node start;

    public void settInnForan(String nyttInnhold) {
	Node ny = new Node(nyttInnhold);
	ny.neste = start;
	start = ny;
    }

    public void skrivUt() {
	skrivUtBaklengst(start);
    }

    public void skrivUtBaklengst(Node n) {
	if (n.neste != null) {
	    skrivUtBaklengst(n.neste);
	    System.out.println(n.innhold);
	} else {
	    System.out.println(n.innhold);
	}
    }

    private class Node {
	private String innhold;
	private Node neste;

	Node (String s) {
	    innhold = s;
	}
    }
}
