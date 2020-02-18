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
 *         
 *              
**/

@Entity
@Table(name="proveedor")
public class Proveedor implements Serializable {

	/**
	 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_proveedor")
	
	private Long id_proveedor;
	
	@Column(name="nombre_proveedor")
	@NotBlank
	private String nombre_proveedor;

	
	@Column(name = "nit")
	@NotBlank
	private String nit;
	
	@Column(name = "telefono")
	@NotBlank
	private String telefono;

	public Long getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(Long id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getNombreProveedor() {
		return nombre_proveedor;
	}

	public void setNombreProveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
				

}
