package co.edu.tunja.usta.VentaCerdos.models.DAO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.tunja.usta.VentaCerdos.entity.TipoPersona;
import co.edu.tunja.usta.VentaCerdos.models.DAO.IPersona;
import co.edu.tunja.usta.VentaCerdos.models.DAO.ITipoPersona;
/** 
 * @Desc esta clase implementa el crud de la interface ILibrosService .
 * @CreateAt 23/11/2019
 * @version 1.0
 * @author Laura Fernanda Castillo
 *         Maria Fernanda Molina
 *         Ericka Julieth Sora         
**/
@Service
public class TipoPersonaServiceImpl implements ITipoPersonaService{

	/** 
	    *  @Autowired es buscar un objeto manejado (beans) que implementen determinada interfaz para hacer 
	    *  referencia a él. DE esta manera no es neceario crear una instancia nueva del objeto cada vez que 
	    *  se necesite la funcionalidad de determinada clase     
    **/
	@Autowired
	private ITipoPersona tipoPersonaDAO;
	

	/** 
	 * @Desc el metodo findAll trae una lista de todas las personas, es propio de la interfaz
	 * @CreateAt 23/11/2019
	 * @Trnsaccional cuando una clase declara @Transactional en sí misma o en sus miembros, 
	 * Spring crea un proxy que implementa las mismas interfaces que la clase que está anotando. 
	 * y cuando es  readOnly = true es porque solo esta de modo lectura     
	**/
	@Transactional(readOnly = true)
	@Override
	public List<TipoPersona> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoPersona>) tipoPersonaDAO.findAll();
	}

	/** 
	 * @Desc el metodo save guarda todas las personas que se creen, es propio de la interfaz
	 * @CreateAt 23/11/2019
	 * @Trnsaccional  cuando una clase declara @Transactional en sí misma o en sus miembros, 
     * Spring crea un proxy que implementa las mismas interfaces que la clase que está anotando.      
	**/
	@Transactional
	@Override
	public void Save(TipoPersona tipoPersona) {
		tipoPersonaDAO.save(tipoPersona);
		
	}
	 /** 
		 * @Desc el metodo findOne trae los datos de una persona, por medio del codigo de la persona, es propio de la interfaz
		 * @CreateAt 23/11/2019
		 * @Trnsaccional  cuando una clase declara @Transactional en sí misma o en sus miembros, 
		 * Spring crea un proxy que implementa las mismas interfaces que la clase que está anotando. 
		 * y cuando es  readOnly = true es porque solo esta de modo lectura 
		**/


	@Transactional(readOnly = true)
	@Override
	public TipoPersona findOne(Long id) {
		// TODO Auto-generated method stub
		return tipoPersonaDAO.findById(id).orElse(null);
	}
	
	/** 
	 * @Desc el metodo delete elimina cada persona por medio del codigo, es propio de la interfaz
	 * @CreateAt 23/11/2019
	 * @Trnsaccional  cuando una clase declara @Transactional en sí misma o en sus miembros, 
	 * Spring crea un proxy que implementa las mismas interfaces que la clase que está anotando.      
	**/
	@Transactional
	@Override
	public void delete(TipoPersona tipoPersona) {
		tipoPersonaDAO.delete(tipoPersona);
	}

}
