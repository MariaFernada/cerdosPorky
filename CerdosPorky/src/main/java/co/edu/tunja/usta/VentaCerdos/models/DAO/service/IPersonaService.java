package co.edu.tunja.usta.VentaCerdos.models.DAO.service;

import java.util.List;

import co.edu.tunja.usta.VentaCerdos.entity.Persona;

/** 
 * @Desc esta es la interfaz del servicio de persona la cual es una forma de especificar 
 * qué debe hacer una clase sin especificar el cómo.
 * @CreateAt 23/11/2019
 * @version 1.0
 * @author Maria Fernanda Molina
**/

public interface IPersonaService {

	public List<Persona> findAll();
	public void Save(Persona persona);
	public Persona findOne(Long id);
	public void delete(Persona persona);
	
}
