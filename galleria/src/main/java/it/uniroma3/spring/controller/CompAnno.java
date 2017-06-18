package it.uniroma3.spring.controller;

import java.util.Comparator;

import it.uniroma3.spring.model.Artista;

public class CompAnno implements Comparator<Artista> {

	@Override
	public int compare(Artista a1, Artista a2) {
		// TODO Auto-generated method stub
		return a1.getAnnoNascita().compareTo(a2.getAnnoNascita());
	}



}
