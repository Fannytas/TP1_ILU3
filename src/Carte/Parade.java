package Carte;

import Carte.Probleme.Type;

public class Parade extends Bataille {

	public Parade(int nombre, Type type) {
		super(nombre, type);
	}

	@Override
	public String toString() {
		String nom = "";
		String carte = "";
		if(getType() == Type.CREVAISON) {
			nom = "Roue de secours";
			carte = "Crevaison";
		}
		else if	(getType() == Type.ESSENCE) {
			nom = "Bidon d'essence";
			carte = "Panne d'Essence";
		}
		else if(getType() == Type.ACCIDENT) {
			nom = "Reparation";
			carte = "Accident";
			
		}
		else if(getType() == Type.FEU) {
			nom = "feu vert";
			carte = "Feu Rouge";
		}
		return nom + " : Cette carte se place sur une carte attaque de sa pile. Elle permet d'annuler l'effet d'une carte : " + carte;
	
	}

}
