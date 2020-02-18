package co.edu.tunja.usta.VentaCerdos.models.DAO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Cerdos.entity.Prestamo;
import Cerdos.models.DAO.IPrestamo;
/** 
 * @Desc esta clase implementa el crud de la interface ILibrosService .
 * @CreateAt 23/11/2019
 * @version 1.0
 * @author Laura Fernanda Castillo
 *         Maria Fernanda Molina
 *         Ericka Julieth Sora         
**/
@Service
public class PrestamoServiceImpl implements IPrestamoService{
 
	/** 
	    *  @Autowired es buscar un objeto manejado (beans) que implementen determinada interfaz para hacer 
	    *  referencia a él. DE esta manera no es neceario crear una instancia nueva del objeto cada vez que 
	    *  se necesite la funcionalidad de determinada clase     
    **/
	@Autowired
	private IPrestamo prestamoDAO;
	
	/** 
	 * @Desc el metodo findAll trae una lista de todos los prestamos, es propio de la interfaz
	 * @CreateAt 23/11/2019
	 * @Trnsaccional cuando una clase declara @Transactional en sí misma o en sus miembros, 
	 * Spring crea un proxy que implementa las mismas interfaces que la clase que está anotando. 
	 * y cuando es  readOnly = true es porque solo esta de modo lectura     
	**/
    @Transactional(readOnly = true)
	@Override
	public List<Venta> findAll() {
		// TODO Auto-generated method stub
		return (List<Venta>) prestamoDAO.findAll();
	}
    /** 
	 * @Desc el metodo save guarda todos los prestamos que se creen, es propio de la interfaz
	 * @CreateAt 23/11/2019
	 * @Trnsaccional  cuando una clase declara @Transactional en sí misma o en sus miembros, 
	**/

    @Transactional
	@Override
	public void Save(Venta prestamo) {
		prestamoDAO.save(prestamo);
	}
    /** 
   	 * @Desc el metodo findOne trae los datos de un prestamo, por medio del id del prestamo, es propio de la interfaz
   	 * @CreateAt 23/11/2019
   	 * @Trnsaccional  cuando una clase declara @Transactional en sí misma o en sus miembros, 
   	 * Spring crea un proxy que implementa las mismas interfaces que la clase que está anotando.  
   	 *  y cuando es  readOnly = true es porque solo esta de modo lectura  
   	**/

    @Transactional(readOnly = true)
	@Override
	public Venta findOne(Long id) {
		return prestamoDAO.findById(id).orElse(null);
	}

    /** 
   	 * @Desc el metodo delete elimina cada prestamo por medio del id, es propio de la interfaz
   	 * @CreateAt 23/11/2019
   	 * @Trnsaccional  cuando una clase declara @Transactional en sí misma o en sus miembros, 
   	 * Spring crea un proxy que implementa las mismas interfaces que la clase que está anotando.      
   	**/

    @Transactional
	@Override
	public void delete(Venta prestamo) {
		prestamoDAO.delete(prestamo);
	}

}
