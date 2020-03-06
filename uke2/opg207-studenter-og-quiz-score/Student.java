class Student {
    private String navn;
    private int totSkore;
    private int antallQuizDeltatt;
    public Student(String name, int totScore, int numQuizDeltatt) {
	navn = name;
	totSkore = totScore;
	antallQuizDeltatt = numQuizDeltatt;
    }

    public String getName() {
	return navn;
    }

    public void leggTilQuizScore(int score){
	antallQuizDeltatt += 1;
	totSkore = totSkore + score;
    }

    public int hentTotalScore(){
	return totSkore;
    }
    
    public double hentGjennomsnittligScore(){
	return totSkore/((double) antallQuizDeltatt);
    }
}
