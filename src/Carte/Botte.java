package Carte;

public class Botte extends Probleme {

	public Botte(int nombre, Type type) {
		super(nombre, type);
	}

	@Override
	public String toString() {
		String nom = "";
		String carte = "";
		if(getType() == Type.CREVAISON) {
			nom = "INCREVABLE";
			carte = "Crevaison";
		}
		else if	(getType() == Type.ESSENCE) {
			nom = "CITERNE D'ESSANCE";
			carte = "Panne d'Essence";
		}
		else if(getType() == Type.ACCIDENT) {
			nom = "AS DU VOLANT";
			carte = "Accident";
		}
		else if(getType() == Type.FEU) {
			nom = "VEHICULE PRIORITAIRE";
			carte = "Feu Rouge ni avec une carte Limite de Vitesse";
		}
		return nom + " : Une fois que vous avez posé cette Botte, vos adversaire ne peuvent plus vous attaquer avec une carte " + carte;
	}

}
