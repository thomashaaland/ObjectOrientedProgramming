class LegesystemHovedprogram {
    static public void main(String[] args) {
	Legesystem legesystem = new Legesystem();
	String lagringsSted = "legesystemLagring.txt";
	// Unntak på lesFraFil?
	legesystem.lesFraFil(lagringsSted);
	Hovedmeny hovedmeny = new Hovedmeny(legesystem, lagringsSted);
	hovedmeny.hovedmeny();
    }

}
