// backend
import java.util.Random;

public class RockPaperScissor {

    // Todas as escolhas possíveis
    private static final String[] computerChoices = {"Rock", "Paper", "Scissors"};

    // armazena
    private String camputerChoices;

    public String getCamputerChoice() {
        return camputerChoices;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore(){
        return playerScore;
    }

    public String computerChoice;

    private int computerScore, playerScore;

    // gerador de aleatoriedade para escolher as possibilidades
    private Random random;

    // Construtor para inicializar o obj random
    public RockPaperScissor(){
        random = new Random();
    }

    public String playRockPaperScissor(String playerChoice){
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];
        String result;

        if(computerChoice.equals("Rock")){
            if(playerChoice.equals("Paper")){
                result = "Player Wins";
                playerScore++;
            }else if(playerChoice.equals("Scissors")){
                result = "Computer Wins";
                computerScore++;
            }else{
                result = "Draw";
            }
        }else if(computerChoice.equals("Paper")){
            if(playerChoice.equals("Scissors")){
                result = "Player Wins";
                playerScore++;
            }else if(playerChoice.equals("Rock")){
                result = "Computer Wins";
                computerScore++;
            }else{
                result = "Draw";
            }
        }else{
            // computer chooses scissors
            if(playerChoice.equals("Rock")){
                result = "Player Wins";
                playerScore++;
            }else if(playerChoice.equals("Paper")){
                result = "Computer Wins";
                computerScore++;
            }else{
                result = "Draw";
            }
        }

        return result;
    }

}
