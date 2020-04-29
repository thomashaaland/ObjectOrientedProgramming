class AvbrytTraaden {
    public static void main(String[] args) {
	Thread t = new Thread(new MyRunnable());
	t.start();
	t.interrupt();
    }
}
