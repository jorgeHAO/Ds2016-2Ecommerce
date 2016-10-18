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
@Table(name="TB_PAGAMENTO")
public class Pagamento implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PAGAMENTO")
	private Integer idPagamento;
	
	@Column(name="VLR_PAGAMENTO")
	private float vlrPagamento;
	
	@Column(name="DATA_PAGAMENTO")
	private Date dataPagamento;
	
	@Column(name="DS_PAGAMENTO")
	private String dsPagamento;
	
//    @ManyToOne
//    @JoinColumn(name="ID_FUNCIONARIO",referencedColumnName="ID_FUNCIONARIO")
//    private Funcionario funcionario;

	public Integer getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}

	public float getVlrPagamento() {
		return vlrPagamento;
	}

	public void setVlrPagamento(float vlrPagamento) {
		this.vlrPagamento = vlrPagamento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getDsPagamento() {
		return dsPagamento;
	}

	public void setDsPagamento(String dsPagamento) {
		this.dsPagamento = dsPagamento;
	}
	
	
}
