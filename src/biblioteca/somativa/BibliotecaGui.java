package biblioteca.somativa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;



public class BibliotecaGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					BibliotecaGui frame = new BibliotecaGui();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BibliotecaGui() {
		
		Biblioteca biblioteca = new Biblioteca(); // Inicialização da variável
	    biblioteca.carregarLivrosDoArquivo(); // Carregar dados existentes
	    biblioteca.carregarUsuariosDoArquivo(); // Carregar dados existentes
	    // ...
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1269, 767);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) SystemColor.inactiveCaption));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel painelUsuario = new JPanel();
		painelUsuario.setBounds(10, 10, 624, 125);
		contentPane.add(painelUsuario);
		painelUsuario.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(0, 0, 168, 23);
		painelUsuario.add(lblNewLabel);
		
		JLabel lblNomeUsuario = new JLabel("Nome : ");
		lblNomeUsuario.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNomeUsuario.setBounds(10, 27, 70, 13);
		painelUsuario.add(lblNomeUsuario);
		
		textField = new JTextField();
		textField.setBounds(57, 24, 342, 19);
		painelUsuario.add(textField);
		textField.setColumns(10);
		
		JLabel lblNumeroRegistro = new JLabel("Numero de Registro: ");
		lblNumeroRegistro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNumeroRegistro.setBounds(10, 63, 119, 13);
		painelUsuario.add(lblNumeroRegistro);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 60, 272, 19);
		painelUsuario.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCadastroUser = new JButton("Cadastrar Usuario");
		
		
		btnCadastroUser.setBackground(new Color(204, 24, 4));
		btnCadastroUser.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnCadastroUser.setBounds(424, 90, 147, 25);
		painelUsuario.add(btnCadastroUser);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 145, 624, 125);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de Livro");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(22, 0, 129, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Titulo :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 23, 45, 13);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Autor :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 58, 45, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ISBN :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 91, 45, 13);
		panel_1.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(65, 23, 234, 19);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(65, 55, 234, 19);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(65, 88, 234, 19);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
		
		
		btnCadastrarLivro.setBackground(new Color(204, 24, 4));
		btnCadastrarLivro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnCadastrarLivro.setBounds(425, 87, 143, 28);
		panel_1.add(btnCadastrarLivro);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 280, 624, 125);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Emprestimo Livro");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_5.setBounds(25, 0, 134, 13);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("ISBN :");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 34, 77, 13);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Numero de Registro :");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_7.setBounds(10, 67, 122, 13);
		panel_2.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(60, 31, 194, 19);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(132, 64, 122, 19);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnEmprestarLivro = new JButton("Emprestar Livro");
		btnEmprestarLivro.setBackground(new Color(204, 24, 4));
		
		
		btnEmprestarLivro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnEmprestarLivro.setBounds(424, 87, 148, 28);
		panel_2.add(btnEmprestarLivro);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 415, 624, 125);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Devolvolução Livros");
		lblNewLabel_10.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(24, 0, 152, 20);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("ISBN :");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_11.setBounds(10, 30, 71, 13);
		panel_3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Numero de Registro :");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_12.setBounds(10, 64, 121, 13);
		panel_3.add(lblNewLabel_12);
		
		textField_7 = new JTextField();
		textField_7.setBounds(51, 27, 203, 19);
		panel_3.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(129, 61, 125, 19);
		panel_3.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnDevolverLivro = new JButton("Devolver Livro");
		btnDevolverLivro.setBackground(new Color(204, 24, 4));
		
		btnDevolverLivro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnDevolverLivro.setBounds(429, 87, 142, 28);
		panel_3.add(btnDevolverLivro);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 558, 624, 162);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("Livros Disponiveis");
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(10, 10, 158, 13);
		panel_4.add(lblNewLabel_13);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 33, 356, 119);
		panel_4.add(textArea);
		
		JButton btnLivrosDisponivel = new JButton("Livros disponiveis ");
		btnLivrosDisponivel.setBackground(new Color(204, 24, 4));
		btnLivrosDisponivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLivrosDisponivel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLivrosDisponivel.setBounds(430, 131, 166, 21);
		panel_4.add(btnLivrosDisponivel);
		
		JLabel lblImagem = new JLabel("");
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setBackground(SystemColor.info);
		lblImagem.setBounds(644, 10, 601, 710);
		contentPane.add(lblImagem);
		

        // Carregando e inserindo a imagem
        ImageIcon imagemBook = new ImageIcon("imagens/bible.jpg"); // Caminho para a imagem
        lblImagem.setIcon(imagemBook);
		
        btnCadastroUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String nome = textField.getText();
                String numeroRegistro = textField_1.getText();
                
                Usuario usuario = new Usuario(nome, numeroRegistro);
                biblioteca.cadastrarUsuario(usuario);
                biblioteca.escreverArquivoUsuario(usuario);
                
                JOptionPane.showMessageDialog(null, "Usuário cadastrado e salvo com sucesso!");
                
                textField.setText("");
                textField_1.setText("");
            }
        });

        btnCadastrarLivro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = textField_2.getText();
                String autor = textField_3.getText();
                String ISBN = textField_4.getText();
                
                Livro livro = new Livro(titulo, autor, ISBN);
                biblioteca.cadastrarLivro(livro);
                biblioteca.escreverArquivoLivro(livro);
                
                JOptionPane.showMessageDialog(null, "Livro cadastrado e salvo com sucesso!");
                
                textField_2.setText("");
                textField_3.setText("");
                textField_4.setText("");
            }
        });


        btnEmprestarLivro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String isbnEmprestimo = textField_5.getText();
                String regEmprestimo = textField_6.getText();
                
                biblioteca.emprestarLivro(isbnEmprestimo, regEmprestimo);
                
                JOptionPane.showMessageDialog(null, "Livro emprestado com sucesso!");
                
                textField_5.setText("");
                textField_6.setText("");
               
            }
        });


        btnDevolverLivro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String isbnDevolucao = textField_7.getText();
                String regDevolucao = textField_8.getText();
                
                biblioteca.devolverLivro(isbnDevolucao, regDevolucao);
                JOptionPane.showMessageDialog(null, "Livro devolvido com sucesso!");
                
                textField_7.setText("");
                textField_8.setText("");
               
            }
        });


        btnLivrosDisponivel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder livrosDisponiveis = new StringBuilder();
                
                for (Livro livro : biblioteca.getLivrosDisponiveis()) {
                    livrosDisponiveis.append(livro.toString()).append("\n"); // Supondo que você tenha um método toString na classe Livro
                }
                
                textArea.setText(livrosDisponiveis.toString());
            }
        });

		
	}
}
