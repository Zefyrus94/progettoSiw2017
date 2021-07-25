package it.uniroma3.galleria.controller;

import java.util.Comparator;

import it.uniroma3.galleria.model.Artista;

public class ComparatoreAnnoArtisti implements Comparator<Artista> {

	@Override
	public int compare(Artista a1, Artista a2) {
		// TODO Auto-generated method stub
		return a1.getAnnoNascita().compareTo(a2.getAnnoNascita());
	}



}
