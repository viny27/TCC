
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AnexoBC;
import vinicius.ferneda.tcc.certics.business.EvidenciaBC;
import vinicius.ferneda.tcc.certics.domain.Anexo;
import vinicius.ferneda.tcc.certics.domain.Evidencia;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./anexo_list.jsf")
public class AnexoEditMB extends AbstractEditPageBean<Anexo, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AnexoBC anexoBC;
	

	@Inject
	private EvidenciaBC evidenciaBC;
	
	public List<Evidencia> getEvidenciaList(){
		return evidenciaBC.findAll();
	}
			
	
	@Override
	@Transactional
	public String delete() {
		this.anexoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.anexoBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.anexoBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected Anexo handleLoad(Long id) {
		return this.anexoBC.load(id);
	}	
}