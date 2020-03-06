class Parametere {
    public static void main(String[] args) {

	String c = "hei! ";
	String d = metodeTre(c);

	System.out.println(c);
	System.out.println(d);

    }

    public static String metodeTre(String noe) {
	noe = noe + "og hallo!";
	return noe;
    }
}
