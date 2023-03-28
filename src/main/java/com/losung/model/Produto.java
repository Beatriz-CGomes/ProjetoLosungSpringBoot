package com.losung.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity // indica que é uma entidade, que será utilizada para gerar uma tabela no banco de dados
@Table(name = "tb_produtos") // criação da tabela
public class Produto {

	@Id // Indica que o atributo será anotado como chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // GeneratedValue indica que a chave primária será gerada pela Spring Data JPA strategy = é a estratégia de parâmetro que indica que a chave primeria será  gerada >GenerationType.IDENTITY< no banco de dados é será auto-incremento.
	private Long id;

	@NotBlank // Indica que não pode ser nulo é o valor NOTBLANK não permite nem um espaço.
	@Size(min = 5, max = 100, message = "O atributo nome é obrigatório")
	private String nome;

	@NotBlank
	@Size(min = 15, max = 1000, message = "O atributo descrição é obrigatório") // size indica o tamanho que definimos na criação da tabela no banco de dados.
	private String descricao;

	@NotBlank(message = "O atributo preço é Obrigatório")
	private double preco;

	private int ean;

	// Gerando Getters e Setters que são os controladores de acesso para as outras classes, já que colocamos o encapsulamento
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getEan() {
		return ean;
	}

	public void setEan(int ean) {
		this.ean = ean;
	}

}
