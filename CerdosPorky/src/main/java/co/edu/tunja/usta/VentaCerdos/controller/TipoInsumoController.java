package co.edu.tunja.usta.VentaCerdos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.tunja.usta.VentaCerdos.entity.TipoInsumo;
import co.edu.tunja.usta.VentaCerdos.models.DAO.service.ITipoInsumoService;
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
public class TipoInsumoController {
	
@Autowired
private ITipoInsumoService tipoInsumoService;

/** 
 * @Desc Este metodo permite listar todos los usuarios que se encuentren en la base de datos.
 * @param model
 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
**/
@GetMapping("/listartipoInsumo")
public String listar(Model model) {
	model.addAttribute("titulo", "Listado de tipoInsumos");
	model.addAttribute("tipoInsumos", tipoInsumoService.findAll());
	//crear tipoInsumo
	TipoInsumo tipoInsumo = new TipoInsumo();
	model.addAttribute("tipoInsumo", tipoInsumo);
	return "listartipoInsumo";
	}
/** 
 * @Desc Este metodo permite editar los datos de una tipoInsumo que se encuentra registrada
 *  en la base de datos
 * @param model, codigo
 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
 * @PathVariable es una anotación Spring que indica que un parámetro de método debe 
 * estar vinculado a una variable de plantilla URI.
**/

@GetMapping("/listartipoInsumo/{id_Tipo_Insumo}")
public String editar(@PathVariable(value = "id_Tipo_Insumo") Long id_Tipo_Insumo, Model model) {
	TipoInsumo tipoInsumo = null;
	if(id_Tipo_Insumo>0) {
		tipoInsumo=tipoInsumoService.findOne(id_Tipo_Insumo);
	}else {
		return "redirect:/listartipoInsumo";
	}
	model.addAttribute("tipoInsumo", tipoInsumo);
	model.addAttribute("titulo", "Editar Insumo");
	return "listartipoInsumo";
	
}

/** 
 * @Desc Este metodo permite eliminar a una tipoInsumo que se encuentre en la base de datos
 * por medio del codigo
 * @param id
 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
 * @PathVariable es una anotación Spring que indica que un parámetro de método debe 
 * estar vinculado a una variable de plantilla URI.
 * @RequestMapping es una de las anotaciones Spring MVC más utilizadas La 
 * anotación se utiliza para asignar solicitudes web a clases de manejador y / o métodos de manejador específicos.
**/

@RequestMapping("/eliminartipoInsumo/{id_Tipo_Insumo}")
public String eliminar(@PathVariable(value = "id_Tippo_Insumo" )Long id_Tippo_Insumo) {
	if(id_Tippo_Insumo>0) {
		tipoInsumoService.delete(tipoInsumoService.findOne(id_Tippo_Insumo));
	}
	return "redirect:/listartipoInsumo";
}

/** 
 * @Desc Este metodo permite guardar todos las tipoInsumos que se crean, y se guardan en la base de datos
 * @param tipoInsumo
 * @PostMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.POST).
 **/
@PostMapping("/listartipoInsumo")
public String gurdar(TipoInsumo tipoInsumo) {
	tipoInsumoService.Save(tipoInsumo);
	return "redirect:/listartipoInsumo";
	
}
}
