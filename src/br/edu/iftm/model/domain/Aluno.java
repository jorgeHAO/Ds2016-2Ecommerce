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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "tb_aluno")
@XmlRootElement
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aluno")
    private Integer idAluno;
    @Column(name = "nm_pessoa")
    private String nmPessoa;
    @Column(name = "nm_cpf")
    private String nmCpf;
    @Column(name = "ds_endereco")
    private String dsEndereco;
    @Column(name = "nr_telefone")
    private String nrTelefone;
    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtNascimento;
    @Transient
    private String dtNascimentoStr;
    @Column(name = "nr_prenach")
    private Integer nrPrenach;
    @OneToMany(mappedBy = "idAluno")
    private Collection<CategoriaAluno> categoriaAlunoCollection;

    public String getDtNascimentoStr() {
		return dtNascimentoStr;
	}

	public void setDtNascimentoStr(String dtNascimentoStr) {
		this.dtNascimentoStr = dtNascimentoStr;
	}

	public Aluno() {
    }

    public Aluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

    public String getNmCpf() {
        return nmCpf;
    }

    public void setNmCpf(String nmCpf) {
        this.nmCpf = nmCpf;
    }

    public String getDsEndereco() {
        return dsEndereco;
    }

    public void setDsEndereco(String dsEndereco) {
        this.dsEndereco = dsEndereco;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Integer getNrPrenach() {
        return nrPrenach;
    }

    public void setNrPrenach(Integer nrPrenach) {
        this.nrPrenach = nrPrenach;
    }

    @XmlTransient
    public Collection<CategoriaAluno> getCategoriaAlunoCollection() {
        return categoriaAlunoCollection;
    }

    public void setCategoriaAlunoCollection(Collection<CategoriaAluno> categoriaAlunoCollection) {
        this.categoriaAlunoCollection = categoriaAlunoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAluno != null ? idAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.idAluno == null && other.idAluno != null) || (this.idAluno != null && !this.idAluno.equals(other.idAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sistemaEcommerce.domain.Aluno[ idAluno=" + idAluno + " ]";
    }
    
}
