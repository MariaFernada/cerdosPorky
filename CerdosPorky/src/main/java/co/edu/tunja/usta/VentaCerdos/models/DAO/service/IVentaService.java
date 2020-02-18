package co.edu.tunja.usta.VentaCerdos.models.DAO.service;

import java.util.List;

import co.edu.tunja.usta.VentaCerdos.entity.*;
/** 
 * @Desc esta es la interfaz del servicio del libro la cual es una forma de especificar 
 * qué debe hacer una clase sin especificar el cómo.
 * @CreateAt 23/11/2019
 * @version 1.0
 * @author Laura Fernanda Castillo       
**/

public interface IVentaService {
	
	public List<Venta> findAll();
	public void Save(Venta prestamo);
	public Venta findOne(Long id);
	public void delete(Venta id);
	

}
