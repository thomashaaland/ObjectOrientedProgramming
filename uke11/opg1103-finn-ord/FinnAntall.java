import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

class FinnAntall {
    public static void main(String[] args) {
	String ord;
	String filename;
	File fil;
	int nThreads;
	int nWords;
	String[] wordList;
	Monitor monitor;
	CountDownLatch count;
	
	// Check if input is right
	try {
	    if (!(args.length == 3)) {
		throw new IllegalArgumentException();
	    }
	}
	catch (IllegalArgumentException e) {
	    System.out.println("You need 3 arguments: searchword, filename and number of threads");
	}

	ord = args[0];
	filename = args[1];
	nThreads = Integer.parseInt(args[2]);

	// Read in and handle the file
	try {
	    fil = new File(filename);

	    Scanner in = new Scanner(fil);

	    wordList = new String[in.nextInt()];

	    int i = 0;
	    while (in.hasNext()) {
		wordList[i++] = in.next();
	    }

	    int start;
	    int end;
	    String[] batch;

	    monitor = new Monitor(ord);
	    count = new CountDownLatch(nThreads);
	    
	    // Start threads:
	    int batchSize = wordList.length / nThreads;
	    for (int j = 0; j < nThreads; j++) {
		start = j * batchSize;

		if (j == nThreads - 1) {
		    end = wordList.length - 1;
		}
		else {
		    end = (j + 1) * batchSize;
		}

		batch = new String[end - start + 1];

		for (int k = 0; k < batch.length; k++) {
		    batch[k] = wordList[k + start];
		}
		

		Thread t = new Thread(new Search(batch, monitor, count));
		t.start();
	    }
	    try {
		count.await();
	    }
	    catch (InterruptedException e) {
		System.out.println(e);
	    }
	    
	    System.out.println(monitor.getCount());
	}
	catch (FileNotFoundException e) {
	    System.out.println("Could not find the file " + filename);
	}
    }
}
