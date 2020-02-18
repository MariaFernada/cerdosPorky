package co.edu.tunja.usta.VentaCerdos.models.DAO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Cerdos.entity.Libro;
import Cerdos.models.DAO.ILibro;
/** 
 * @Desc esta clase implementa el crud de la interface ILibrosService .
 * @CreateAt 23/11/2019
 * @version 1.0
 * @author Laura Fernanda Castillo
 *         Maria Fernanda Molina
 *         Ericka Julieth Sora         
**/

@Service
public class LibroServiceImpl  implements ILibroService{

	/** 
    *  @Autowired es buscar un objeto manejado (beans) que implementen determinada interfaz para hacer 
    *  referencia a él. DE esta manera no es neceario crear una instancia nueva del objeto cada vez que 
    *  se necesite la funcionalidad de determinada clase     
	**/
	@Autowired
	private ILibro libroDAO;
	
	/** 
	 * @Desc el metodo findAll trae una lista de todos los libros, es propio de la interfaz
	 * @CreateAt 23/11/2019
	 * @Trnsaccional cuando una clase declara @Transactional en sí misma o en sus miembros, 
	 * Spring crea un proxy que implementa las mismas interfaces que la clase que está anotando.     
	**/

	 @Transactional(readOnly = true)
	@Override
	public List<Cerdo> findAll() {
		// TODO Auto-generated method stub
		return (List<Cerdo>) libroDAO.findAll();
	}

		/** 
		 * @Desc el metodo save guarda todos los libros que se creen, es propio de la interfaz
		 * @CreateAt 23/11/2019
		 * @Trnsaccional  cuando una clase declara @Transactional en sí misma o en sus miembros, 
	     * Spring crea un proxy que implementa las mismas interfaces que la clase que está anotando.      
		**/

    @Transactional
	@Override
	public void Save(Cerdo libro) {
		libroDAO.save(libro);
		
	}
 
    /** 
	 * @Desc el metodo findOne trae los datos de un libro, por medio del id del libro, es propio de la interfaz
	 * @CreateAt 23/11/2019
	 * @Trnsaccional  cuando una clase declara @Transactional en sí misma o en sus miembros, 
	 * Spring crea un proxy que implementa las mismas interfaces que la clase que está anotando.   
	**/

    @Transactional(readOnly = true)
	@Override
	public Cerdo findOne(Long id) {
		// TODO Auto-generated method stub
		return libroDAO.findById(id).orElse(null);
	}
 
    /** 
	 * @Desc el metodo delete elimina cada libro por medio del id, es propio de la interfaz
	 * @CreateAt 23/11/2019
	 * @Trnsaccional  cuando una clase declara @Transactional en sí misma o en sus miembros, 
	 * Spring crea un proxy que implementa las mismas interfaces que la clase que está anotando.      
	**/

    @Transactional
	@Override
	public void delete(Cerdo libro) {
		libroDAO.delete(libro);		
		
	}
	
	

}