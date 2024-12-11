import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//fronten
public class RockPaperScissorGUI extends JFrame implements ActionListener {
    //Criação dos botões
    JButton rockButton, paperButton, scissorButton;
    // Display para a criação do botão de escolha
    JLabel computerChoice;

    JLabel computerScoreLabel, playerScorreLabel;

    RockPaperScissor rockPaperScissor;

    public RockPaperScissorGUI() {
        // Chama o construtor de Jframe e insere o título da áre de usuário
        super("Rock Paper Scissor");
        // Dimensões da tela de usuário
        setSize(450, 574);
        //Posicionamento dos elementos na tela
        setLayout(null);
        //Encerrar JVM quando a interface de usuário for fechada
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Carrega a tela de usuário no centro todas as vezes que for iniciado
        setLocationRelativeTo(null);
        //Inicialização do backend
        rockPaperScissor = new RockPaperScissor();
        // Componentes GUI
        addGuiComponents();

    }

    private void addGuiComponents() {
        // Contador de pontos
        computerScoreLabel  = new JLabel("Computer: 0");
        // Coordenadas x, y, altura e largura - contador de pontos
        computerScoreLabel .setBounds(0, 43, 450, 30);
        // Configuração das fontes
        computerScoreLabel .setFont(new Font("Dialog", Font.BOLD, 26));
        // Centralizar
        computerScoreLabel .setHorizontalAlignment(SwingConstants.CENTER);
        // Adiconar à interface de usuário
        add(computerScoreLabel);

        // Computer choice
        computerChoice = new JLabel("?");
        computerChoice.setBounds(175, 118, 98, 81);
        computerChoice.setFont(new Font("Dialog", Font.PLAIN, 18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        // Criando contornos
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);


        // Create player score laber
        playerScorreLabel = new JLabel("Player: 0");
        playerScorreLabel.setBounds(0, 317, 450, 30);
        playerScorreLabel.setFont((new Font("Dialog", Font.BOLD, 26)));
        playerScorreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScorreLabel);

        // Botão player

        // Botão rock
        rockButton = new JButton("Rock");
        rockButton.setBounds(40, 387, 105, 81);
        rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        rockButton.addActionListener(this);
        add(rockButton);

        //Botão paper
        paperButton = new JButton("Paper");
        paperButton.setBounds(165, 387, 105, 81);
        paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        paperButton.addActionListener(this);
        add(paperButton);

        // Botão scissor
        scissorButton = new JButton("Scissors");
        scissorButton.setBounds(291, 387, 105, 81);
        scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        scissorButton.addActionListener(this);
        add(scissorButton);

    }
    // Metodo que imprime 'vencedor' e 'tente novamente'
    private void showDialog(String message){
        JDialog resultDialog = new JDialog(this, "Result",true);
        resultDialog.setSize(227, 124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        // Mensagem
        JLabel resultLaber = new JLabel(message);
        resultLaber.setFont(new Font("Dialog", Font.BOLD, 18));
        resultLaber.setHorizontalAlignment(SwingConstants.CENTER);
        resultLaber.add(resultLaber, BorderLayout.CENTER);

        // Botão pare tentar novamente
        JButton tryAgainButton = new JButton("Try Againm?");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            // reset computer choice
            public void actionPerformed(ActionEvent e) {
                // reset computer choice
                computerChoice.setText("?");
                // fechar caixa de diálogo
                resultDialog.dispose();

            }
        });
        resultDialog.add(tryAgainButton, BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        String playerChoice = e.getActionCommand().toString();

        String result = rockPaperScissor.playRockPaperScissor(playerChoice);

        computerChoice.setText(rockPaperScissor.getCamputerChoice());

        computerScoreLabel.setText("Computer: " + rockPaperScissor.getComputerScore());
        playerScorreLabel.setText("Player: " + rockPaperScissor.getPlayerScore());

        showDialog(result);
    }
}