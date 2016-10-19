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
@Table(name = "tb_nota")
@XmlRootElement
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nota")
    private Integer idNota;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vl_nota")
    private Float vlNota;
    @JoinColumn(name = "id_categoria_aluno", referencedColumnName = "id_categoria_aluno")
    @ManyToOne
    private CategoriaAluno idCategoriaAluno;
    @JoinColumn(name = "id_simulado", referencedColumnName = "id_simulado")
    @ManyToOne
    private Simulado idSimulado;

    public Nota() {
    }

    public Nota(Integer idNota) {
        this.idNota = idNota;
    }

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public Float getVlNota() {
        return vlNota;
    }

    public void setVlNota(Float vlNota) {
        this.vlNota = vlNota;
    }

    public CategoriaAluno getIdCategoriaAluno() {
        return idCategoriaAluno;
    }

    public void setIdCategoriaAluno(CategoriaAluno idCategoriaAluno) {
        this.idCategoriaAluno = idCategoriaAluno;
    }

    public Simulado getIdSimulado() {
        return idSimulado;
    }

    public void setIdSimulado(Simulado idSimulado) {
        this.idSimulado = idSimulado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNota != null ? idNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nota)) {
            return false;
        }
        Nota other = (Nota) object;
        if ((this.idNota == null && other.idNota != null) || (this.idNota != null && !this.idNota.equals(other.idNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sistemaEcommerce.domain.Nota[ idNota=" + idNota + " ]";
    }
    
}
