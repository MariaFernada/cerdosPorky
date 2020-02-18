package co.edu.tunja.usta.VentaCerdos.models.DAO.service;

import java.util.List;

import co.edu.tunja.usta.VentaCerdos.entity.Cerdo;

/** 
 * @Desc esta es la interfaz del servicio del libro la cual es una forma de especificar 
 * qué debe hacer una clase sin especificar el cómo.
 * @CreateAt 23/11/2019
 * @version 1.0
 * @author Ericka Julieth Sora         
**/

public interface ICerdoService {

	public List<Cerdo> findAll();
	public void Save(Cerdo cerdo);
	public Cerdo findOne(Long id);
	public void delete(Cerdo cerdo);
	
}
