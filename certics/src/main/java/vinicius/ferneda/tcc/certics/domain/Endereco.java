package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import vinicius.ferneda.tcc.certics.constant.EnumUF;

@MappedSuperclass
public abstract class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="END_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="END_CEP", nullable=false, length=20)
	private String cep;
	
	@Column(name="END_LOGRADOURO", nullable=false, length=255)
	private String logradouro;
	
	@Column(name="END_NUMERO", length=10)
	private Integer numero;
	
	@Column(name="END_COMPLEMENTO", length=500)
	private String complemento;
	
	@Column(name="END_BAIRRO", length=255)
	private String bairro;
	
	@Column(name="END_CIDADE", nullable=false, length=255)
	private String cidade;
	
	@Enumerated(EnumType.STRING)
	@Column(name="END_UF", nullable=false, length=2)
	private EnumUF uf;
	
	@Column(name="END_PAIS", nullable=false, length=255)
	private String pais;
	
	@JoinColumn(name="PES_ENDID", nullable=false)
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private AvaliadorEntity avaliador;
	
	@JoinColumn(name="PES_ENDID", nullable=false)
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private ProfissionalEntity profissional;
	
	@JoinColumn(name="ORS_ENDID", nullable=false)
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private OrganizacaoSolicitanteEntity organizacaoSolicitante;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public EnumUF getUf() {
		return uf;
	}

	public void setUf(EnumUF uf) {
		this.uf = uf;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public AvaliadorEntity getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(AvaliadorEntity avaliador) {
		this.avaliador = avaliador;
	}

	public ProfissionalEntity getProfissional() {
		return profissional;
	}

	public void setProfissional(ProfissionalEntity profissional) {
		this.profissional = profissional;
	}

	public OrganizacaoSolicitanteEntity getOrganizacaoSolicitante() {
		return organizacaoSolicitante;
	}

	public void setOrganizacaoSolicitante(
			OrganizacaoSolicitanteEntity organizacaoSolicitante) {
		this.organizacaoSolicitante = organizacaoSolicitante;
	}
	
}
