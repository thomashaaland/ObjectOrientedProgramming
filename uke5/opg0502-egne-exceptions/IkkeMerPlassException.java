class IkkeMerPlassException extends Exception {
    public IkkeMerPlassException(String id) {
	super("Ikke mer plass til boken " + id + ".");
    }
}
