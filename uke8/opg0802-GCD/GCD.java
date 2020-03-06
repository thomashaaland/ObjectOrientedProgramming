class GCD {
    public static int getItself(int itself, int dummy) {
	return itself;
    }
    
    public static int gcdRec(int a, int b) {
	// sett storste verdi til a, minste til b
	if (b > a) {
	    a = getItself(b, b=a);
	}
	int c = a % b;

	if (c == 0) {
	    return b;
	} else {
	    return gcdRec(b, c);
	}
    }

    public static int gcdIter(int a, int b) {
	// sett største verdi til a
	if (b > a) {
	    a = getItself(b, b=a);
	}
	int c = a % b;
	while (c != 0) {
	    a = b;
	    b = c;
	    c = a % b;
	}
	return b;
    }
    
    public static void main(String[] args) {
	System.out.println("Recursive GCD(12, 4): " + gcdRec(12, 4));
	System.out.println("Recursive GCD(4, 12): " + gcdRec(4, 12));
	System.out.println("Recursive GCD(13,12): " + gcdRec(13, 12));
	System.out.println("Recursive GCD(150,2500): " + gcdRec(150, 2500));
	
	System.out.println("Iterative GCD(12, 4): " + gcdIter(12, 4));
	System.out.println("Iterative GCD(4, 12): " + gcdIter(4, 12));
	System.out.println("Iterative GCD(13,12): " + gcdIter(13, 12));
	System.out.println("Iterative GCD(150,2500): " + gcdIter(150, 2500));
	
    }
}
