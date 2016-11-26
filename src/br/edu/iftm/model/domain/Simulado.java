package br.edu.iftm.model.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saulo.borges
 */
@Entity
@Table(name = "tb_simulado")
@XmlRootElement
public class Simulado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_simulado")
    private Integer idSimulado;
    @Column(name = "dt_aplicacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAplicacao;
    @NotNull(message="Descrição do simulado não pode ser vazia.")
    @Column(name = "ds_simulado")
    private String dsSimulado;

    @JoinTable(name = "tb_selecao", joinColumns = {
        @JoinColumn(name = "id_simulado", referencedColumnName = "id_simulado")}, inverseJoinColumns = {
        @JoinColumn(name = "id_pergunta", referencedColumnName = "id_pergunta")})
    @ManyToMany
    private Collection<Pergunta> perguntaCollection;
    @OneToMany(mappedBy = "idSimulado")
    private Collection<Nota> notaCollection;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne
    private Categoria categoria;

    public Simulado() {
    }

    public Simulado(Integer idSimulado) {
        this.idSimulado = idSimulado;
    }

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
    
    public String getDsSimulado() {
		return dsSimulado;
	}

	public void setDsSimulado(String dsSimulado) {
		this.dsSimulado = dsSimulado;
	}

	@XmlTransient
    public Collection<Pergunta> getPerguntaCollection() {
        return perguntaCollection;
    }

    public void setPerguntaCollection(Collection<Pergunta> perguntaCollection) {
        this.perguntaCollection = perguntaCollection;
    }

    @XmlTransient
    public Collection<Nota> getNotaCollection() {
        return notaCollection;
    }

    public void setNotaCollection(Collection<Nota> notaCollection) {
        this.notaCollection = notaCollection;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSimulado != null ? idSimulado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Simulado)) {
            return false;
        }
        Simulado other = (Simulado) object;
        if ((this.idSimulado == null && other.idSimulado != null) || (this.idSimulado != null && !this.idSimulado.equals(other.idSimulado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sistemaEcommerce.domain.Simulado[ idSimulado=" + idSimulado + " ]";
    }
    
}
