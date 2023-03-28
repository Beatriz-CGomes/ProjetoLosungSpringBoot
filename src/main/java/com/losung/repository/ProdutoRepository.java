package com.losung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.losung.model.Produto;

// Interface nos ajuda na interação com banco de dados, por ela conseguimos metodos pre-implementados para manipular os dadsos da entidade, como salvar, deletar, listar, recuperar e etc. Além do mais, conseguimos criar consular personalizadas chamadas de Query Methods. Para isso utilizamos a herança, vamos extender da JpaRepositoru.


@Repository //Indica que a interface é do tipo repositorio , em outras palavras, responsavel pela comunicação com Banco de dados.
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
