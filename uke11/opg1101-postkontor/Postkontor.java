import java.util.concurrent.locks.*;

class Postkontor {

    Post[] liste = new Post[10];

    Lock laas = new ReentrantLock();
    Condition ikkeFull = laas.newCondition();
    Condition ikkeTom = laas.newCondition();

    public int storrelse() {
	int storrelse = 0;
	for (int i = 0; i < liste.length; i++) {
	    if (liste[i] != null) {
		storrelse++;
	    }
	}
	return storrelse;
    }

    public void leverPost(Post p) {
	laas.lock();
	try {
	    if (storrelse() == 10) {
		ikkeFull.await();
	    }
	    for (int i = 0; i < liste.length; i++) {
		if (liste[i] == null) {
		    liste[i] = p;
		    ikkeTom.signal();
		    return;
		}
	    }
	}
	catch (InterruptedException e) {
	    System.out.println(e);
	}
	finally {
	    laas.unlock();
	}
    }

    public Post hentPost (String mottaker) {
	laas.lock();
	try {
	    if (storrelse() == 0) {
		ikkeTom.await();
	    }
	    for (int i = 0; i < liste.length; i++) {
		if (liste[i] != null) {
		    if (liste[i].hentMottaker().equals(mottaker)) {
			Post p = liste[i];
			liste[i] = null;
			ikkeFull.signal();
			return p;
		    }
		}
	    }
	    ikkeTom.await();
	}
	catch (InterruptedException e) {
	    System.out.println(e);
	}
	finally {
	    laas.unlock();
	}
	return null;
    }
}
