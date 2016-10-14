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
@Table(name="TB_SIMULADO")
public class Simulado implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_SIMULADO")
	private Integer idSimulado;
	
	@Column(name="DT_APLICACAO")
	private Date dtAplicacao;

	public Integer getIdSimulado() {
		return idSimulado;
	}

	public void setIdSimulado(Integer idSimulado) {
		this.idSimulado = idSimulado;
	}

	public Date getDtAplicacao() {
		return dtAplicacao;
	}

	public void setDtAplicacao(Date dtAplicacao) {
		this.dtAplicacao = dtAplicacao;
	}
	
	

}
