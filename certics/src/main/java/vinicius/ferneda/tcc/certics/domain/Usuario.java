package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "USU_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="USU_EMAIL", length=255)
	private String email;
	
	@Column(name="USU_SENHA", length=255)
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="USU_PROID")
	private ProfissionalEntity profissional;

	@ManyToOne
	@JoinColumn(name="USU_AVRID")
	private AvaliadorEntity avaliador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ProfissionalEntity getProfissional() {
		return profissional;
	}

	public void setProfissional(ProfissionalEntity profissional) {
		this.profissional = profissional;
	}

	public AvaliadorEntity getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(AvaliadorEntity avaliador) {
		this.avaliador = avaliador;
	}

}