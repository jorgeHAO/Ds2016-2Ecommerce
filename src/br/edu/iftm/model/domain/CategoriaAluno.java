package br.edu.iftm.model.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "tb_categoria_aluno")
@XmlRootElement
public class CategoriaAluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_categoria_aluno")
    private Integer idCategoriaAluno;
    @Column(name = "st_concluido")
    private Boolean stConcluido;
    @JoinColumn(name = "id_aluno", referencedColumnName = "id_aluno")
    @ManyToOne
    private Aluno idAluno;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne
    private Categoria idCategoria;
    @OneToMany(mappedBy = "idCategoriaAluno")
    private Collection<Nota> notaCollection;
    @OneToMany(mappedBy = "idCategoriaAluno")
    private Collection<Pagamento> pagamentoCollection;
    @OneToMany(mappedBy = "idCategoriaAluno")
    private Collection<Frequencia> frequenciaCollection;

    public CategoriaAluno() {
    }

    public CategoriaAluno(Integer idCategoriaAluno) {
        this.idCategoriaAluno = idCategoriaAluno;
    }

    public Integer getIdCategoriaAluno() {
        return idCategoriaAluno;
    }

    public void setIdCategoriaAluno(Integer idCategoriaAluno) {
        this.idCategoriaAluno = idCategoriaAluno;
    }

    public Boolean getStConcluido() {
        return stConcluido;
    }

    public void setStConcluido(Boolean stConcluido) {
        this.stConcluido = stConcluido;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @XmlTransient
    public Collection<Nota> getNotaCollection() {
        return notaCollection;
    }

    public void setNotaCollection(Collection<Nota> notaCollection) {
        this.notaCollection = notaCollection;
    }

    @XmlTransient
    public Collection<Pagamento> getPagamentoCollection() {
        return pagamentoCollection;
    }

    public void setPagamentoCollection(Collection<Pagamento> pagamentoCollection) {
        this.pagamentoCollection = pagamentoCollection;
    }

    @XmlTransient
    public Collection<Frequencia> getFrequenciaCollection() {
        return frequenciaCollection;
    }

    public void setFrequenciaCollection(Collection<Frequencia> frequenciaCollection) {
        this.frequenciaCollection = frequenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaAluno != null ? idCategoriaAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaAluno)) {
            return false;
        }
        CategoriaAluno other = (CategoriaAluno) object;
        if ((this.idCategoriaAluno == null && other.idCategoriaAluno != null) || (this.idCategoriaAluno != null && !this.idCategoriaAluno.equals(other.idCategoriaAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sistemaEcommerce.domain.CategoriaAluno[ idCategoriaAluno=" + idCategoriaAluno + " ]";
    }
    
}
