class GeneriskStabel<T> {
    private Node start;

    public void leggPaa(T x) {
	if (erTom()) {
	    start = new Node(x);
	} else {
	    Node midl = start;
	    start = new Node(x);
	    start.neste = midl;
	}
    }

    public T taAv() {
	if (erTom()) {
	    return null;
	}
	Node midl = start;
	start = start.neste;
	return midl.data;
    }

    public boolean erTom(){
	return start == null;
    }

    private class Node{
	private T data;
	private Node neste;

	private Node(T data) {
	    this.data = data;
	}
    }
}
