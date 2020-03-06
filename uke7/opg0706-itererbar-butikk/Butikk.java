import java.util.Iterator;

public class Butikk implements Iterable<Person>{
    private Person forste;

    public void settInn(Person p) {
	if (this.forste == null) {
	    this.forste = p;
	} else {
	    Person midlertidig = forste;
	    while (midlertidig.hentNeste() != null) {
		midlertidig = midlertidig.hentNeste();
	    }
	    midlertidig.settNeste(p);
	}
    }

    public Iterator<Person> iterator() {
	return new PersonIterator();
    }

    class PersonIterator implements Iterator<Person> {
	private Person denne;

	public PersonIterator() {
	    denne = forste;
	}

	@Override
	public boolean hasNext() {
	    return denne != null;
	}

	@Override
	public Person next() {
	    Person midl = denne;
	    denne = denne.hentNeste();
	    return midl;
	}
    }
}
