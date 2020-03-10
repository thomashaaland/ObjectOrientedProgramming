class Ordkryss {

    // CheckAdjacent checks if the firstletter is in the current grid. If its
    // not, return false. If it is found it checks if there is more letters.
    // if there are no more letters, return true. Else checks neighbours.
    public static boolean checkAdjacent(String letters, char[][] brett, int i, int j) {
	int forwardI = (i + 1) % 4;
	int backI = (4 + i - 1) % 4;
	int forwardJ = (j + 1) % 4;
	int backJ = (4 + j - 1) % 4;
	char firstLetter = letters.charAt(0);
	if (firstLetter == brett[i][j] && letters.length() == 1) {
	    return true;
	} else if (firstLetter != brett[i][j]) {
	    return false;
	} else {
	    String rest = letters.substring(1);
	    return checkAdjacent(rest, brett, backI, backJ) ||
		checkAdjacent(rest, brett, backI, j) ||
		checkAdjacent(rest, brett, backI, forwardJ) ||
		checkAdjacent(rest, brett, i, backJ) ||
		checkAdjacent(rest, brett, i, j) ||
		checkAdjacent(rest, brett, i, forwardJ) ||
		checkAdjacent(rest, brett, forwardI, backJ) ||
		checkAdjacent(rest, brett, forwardI, j) ||
		checkAdjacent(rest, brett, forwardI, forwardJ);
	}
    }

    public static boolean ordkryss(String word, char[][] brett) {
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 4; j++) {
		if (checkAdjacent(word, brett, i, j)) {
		    return true;
		}
	    }
	}
	return false;
    }
    
    public static void main(String[] args) {
	// Brett is the playing board,
	char [][] brett = {{'H', 'A', 'B', 'D'},
			   {'M', 'V', 'Q', 'K'},
			   {'P', 'L', 'U', 'G'},
			   {'A', 'S', 'R', 'D'}};
	
	System.out.println("KURS: " + ordkryss("KURS", brett));
	System.out.println("PAVE: " + ordkryss("PAVE", brett));
    }
}
