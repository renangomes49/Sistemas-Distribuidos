package pojos;

import java.io.Serializable;

public class Partida implements Serializable {
	private static final long serialVersionUID = 1L;

	private Time time1;
	private Time time2;
	private Time vencedor;
	private String estadio;
	private String data;
	private String horario;

	public Partida() {

	}
	
	public Partida(Time time1, Time time2, Time vencedor, String estadio, String data, String horario) {
		this.time1 = time1;
		this.time2 = time2;
		this.vencedor = vencedor;
		this.estadio = estadio;
		this.data = data;
		this.horario = horario;
	}
	
	public Partida(String estadio, String data, String horario) {
		this.estadio = estadio;
		this.data = data;
		this.horario = horario;
	}

	public Time getTime1() {
		return time1;
	}

	public void setTime1(Time time1) {
		this.time1 = time1;
	}

	public Time getTime2() {
		return time2;
	}

	public void setTime2(Time time2) {
		this.time2 = time2;
	}

	public Time getVencedor() {
		return vencedor;
	}

	public void setVencedor(Time vencedor) {
		this.vencedor = vencedor;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "Partida [time1=" + time1 + ", time2=" + time2 + ", vencedor=" + vencedor + ", estadio=" + estadio
				+ ", data=" + data + ", horario=" + horario + "]";
	}
	
	

}
