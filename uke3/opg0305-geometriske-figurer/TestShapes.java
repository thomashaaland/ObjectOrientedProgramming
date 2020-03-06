class TestShapes {
    public static void main(String[] args) {
	Circle c1 = new Circle(2);
	Triangel t1 = new Triangel(1,2);
	Rektangel r1 = new Rektangel(1,2);
	Kvadrat k1 = new Kvadrat(2);
	
	
	System.out.println("Sirkel: " + c1.area());
	System.out.println("Triangel: " + t1.area());
	System.out.println("Rektangel: " + r1.area());
	System.out.println("Kvadrat: " + k1.area());
    }
}
