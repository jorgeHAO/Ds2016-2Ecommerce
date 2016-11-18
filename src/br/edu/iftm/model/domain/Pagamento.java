package br.edu.iftm.model.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "tb_pagamento")
@XmlRootElement
public class Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_pagamento")
	private Integer idPagamento;

	@Column(name = "vl_pagamento")
	private Float vlPagamento;

	@Column(name = "dt_pagamento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtPagamento;

	@Column(name = "ds_pagamento")
	private String dsPagamento;

	@JoinColumn(name = "id_tipo_pagamento", referencedColumnName = "id_tipo_pagamento")
	@ManyToOne
	private TipoPagamento idTipoPagamento;

	@JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
	@ManyToOne
	private Funcionario idFuncionario;

	@JoinColumn(name = "id_categoria_aluno", referencedColumnName = "id_categoria_aluno")
	@ManyToOne
	private CategoriaAluno idCategoriaAluno;

	@OneToMany(mappedBy = "idPagamento")
	private Collection<Parcela> parcelaCollection;

	public Pagamento() {
		super();
	}

	public Pagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}

	public Integer getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}

	public Float getVlPagamento() {
		return vlPagamento;
	}

	public void setVlPagamento(Float vlPagamento) {
		this.vlPagamento = vlPagamento;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public String getDsPagamento() {
		return dsPagamento;
	}

	public void setDsPagamento(String dsPagamento) {
		this.dsPagamento = dsPagamento;
	}

	public TipoPagamento getIdTipoPagamento() {
		return idTipoPagamento;
	}

	public void setIdTipoPagamento(TipoPagamento idTipoPagamento) {
		this.idTipoPagamento = idTipoPagamento;
	}

	public Funcionario getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Funcionario idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public CategoriaAluno getIdCategoriaAluno() {
		return idCategoriaAluno;
	}

	public void setIdCategoriaAluno(CategoriaAluno idCategoriaAluno) {
		this.idCategoriaAluno = idCategoriaAluno;
	}

	@XmlTransient
	public Collection<Parcela> getParcelaCollection() {
		return parcelaCollection;
	}

	public void setParcelaCollection(Collection<Parcela> parcelaCollection) {
		this.parcelaCollection = parcelaCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idPagamento != null ? idPagamento.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Pagamento)) {
			return false;
		}
		Pagamento other = (Pagamento) object;
		if ((this.idPagamento == null && other.idPagamento != null)
				|| (this.idPagamento != null && !this.idPagamento.equals(other.idPagamento))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaEcommerce.domain.Pagamento[ idPagamento=" + idPagamento + " ]";
	}

}
