package br.edu.iftm.model.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "tb_funcionario")
@XmlRootElement
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_funcionario")
    private Integer idFuncionario;
    
    @NotNull(message="Nome do Funcionario não pode ser vazio")
    @Column(name = "nm_funcionario")
    private String nmFuncionario;
    
    @Size(min=11,max=15,message="cpf precisa ter entre {min} e {max} caracteres")
    @Column(name = "nm_cpf")
    private String nmCpf;
    
    @Size(min=5,max=10,message="a senha precisa ter entre {min} e {max} caracteres")
    @Column(name = "ds_senha")
    private String dsSenha;
    @Column(name = "ds_endereco")
    private String dsEndereco;
    @Column(name = "nr_telefone")
    private String nrTelefone;
    @Column(name = "ds_escolaridade")
    private String dsEscolaridade;
    @Column(name = "nr_perfil")
    private String nrPerfil;
    @OneToMany(mappedBy = "idFuncionario")
    private Collection<Aula> aulaCollection;
    @OneToMany(mappedBy = "idFuncionario")
    private Collection<Pagamento> pagamentoCollection;

    public Funcionario() {
    }

    public Funcionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNmFuncionario() {
        return nmFuncionario;
    }

    public void setNmFuncionario(String nmFuncionario) {
        this.nmFuncionario = nmFuncionario;
    }

    public String getNmCpf() {
        return nmCpf;
    }

    public void setNmCpf(String nmCpf) {
        this.nmCpf = nmCpf;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
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

    public String getDsEscolaridade() {
        return dsEscolaridade;
    }

    public void setDsEscolaridade(String dsEscolaridade) {
        this.dsEscolaridade = dsEscolaridade;
    }

    public String getNrPerfil() {
        return nrPerfil;
    }

    public void setNrPerfil(String nrPerfil) {
        this.nrPerfil = nrPerfil;
    }

    @XmlTransient
    public Collection<Aula> getAulaCollection() {
        return aulaCollection;
    }

    public void setAulaCollection(Collection<Aula> aulaCollection) {
        this.aulaCollection = aulaCollection;
    }

    @XmlTransient
    public Collection<Pagamento> getPagamentoCollection() {
        return pagamentoCollection;
    }

    public void setPagamentoCollection(Collection<Pagamento> pagamentoCollection) {
        this.pagamentoCollection = pagamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.sistemaEcommerce.domain.Funcionario[ idFuncionario=" + idFuncionario + " ]";
    }
    
}
