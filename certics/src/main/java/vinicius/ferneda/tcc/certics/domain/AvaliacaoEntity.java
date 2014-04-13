package vinicius.ferneda.tcc.certics.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import vinicius.ferneda.tcc.certics.constant.EnumPontuacaoAvaliacao;
import vinicius.ferneda.tcc.certics.constant.EnumVersaoCertics;

@Entity
@Table(name="TB_AVALIACAO")
@NamedQueries({
    @NamedQuery(name = "AvaliacaoEntity.findById", query = "SELECT obj FROM AvaliacaoEntity obj WHERE obj.id = :id")
})
public class AvaliacaoEntity extends Avaliacao {

	private static final long serialVersionUID = 1L;

	public AvaliacaoEntity(){
	}
	
	public AvaliacaoEntity(EnumVersaoCertics versaoCertics, EnumPontuacaoAvaliacao pontuacao, Date dataAvaliacao, SoftwareEntity software, AvaliadorEntity avaliador) {
		setVersaoCertics(versaoCertics);
		setPontuacao(pontuacao);
		setDataAvaliacao(dataAvaliacao);
		setSoftware(software);
		setAvaliador(avaliador);
	}
	
}