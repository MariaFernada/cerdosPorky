package co.edu.tunja.usta.VentaCerdos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.tunja.usta.VentaCerdos.entity.Insumo;
import co.edu.tunja.usta.VentaCerdos.models.DAO.service.IInsumoService;


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
public class InsumoController {
	
@Autowired
private IInsumoService insumoService;

/** 
 * @Desc Este metodo permite listar todos los usuarios que se encuentren en la base de datos.
 * @param model
 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
**/
@GetMapping("/listarInsumo")
public String listar(Model model) {
	model.addAttribute("Nombre", "Listado de Insumos");
	model.addAttribute("insumos", insumoService.findAll());
	//crear insumo
	Insumo insumo = new Insumo();
	model.addAttribute("insumo", insumo);
	return "listarinsumo";
	}
/** 
 * @Desc Este metodo permite editar los datos de una Insumo que se encuentra registrada
 *  en la base de datos
 * @param model, codigo
 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
 * @PathVariable es una anotación Spring que indica que un parámetro de método debe 
 * estar vinculado a una variable de plantilla URI.
**/

@GetMapping("/listarInsumo/{id_insumo}")
public String editar(@PathVariable(value = "id_insumo") Long id_insumo, Model model) {
	Insumo insumo = null;
	if(id_insumo>0) {
		insumo=insumoService.findOne(id_insumo);
	}else {
		return "redirect:/listarInsumo";
	}
	model.addAttribute("insumo", insumo);
	model.addAttribute("titulo", "Editar insumo");
	return "listarInsumo";
	
}

/** 
 * @Desc Este metodo permite eliminar a una Insumo que se encuentre en la base de datos
 * por medio del codigo
 * @param id
 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
 * @PathVariable es una anotación Spring que indica que un parámetro de método debe 
 * estar vinculado a una variable de plantilla URI.
 * @RequestMapping es una de las anotaciones Spring MVC más utilizadas La 
 * anotación se utiliza para asignar solicitudes web a clases de manejador y / o métodos de manejador específicos.
**/

@RequestMapping("/eliminarInsumo/{id_insumo}")
public String eliminar(@PathVariable(value = "codigo" )Long id_insumo) {
	if(id_insumo>0) {
		insumoService.delete(insumoService.findOne(id_insumo));
	}
	return "redirect:/listarInsumo";
}

/** 
 * @Desc Este metodo permite guardar todos las Insumos que se crean, y se guardan en la base de datos
 * @param Insumo
 * @PostMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.POST).
 **/
@PostMapping("/listarInsumo")
public String gurdar(Insumo insumo) {
	insumoService.Save(insumo);
	return "redirect:/listarInsumo";
	
}
}
