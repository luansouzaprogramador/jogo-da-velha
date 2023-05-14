package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JanelaPrincipal extends JFrame implements ActionListener{
    // campos da classe
    private JLabel textoAcima;

    private JPanel centro;               // 2x1
    private JPanel resposta;
    private JTextField[] letrasResposta; // 1x7
    private JPanel teclado;
    private JButton[] letrasTeclado;     // 3x1

    private JPanel linha1;               // 10x1
    private JPanel linha2;               // 10x1
    private JPanel linha3;               // 7x1

    private JPanel sul;                  // 2x1
    private JPanel botoesSul;
    private JButton novoJogo;
    private JButton conferir;
    private JButton sair;
    private JLabel textoAbaixo;

    String textoBotaoSelecionado;

    // contrutor
    public JanelaPrincipal() {
        super("Jodo da Forca");
        instanciarComponentes();
        adicionarComponentes();
        registrarHandlerEvento();
    }

    public void instanciarComponentes() {
        String[] auxiliar = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S",
                "D", "F", "G", "H", "J", "K", "L", "Ç", "Z", "X", "C", "V", "B", "N", "M"};
        textoAcima = new JLabel("Adivinhe a palavra");

        centro = new JPanel();

        resposta = new JPanel();
        letrasResposta = new JTextField[7];
        for (int i=0; i<letrasResposta.length; i++) {
            letrasResposta[i] = new JTextField();
        }

        teclado = new JPanel();
        linha1 = new JPanel();
        linha2 = new JPanel();
        linha3 = new JPanel();
        letrasTeclado = new JButton[27];
        for (int i=0; i<letrasTeclado.length; i++) {
            letrasTeclado[i] = new JButton(auxiliar[i]);
        }

        sul = new JPanel();

        botoesSul = new JPanel();
        novoJogo = new JButton("Novo jogo");
        conferir = new JButton("Conferir");
        sair = new JButton("Sair");

        textoAbaixo = new JLabel("Voce tem 15 tentativas");
    }

    public void adicionarComponentes() {
        setLayout(new BorderLayout());
        add(textoAcima, BorderLayout.NORTH);

        // adiciona e muda o layout
        add(centro, BorderLayout.CENTER);
        centro.setLayout(new GridLayout(2, 1));

        // adiciona as JPanel de centro
        centro.add(resposta);
        resposta.setLayout(new GridLayout(1, 7));
        for (int i=0; i<letrasResposta.length; i++) {
            resposta.add(letrasResposta[i]);
        }

        centro.add(teclado);
        teclado.setLayout(new GridLayout(3, 1));
        teclado.add(linha1);
        linha1.setLayout(new GridLayout(1, 10));
        int i=0;

        while(i<10) {
            linha1.add(letrasTeclado[i]);
            i++;
        }
        teclado.add(linha2);
        linha2.setLayout(new GridLayout(1, 10));
        while(i<20) {
            linha2.add(letrasTeclado[i]);
            i++;
        }
        teclado.add(linha3);
        linha3.setLayout(new GridLayout(1, 7));
        while (i<27) {
            linha3.add(letrasTeclado[i]);
            i++;
        }

        add(sul, BorderLayout.SOUTH);
        sul.setLayout(new GridLayout(2, 1));
        sul.add(botoesSul);
        botoesSul.setLayout(new GridLayout(1, 3));
        botoesSul.add(novoJogo);
        botoesSul.add(conferir);
        botoesSul.add(sair);

        sul.add(textoAbaixo);
    }

    public void registrarHandlerEvento() {
        for (JButton botao : letrasTeclado) {
            botao.addActionListener(this);
        }
        novoJogo.addActionListener(this::novoJogo);
        conferir.addActionListener(this::conferir);
        sair.addActionListener(this::sair);
    }

    public void novoJogo(ActionEvent actionEvent) {
        System.out.println("Novo jogo");
    }

    public void conferir(ActionEvent actionEvent) {
        System.out.println("Conferir");
        System.out.println("textoBotaoSelecionado: "+textoBotaoSelecionado);
    }

    public void sair(ActionEvent actionEvent) {
        System.out.println("Sair");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for (JButton botao : letrasTeclado) {
            if (actionEvent.getSource() == botao) {
                // Obtém o texto do botão que foi pressionado
                String textoBotao = botao.getText();
                textoBotaoSelecionado = textoBotao;
                System.out.println("Texto do botão selecionado: " + textoBotaoSelecionado);
            }
        }
    }

    public String teste(ActionEvent actionEvent) {
        for (JButton botao : letrasTeclado) {
            if (actionEvent.getSource() == botao) {
                // Obtém o texto do botão que foi pressionado
                return botao.getText();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        JanelaPrincipal janela = new JanelaPrincipal();
        janela.setSize(500, 500);
        janela.setVisible(true);
        ArrayList<Integer> posicoes;
    }
}
