class Triangel {
    static void triangel(int m, int n) {
	if (m <= n) {
	    String stars = "";
	    for (int i = 0; i < m; i++) {
		stars += "*";
	    }
	    
	    System.out.println(stars);
	    triangel(m+1, n);
	    System.out.println(stars);
	}
    }

    
    public static void main(String[] args) {
	triangel(3, 5);
    }
}
