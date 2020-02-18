package co.edu.tunja.usta.VentaCerdos.models.DAO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.tunja.usta.VentaCerdos.entity.TipoInsumo;
import co.edu.tunja.usta.VentaCerdos.models.DAO.ITipoInsumo;
/** 
 * @Desc esta clase implementa el crud de la interface ILibrosService .
 * @CreateAt 23/11/2019
 * @version 1.0
 * @author Laura Fernanda Castillo
 *         Maria Fernanda Molina
 *         Ericka Julieth Sora         
**/
@Service
public class TipoInsumoServiceImpl implements ITipoInsumoService{

	/** 
	    *  @Autowired es buscar un objeto manejado (beans) que implementen determinada interfaz para hacer 
	    *  referencia a él. DE esta manera no es neceario crear una instancia nueva del objeto cada vez que 
	    *  se necesite la funcionalidad de determinada clase     
    **/
	@Autowired
	private ITipoInsumo tipoInsumoDAO;
	

	/** 
	 * @Desc el metodo findAll trae una lista de todas las TipoInsumos, es propio de la interfaz
	 * @CreateAt 23/11/2019
	 * @Trnsaccional cuando una clase declara @Transactional en sí misma o en sus miembros, 
	 * Spring crea un proxy que implementa las mismas interfaces que la clase que está anotando. 
	 * y cuando es  readOnly = true es porque solo esta de modo lectura     
	**/
	@Transactional(readOnly = true)
	@Override
	public List<TipoInsumo> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoInsumo>) tipoInsumoDAO.findAll();
	}

	/** 
	 * @Desc el metodo save guarda todas las TipoInsumos que se creen, es propio de la interfaz
	 * @CreateAt 23/11/2019
	 * @Trnsaccional  cuando una clase declara @Transactional en sí misma o en sus miembros, 
     * Spring crea un proxy que implementa las mismas interfaces que la clase que está anotando.      
	**/
	@Transactional
	@Override
	public void Save(TipoInsumo tipoInsumo) {
		tipoInsumoDAO.save(tipoInsumo);
		
	}
	 /** 
		 * @Desc el metodo findOne trae los datos de una TipoInsumo, por medio del codigo de la TipoInsumo, es propio de la interfaz
		 * @CreateAt 23/11/2019
		 * @Trnsaccional  cuando una clase declara @Transactional en sí misma o en sus miembros, 
		 * Spring crea un proxy que implementa las mismas interfaces que la clase que está anotando. 
		 * y cuando es  readOnly = true es porque solo esta de modo lectura 
		**/


	@Transactional(readOnly = true)
	@Override
	public TipoInsumo findOne(Long id) {
		// TODO Auto-generated method stub
		return tipoInsumoDAO.findById(id).orElse(null);
	}
	
	/** 
	 * @Desc el metodo delete elimina cada TipoInsumo por medio del codigo, es propio de la interfaz
	 * @CreateAt 23/11/2019
	 * @Trnsaccional  cuando una clase declara @Transactional en sí misma o en sus miembros, 
	 * Spring crea un proxy que implementa las mismas interfaces que la clase que está anotando.      
	**/
	@Transactional
	@Override
	public void delete(TipoInsumo tipoInsumo) {
		tipoInsumoDAO.delete(tipoInsumo);
	}

	

}
