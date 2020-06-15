import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.event.*;
import java.io.File;
import java.io.FileNotFoundException;


public class LabyrintLoser extends Application {
    // Deklarer eller initier globale variabler
    static Pane kulisser = new Pane();
    final static int PADDING = 20;
    final static int PADDINGX = 1000;
    final static int PADDINGY = 800;
    File fil = null;
    Labyrint labyrint = null;
    int lKolonner;
    int lRader;
    
    Liste<String> utveier;
    String valgtUtvei;
    int valgtUtveiIndeks = 0;
    static int valgtUtveiStorrelse = 0;
    
    boolean[][] losning = null;
    
    // Globale navn som trengs
    String labyrintNavn = null;
    Text labyrintNavnTekst = new Text("Labyrint ikke lastet");
    
    // Buttons
    Button velgFilKnapp;
    Button lastInnKnapp;
    Button fjernFilKnapp;
    Button avsluttKnapp;
    Button nesteUtvei;
    Button forrigeUtvei;

    // INTRO SCREEN
    String intro =
	"............................\n" +
	"...#...#...#...#####.#####..\n" +
	"...##.##..#.#.....#..#......\n" +
	"...#.#.#.#...#...#...###....\n" +
	"...#...#.#####..#....#......\n" +
	"...#...#.#...#.#####.#####..\n" +
	"............................\n" +
	"....###...###...#....#...#..\n" +
	"...#...#.#...#..#....#...#..\n" +
	"....##...#...#..#....#...#..\n" +
	"..#...#..#...#..#.....#.#...\n" +
	"...###....###...####...#....\n" +
	"............................\n";
    
    // MAIN
    static public void main(String[] args) {
	launch();
    }

    // BEHANDLERE
    /**
       HentFilBehandler for å hente fil via knapp. Setter også opp 
       labyrinten.
     **/    
    class HentFilBehandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
	    losning = null;
	    valgtUtveiIndeks = 0;
	    
	    FileChooser fileChooser = new FileChooser();
	    ExtensionFilter filter = new ExtensionFilter("Text Files", "*.in");
	    fileChooser.getExtensionFilters().add(filter);
	    fileChooser.setTitle("Velg labyrint");
	    File fil = fileChooser.showOpenDialog(null);

