class TestBaathus {
    public static void main(String[] args) {

	Baat b1 = new Baat("Triton");
	Baat b2 = new Baat("Chaparral");
	Baat b3 = new Baat("Mercury");
	Baat b4 = new Baat("Mercury");
	
	
	Baathus myBaathus = new Baathus(3);
	myBaathus.settInn("Ford");
	myBaathus.skrivBaater();
	myBaathus.settInn("Ferrari");
	myBaathus.settInn("Boeing");
	myBaathus.skrivBaater();
	myBaathus.settInn("Tesla");
	myBaathus.skrivBaater();
    }
}
