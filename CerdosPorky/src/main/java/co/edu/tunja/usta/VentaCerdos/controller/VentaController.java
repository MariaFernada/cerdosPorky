package co.edu.tunja.usta.VentaCerdos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.tunja.usta.VentaCerdos.entity.*;
import co.edu.tunja.usta.VentaCerdos.models.DAO.service.*;

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
public class VentaController {

	/** 
	 * @Desc Este metodo permite listar todos los ventas que se encuentren en la base de datos con 
	 * sus respectivos atributos.
	 * @param model
	 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
	**/
	
	@Autowired
	private IVentaService ventaService;
	
	@GetMapping({"/listarVenta"})
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de ventas");
		model.addAttribute("ventas", ventaService.findAll());
		//crear venta
		Venta venta =new Venta();
		model.addAttribute("venta", venta);
		return "listarVenta";
	}
	
	/** 
	 * @Desc Este metodo permite editar un venta que se encuentre en la base de datos, 
	 * este es llamado por su id.
	 * @param model, id
	 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
	 * @PathVariable es una anotación Spring que indica que un parámetro de método debe 
	 * estar vinculado a una variable de plantilla URI.
	**/
	@GetMapping("/listarventa/{id_venta}")
	public String editar(@PathVariable(value = "id_venta") Long id_venta, Model model) {
		Venta venta = null;
		if(id_venta>0) {
			venta=ventaService.findOne(id_venta);
		}else {
			return "redirect:/listarventa";
		}
		model.addAttribute("venta", venta);
		model.addAttribute("titulo", "Editar venta");
		return "listarventa";
	}
	/** 
	 * @Desc Este metodo permite eliminar un venta que se encuentre en la base de datos
	 * por medio del id
	 * @param id
	 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
	 * @PathVariable es una anotación Spring que indica que un parámetro de método debe 
	 * estar vinculado a una variable de plantilla URI.
	 * @RequestMapping es una de las anotaciones Spring MVC más utilizadas La 
	 * anotación se utiliza para asignar solicitudes web a clases de manejador y / o métodos de manejador específicos.
	**/
	
	@RequestMapping("/eliminarventa/{id_ventad}")
	public String eliminar(@PathVariable(value = "id_venta" )Long id_venta) {
		if(id_venta>0) {
			ventaService.delete(ventaService.findOne(id_venta));
		}
		return "redirect:/listarventa";
	}
	
	/** 
	 * @Desc Este metodo permite guardar todos los prestao que se crean, y se guardan en la base de datos
	 * @param venta
	 * @PostMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.POST).
	 **/
	
	@PostMapping("/listarVenta")
	public String gurdar(Venta venta) {
		System.out.print(venta);
		ventaService.Save(venta);
		
		return "redirect:/listarventa";
		
	}
}
