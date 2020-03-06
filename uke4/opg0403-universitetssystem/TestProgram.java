class TestProgram {
    public static void main(String[] args) {
	Bachelorstudent stud1 = new Bachelorstudent("Truls", 21, "Fysikk", "UiO");
	Masterstudent stud2 = new Masterstudent("Hege", 27, "Kjemi", "UiO");
	Professor prof = new Professor("Kjetil", 43, 400, "kake", "baking");

	stud1.skrivInfo();
	stud2.skrivInfo();
	prof.skrivInfo();
    }
}
