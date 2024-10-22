/* Nome: Maria Eduarda Fodor CB3025063
 * Nome: Pedro Xavier Oliveira CB3027376
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class FormularioAluno extends JFrame {
    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField enderecoField;
    private List<Aluno> alunos; // Lista para armazenar os alunos

    public FormularioAluno() {
        alunos = new ArrayList<>(); // Inicializa a lista de alunos

        // Configurações da janela
        setTitle("Cadastro de Aluno");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre os componentes

        // Criação dos labels e campos de texto
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField(15); // Tamanho da caixa de texto

        JLabel idadeLabel = new JLabel("Idade:");
        idadeField = new JTextField(15);

        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoField = new JTextField(15);

        // Adicionando os componentes à janela
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 0; // Linha 0
        add(nomeLabel, gbc);

        gbc.gridx = 1; // Coluna 1
        gbc.gridy = 0; // Linha 0
        add(nomeField, gbc);

        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 1; // Linha 1
        add(idadeLabel, gbc);

        gbc.gridx = 1; // Coluna 1
        gbc.gridy = 1; // Linha 1
        add(idadeField, gbc);

        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 2; // Linha 2
        add(enderecoLabel, gbc);

        gbc.gridx = 1; // Coluna 1
        gbc.gridy = 2; // Linha 2
        add(enderecoField, gbc);

        // Botões
        JButton okButton = new JButton("Ok");
        JButton limparButton = new JButton("Limpar");
        JButton mostrarButton = new JButton("Mostrar");
        JButton sairButton = new JButton("Sair");

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(limparButton);
        buttonPanel.add(mostrarButton);
        buttonPanel.add(sairButton);

        // Adicionando o painel de botões na parte inferior
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 3; // Linha 3
        gbc.gridwidth = 2; // Ocupa duas colunas
        add(buttonPanel, gbc);

        // Ações dos botões
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Verifica se o campo nome contém apenas letras
                    String nome = nomeField.getText();
                    if (!nome.matches("[a-zA-Z\\s]+")) {
                        throw new IllegalArgumentException("Nome deve conter apenas letras.");
                    }
        
                    // Verifica se o campo endereço contém apenas letras e espaços
                    String endereco = enderecoField.getText();
                    if (!endereco.matches("[a-zA-Z\\s]+")) {
                        throw new IllegalArgumentException("Endereço deve conter apenas letras.");
                    }
        
                    // Tenta converter a idade para um número inteiro
                    int idade = Integer.parseInt(idadeField.getText()); // Converte a idade para int
                    Aluno aluno = new Aluno(nome, endereco, idade);
                    alunos.add(aluno); // Adiciona o aluno à lista
                    JOptionPane.showMessageDialog(null, "Aluno cadastrado: " + nome);
                } catch (NumberFormatException ex) {
                    // Caso o valor inserido no campo idade não seja um número, exibe uma mensagem de erro
                    JOptionPane.showMessageDialog(null, "Erro: Idade deve ser um número válido.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    // Caso os campos nome ou endereço contenham caracteres inválidos, exibe uma mensagem de erro
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage(), "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpar os campos
                nomeField.setText("");
                idadeField.setText("");
                enderecoField.setText("");
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para mostrar os dados cadastrados
                StringBuilder mensagem = new StringBuilder("Alunos cadastrados:\n");
                for (Aluno aluno : alunos) {
                    mensagem.append("ID: ").append(aluno.getUuid()).append(" Nome: ").append(aluno.getNome()).append("\n");
                }
                JOptionPane.showMessageDialog(FormularioAluno.this, mensagem.toString());
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sair da aplicação
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        // Executar a aplicação
        SwingUtilities.invokeLater(() -> {
            FormularioAluno formulario = new FormularioAluno();
            formulario.setVisible(true);
        });
    }
}