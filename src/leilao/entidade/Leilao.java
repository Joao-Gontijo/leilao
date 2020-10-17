package leilao.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Leilao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	private String descricao, dataCriacao, situacao;
//	private double valorInicial, valorArremate;
	
	@Transient
	private List<Lance> lances = new ArrayList<Lance>();
	@Transient
	private Lance maiorLance = null;

	public Leilao() {
		// TODO Auto-generated constructor stub
	}

	public Leilao(Long id) {
		super();
		this.id = id;
	}

	public double calculaValorLance(double valorLance, double taxa) {
		return valorLance + (valorLance * taxa);
	}

	public void efetuaLance(Lance lance) {
		lances.add(lance);
		if (maiorLance == null) {
			maiorLance = lance;
		} else {
			if (maiorLance.getValor() < lance.getValor()) {
				maiorLance = lance;
			}
		}
	}

	public Lance ultimoLance() {
		return lances.get(lances.size() - 1);
	}

	public Lance retornaMaiorLance() {
		if (maiorLance == null) {
			return new Lance(0, new Participante());
		}
		return maiorLance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

