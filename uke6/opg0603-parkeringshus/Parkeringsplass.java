class Parkeringsplass<T> {
    private T kjoretoy = null;

    public void parker(T kjoretoy) {
	this.kjoretoy = kjoretoy;
    }

    public T kjorUt() {
	T kjor = kjoretoy;
	kjoretoy = null;
	return kjor;
    }
}
