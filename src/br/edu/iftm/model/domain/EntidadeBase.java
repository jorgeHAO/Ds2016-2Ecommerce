package br.edu.iftm.model.domain;

import java.io.Serializable;

/**
 * @author alan.franco
 *
 *         Entidade criada para centralizar as caracteristicas genéricas das
 *         classes de dominio;
 *
 *         Exemplo de Necessidades: Viabilizar a clonagem desta entidade, e
 *         também a serealização.
 */
public class EntidadeBase implements Serializable, Cloneable {
	/**
	 *
	 */
	private static final long serialVersionUID = -6076774018373167939L;

	public EntidadeBase() {
		super();
	}

}
