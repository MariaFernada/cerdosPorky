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
**/

@Entity
@Table(name="TipoInsumo")
public class TipoInsumo implements Serializable {

	/**
	 * 	
	 */
	private static final long serialVersionUID = 1L;
	

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipoInsumo")
	
	private Long id_tipoInsumo;
	
	@Column(name="nombre_tipoInsumo")
	@NotBlank
	private String nombre_tipoInsumo;
	
	@Column(name="id_insumo")
	@NotBlank
	private long id_insumo;
	
	public Long getId_tipoInsumo() {
		return id_insumo;
	}
	
	public void setId_tipoInsumo(Long id_tipoInsumo) {
		this.id_tipoInsumo = id_tipoInsumo;
	}
	
	public String getNombreTipoInsumo() {
		return nombre_tipoInsumo;
	}

	public void setNombreTipoInsumo(String nombre_tipoInsumo) {
		this.nombre_tipoInsumo = nombre_tipoInsumo;
	}
	
	public Long getId_insumo() {
		return id_insumo;
	}
	
	public void setId_insumo(Long id_insumo) {
		this.id_insumo = id_insumo;
	}
	
	}
