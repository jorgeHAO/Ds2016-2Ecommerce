package br.edu.iftm.model.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "tb_categoria")
@XmlRootElement
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Integer idCategoria;
    @Column(name = "ds_categoria")
    private String dsCategoria;
    @ManyToMany(mappedBy = "categoriaCollection")
    private Collection<Materia> materiaCollection;
    @OneToMany(mappedBy = "idCategoria")
    private Collection<CategoriaAluno> categoriaAlunoCollection;
    @OneToMany(mappedBy = "categoria")
    private Collection<Simulado> simuladoCollection;

    public Categoria() {
    }

    public Categoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDsCategoria() {
        return dsCategoria;
    }

    public void setDsCategoria(String dsCategoria) {
        this.dsCategoria = dsCategoria;
    }

    @XmlTransient
    public Collection<Materia> getMateriaCollection() {
        return materiaCollection;
    }

    public void setMateriaCollection(Collection<Materia> materiaCollection) {
        this.materiaCollection = materiaCollection;
    }

    @XmlTransient
    public Collection<CategoriaAluno> getCategoriaAlunoCollection() {
        return categoriaAlunoCollection;
    }

    public void setCategoriaAlunoCollection(Collection<CategoriaAluno> categoriaAlunoCollection) {
        this.categoriaAlunoCollection = categoriaAlunoCollection;
    }

    @XmlTransient
    public Collection<Simulado> getSimuladoCollection() {
        return simuladoCollection;
    }

    public void setSimuladoCollection(Collection<Simulado> simuladoCollection) {
        this.simuladoCollection = simuladoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sistemaEcommerce.domain.Categoria[ idCategoria=" + idCategoria + " ]";
    }
    
}
