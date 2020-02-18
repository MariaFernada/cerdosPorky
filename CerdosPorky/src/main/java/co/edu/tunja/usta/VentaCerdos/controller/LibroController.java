package co.edu.tunja.usta.VentaCerdos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Cerdos.entity.Libro;
import Cerdos.models.DAO.service.ILibroService;

/** 
 * @Desc Esta es una clase Controller que permite gestionar los datos que se enviaran 
 * 			desde la Interfaz del Servicio a la vista html
 * @CreateAt 23/11/2019
 * @version 1.0
 * @author Laura Fernanda Castillo
 *         Maria Fernanda Molina
 *         Ericka Julieth Sora         
 * @required Interfaz Service
**/

@Controller
public class LibroController {
	
	@Autowired
	private ILibroService libroService;
	/** 
	 * @Desc Este metodo permite listar todos los libros que se encuentren en la base de datos con 
	 * sus respectivos atributos.
	 * @param model
	 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
	 * indica la ruta url que se debe escribir en el navegador para poder ingresar a la vista.
	 * - La clase Model permite enviar datos de las clases java a las vistas html
	**/
	
	@GetMapping({"/listarLibro","","/"})
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Libros");
		model.addAttribute("libros", libroService.findAll());
		//crear libro
		Cerdo libro =new Cerdo();
		model.addAttribute("libro", libro);
		return "listarLibro";
	}
	
	/** 
	 * @Desc Este metodo permite editar un libro que se encuentre en la base de datos, 
	 * este es llamado por su id.
	 * @param model
	 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
	 * @PathVariable es una anotación Spring que indica que un parámetro de método debe 
	 * estar vinculado a una variable de plantilla URI.
	**/
	
	@GetMapping("/listarLibro/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {
		Cerdo libro = null;
		if(id>0) {
			libro=libroService.findOne(id);
		}else {
			return "redirect:/listarLibro";
		}
		model.addAttribute("libro", libro);
		model.addAttribute("titulo", "Editar Libro");
		return "listarLibro";
	}
	
	/** 
	 * @Desc Este metodo permite eliminar un libro que se encuentre en la base de datos
	 * por medio del id
	 * @param id
	 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
	 * @PathVariable es una anotación Spring que indica que un parámetro de método debe 
	 * estar vinculado a una variable de plantilla URI.
	 * @RequestMapping es una de las anotaciones Spring MVC más utilizadas La 
	 * anotación se utiliza para asignar solicitudes web a clases de manejador y / o métodos de manejador específicos.
	**/
	
	@RequestMapping("/eliminarLibro/{id}")
	public String eliminar(@PathVariable(value = "id" )Long id) {
		if(id>0) {
			libroService.delete(libroService.findOne(id));
		}
		return "redirect:/listarLibro";
	}
	
	/** 
	 * @Desc Este metodo permite guardar todos los libros que se crean, y se guardan en la base de datos
	 * @param libro
	 * @PostMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.POST).
	 **/
	
	
	@PostMapping("/listarLibro")
	public String gurdar(Cerdo libro) {
		libroService.Save(libro);
		return "redirect:/listarLibro";
		
	}
}
