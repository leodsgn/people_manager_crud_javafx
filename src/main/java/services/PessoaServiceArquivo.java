package services;

import models.Pessoa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PessoaServiceArquivo implements PessoaService{
    // divisor de colunas no arquivo
    private static final String SEPARADOR = ";";

    // o caminho para o arquivo deve ser selecionado aqui
    private static final Path ARQUIVO_SAIDA = Paths.get("./dados.csv");

    // os dados do arquivo
    private List<Pessoa> pessoas;

    // formato de data usado no arquivo
    final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    public PessoaServiceArquivo() {
        carregaDados();
    }

    @Override
    public void salvar(Pessoa pPessoa) {
        pPessoa.setId(ultimoId() + 1);
        pessoas.add(pPessoa);
        salvaDados();
    }


    @Override
    public void atualizar(Pessoa pPessoa) {
        Pessoa pessoaAltera = buscaPorId(pPessoa.getId());
        pessoaAltera.setNome(pPessoa.getNome());
        pessoaAltera.setDataNascimento(pPessoa.getDataNascimento());
        pessoaAltera.setAltura(pPessoa.getAltura());
        pessoaAltera.setPeso(pPessoa.getPeso());
        salvaDados();
    }

    public List<Pessoa> getListaPessoa() {
        return pessoas;
    }

    @Override
    public void apagar(int id) {
        Pessoa pessoa = buscaPorId(id);
        pessoas.remove(pessoa);
        salvaDados();
    }

    public Pessoa buscaPorId(int id) {
        return pessoas.stream().filter(pessoa -> pessoa.getId() == id).findFirst()
                .orElseThrow(() -> new Error("Pessoa não encontrada"));
    }

    // salva a lista de dados no arquivo, gerando um novo CSV e escrevendo o arquivo completamente
    private void salvaDados() {
        StringBuffer sb = new StringBuffer();
        for (Pessoa pessoa : this.getListaPessoa()) {
            String linha = criaLinha(pessoa);
            sb.append(linha);
            sb.append(System.getProperty("line.separator"));
        }
        try {
            Files.delete(ARQUIVO_SAIDA);
            Files.write(ARQUIVO_SAIDA, sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    // o ID mais alto é retornado aqui para continuarmos contando os IDs
    private int ultimoId() {
        return this.getListaPessoa().stream().mapToInt(Pessoa::getId).max().orElse(0);
    }

    // carrega os dados do arquivo para a lista contas
    private void carregaDados() {
        try {
            if(!Files.exists(ARQUIVO_SAIDA)) {
                Files.createFile(ARQUIVO_SAIDA);
            }
            pessoas = Files.lines(ARQUIVO_SAIDA).map(this::leLinha).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    // transforma uma linha do CSV para o tipo Conta
    private Pessoa leLinha(String linha) {
        String colunas[] = linha.split(SEPARADOR);
        int id = Integer.parseInt(colunas[0]);
        Date dataNascimento = null;
        try {
            dataNascimento = formatoData.parse(colunas[2]);
        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(0);
        }
        Pessoa pessoa = new Pessoa(colunas[1],dataNascimento,Double.parseDouble(colunas[3]),
                Double.parseDouble(colunas[4]));
        return pessoa;
    }

    // transforma um objeto conta em um arquivo CSV
    private String criaLinha(Pessoa pPessoa) {
        String dataStr = formatoData.format(pPessoa.getDataNascimento());
        String idStr = String.valueOf(pPessoa.getId());
        String linha = String.join(SEPARADOR, idStr, pPessoa.getNome(), dataStr,
                String.valueOf(pPessoa.getAltura()),String.valueOf(pPessoa.getPeso()));
        return linha;
    }
}
