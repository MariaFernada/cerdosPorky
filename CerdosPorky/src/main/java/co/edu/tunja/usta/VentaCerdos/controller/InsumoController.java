package co.edu.tunja.usta.VentaCerdos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.tunja.usta.VentaCerdos.entity.Persona;
import co.edu.tunja.usta.VentaCerdos.models.DAO.service.IPersonaService;;
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
private IPersonaService personaService;

/** 
 * @Desc Este metodo permite listar todos los usuarios que se encuentren en la base de datos.
 * @param model
 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
**/
@GetMapping("/listarPersona")
public String listar(Model model) {
	model.addAttribute("titulo", "Listado de Personas");
	model.addAttribute("personas", personaService.findAll());
	//crear persona
	Persona persona = new Persona();
	model.addAttribute("persona", persona);
	return "listarPersona";
	}
/** 
 * @Desc Este metodo permite editar los datos de una persona que se encuentra registrada
 *  en la base de datos
 * @param model, codigo
 * @GetMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.GET).
 * @PathVariable es una anotación Spring que indica que un parámetro de método debe 
 * estar vinculado a una variable de plantilla URI.
**/

@GetMapping("/listarPersona/{id_persona}")
public String editar(@PathVariable(value = "codigo") Long id_persona, Model model) {
	Persona persona = null;
	if(id_persona>0) {
		persona=personaService.findOne(id_persona);
	}else {
		return "redirect:/listarPersona";
	}
	model.addAttribute("persona", persona);
	model.addAttribute("titulo", "Editar Persona");
	return "listarPersona";
	
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

@RequestMapping("/eliminarPersona/{codigo}")
public String eliminar(@PathVariable(value = "codigo" )Long codigo) {
	if(codigo>0) {
		personaService.delete(personaService.findOne(codigo));
	}
	return "redirect:/listarPersona";
}

/** 
 * @Desc Este metodo permite guardar todos las personas que se crean, y se guardan en la base de datos
 * @param persona
 * @PostMappinges una anotación compuesta que actúa como un atajo para @RequestMapping(method = RequestMethod.POST).
 **/
@PostMapping("/listarPersona")
public String gurdar(Persona persona) {
	personaService.Save(persona);
	return "redirect:/listarPersona";
	
}
}
