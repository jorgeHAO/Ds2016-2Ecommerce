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
@Table(name = "tb_frequencia")
@XmlRootElement
public class Frequencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_frequencia")
    private Integer idFrequencia;
    @Column(name = "st_presente")
    private Integer stPresente;
    @JoinColumn(name = "id_categoria_aluno", referencedColumnName = "id_categoria_aluno")
    @ManyToOne
    private CategoriaAluno idCategoriaAluno;
    @JoinColumn(name = "id_aula", referencedColumnName = "id_aula")
    @ManyToOne
    private Aula idAula;

    public Frequencia() {
    }

    public Frequencia(Integer idFrequencia) {
        this.idFrequencia = idFrequencia;
    }

    public Integer getIdFrequencia() {
        return idFrequencia;
    }

    public void setIdFrequencia(Integer idFrequencia) {
        this.idFrequencia = idFrequencia;
    }

    public Integer getStPresente() {
        return stPresente;
    }

    public void setStPresente(Integer stPresente) {
        this.stPresente = stPresente;
    }

    public CategoriaAluno getIdCategoriaAluno() {
        return idCategoriaAluno;
    }

    public void setIdCategoriaAluno(CategoriaAluno idCategoriaAluno) {
        this.idCategoriaAluno = idCategoriaAluno;
    }

    public Aula getIdAula() {
        return idAula;
    }

    public void setIdAula(Aula idAula) {
        this.idAula = idAula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFrequencia != null ? idFrequencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Frequencia)) {
            return false;
        }
        Frequencia other = (Frequencia) object;
        if ((this.idFrequencia == null && other.idFrequencia != null) || (this.idFrequencia != null && !this.idFrequencia.equals(other.idFrequencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sistemaEcommerce.domain.Frequencia[ idFrequencia=" + idFrequencia + " ]";
    }
    
}
