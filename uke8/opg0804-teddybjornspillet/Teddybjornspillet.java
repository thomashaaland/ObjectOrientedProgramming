class Teddybjornspillet {

    public static int teddyGame(int n) {
	if (n == 42) {
	    return 42;
	}
	else if (n % 5 == 0) {
	    return teddyGame(n - 42);
	}
	else if ((((n % 100)/10) * (n % 10)) != 0 && (n % 4 == 0 || n % 3 == 0)) {
	    return teddyGame( n - (((n % 100)/10) * (n % 10)) );
	}
	else if (n % 2 == 0) {
	    return teddyGame( n - (n / 2) );
	} else {
	    return -1;
	}
    }

    public static boolean teddy(int n) {
	return (teddyGame(n) == 42);
    }
    
    public static void main(String[] args) {
	System.out.println(teddy(250));
	System.out.println(teddy(42));
	System.out.println(teddy(84));
	System.out.println(teddy(53));
	System.out.println(teddy(41));
    }
}
