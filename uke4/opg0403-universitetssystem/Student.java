public abstract class Student extends Person {
    
    protected String kurs;
    protected String laerersted;
    public Student(String navnet,
		   int alderen,
		   String kurset,
		   String laererstedet) {
	super(navnet, alderen);
	kurs = kurset;
	laerersted = laererstedet;
    }
    public abstract boolean harTilgang();
}
