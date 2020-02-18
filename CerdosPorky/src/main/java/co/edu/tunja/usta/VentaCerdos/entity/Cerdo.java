package co.edu.tunja.usta.VentaCerdos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
/** 
 * @Desc esta entidad hace referencia a la tabla de la base de datos llamada libro.
 * @CreateAt 23/11/2019
 * @version 1.0
 * @author Laura Fernanda Castillo
 *         Maria Fernanda Molina
 *         Ericka Julieth Sora         
**/
@Table(name="cerdo")
@Entity
public class Cerdo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id_cerdo")
	private Long idCerdo;
	
	
	@Column(name="peso")
	@NotBlank

	private long peso;
	
	@Column(name="edad")
	@NotBlank
	private long edad;
	
	@Column(name="raza")
	@NotBlank
	private String raza;
	
	@Column(name="id_insumo")
	@NotBlank
	private long id_insumo;

	public Long getIdCerdo() {
		return idCerdo;
	}

	public void setIdCerdo(Long idCerdo) {
		this.idCerdo = idCerdo;
	}

	public long getPeso() {
		return peso;
	}

	public void setPeso(long peso) {
		this.peso = peso;
	}

	public long getEdad() {
		return edad;
	}

	public void setEdad(long edad) {
		this.edad = edad;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public long getId_Insumo() {
		return id_insumo;
	}

	public void setId_Insumo(long id_insumo) {
		this.id_insumo = id_insumo;
	}

	
}
