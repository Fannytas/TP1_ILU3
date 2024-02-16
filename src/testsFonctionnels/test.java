package testsFonctionnels;

import Carte.Attaque;
import Carte.Botte;
import Carte.Parade;
import Carte.Probleme.Type;
import jeu.Sabot;

public class test {
	public static void main(String[] args) {
		Parade reparation = new Parade(6, Type.FEU);
		Attaque accident =  new Attaque(3, Type.ACCIDENT);
		Botte asvolant = new Botte(1, Type.ACCIDENT);
		Sabot sabot = new Sabot(110);
		sabot.ajouterFamilleCarte(reparation, accident, asvolant);
		sabot.piocher();
		sabot.piocher();
		sabot.piocher();
		sabot.piocher();
		sabot.piocher();
		sabot.piocher();
		sabot.piocher();
	}
}
