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
@Table(name="TB_RESPOSTA")
public class Resposta implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RESPOSTA")
	private Integer idResposta;

	@Column(name="DS_RESPOSTA")
	private String ds_resposta;
	
	@Column(name="ST_CORRETA")
	private boolean stCorreta;

	public Integer getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(Integer idResposta) {
		this.idResposta = idResposta;
	}

	public String getDs_resposta() {
		return ds_resposta;
	}

	public void setDs_resposta(String ds_resposta) {
		this.ds_resposta = ds_resposta;
	}

	public boolean isStCorreta() {
		return stCorreta;
	}

	public void setStCorreta(boolean stCorreta) {
		this.stCorreta = stCorreta;
	}
	
}
