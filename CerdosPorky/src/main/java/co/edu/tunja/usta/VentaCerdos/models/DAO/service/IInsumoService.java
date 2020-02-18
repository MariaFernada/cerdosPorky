package co.edu.tunja.usta.VentaCerdos.models.DAO.service;

import java.util.List;

import co.edu.tunja.usta.VentaCerdos.entity.*;

/** 
 * @Desc esta es la interfaz del servicio del libro la cual es una forma de especificar 
 * qué debe hacer una clase sin especificar el cómo.
 * @CreateAt 23/11/2019
 * @version 1.0
 * @author      
**/

public interface IInsumoService {
	
	public List<Insumo> findAll();
	public void Save(Insumo insumo);
	public Insumo findOne(Long id_insumo);
	public void delete(Insumo id_insumo);
	

}
