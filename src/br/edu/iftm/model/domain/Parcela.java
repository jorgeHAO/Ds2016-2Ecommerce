package br.edu.iftm.model.domain;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "tb_parcela")
@XmlRootElement
public class Parcela extends EntidadeBase {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_parcela")
	private Integer idParcela;

	@Column(name = "vl_parcela")
	private Float vlParcela;

	@Column(name = "dt_pagamento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtPagamento;

	@Column(name = "dt_recebimento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtRecebimento;

	@JoinColumn(name = "id_pagamento", referencedColumnName = "id_pagamento")
	@ManyToOne
	private Pagamento idPagamento;

	public Parcela() {
		super();	
	}

	public Parcela(Integer idParcela) {
		this.idParcela = idParcela;
	}

	public Integer getIdParcela() {
		return idParcela;
	}

	public void setIdParcela(Integer idParcela) {
		this.idParcela = idParcela;
	}

	public Float getVlParcela() {
		return vlParcela;
	}

	public void setVlParcela(Float vlParcela) {
		this.vlParcela = vlParcela;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public Date getDtRecebimento() {
		return dtRecebimento;
	}

	public void setDtRecebimento(Date dtRecebimento) {
		this.dtRecebimento = dtRecebimento;
	}

	public Pagamento getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Pagamento idPagamento) {
		this.idPagamento = idPagamento;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idParcela != null ? idParcela.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Parcela)) {
			return false;
		}
		Parcela other = (Parcela) object;
		if ((this.idParcela == null && other.idParcela != null)
				|| (this.idParcela != null && !this.idParcela.equals(other.idParcela))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaEcommerce.domain.Parcela[ idParcela=" + idParcela + " ]";
	}

}
