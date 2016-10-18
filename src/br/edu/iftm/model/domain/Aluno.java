package br.edu.iftm.model.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_ALUNO")
public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ALUNO")
	private Integer idAluno;
	
	@Column(name="NM_ALUNO")
	private String nmAluno;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="ENDERECO")
	private String endereco;
	
	@Column(name="TELEFONE")
	private String telefone;
	
	@Column(name="DT_NASCIMENTO")
	private Date dtNascimento;
	
	@Column(name="NR_RENACH")
	private Integer nrRenach;
	
//    @ManyToOne
//    @JoinColumn(name="ID_PAGAMENTO",referencedColumnName="ID_PAGAMENTO")
//    private Pagamento pagamento;
	
	public Aluno() {
		super();
	}
	
	public Aluno(Integer id) {
		this.idAluno = id;
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public String getNmAluno() {
		return nmAluno;
	}

	public void setNmAluno(String nmAluno) {
		this.nmAluno = nmAluno;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Integer getNrRenach() {
		return nrRenach;
	}

	public void setNrRenach(Integer nrRenach) {
		this.nrRenach = nrRenach;
	}
}
