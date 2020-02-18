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
@Table(name="insumo")
public class Insumo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_insumo")
	
	private Long id_insumo;
	
	@Column(name="nombre_insumo")
	@NotBlank
	private String nombre_insumo;
	
	@Column(name="id_proveedor")
	@NotBlank
	private long id_proveedor;
	
	@Column(name="id_cerdo")
	@NotBlank
	private long id_cerdo;
	
	@Column(name="cantidad_stock")
	@NotBlank
	private long cantidad_stock;

	@Column(name="valor")
	@NotBlank
	private long valor;
	
	public Long getId_insumo() {
		return id_insumo;
	}
	
	public void setId_insumo(Long id_insumo) {
		this.id_insumo = id_insumo;
	}

	public Long getId_proveedor() {
		return id_proveedor;		
	}
	
	
	public void setId_cerdo(Long id_cerdo) {
		this.id_cerdo = id_cerdo;
	}

	public Long getId_cerdo() {
		return id_cerdo;		
	}
	public void setId_proveedor(Long id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
				

}