import java.util.ArrayList;

public class SortertArrayList<T extends Comparable<T>> {
    private ArrayList<T> liste = new ArrayList<>();

    // Sett inn element
    public void settInn(T data) {
	for (int i = 0; i < liste.size(); i++) {
	    if (liste.get(i).compareTo(data) > 0) {
		liste.add(i, data);
		return;
	    }
	}
	liste.add(data);
    }

    public T hentForste() {
	return liste.remove(0);
    }
}
