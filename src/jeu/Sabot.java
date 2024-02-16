package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import Carte.Carte;

public class Sabot implements Iterable<Carte>{
	private int nbCartes = 0;
	private Carte[] sabot;
	private int nombreOperation = 0;
	public Sabot(int nbCartesMaximum) {
		super();

		this.sabot = new Carte[nbCartesMaximum];
	}
	
	
	public boolean estVide() {
		if(nbCartes == 0) {
			return true;
		}
		return false;
	}
	
	private void ajouterCarte() {
		if (nbCartes != sabot.length) {
			nbCartes += 1;
			nombreOperation++;
			
		}
		else {
			throw new NoSuchElementException();
		}
	}
	
	public void ajouterFamilleCarte(Carte carte) {
		for (int i = 0; i < carte.getNombre(); i++) {
			sabot[nbCartes] = carte;
			ajouterCarte();
		}
		
	}
	public void ajouterFamilleCarte(Carte ...cartes) {
		for( Carte carte : cartes) {
			ajouterFamilleCarte(carte);
		}
	}
	
	public Iterator<Carte> iterator(){
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private int nombreOperationsReference = nombreOperation;
		private boolean nextEffectue = false;
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}
		public Carte next() {
			verificationConcurrence();
			if (hasNext()) {
				Carte carte = sabot[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			} else {
				throw new NoSuchElementException();
			}

		}
		public void remove() {
			verificationConcurrence();
			if(nbCartes <1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for (int i = indiceIterateur -1; i < nbCartes -1; i++) {
				sabot[i] = sabot[i + 1];
			}
			nextEffectue = false;
			indiceIterateur --;
			nbCartes --;
			nombreOperation ++;
			nombreOperationsReference ++;
		}
		private void verificationConcurrence(){
			if (nombreOperation != nombreOperationsReference)
			throw new ConcurrentModificationException();
		}
		
	}
	public Carte piocher() {
			Carte carte = null;
			Iterator<Carte> iter = iterator();
			if( iter.hasNext()) {
				carte = iter.next();
			}
			if(carte != null) {
				iter.remove();
			}
			System.out.println("Je pioche la carte " + carte.toString());
			return carte;
		}
	
	
}
