package Carte;

import Carte.Probleme.Type;

public class Attaque extends Bataille {

	public Attaque(int nombre, Type type) {
		super(nombre, type);
	}

	@Override
	public String toString() {
		String nom = "";
		if(getType() == Type.CREVAISON) {
			nom = "CREVAISON";
		}
		else if	(getType() == Type.ESSENCE) {
			nom = "Panne d'Essence";
		}
		else if(getType() == Type.ACCIDENT) {
			nom = "Accident";
			
		}
		else if(getType() == Type.FEU) {
			nom = "Feu Rouge";
		}
		return nom + " : Cette carte se place sur la pile de Vitesse d'un adversaire qui roule. Elle l'empêche de poser de nouvelles cartes Bornes.";
	}
}

