class StudentQuiz {
    static public void main(String[] args) {
	Student joakim = new Student("Joakim", 10, 24);
	Student kristin = new Student("Kristin", 14, 2);
	Student dag = new Student("Dag", 53, 5);

	joakim.leggTilQuizScore(5);
	joakim.leggTilQuizScore(3);

	kristin.leggTilQuizScore(34);
	kristin.leggTilQuizScore(23);

	dag.leggTilQuizScore(4);
	dag.leggTilQuizScore(55);

	System.out.println("Student: " + joakim.getName());
	System.out.println("Score: " + joakim.hentTotalScore());
	System.out.println("Gjenomsnitt: " + joakim.hentGjennomsnittligScore());

	System.out.println("Student: " + kristin.getName());
	System.out.println("Score: " + kristin.hentTotalScore());
	System.out.println("Gjenomsnitt: " + kristin.hentGjennomsnittligScore());

	System.out.println("Student: " + dag.getName());
	System.out.println("Score: " + dag.hentTotalScore());
	System.out.println("Gjenomsnitt: " + dag.hentGjennomsnittligScore());
	
    }
}
