package br.edu.iftm.model.domain;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "tb_tipo_pagamento")
@XmlRootElement
public class TipoPagamento extends EntidadeBase {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_tipo_pagamento")
	private Integer idTipoPagamento;

	@Column(name = "ds_tipo_pagamento")
	private String dsTipoPagamento;

	@Column(name = "nr_parcelas")
	private Integer nrParcelas;

	@OneToMany(mappedBy = "idTipoPagamento")
	private Collection<Pagamento> pagamentoCollection;

	public TipoPagamento() {
		super();
	}

	public TipoPagamento(Integer idTipoPagamento) {
		this.idTipoPagamento = idTipoPagamento;
	}

	public Integer getIdTipoPagamento() {
		return idTipoPagamento;
	}

	public void setIdTipoPagamento(Integer idTipoPagamento) {
		this.idTipoPagamento = idTipoPagamento;
	}

	public String getDsTipoPagamento() {
		return dsTipoPagamento;
	}

	public void setDsTipoPagamento(String dsTipoPagamento) {
		this.dsTipoPagamento = dsTipoPagamento;
	}

	public Integer getNrParcelas() {
		return nrParcelas;
	}

	public void setNrParcelas(Integer nrParcelas) {
		this.nrParcelas = nrParcelas;
	}

	@XmlTransient
	public Collection<Pagamento> getPagamentoCollection() {
		return pagamentoCollection;
	}

	public void setPagamentoCollection(Collection<Pagamento> pagamentoCollection) {
		this.pagamentoCollection = pagamentoCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idTipoPagamento != null ? idTipoPagamento.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof TipoPagamento)) {
			return false;
		}
		TipoPagamento other = (TipoPagamento) object;
		if ((this.idTipoPagamento == null && other.idTipoPagamento != null)
				|| (this.idTipoPagamento != null && !this.idTipoPagamento.equals(other.idTipoPagamento))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaEcommerce.domain.TipoPagamento[ idTipoPagamento=" + idTipoPagamento + " ]";
	}

}
