package model;

public class todoClass {
	
	private Long id;
    private String titulo;
    private String descricao;
    private Boolean concluida;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return titulo;
	}
	public void setNome(String nome) {
		this.titulo = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getConcluida() {
		return concluida;
	}
	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}
}