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
@Table(name="TB_FREQUENCIA")
public class Frequencia implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_FREQUENCIA")
	private Integer idFrequencia;
	
	@Column(name="ST_PRESENTE")
	private boolean stPresente;

	public Integer getIdFrequencia() {
		return idFrequencia;
	}

	public void setIdFrequencia(Integer idFrequencia) {
		this.idFrequencia = idFrequencia;
	}

	public boolean isStPresente() {
		return stPresente;
	}

	public void setStPresente(boolean stPresente) {
		this.stPresente = stPresente;
	}

}
