class BinearUtskrift {
    static String binear(int n) {
	if (n == 0) {
	    return "" + 0;
	} else {
	    return "" + binear(n / 2) + n % 2;
	}
    }
    
    static void skrivUtBinear(int n) {
	System.out.print(binear(n));
    }

    public static void main(String[] args) {
	System.out.println("\n1: ");
	skrivUtBinear(1);
	System.out.println("\n2: ");
	skrivUtBinear(2);
	System.out.println("\n3: ");
	skrivUtBinear(3);
	System.out.println("\n4: ");
	skrivUtBinear(4);
	System.out.println("\n5: ");
	skrivUtBinear(5);
	System.out.println("\n6: ");
	skrivUtBinear(6);
    }
}
