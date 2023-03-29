package com.losung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.losung.model.Produto;
import com.losung.repository.ProdutoRepository;

//Controler é uma classe controlado, ela é responsavel por responder todas e qualquer requisição HTTP REQUEST.
// Aqui implementaremos o crud, Create, Read, Update e Delete, que faz interação com a interface Repository


@RestController // aqui definimos que a class é do tipo RestController, e irá receber URL, VERBO, CORPO DE REQUISIÇÃO
@RequestMapping("/produtos") // aqui definimos a URL ex: http://localhost:8080/produtos
@CrossOrigin(origins = "*", allowedHeaders = "*") // Indica que a classe controladora irá ter acesso ao recebimento de requisições realizadas fora do dominino (localhost). Essencial para o Front ter acesso a aplicação.
public class ProdutoController {
	@Autowired //Injeção de depedencia. 
	private ProdutoRepository produtoRepository;
	
	
	@GetMapping // mapeia todas as requisções http get, é o caminho da nossa url 
	public ResponseEntity<List<Produto>> getAll(){ //List é para retornar todos os objetos da classe Produtos.
		return ResponseEntity.ok(produtoRepository.findAll()); // retornando pq colocamos o tipo ResponseEntity e se tiver OK-> 200 ele irá receber o jpa pois lá que esá a comunicação com Banco de dados e irá encontrar todos os objetos.
	}
	
	@GetMapping("{id}") // utilizado em chaves pois não se sabe qual id quer procurar
	public ResponseEntity<Produto> getById(@PathVariable Long id){
		return produtoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp)) // map É um contêiner para um valor que pode estar ausente.  fazemos uso do Optional para que ele faça o encapsulamento e informe se o Objeto está presente ou não.
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	
}
