
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.EnderecoBC;
import vinicius.ferneda.tcc.certics.business.OrganizacaoSolicitanteBC;
import vinicius.ferneda.tcc.certics.domain.Endereco;
import vinicius.ferneda.tcc.certics.domain.OrganizacaoSolicitanteEntity;
import vinicius.ferneda.tcc.certics.domain.ProfissionalEntity;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./organizacaoSolicitante_list.jsf")
public class OrganizacaoSolicitanteEditMB extends AbstractEditPageBean<OrganizacaoSolicitanteEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OrganizacaoSolicitanteBC organizacaoSolicitanteBC;
	

	@Inject
	private EnderecoBC enderecoBC;
	
	public List<Endereco> getEnderecoList(){
		return enderecoBC.findAll();
	}
			
	private DataModel<ProfissionalEntity> profissionalList;
	
	public void addProfissional() {
		this.getBean().getProfissionais().add(new ProfissionalEntity());
	}
	public void deleteProfissional() {
	   this.getBean().getProfissionais().remove(getProfissionalList().getRowData());
	}
	public DataModel<ProfissionalEntity> getProfissionalList() {
	   if (profissionalList == null) {
		   profissionalList = new ListDataModel<ProfissionalEntity>(this.getBean().getProfissionais());
	   }
	   return profissionalList;
	} 
	
	@Override
	@Transactional
	public String delete() {
		this.organizacaoSolicitanteBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.organizacaoSolicitanteBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.organizacaoSolicitanteBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected OrganizacaoSolicitanteEntity handleLoad(Long id) {
		return this.organizacaoSolicitanteBC.load(id);
	}	
}