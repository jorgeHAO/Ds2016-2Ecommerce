package br.edu.iftm.model.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "tb_resposta")
@XmlRootElement
public class Resposta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_resposta")
    private Integer idResposta;
    @Column(name = "ds_resposta")
    private String dsResposta;
    @Column(name = "st_correta")
    private Boolean stCorreta;
    @JoinColumn(name = "id_pergunta", referencedColumnName = "id_pergunta")
    @ManyToOne
    private Pergunta idPergunta;

    public Resposta() {
    }

    public Resposta(Integer idResposta) {
        this.idResposta = idResposta;
    }

    public Integer getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Integer idResposta) {
        this.idResposta = idResposta;
    }

    public String getDsResposta() {
        return dsResposta;
    }

    public void setDsResposta(String dsResposta) {
        this.dsResposta = dsResposta;
    }

    public Boolean getStCorreta() {
        return stCorreta;
    }

    public void setStCorreta(Boolean stCorreta) {
        this.stCorreta = stCorreta;
    }

    public Pergunta getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(Pergunta idPergunta) {
        this.idPergunta = idPergunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResposta != null ? idResposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resposta)) {
            return false;
        }
        Resposta other = (Resposta) object;
        if ((this.idResposta == null && other.idResposta != null) || (this.idResposta != null && !this.idResposta.equals(other.idResposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sistemaEcommerce.domain.Resposta[ idResposta=" + idResposta + " ]";
    }
    
}
