package br.edu.iftm.model.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "tb_pergunta")
@XmlRootElement

public class Pergunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pergunta")
    private Integer idPergunta;
    @Column(name = "ds_pergunta")
    private String dsPergunta;
    @ManyToMany(mappedBy = "perguntaCollection")
    private Collection<Simulado> simuladoCollection;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    @ManyToOne
    private Materia idMateria;
    @OneToMany(mappedBy = "idPergunta")
    private Collection<Resposta> respostaCollection;

    public Pergunta() {
    }

    public Pergunta(Integer idPergunta) {
        this.idPergunta = idPergunta;
    }

    public Integer getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(Integer idPergunta) {
        this.idPergunta = idPergunta;
    }

    public String getDsPergunta() {
        return dsPergunta;
    }

    public void setDsPergunta(String dsPergunta) {
        this.dsPergunta = dsPergunta;
    }

    @XmlTransient
    public Collection<Simulado> getSimuladoCollection() {
        return simuladoCollection;
    }

    public void setSimuladoCollection(Collection<Simulado> simuladoCollection) {
        this.simuladoCollection = simuladoCollection;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    @XmlTransient
    public Collection<Resposta> getRespostaCollection() {
        return respostaCollection;
    }

    public void setRespostaCollection(Collection<Resposta> respostaCollection) {
        this.respostaCollection = respostaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPergunta != null ? idPergunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pergunta)) {
            return false;
        }
        Pergunta other = (Pergunta) object;
        if ((this.idPergunta == null && other.idPergunta != null) || (this.idPergunta != null && !this.idPergunta.equals(other.idPergunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sistemaEcommerce.domain.Pergunta[ idPergunta=" + idPergunta + " ]";
    }
    
}
