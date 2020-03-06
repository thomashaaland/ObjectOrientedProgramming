class BoolskeVerider {
    public static void main(String[] args) {
	boolean sann = true;
	boolean usann = false;

	System.out.println(sann);

	if (sann != usann) {
	    System.out.println("Første test slo til");
		}
	else {
	    System.out.println("Første test slo ikke til");
		}
	if (sann == usann) {
	    System.out.println("Andre test slo til");
		}
	else {
	    System.out.println("Andre test slo ikke til");
		}
	
    }
}
	
