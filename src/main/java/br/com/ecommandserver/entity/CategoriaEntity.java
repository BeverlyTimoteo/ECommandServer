package br.com.ecommandserver.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity()
@Table(name = "produtocategoria")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CategoriaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "produtocategoria_id_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "produtocategoria_id_seq", allocationSize = 1, initialValue = 1, sequenceName = "produtocategoria_id_seq")
	private Long id;

	@NotNull(message = "Descrição obrigatória")
	@Column(name = "descricao", length = 30, nullable = false)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
