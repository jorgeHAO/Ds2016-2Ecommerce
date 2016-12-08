package br.edu.iftm.model.domain;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "tb_materia")
@XmlRootElement
public class Materia extends EntidadeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 867038271753005374L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_materia")
	private Integer idMateria;

	@Column(name = "ds_materia")
	private String dsMateria;

	@JoinTable(name = "tb_categoria_materia", joinColumns = {
			@JoinColumn(name = "id_materia", referencedColumnName = "id_materia") }, inverseJoinColumns = {
					@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria") })
	@ManyToMany
	private Collection<Categoria> categoriaCollection;

	@OneToMany(mappedBy = "idMateria")
	private Collection<Pergunta> perguntaCollection;

	@OneToMany(mappedBy = "idMateria")
	private Collection<Aula> aulaCollection;

	public Materia() {
		super();
	}

	public Materia(Integer idMateria) {
		this.idMateria = idMateria;
	}

	public Integer getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}

	public String getDsMateria() {
		return dsMateria;
	}

	public void setDsMateria(String dsMateria) {
		this.dsMateria = dsMateria;
	}

	@XmlTransient
	public Collection<Categoria> getCategoriaCollection() {
		return categoriaCollection;
	}

	public void setCategoriaCollection(Collection<Categoria> categoriaCollection) {
		this.categoriaCollection = categoriaCollection;
	}

	@XmlTransient
	public Collection<Pergunta> getPerguntaCollection() {
		return perguntaCollection;
	}

	public void setPerguntaCollection(Collection<Pergunta> perguntaCollection) {
		this.perguntaCollection = perguntaCollection;
	}

	@XmlTransient
	public Collection<Aula> getAulaCollection() {
		return aulaCollection;
	}

	public void setAulaCollection(Collection<Aula> aulaCollection) {
		this.aulaCollection = aulaCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idMateria != null ? idMateria.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Materia)) {
			return false;
		}
		Materia other = (Materia) object;
		if ((this.idMateria == null && other.idMateria != null)
				|| (this.idMateria != null && !this.idMateria.equals(other.idMateria))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.sistemaEcommerce.domain.Materia[ idMateria=" + idMateria + " ]";
	}

}
