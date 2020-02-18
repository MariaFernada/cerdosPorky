package co.edu.tunja.usta.VentaCerdos.entity;
import java.io.Serializable;
import java.util.Date;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
/** 
 * @Desc esta entidad hace referencia a la tabla de la base de datos llamada prestamo.
 * @CreateAt 23/11/2019
 * @version 1.0
 * @author Laura Fernanda Castillo
 *         Maria Fernanda Molina
 *         Ericka Julieth Sora         
**/

@Entity
@Table(name="venta")
public class Venta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_venta")
	private Long idVenta;
	
	@Column(name="id_cerdo")
	private Long idCerdo;
	
	@Column(name="id_persona")
	private Long idPersona;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyy-MM-dd")
	@Column(name="fecha_venta")

	private Date fechaVenta;
		
	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public Long getIdCerdo() {
		return idCerdo;
	}
	public void setIdCerdo(Long idCerdo) {
		this.idCerdo = idCerdo;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}



	

}
