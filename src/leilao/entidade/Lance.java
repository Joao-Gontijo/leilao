package leilao.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double valor;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Participante participante;

	public Lance() {

	}

	public Lance(double valor, Participante participante) {
		this.valor = valor;
		this.participante = participante;
	}

	public Lance(double valor) {
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

}
