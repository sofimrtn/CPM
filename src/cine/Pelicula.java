package cine;

public class Pelicula {

	private String codigo;
	private String titulo;
	private String sinopsis;
	private String genero;
	private String sala;
	private String tresde;
	
	public Pelicula(String codigo, String titulo, String sinopsis, String genero,String sala, String tresde) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.genero = genero;
		this.sala = sala;
		this.tresde = tresde;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public String getTresde() {
		return tresde;
	}
	public void setTresde(String tresde) {
		this.tresde = tresde;
	}
	
	
}
