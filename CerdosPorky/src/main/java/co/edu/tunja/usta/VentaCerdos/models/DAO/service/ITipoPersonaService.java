package co.edu.tunja.usta.VentaCerdos.models.DAO.service;

import java.util.List;

import co.edu.tunja.usta.VentaCerdos.entity.TipoPersona;

/** 
 * @Desc esta es la interfaz del servicio de persona la cual es una forma de especificar 
 * qué debe hacer una clase sin especificar el cómo.
 * @CreateAt 23/11/2019
 * @version 1.0
 * @author Maria Fernanda Molina
**/

public interface ITipoPersonaService {

	public List<TipoPersona> findAll();
	public void Save(TipoPersona tipoPersona);
	public TipoPersona findOne(Long id);
	public void delete(TipoPersona tipoPersona);
	
}
