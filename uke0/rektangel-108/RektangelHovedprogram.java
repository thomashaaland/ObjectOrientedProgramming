class RektangelHovedProgram{

    public static void main(String[] args) {

	Rektangel en = new Rektangel(5, 9);
	Rektangel to = new Rektangel(10, 2);

	System.out.println("Areal: " + en.areal());
	System.out.println("Areal: " + to.areal());

	en.oekBredde(5);
	to.oekLengde(2);

	System.out.println("Omkrets: " + en.omkrets());
	System.out.println("Omkrets: " + to.omkrets());
    }
}
	    
