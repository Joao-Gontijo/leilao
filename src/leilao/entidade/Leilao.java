package leilao.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Leilao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private double valorInicial, valorArremate;
	
	private String descricao, situacao;
	
	
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;
	
	
//	@Transient
//	private List<Lance> lances = new ArrayList<Lance>();
//	@Transient
//	private Lance maiorLance = null;

	public Leilao() {
	}

	public Leilao(String descricao, Date dataCriacao) {
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
	}
	
	public Leilao(String descricao, Date dataCriacao, double valorInicial, String situacao) {
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.valorInicial = valorInicial;
		this.situacao = situacao;
	}

	public double calculaValorLance(double valorLance, double taxa) {
		return valorLance + (valorLance * taxa);
	}

//	public void efetuaLance(Lance lance) {
//		lances.add(lance);
//		if (maiorLance == null) {
//			maiorLance = lance;
//		} else {
//			if (maiorLance.getValor() < lance.getValor()) {
//				maiorLance = lance;
//			}
//		}
//	}
//
//	public Lance ultimoLance() {
//		return lances.get(lances.size() - 1);
//	}
//
//	public Lance retornaMaiorLance() {
//		if (maiorLance == null) {
//			return new Lance(0, new Participante());
//		}
//		return maiorLance;
//	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public double getValorArremate() {
		return valorArremate;
	}

	public void setValorArremate(double valorArremate) {
		this.valorArremate = valorArremate;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}