	    if (fil != null) {
		labyrintNavn = fil.getPath();
		labyrintNavnTekst = new Text(labyrintNavn);
		try {
		    labyrint = Labyrint.lesFraFil(fil);
		    String[] labyrinter = ("" + labyrint).split("\n");
		    lRader = labyrinter.length;
		    lKolonner = labyrinter[0].length();

		}
		catch (FileNotFoundException fnfe) {}
	    }
	    else {
		labyrintNavn = "Fail";
		labyrintNavnTekst = new Text(labyrintNavn);
		lRader = 0;
		lKolonner = 0;
	    }
	    update();
	}
    }

    class FjernFilBehandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
	    fil = null;
	    labyrint = null;
	    valgtUtveiStorrelse = 0;
	    valgtUtveiIndeks = 0;
	    losning = null;
	    labyrintNavn = null;
	    labyrintNavnTekst = new Text("Labyrint ikke lastet");

	    update();
	}
    }

    /**
       For å avslutte programmet med avslutningsknapp
    **/
    class AvsluttBehandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
	    Platform.exit();
	}
    }

    /**
       LabyrintLosningsBehandler er laget for knappene som gjør opp labyrinten
       Når man trykker på en rute i labyrinten skal denne metoden finne 
       løsninger som finnes fra den valgte ruten
       Har konstruktør og handle metodene
       @ param kolonne  -kolonne til den valgte ruten
       @ param rad      -raden til den valgte ruten
       @ param kolonner -totalt antall kolonner i labyrinten
       @ param rader    -totalt antall rader i labyrinten
       @ param l        -labyrinten som skal behandles
     **/
    class LabyrintLosningBehandler implements EventHandler<ActionEvent> {
	int kolonne;
	int rad;
	int kolonner;
	int rader;
	Labyrint l;
	
	public LabyrintLosningBehandler(int kolonne, int rad,
					int kolonner, int rader,
					Labyrint l) {
	    this.kolonne = kolonne;
	    this.rad = rad;
	    this.kolonner = kolonner;
	    this.rader = rader;
	    this.l = labyrint;
	}
	
	@Override
	public void handle(ActionEvent e) {
	    utveier = l.finnUtveiFra(kolonne, rad);
	    // Velger ut korteste utvei som den første utveien som vises
	    if (utveier.stoerrelse() != 0) {
		valgtUtvei = utveier.hent(0);
		valgtUtveiIndeks = 0;
		int dummyIndeks = 0;
		for (String utvei : utveier) {
		    dummyIndeks++;
		    if (valgtUtvei.length() > utvei.length()) {
			valgtUtvei = utvei;
			valgtUtveiIndeks = dummyIndeks;
		    }
		}
		losning = losningsStringTilTabell(valgtUtvei, kolonner, rader);
	    }
	    else {
		losning = null;
	    }
	    update();
	}
    }

    class NesteKnappBehandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
	    if (utveier != null && utveier.stoerrelse() > 0) {
		int antUtveier = utveier.stoerrelse();
		valgtUtveiIndeks = (valgtUtveiIndeks + 1) % antUtveier;
		valgtUtvei = utveier.hent(valgtUtveiIndeks);
		losning = losningsStringTilTabell(valgtUtvei, lKolonner, lRader);
		
		update();
	    }
	}
    }

    class ForrigeKnappBehandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
	    if (utveier != null && utveier.stoerrelse() > 0) {
		int antUtveier = utveier.stoerrelse();
		valgtUtveiIndeks = ((valgtUtveiIndeks - 1) < 0) ? (antUtveier - 1) : (valgtUtveiIndeks - 1);
		valgtUtvei = utveier.hent(valgtUtveiIndeks);
		losning = losningsStringTilTabell(valgtUtvei, lKolonner, lRader);
		
		update();
	    }
	}
    }
    
    // MENYER, KULISSER og LAYOUT. Metoder som angår presentasjon

    /**
       Lager knappemenyen som står øverst i programmet. Her settes
       knapper som angår lasting av labyrint og
       @ return - HBox en horisontal liste med knapper
    **/    
    HBox lagMeny() {
	// Knapper
	velgFilKnapp = new Button("Hent fil");
	HentFilBehandler filHenter = new HentFilBehandler();
	velgFilKnapp.setOnAction(filHenter);
	velgFilKnapp.setPrefWidth(200);

	fjernFilKnapp = new Button("Fjern fil");
	FjernFilBehandler filFjerner = new FjernFilBehandler();
	fjernFilKnapp.setOnAction(filFjerner);
	fjernFilKnapp.setPrefWidth(200);
	
	avsluttKnapp = new Button("Avslutt");
	AvsluttBehandler avslutt = new AvsluttBehandler();
	avsluttKnapp.setOnAction(avslutt);
	avsluttKnapp.setPrefWidth(200);
		
	// Sett opp menyen
	HBox meny = new HBox();
	int menyVidde = 200;
	meny.setPrefWidth(menyVidde);

	velgFilKnapp.setMinWidth(menyVidde);
	avsluttKnapp.setMinWidth(menyVidde);
	
	meny.getChildren().addAll(velgFilKnapp,
				  fjernFilKnapp,
				  avsluttKnapp);
	meny.setPadding(new Insets(20, 20, 20, 20));
	
	return meny;
    }

    public VBox visInfo() {
	VBox info = new VBox();
	info.setPadding(new Insets(20, 20, 20, 20));
	info.setPrefSize(250, 200);
	Text antUtveier;
	// Info som antall utveier funnet:
	String antUtvei = "Antall utveier funnet: ";
	if (utveier == null) {
	    antUtveier = new Text(antUtvei + "0");
	}
	else {
	    antUtveier = new Text(antUtvei + utveier.stoerrelse());
	}

	// Info om nåværende utvei
	Text lengdePaaValgtVei = new Text("Valgt utvei har " + valgtUtveiStorrelse + " trinn.");
	Text valgtUtveiIndeksTekst = new Text("Utvei nr. " + (valgtUtveiIndeks + 1) + ".");
	
	// Sett opp knapper for å velge nye utveier
	nesteUtvei = new Button("Neste");
	NesteKnappBehandler nesteKnapp = new NesteKnappBehandler();
	nesteUtvei.setOnAction(nesteKnapp);
	
	forrigeUtvei = new Button("Forrige");
	ForrigeKnappBehandler forrigeKnapp = new ForrigeKnappBehandler();
	forrigeUtvei.setOnAction(forrigeKnapp);
	
	info.getChildren().add(new Text("Information om labyrint:"));
	info.getChildren().add(antUtveier);
	info.getChildren().add(lengdePaaValgtVei);
	info.getChildren().add(valgtUtveiIndeksTekst);
	info.getChildren().add(new HBox(forrigeUtvei, nesteUtvei));
	
	return info;
    }
    
    public HBox visInfoOgLabyrint() {
	HBox infoOgLabyrint = new HBox();
	ScrollPane scrollPane = new ScrollPane(visLabyrint());
	scrollPane.setMaxSize(720, 690);
	
	infoOgLabyrint.getChildren().addAll(visInfo(),
					    scrollPane);
	return infoOgLabyrint;
    }

    /**
       lagLayout
       Metode for å holde presentere den vertikale layouten i programmet.
       Det er tre seksjoner: En overskrifts seksjon der det står hvilken labyrint som
       er lastet står øverst, en knappemeny er i midten og nederst er labyrinten og 
       tilhørende funksjonalitet
       @ return VBox - returnerer en vertikal liste der det øverst står labyrintnavn
                       knappemeny og nederst er labyrinten
     **/
    public VBox lagLayout() {
    	// Sett opp layout. Bruker en vertikal layout
	// slik at info kommer øverst, meny under der
	// og labyrint kommer i bånn.
	VBox layout = new VBox();
	layout.setPadding(new Insets(PADDING));
	layout.getChildren().addAll(labyrintNavnTekst,
				    lagMeny(),
				    visInfoOgLabyrint());
	return layout;
    }

    // START metoden. 
    @Override
    public void start(Stage teater) {	
	// Sett opp kulisser
	update();

	Scene scene = new Scene(kulisser);

	teater.setTitle("LabyrintLøser");
	teater.setScene(scene);
	teater.show();
    }
    
    // HJELPEMETODER
    // for å lage ting under panseret, som labyrint
       
    /**       
       Metode for å lage en GridPane med knapper basert på et Labyrint objekt
       @ param  -labyrint. Et Labyrint objekt fra Oblig5. 
       @ return -returnerer et GridPane objekt fylt med fargede knapper, gjengir
                Labyrint objektet og gjør det mulig å trykke på en knapp for å 
		få tilbake en løsning. LabyrintLosningBehandler generer løsning
    **/
    public GridPane lagLabyrint(Labyrint labyrint) {
	GridPane l = new GridPane();

	// Deler opp labyrinten i rader, String objekt representerer kolonner
	String[] labyrinter = ("" + labyrint).split("\n");
	int rader = labyrinter.length;
	int kolonner = labyrinter[0].length();

	// Løp over kolonnene i, og radene j:
	for (int i = 0; i < kolonner; i++) {
	    for (int j = 0; j < rader; j++) {
		// Administrer Buttons, finn char på (i, j) plassering, generer en
		// knapp, gi knappen funksjonalitet og gi knappen en farge gitt rollen.
		char rute = labyrinter[j].charAt(i);
		Button ruteKnapp = new Button();
		ruteKnapp.setPrefSize(20,20);
		LabyrintLosningBehandler lKnapp =
		    new LabyrintLosningBehandler(i, j, kolonner, rader, labyrint);
		ruteKnapp.setOnAction(lKnapp);
		if (rute == '#') {
		    ruteKnapp.setStyle("-fx-background-color: Black");
		}
		// Her sjekkes det om det er funnet en løsning og om denne
		// ruten er en del av løsningen
		else if (losning != null && losning[i][j]) {
		    ruteKnapp.setStyle("-fx-background-color: Gray");
		}
		else {
		    ruteKnapp.setStyle("-fx-background-color: White");
		}
		l.add(ruteKnapp, i, j);
	    }
	}
	return l;
    }

    public GridPane lagIntroLabyrint() {
    	GridPane l = new GridPane();
	
	// Deler opp labyrinten i rader, String objekt representerer kolonner
	String[] labyrinter = (intro).split("\n");
	int rader = labyrinter.length;
	int kolonner = labyrinter[0].length();
	
	// Løp over kolonnene i, og radene j:
	for (int i = 0; i < kolonner; i++) {
	    for (int j = 0; j < rader; j++) {
		// Administrer Buttons, finn char på (i, j) plassering, generer en
		// knapp, gi knappen funksjonalitet og gi knappen en farge gitt rollen.
		char rute = labyrinter[j].charAt(i);
		Button ruteKnapp = new Button();
		ruteKnapp.setPrefSize(20,20);
		if (rute == '#') {
		    ruteKnapp.setStyle("-fx-background-color: Black");
		}
		else {
		    ruteKnapp.setStyle("-fx-background-color: White");
		}
		l.add(ruteKnapp, i, j);
	    }
	}
	return l;
    }
    
    /** 
	Metode for å vise labyrint
	@ param  -ingen. Benytter seg av globale variabler
	@ return -returnerer en GridPane fylt med knapper der knappene er farget 
	         med sort for vegg, hvit for åpen vei og grå for å gjengi en 
		 løsning.
     **/
    public GridPane visLabyrint() {
	GridPane l = new GridPane();
	if (labyrintNavn == null) {
	    l = lagIntroLabyrint();
	}
	else {
	    l = lagLabyrint(labyrint);
	}
	return l;
    }

    /**
      Konverterer løsningen fra oblig5 til en boolean[][] representasjon av løsningen
      Måtte endre regex metoden: Bruker innebygd regex i String klassen og pattern
      er endret til ".*\\(i, j\\).*". Denne pattern funker på min maskin, utleverte 
      pattern funker ikke. Melder også fra til en global variabel om storrelse på
      valgt utvei.
      @ param        -losningString String-representasjon av stien gått
      @ param bredde -antall kolonner i labyrinten
      @ param hoyde  -antall rader i labyrinten
      @ return       -2D representasjon der verdien true indikerer at ruten er en
                     del av utveien
    **/
    static boolean[][] losningsStringTilTabell(String losningString, int bredde, int hoyde) {
	boolean[][] losning = new boolean[bredde][hoyde];
	valgtUtveiStorrelse = 0;
	for (int i = 0; i < bredde; i++) {
	    for (int j = 0; j < hoyde; j++) {
		String p = ".*\\(" + i + ", " + j + "\\).*";
		if (losningString.matches(p)) {
		    losning[i][j] = true;
		    valgtUtveiStorrelse += 1;
		}
		else losning[i][j] = false;
	    }
	}
	return losning;
    }

    /**
       Metode for å oppdatere labyrint
       @ param -antall kolonner i den lastede labyrinten
       @ param -antall rader i den lastede labyrinten
    **/
    public void update() {
	kulisser.getChildren().clear();
	kulisser.setPrefSize(lKolonner + PADDINGX, lRader + PADDINGY);
        
	kulisser.getChildren().add(lagLayout());
    }
}
