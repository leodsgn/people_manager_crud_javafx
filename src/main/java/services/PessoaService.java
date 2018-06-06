package services;

import models.Pessoa;

import java.util.List;

public interface PessoaService {
        // CREATE
        public void salvar(Pessoa conta);

        // RETRIEVE
        public List<Pessoa> getListaPessoa();

        public Pessoa buscaPorId(int id);

        // DELETE
        public void apagar(int id);

        // UPDATE
        public void atualizar(Pessoa conta);


}
