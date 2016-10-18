package br.edu.iftm.model.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_PARCELA")
public class Parcela implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PARCELA")
	private Integer idParcela;
	
	@Column(name="VLR_PARCELA")
	private float vlrParcela;
	
	@Column(name="DT_VENCIMENTO")
	private Date dtVencimento;
	
	@Column(name="DT_PAGAMENTO")
	private Date dtPagamento;

	public Integer getIdParcela() {
		return idParcela;
	}

	public void setIdParcela(Integer idParcela) {
		this.idParcela = idParcela;
	}

	public float getVlrParcela() {
		return vlrParcela;
	}

	public void setVlrParcela(float vlrParcela) {
		this.vlrParcela = vlrParcela;
	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	
	

}
