public abstract class Person {
    protected String navn;
    protected int alder;

    public Person(String navnet, int alderen) {
	navn = navnet;
	alder = alderen;
    }
    public abstract void skrivInfo();
}
