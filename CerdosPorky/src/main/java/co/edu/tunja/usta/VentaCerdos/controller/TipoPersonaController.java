package co.edu.tunja.usta.VentaCerdos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.tunja.usta.VentaCerdos.entity.Persona;
import co.edu.tunja.usta.VentaCerdos.entity.TipoPersona;
import co.edu.tunja.usta.VentaCerdos.models.DAO.service.ITipoPersonaService;;
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
public class TipoPersonaController {
	
@Autowired
private ITipoPersonaService tipoPersonaService;

/** 
 * @Desc Este metodo permite listar todos los usuarios que se encuentren en la base de datos.
 * @param model
 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
**/
@GetMapping("/listarTipoPersona")
public String listar(Model model) {
	model.addAttribute("titulo", "Listado de Personas");
	model.addAttribute("personas", tipoPersonaService.findAll());
	//crear persona
	TipoPersona tipoPersona = new TipoPersona();
	model.addAttribute("tipoPersona", tipoPersona);
	return "listarTipoPersona";
	}
/** 
 * @Desc Este metodo permite editar los datos de una persona que se encuentra registrada
 *  en la base de datos
 * @param model, codigo
 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
 * @PathVariable es una anotación Spring que indica que un parámetro de método debe 
 * estar vinculado a una variable de plantilla URI.
**/

@GetMapping("/listarTipoPersona/{id_tipo_persona}")
public String editar(@PathVariable(value = "id_tipo_persona") Long id_tipo_persona, Model model) {
	TipoPersona tipoPersona = null;
	if(id_tipo_persona>0) {
		tipoPersona=tipoPersonaService.findOne(id_tipo_persona);
	}else {
		return "redirect:/listarTipoPersona";
	}
	model.addAttribute("tipoPersona", tipoPersona);
	model.addAttribute("titulo", "Editar Persona");
	return "listarTipoPersona";
	
}

/** 
 * @Desc Este metodo permite eliminar a una persona que se encuentre en la base de datos
 * por medio del codigo
 * @param id
 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
 * @PathVariable es una anotación Spring que indica que un parámetro de método debe 
 * estar vinculado a una variable de plantilla URI.
 * @RequestMapping es una de las anotaciones Spring MVC más utilizadas La 
 * anotación se utiliza para asignar solicitudes web a clases de manejador y / o métodos de manejador específicos.
**/

@RequestMapping("/eliminarTipoPersona/{id_tipo_persona}")
public String eliminar(@PathVariable(value = "id_tipo_persona" )Long id_tipo_persona) {
	if(id_tipo_persona>0) {
		tipoPersonaService.delete(tipoPersonaService.findOne(id_tipo_persona));
	}
	return "redirect:/listarTipoPersona";
}

/** 
 * @Desc Este metodo permite guardar todos las personas que se crean, y se guardan en la base de datos
 * @param persona
 * @PostMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.POST).
 **/
@PostMapping("/listarTipoPersona")
public String gurdar(TipoPersona tipoPersona) {
	tipoPersonaService.Save(tipoPersona);
	return "redirect:/listarPersona";
	
}
}
