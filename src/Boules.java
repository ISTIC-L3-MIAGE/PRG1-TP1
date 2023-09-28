public class Boules {

    // Attributs
    final static int nombreBoules = 10;
    static char[] tableauBoules;


    public static void triBoules() {
	Ecriture.ecrireString("Suite des " + nombreBoules + " boules : ");
	tableauBoules = lireTableauBoules();
	int r = 0, s = 0, t = nombreBoules - 1;
	// Tri
	while (s <= t) {
	    switch (tableauBoules[s]) {
	    case 'v':
		echange(r, s, tableauBoules);
		++r; ++s;
		break;
		
	    case 'b':
		++s;
		break;

	    case 'r':
		echange(s, t, tableauBoules);
		--t;
		break;

	    default:
		Ecriture.ecrireString("Erreur : s = " + s + ", boule = " + tableauBoules[s]);
		System.exit(0);
	    }
	    photo(r, s, t, tableauBoules);
    	    Ecriture.ecrireStringln("" + estCorrect(r, s, t, tableauBoules));
	    
	}

	Ecriture.ecrireString("résultat du tri : ");
	ecrireTableauBoules(tableauBoules);
	Ecriture.ecrireStringln("");
    }

    /*
     * Vérification.
     *
     * @param int r : L'index de r
     * @param int s : L'index de s
     * @param int t : L'index de t
     * @param char[] tab : Tableau de boule
     */
    public static boolean estCorrect(int r, int s, int t, char[] tab) {
	for (int i = 0; i < nombreBoules; ++i) {
	    if (
		(0 <= i && i < r && tab[i] != 'v')
		|| (r <= i && i < s && tab[i] != 'b')
		|| (t < i && i < nombreBoules && tab[i] != 'r')
		|| (s == t)
		)
	    {
		return false;
	    }
	}
	return true;
    }

     /*
     * Affiche les valeurs intermédiaires à l'écran.
     *
     * @param int r : L'index de r
     * @param int s : L'index de s
     * @param int t : L'index de t
     * @param char[] tab : Tableau de boule
     */
    public static void photo(int r, int s, int t, char[] tab) {
	Ecriture.ecrireStringln("r = " + r + " s = " + s + " t = " + t);
	ecrireTableauBoules(tab);
	Ecriture.ecrireStringln("");
    }

    /*
     * Crée et retourne un tableau de boules.
     *
     * @return char[] tab : Un tableau contenant la suite des caractères lus.
     */
    public static char[] lireTableauBoules() {
	char[] tab = new char[nombreBoules];
	for (int i = 0; i < nombreBoules; ++i) {
	    tab[i] = Lecture.lireChar();
	}
	return tab;
    }

    /*
     * Affiche à l'écran le contenu de tab.
     *
     * @param char[] tab : Tableau 
     */
    public static void ecrireTableauBoules(char[] tab) {
	for (int i = 0; i < nombreBoules; ++i) {
	    Ecriture.ecrireChar(tab[i]);
	}
    }

    /*
     * Permute tab[i] et tab[j].
     *
     * @param int i : Index d'un élément du tableau
     * @param int j : Index d'un autre élément du tableau
     * @param char[] tab : Tableau dans lequel on effectue la permutation
     */
    public static void echange(int i, int j, char[] tab) {
	char c = tab[i];
	tab[i] = tab[j];
	tab[j] = c;
    }

    // Tests
    public static void testLireTableauBoules() {
	triBoules();
	ecrireTableauBoules(tableauBoules);
    }

    public static void testEchange() {
	echange(0, 9, tableauBoules);
	ecrireTableauBoules(tableauBoules);
    }

    // Main
    public static void main(String[] args) {
	//testLireTableauBoules();
	//testEchange();
	triBoules();
    }

    
}
