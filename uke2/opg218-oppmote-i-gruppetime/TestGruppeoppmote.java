class TestGruppeoppmote {
    public static void main(String[] args) throws Exception {
	Gruppeoppmoete oppmote = new Gruppeoppmoete();
	oppmote.lesInnNavn();
	oppmote.registrerStudent("Nille", true);
	oppmote.registrerStudent("Per", false);
	oppmote.registrerStudent("Geir", false);
	oppmote.skrivUtOppmote();
    }
}
