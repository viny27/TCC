package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import vinicius.ferneda.tcc.certics.constant.EnumVersaoCertics;

@Entity
@Table(name="TB_AREA_COMPETENCIA")
@SequenceGenerator(name="ARC_ID", sequenceName="ARC_ID")
@NamedQueries({
    @NamedQuery(name = "AreaCompetenciaEntity.findById", query = "SELECT obj FROM AreaCompetenciaEntity obj WHERE obj.id = :id")
})
public class AreaCompetenciaEntity extends AreaCompetencia {

	private static final long serialVersionUID = 1L;
	
	public AreaCompetenciaEntity(){
	}
	
	public AreaCompetenciaEntity(String titulo, String perguntaChave, String descricao, EnumVersaoCertics versaoCertics) {
		setTitulo(titulo);
		setPerguntaChave(perguntaChave);
		setDescricao(descricao);
		setVersaoCertics(versaoCertics);
	}
}
