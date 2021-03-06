package leilao.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Lance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private double valor;

	@ManyToOne
	private Participante participante;

	
	@ManyToOne
	private Leilao leilao;
	
	@Transient
	private String p;
	
	public Lance() {
	}
	
	public Lance(double valor, Participante participante) {
		this.valor = valor;
		this.participante = participante;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
	public Leilao getLeilao() {
		return leilao;
	}
	
	public void setLeilao(Leilao leilao) {
		this.leilao = leilao;
	}
}