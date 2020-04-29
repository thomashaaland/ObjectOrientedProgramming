class Postmann implements Runnable {

    Postkontor postkontor;

    public Postmann(Postkontor postkontor) {
	this.postkontor = postkontor;
    }

    public void run() {
	for (int i = 0; i < 100; i++) {
	    if (i % 2 == 0) {
		Post p = new Pakke("Hei. Pls respond", "Henrik");
		postkontor.leverPost(p);
	    }
	    else {
		Post p = new Brev("Hei. U w0t m8", "Margrethe");
		postkontor.leverPost(p);
	    }
	}
    }
}
