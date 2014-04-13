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
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class ConjuntoEvidencias implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CEV_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name="CEV_COMENTARIO", nullable=false, length=8000)
	private String comentario;
	
	@JoinColumn(name="CEV_RESID", nullable=false)
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private ResultadoEsperadoEntity resultadoEsperado;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="EVI_REVID")
	private List<RespostaEvidenciaEntity> respostas = new ArrayList<RespostaEvidenciaEntity>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public ResultadoEsperadoEntity getResultadoEsperado() {
		return resultadoEsperado;
	}

	public void setResultadoEsperado(ResultadoEsperadoEntity resultadoEsperado) {
		this.resultadoEsperado = resultadoEsperado;
	}

	public List<RespostaEvidenciaEntity> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaEvidenciaEntity> respostas) {
		this.respostas = respostas;
	}
	
}