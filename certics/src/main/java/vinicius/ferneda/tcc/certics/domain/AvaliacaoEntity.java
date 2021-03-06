package vinicius.ferneda.tcc.certics.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import vinicius.ferneda.tcc.certics.constant.EnumPontuacaoAvaliacao;

@Entity
@Table(name="TB_AVALIACAO")
@SequenceGenerator(name="AVA_ID", sequenceName="SEQ_AVA_ID", allocationSize=1)
@NamedQueries({
    @NamedQuery(name="AvaliacaoEntity.findById", 
    		query="SELECT obj "
    				+ " FROM AvaliacaoEntity obj "
    				+ " WHERE obj.id = :id"),
    				
    @NamedQuery(name="AvaliacaoEntity.findByAvaliadorID",
    		query="SELECT obj "
    				+ " FROM AvaliacaoEntity obj "
    				+ " WHERE obj.avaliador.id = :avaliadorID"),

    @NamedQuery(name="AvaliacaoEntity.findByAvaliadorIDDataAtual",
			query="SELECT obj "
					+ " FROM AvaliacaoEntity obj "
					+ " WHERE obj.avaliador.id = :avaliadorID"
					+ "		AND obj.dataAvaliacao <= :dataInicio"),

    @NamedQuery(name="AvaliacaoEntity.findByOrganizacaoIDDataAtual",
		query="SELECT obj "
				+ " FROM AvaliacaoEntity obj "
				+ " WHERE obj.software.organizacaoSolicitante.id = :organizacaoID"
				+ "		AND obj.dataAvaliacao <= :dataInicio")

})
public class AvaliacaoEntity extends Avaliacao {

	private static final long serialVersionUID = 1L;

	public AvaliacaoEntity(){
	}
	
	public AvaliacaoEntity(EnumPontuacaoAvaliacao pontuacao, Date dataAvaliacao, SoftwareEntity software, AvaliadorEntity avaliador, VersaoCerticsEntity versaoCertics) {
		setPontuacao(pontuacao);
		setDataAvaliacao(dataAvaliacao);
		setSoftware(software);
		setAvaliador(avaliador);
		setVersaoCertics(versaoCertics);
	}

	private ConjuntoEvidenciasEntity conjuntoEvidenciasAux;
	private RespostaEvidenciaEntity respostaEvidenciaAux;
	private EvidenciaProfissionalEntity evidenciaProfissionalEntity;
	private EvidenciaEntity evidenciaAux;

	public ConjuntoEvidenciasEntity getConjuntoEvidenciasAux() {
		return conjuntoEvidenciasAux;
	}

	public void setConjuntoEvidenciasAux(ConjuntoEvidenciasEntity conjuntoEvidenciasAux) {
		this.conjuntoEvidenciasAux = conjuntoEvidenciasAux;
	}

	public RespostaEvidenciaEntity getRespostaEvidenciaAux() {
		return respostaEvidenciaAux;
	}

	public void setRespostaEvidenciaAux(RespostaEvidenciaEntity respostaEvidenciaAux) {
		this.respostaEvidenciaAux = respostaEvidenciaAux;
	}
	
	public EvidenciaProfissionalEntity getEvidenciaProfissionalEntity() {
		return evidenciaProfissionalEntity;
	}

	public void setEvidenciaProfissionalEntity(EvidenciaProfissionalEntity evidenciaProfissionalEntity) {
		this.evidenciaProfissionalEntity = evidenciaProfissionalEntity;
	}

	public EvidenciaEntity getEvidenciaAux() {
		return evidenciaAux;
	}

	public void setEvidenciaAux(EvidenciaEntity evidenciaAux) {
		this.evidenciaAux = evidenciaAux;
	}

}
