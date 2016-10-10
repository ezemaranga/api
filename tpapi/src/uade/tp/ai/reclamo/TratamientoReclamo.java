package uade.tp.ai.reclamo;

public class TratamientoReclamo {

	private String fecha;
	private String estado;
	private String desc;

	public TratamientoReclamo(String fecha, String estado, String desc) {
		super();
		this.fecha = fecha;
		this.estado = estado;
		this.desc = desc;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
