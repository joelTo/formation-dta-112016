package fr.pizzeria.model;

public class Pizza {

	private int id;
	private String code;
	private String nom;
	private double prix;
	private static int nbPizzas;
	
	
	public Pizza(int id, String code, String nom, double prix) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		nbPizzas++;
	}
	public Pizza() {
		super();
		nbPizzas++;
		// TODO Auto-generated constructor stub
	}
	
	public int getNbPizzas(){
		return nbPizzas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Pizza [id=" + id + ", code=" + code + ", nom=" + nom
				+ ", prix=" + prix + "]";
	}
	
	

}
