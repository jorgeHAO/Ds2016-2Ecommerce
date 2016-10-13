package br.edu.iftm.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_FUNCIONARIO")
public class Funcionario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_FUNCIONARIO")
	private Integer idFuncionario;
	
	@Column(name="NOME_FUNCIONARIO")
	private String nomeFuncionario;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="SENHA")
	private String senha;
	
	@Column(name="ENDERECO")
	private String endereco;
	
	@Column(name="TELEFONE")
	private String telefone;
	
	@Column(name="ESCOLARIDADE")
	private String escolaridade;
	
	@Column(name="PERFIL")
	private String perfil;

}
