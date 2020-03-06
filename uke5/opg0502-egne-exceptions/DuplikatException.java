class DuplikatException extends Exception {
    public DuplikatException(String id) {
	super(id + " er duplikat og eksisterer allerede.");
    }
}
