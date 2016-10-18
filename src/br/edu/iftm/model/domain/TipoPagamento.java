package br.edu.iftm.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_TIPOPAGAMENTO")
public class TipoPagamento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PAGAMENTO")
	private Integer idPagamento;
	
	@Column(name="TIPO_PAGAMENTO")
	private String tipoPagamento;

	@Column(name="NR_PARCELAS")
	private Integer nrParcelas;
	
//    @ManyToOne
//    @JoinColumn(name="ID_PAGAMENTO",referencedColumnName="ID_PAGAMENTO")
//    private Pagamento pagamento;

	public TipoPagamento(){
		super();
	}
	
	public Integer getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Integer getNrParcelas() {
		return nrParcelas;
	}

	public void setNrParcelas(Integer nrParcelas) {
		this.nrParcelas = nrParcelas;
	}

	
	
}
