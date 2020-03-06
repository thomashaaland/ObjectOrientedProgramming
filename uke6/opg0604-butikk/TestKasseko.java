class TestKasseko {
    public static void main(String[] args) {
	Person p1 = new Person("Nils Henrik Abel", "kladdebok med ruter");
	Person p2 = new Person("Vilhelm Bjerknes", "termometer");
	Person p3 = new Person("Sheldon Cooper", "lego");

	Butikk butikk = new Butikk();

	butikk.entreButikk(p1);
	butikk.entreButikk(p2);
	butikk.entreButikk(p3);

	butikk.kassa();
    }
}
