package dominio;

import servicos.ManipulaArquivoTexto;

import java.util.ArrayList;
import java.util.Random;

public class JogoDaForca {
    private String palavra;
    private String[] palavrasDoJogo;
    private int numTentativas;
    private boolean venceu;


    public JogoDaForca() {
        this.palavra = sorteiaPalavra();
        this.palavrasDoJogo = palavras();
        this.numTentativas = 5;
        this.venceu = false;
    }

    public boolean verificaFimDeJogo() {
        return false;
    }

    public ArrayList<Integer> verificaLetra() {
        ArrayList<Integer> posicoes = new ArrayList<>();
        return posicoes;
    }

    public String sorteiaPalavra() {
        // SORTEADOR
        Random random = new Random();

        // PALAVRA SORTEADA
        return palavrasDoJogo[random.nextInt(palavrasDoJogo.length)];
    }

    public String[] palavras() {
        // LISTA DE PALAVRAS
        // se tivesse duas ou mais linhas, funcionaria?
        for (int i=0; i<ManipulaArquivoTexto.lerArquivo().size(); i++) {
            palavrasDoJogo = ManipulaArquivoTexto.lerArquivo().get(i).split(" ");
        }
        return palavrasDoJogo;
    }
}
