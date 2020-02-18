package co.edu.tunja.usta.VentaCerdos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/** 
 * @Desc esta entidad hace referencia a la tabla de la base de datos llamada persona.
 * @CreateAt 23/11/2019
 * @version 1.0
 * @author Laura Fernanda Castillo
 *         Maria Fernanda Molina
 *         Ericka Julieth Sora    
 *         
 *            ID_TIPO_PERSONA      int not null,
   NOMBRE_TIPO_PERSONA  char(30),  
**/

@Entity
@Table(name="TipoPersona")
public class TipoPersona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_TipoPersona")
	
	private Long id_TipoPersona;
	
	@Column(name="nombre_tipoPersona")
	@NotBlank
	private String nombre_tipoPersona;
	
	

	public Long getId_TipoPersona() {
		return id_TipoPersona;
	}

	public void setId_persona(Long id_TipoPersona) {
		this.id_TipoPersona = id_TipoPersona;
	}

	public String getNombre_TipoPersona() {
		return nombre_tipoPersona;
	}

	public void setNombre_TipoPersona(String nombre_TipoPersona) {
		this.nombre_tipoPersona = nombre_TipoPersona;
	}

	

}

