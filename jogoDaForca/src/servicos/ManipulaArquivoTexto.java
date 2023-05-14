package servicos;

import java.nio.file.Paths;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

public class ManipulaArquivoTexto {
    public static String arquivo;
    public static Formatter gravador;
    public static Scanner leitor;

    public static void abrirArquivoParaGravacao() {
        try {
            gravador = new Formatter(arquivo);
        } catch (SecurityException e) {
            System.err.println("Permissão negada!");
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo nao encontrado!");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Erro ao abrir o arquivo!");
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Erro inesperado!\n"+e.getMessage());
            System.exit(1);
        }
    }

    public static void fecharArquivoGravacao() {
        if(gravador != null)
            gravador.close();
    }

    public static void abrirArquivoParaLeitura() {
        try {
            leitor = new Scanner(Paths.get(arquivo));
        } catch (IOException e) {
            System.err.println("Erro ao abrir o arquivo!");
            System.exit(1);
        }
    }

    public static ArrayList<String> lerArquivo() {
        ArrayList<String> linhas = new ArrayList<>();
        try {
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                linhas.add(linha);
            }
        } catch (NoSuchElementException noSuchElementException){
            System.err.println("Arquivo Mal Formatado");
        } catch (IllegalStateException stateException){
            System.err.println("Erro ao ler do arquivo");
        }

        return linhas;
    }

    public static void fecharArquivoLeitura() {
        if (leitor != null) {
            leitor.close();
        }
    }
}
