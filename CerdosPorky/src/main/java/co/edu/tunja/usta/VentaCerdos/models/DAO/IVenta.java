package co.edu.tunja.usta.VentaCerdos.models.DAO;

import org.springframework.data.repository.CrudRepository;

import co.edu.tunja.usta.VentaCerdos.entity.Persona;

public interface IVenta extends CrudRepository<Persona, Long>{

}
