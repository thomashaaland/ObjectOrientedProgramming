class Parkeringshus {
    public static void main(String[] args) {
	final int ANTALLPLASSER = 10;
	Parkeringsplass[] etage1 = new Parkeringsplass[ANTALLPLASSER];
	Parkeringsplass[] etage2 = new Parkeringsplass[ANTALLPLASSER];

    	Motorsykkel m1 = new Motorsykkel(110, 2);
	Motorsykkel m2 = new Motorsykkel(111, 3);
	Motorsykkel m3 = new Motorsykkel(112, 4);

	Bil b1 = new Bil(210, 3);
	Bil b2 = new Bil(211, 4);
	Bil b3 = new Bil(212, 5);

	etage1[4] = new Parkeringsplass<Bil>();
	etage1[4].parker(b1);

	etage2[5] = new Parkeringsplass<Motorsykkel>();
	etage2[5].parker(m1);

	etage1[2] = new Parkeringsplass<Bil>();
	etage1[2].parker(b2);

	etage1[3] = new Parkeringsplass<Motorsykkel>();
	etage1[3].parker(m2);

	for (int i = 0; i < ANTALLPLASSER; i++) {
	    if (etage1[i] != null) {
		etage1[i].kjorUt();
		etage1[i] = null;
	    }
	    if (etage2[i] != null) {
		etage2[i].kjorUt();
		etage2[i] = null;
	    }
	}
    }
}
