
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.business.EvidenciaEntityBC;
import vinicius.ferneda.tcc.certics.business.RespostaEvidenciaBC;
import vinicius.ferneda.tcc.certics.domain.AnexoEntity;
import vinicius.ferneda.tcc.certics.domain.AreaCompetenciaEntity;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.domain.ConjuntoEvidenciasEntity;
import vinicius.ferneda.tcc.certics.domain.EvidenciaEntity;
import vinicius.ferneda.tcc.certics.domain.EvidenciaProfissionalEntity;
import vinicius.ferneda.tcc.certics.domain.RespostaEvidenciaEntity;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperadoEntity;
import vinicius.ferneda.tcc.certics.persistence.AreaCompetenciaDAO;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./conjuntoEvidencias_list.jsf")
public class ConjuntoEvidenciasEditMB extends AbstractEditPageBean<AvaliacaoEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AvaliacaoBC avaliacaoBC;

	@Inject
	private AreaCompetenciaDAO areaCompetenciaDAO;

	@Inject
	private RespostaEvidenciaBC respostaEvidenciaBC;

	@Inject
	private EvidenciaEntityBC evidenciaBC;

	private DataModel<AreaCompetenciaEntity> lEvidencias;
	
	public DataModel<AreaCompetenciaEntity> getlEvidencias(){
		if(this.lEvidencias == null){
			this.lEvidencias = new ListDataModel<AreaCompetenciaEntity>(areaCompetenciaDAO.findByVersaoCerticsAndAvaliacaoID(this.getId(), this.getBean().getVersaoCertics().getId()));
		}
		return this.lEvidencias;
	}
	
	public List<SelectItem> getEvidenciaList(){
		return this.evidenciaBC.getEvidenciaList();
	}
	
	private DataModel<AnexoEntity> anexoList;

	public void addAnexo() {
		this.getBean().getEvidenciaAux().getAnexos().add(new AnexoEntity());
	}
	public void deleteAnexo() {
	   this.getBean().getEvidenciaAux().getAnexos().remove(getAnexoList().getRowData());
	}
	public DataModel<AnexoEntity> getAnexoList() {
	   if (anexoList == null) {
		   if(this.getBean().getEvidenciaAux() == null){
			   anexoList = new ListDataModel<AnexoEntity>();
		   }else{
			   anexoList = new ListDataModel<AnexoEntity>(this.getBean().getEvidenciaAux().getAnexos());
		   }
	   }
	   return anexoList;
	} 
	
	@Override
	@Transactional
	public String delete() {
		this.avaliacaoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.avaliacaoBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.avaliacaoBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected AvaliacaoEntity handleLoad(Long id) {
		return this.avaliacaoBC.load(id);
	}
	
	public void setConjuntoEvidencias(ConjuntoEvidenciasEntity conjuntoEvidenciasEntity){
		this.getBean().setConjuntoEvidenciasAux(conjuntoEvidenciasEntity);
		this.getBean().setRespostaEvidenciaAux(new RespostaEvidenciaEntity());
	}
	
	public void setNovaEvidencia(){
		this.getBean().setEvidenciaAux(new EvidenciaEntity());
	}

	public void addRespostaEvidencia(){
		this.getBean().getRespostaEvidenciaAux().setConjuntoEvidencias(this.getBean().getConjuntoEvidenciasAux());
		this.respostaEvidenciaBC.insert(this.getBean().getRespostaEvidenciaAux());
	}

	public void setEvidencia(){
		this.evidenciaBC.insert(this.getBean().getEvidenciaAux());
	}
	
	private TreeNode root;
	
	@SuppressWarnings("unused")
	public TreeNode getRoot(){
		List<AreaCompetenciaEntity> lAreaCompetencia = this.areaCompetenciaDAO.findByVersaoCerticsAndAvaliacaoID(this.getId(), this.getBean().getVersaoCertics().getId());
		this.root = new DefaultTreeNode("root", null);
		
		for (AreaCompetenciaEntity areaCompetenciaEntity : lAreaCompetencia) {
			TreeNode areaCompetencia = new DefaultTreeNode(areaCompetenciaEntity, root);
			for (ResultadoEsperadoEntity resultadoEsperadoEntity : areaCompetenciaEntity.getResultadosEsperados()) {
				TreeNode resultadoEsperado = new DefaultTreeNode(resultadoEsperadoEntity, areaCompetencia);
				for (ConjuntoEvidenciasEntity conjuntoEvidenciasEntity : resultadoEsperadoEntity.getConjuntoEvidencias()) {
					TreeNode conjuntoEvidencias = new DefaultTreeNode(conjuntoEvidenciasEntity, resultadoEsperado);
					for (RespostaEvidenciaEntity respostaEvidenciaEntity : conjuntoEvidenciasEntity.getRespostas()) {
						TreeNode respostaEvidencia = new DefaultTreeNode(respostaEvidenciaEntity, conjuntoEvidencias);
						for (EvidenciaProfissionalEntity evidenciaProfissionalEntity : respostaEvidenciaEntity.getProfissionais()) {
							TreeNode evidenciaProfissional = new DefaultTreeNode(evidenciaProfissionalEntity, respostaEvidencia);
						}
					}
				}
			}
		}
		
		return this.root;
	}
}