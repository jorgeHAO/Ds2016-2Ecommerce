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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "tb_aula")
@XmlRootElement
public class Aula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aula")
    private Integer idAula;
    @Column(name = "dt_aula")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAula;
    @Column(name = "ds_turno")
    private String dsTurno;
    @JoinColumn(name = "id_sala", referencedColumnName = "id_sala")
    @ManyToOne
    private Sala idSala;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    @ManyToOne
    private Materia idMateria;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
    @ManyToOne
    private Funcionario idFuncionario;
    @OneToMany(mappedBy = "idAula")
    private Collection<Frequencia> frequenciaCollection;

    public Aula() {
    }

    public Aula(Integer idAula) {
        this.idAula = idAula;
    }

    public Integer getIdAula() {
        return idAula;
    }

    public void setIdAula(Integer idAula) {
        this.idAula = idAula;
    }

    public Date getDtAula() {
        return dtAula;
    }

    public void setDtAula(Date dtAula) {
        this.dtAula = dtAula;
    }

    public String getDsTurno() {
        return dsTurno;
    }

    public void setDsTurno(String dsTurno) {
        this.dsTurno = dsTurno;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
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
        hash += (idAula != null ? idAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.idAula == null && other.idAula != null) || (this.idAula != null && !this.idAula.equals(other.idAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sistemaEcommerce.domain.Aula[ idAula=" + idAula + " ]";
    }
    
}
