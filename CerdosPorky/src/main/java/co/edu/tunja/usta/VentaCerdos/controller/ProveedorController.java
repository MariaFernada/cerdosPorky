package co.edu.tunja.usta.VentaCerdos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.tunja.usta.VentaCerdos.entity.Proveedor;
import co.edu.tunja.usta.VentaCerdos.models.DAO.service.IProveedorService;;
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
public class ProveedorController {
	
@Autowired
private IProveedorService proveedorService;

/** 
 * @Desc Este metodo permite listar todos los usuarios que se encuentren en la base de datos.
 * @param model
 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
**/
@GetMapping("/listarProveedor")
public String listar(Model model) {
	model.addAttribute("titulo", "Listado de Proveedores");
	model.addAttribute("proveedor", proveedorService.findAll());
	//crear proveedor
	Proveedor proveedor = new Proveedor();
	model.addAttribute("proveedor", proveedor);
	return "listarProveedores";
	}
/** 
 * @Desc Este metodo permite editar los datos de una Proveedor que se encuentra registrada
 *  en la base de datos
 * @param model, codigo
 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
 * @PathVariable es una anotación Spring que indica que un parámetro de método debe 
 * estar vinculado a una variable de plantilla URI.
**/

@GetMapping("/listarProveedor/{id_proveedor}")
public String editar(@PathVariable(value = "id_proveedor") Long id_proveedor, Model model) {
	Proveedor proveedor = null;
	if(id_proveedor>0) {
		proveedor=proveedorService.findOne(id_proveedor);
	}else {
		return "redirect:/listarProveedor";
	}
	model.addAttribute("proveedor", proveedor);
	model.addAttribute("titulo", "Editar Proveedor");
	return "listarProveedores";
	
}

/** 
 * @Desc Este metodo permite eliminar a una Proveedor que se encuentre en la base de datos
 * por medio del codigo
 * @param id
 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
 * @PathVariable es una anotación Spring que indica que un parámetro de método debe 
 * estar vinculado a una variable de plantilla URI.
 * @RequestMapping es una de las anotaciones Spring MVC más utilizadas La 
 * anotación se utiliza para asignar solicitudes web a clases de manejador y / o métodos de manejador específicos.
**/

@RequestMapping("/eliminarProveedor/{id_provedor}")
public String eliminar(@PathVariable(value = "id_proveedor" )Long id_proveedor) {
	if(id_proveedor>0) {
		proveedorService.delete(proveedorService.findOne(id_proveedor));
	}
	return "redirect:/listarProveedor";
}

/** 
 * @Desc Este metodo permite guardar todos las Proveedors que se crean, y se guardan en la base de datos
 * @param Proveedor
 * @PostMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.POST).
 **/
@PostMapping("/listarProveedor")
public String gurdar(Proveedor proveedor) {
	proveedorService.Save(proveedor);
	return "redirect:/listarProveedor";
	
}
}
