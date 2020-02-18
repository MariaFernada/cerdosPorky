package co.edu.tunja.usta.VentaCerdos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Cerdos.entity.Prestamo;
import Cerdos.models.DAO.service.IPrestamoService;
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
public class PrestamoController {

	/** 
	 * @Desc Este metodo permite listar todos los prestamos que se encuentren en la base de datos con 
	 * sus respectivos atributos.
	 * @param model
	 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
	**/
	
	@Autowired
	private IPrestamoService prestamoService;
	
	@GetMapping({"/listarPrestamo"})
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Prestamos");
		model.addAttribute("prestamos", prestamoService.findAll());
		//crear prestamo
		Venta prestamo =new Venta();
		model.addAttribute("prestamo", prestamo);
		return "listarPrestamo";
	}
	
	/** 
	 * @Desc Este metodo permite editar un prestamo que se encuentre en la base de datos, 
	 * este es llamado por su id.
	 * @param model, id
	 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
	 * @PathVariable es una anotación Spring que indica que un parámetro de método debe 
	 * estar vinculado a una variable de plantilla URI.
	**/
	@GetMapping("/listarPrestamo/{id}")
	public String editar(@PathVariable(value = "id") Long id, Model model) {
		Venta prestamo = null;
		if(id>0) {
			prestamo=prestamoService.findOne(id);
		}else {
			return "redirect:/listarPrestamo";
		}
		model.addAttribute("prestamo", prestamo);
		model.addAttribute("titulo", "Editar prestamo");
		return "listarPrestamo";
	}
	/** 
	 * @Desc Este metodo permite eliminar un prestamo que se encuentre en la base de datos
	 * por medio del id
	 * @param id
	 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
	 * @PathVariable es una anotación Spring que indica que un parámetro de método debe 
	 * estar vinculado a una variable de plantilla URI.
	 * @RequestMapping es una de las anotaciones Spring MVC más utilizadas La 
	 * anotación se utiliza para asignar solicitudes web a clases de manejador y / o métodos de manejador específicos.
	**/
	
	@RequestMapping("/eliminarPrestamo/{id}")
	public String eliminar(@PathVariable(value = "id" )Long id) {
		if(id>0) {
			prestamoService.delete(prestamoService.findOne(id));
		}
		return "redirect:/listarPrestamo";
	}
	
	/** 
	 * @Desc Este metodo permite guardar todos los prestao que se crean, y se guardan en la base de datos
	 * @param prestamo
	 * @PostMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.POST).
	 **/
	
	@PostMapping("/listarPrestamo")
	public String gurdar(Venta prestamo) {
		System.out.print(prestamo);
		prestamoService.Save(prestamo);
		
		return "redirect:/listarPrestamo";
		
	}
}
