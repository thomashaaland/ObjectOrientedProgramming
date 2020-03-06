class HeltallsArray {
    public static void main(String[] args) {
	int a = 0;
	int b = 1;
	int c = 2;
	int d = 3;
	int e = 4;

	int[] helTall = new int[5];
	for (int i = 0; i < helTall.length; i++) {
	    helTall[i] = i;
	}
	for (int i = 0; i < helTall.length; i++) {
	    System.out.println("Index: " + i + ":: tall: " + helTall[i]);
	}
    }
}
