

package vinicius.ferneda.tcc.certics.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import vinicius.ferneda.tcc.certics.domain.Anexo;
import vinicius.ferneda.tcc.certics.domain.AnexoEntity;
import vinicius.ferneda.tcc.certics.domain.EvidenciaEntity;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class AnexoBCTest {

    @Inject
	private AnexoBC anexoBC;
	
	@Before
	public void before() {
		for (Anexo anexo : anexoBC.findAll()) {
			anexoBC.delete(anexo.getId());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		AnexoEntity anexo = new AnexoEntity("anexo", new byte[]{}, new EvidenciaEntity());
		anexoBC.insert(anexo);
		List<AnexoEntity> listOfAnexo = anexoBC.findAll();
		assertNotNull(listOfAnexo);
		assertEquals(1, listOfAnexo.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		AnexoEntity anexo = new AnexoEntity("anexo", new byte[]{}, new EvidenciaEntity());
		anexoBC.insert(anexo);
		
		List<AnexoEntity> listOfAnexo = anexoBC.findAll();
		assertNotNull(listOfAnexo);
		assertEquals(1, listOfAnexo.size());
		
		anexoBC.delete(anexo.getId());
		listOfAnexo = anexoBC.findAll();
		assertEquals(0, listOfAnexo.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		AnexoEntity anexo = new AnexoEntity("anexo", new byte[]{}, new EvidenciaEntity());
		anexoBC.insert(anexo);
		
		List<AnexoEntity> listOfAnexo = anexoBC.findAll();
		AnexoEntity anexo2 = (AnexoEntity)listOfAnexo.get(0);
		assertNotNull(listOfAnexo);

		// alterar para tratar uma propriedade existente na Entidade Anexo
		// anexo2.setUmaPropriedade("novo valor");
		anexoBC.update(anexo2);
		
		listOfAnexo = anexoBC.findAll();
		AnexoEntity anexo3 = (AnexoEntity)listOfAnexo.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade Anexo
		assertEquals("novo valor", anexo3.getArquivo());
	}

}