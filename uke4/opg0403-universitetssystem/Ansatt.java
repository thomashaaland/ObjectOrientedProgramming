public abstract class Ansatt extends Person {
    protected int timelonn;

    public Ansatt(String navnet, int alderen, int timelonnen) {
	super(navnet, alderen);
	timelonn = timelonnen;
    }
    public int skrivTimeloenn() {
	return timelonn;
    }
}
