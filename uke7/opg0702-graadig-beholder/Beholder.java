class Beholder<T extends Comparable<T>> {
    T data;

    public Beholder() {
	data = null;
    }

    public T hent() {
	return data;
    }

    public T settInn(T x) {
	if (data == null) {
	    data = x;
	    return null;
	} else if (data.compareTo(x) <= 0) {
	    T temp = data;
	    data = x;
	    return temp;
	} else {
	    return null;
	}
    }
}
