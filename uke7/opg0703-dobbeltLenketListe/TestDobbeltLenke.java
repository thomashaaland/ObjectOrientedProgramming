class TestDobbeltLenke {
    public static void main(String[] args) throws Exception {
	DobbeltLenke<String> liste = new DobbeltLenke<String>();
	liste.leggTil("world!");
	liste.leggTil(", ");
	liste.leggTil("Hello");
	

	System.out.println(liste.fjernSiste() + liste.fjernSiste() + liste.fjernSiste());
    }
}
