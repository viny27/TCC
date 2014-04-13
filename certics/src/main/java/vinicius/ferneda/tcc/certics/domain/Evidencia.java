package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
public abstract class Evidencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="EVI_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name="EVI_NOME", nullable=false, length=255)
	private String nome;
	
	@Column(name="EVI_DESCRICAO", nullable=false, length=8000)
	private String descricao;
	
	@ManyToOne 
	@JoinColumn(name="EVI_REVID", nullable=false)
	private RespostaEvidenciaEntity respostaEvidencia;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="ANE_EVIID")
	private List<AnexoEntity> anexos = new ArrayList<AnexoEntity>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public RespostaEvidenciaEntity getRespostaEvidencia() {
		return respostaEvidencia;
	}

	public void setRespostaEvidencia(RespostaEvidenciaEntity respostaEvidencia) {
		this.respostaEvidencia = respostaEvidencia;
	}

	public List<AnexoEntity> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<AnexoEntity> anexos) {
		this.anexos = anexos;
	}
	
}