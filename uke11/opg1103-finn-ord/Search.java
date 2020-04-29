import java.util.concurrent.CountDownLatch;

class Search implements Runnable {
    String[] list;
    Monitor monitor;
    String sWord;
    CountDownLatch count;

    public Search(String[] list, Monitor monitor, CountDownLatch count) {
	this.list = list;
	this.monitor = monitor;
	this.count = count;
	sWord = monitor.getWord();
    }

    public void run() {
	for (String word : list) {
	    if (sWord.equals(word)) {
		monitor.count();
	    }
	}
	count.countDown();
    }
    
}
