//package it.uniroma3.spring.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//
//@Entity
//public class Amministratore {
//		@Id
//		@GeneratedValue(strategy= GenerationType.AUTO)
//		private Long id;
//		private String nome;
//		private String cognome;
//		private String adminNome;
//		@ManyToOne
//		private Utente utente;
//		@ManyToOne
//		private Opera opera;
//		@ManyToOne
//		private Artista artista;
//		
//		
//		
//		public Utente getUtente() {
//			return utente;
//		}
//		public void setUtente(Utente utente) {
//			this.utente = utente;
//		}
//		public Opera getOpera() {
//			return opera;
//		}
//		public void setOpera(Opera opera) {
//			this.opera = opera;
//		}
//		public Artista getArtista() {
//			return artista;
//		}
//		public void setArtista(Artista artista) {
//			this.artista = artista;
//		}
//		public Long getId() {
//			return id;
//		}
//		public void setId(Long id) {
//			this.id = id;
//		}
//		public String getNome() {
//			return nome;
//		}
//		public void setNome(String nome) {
//			this.nome = nome;
//		}
//		public String getCognome() {
//			return cognome;
//		}
//		public void setCognome(String cognome) {
//			this.cognome = cognome;
//		}
//		public String getAdminNome() {
//			return adminNome;
//		}
//		public void setAdminNome(String adminNome) {
//			this.adminNome = adminNome;
//		}
//		
//		
//		
//		
//		
//	
//	
//}
