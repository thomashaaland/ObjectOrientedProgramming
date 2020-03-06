class Baathus {

    private int nPlasser;
    private int nBaater = 0;
    private Baat[] baatList;
    
    public Baathus(int antallPlasser) {
	baatList = new Baat[antallPlasser];
	nPlasser = antallPlasser;
    }

    public void settInn(String merke) {
	if (nBaater >= nPlasser) {
	    System.out.println("Kan ikke sette inn ny båt, båthuset er fullt.");
	}
	else {
	    baatList[nBaater] = new Baat(merke);
	    nBaater++;
	}
    }
    
    public void skrivBaater() {
	for (int i = 0; i < nBaater; i++) {
	    System.out.println(baatList[i].hentInfo());
	}
    }
}
