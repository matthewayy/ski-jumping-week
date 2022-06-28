package Subor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class skiJumping {
    private String name;
    private Random random;
    private Scanner reader;
    private ArrayList<skiJumper> participants;
    private int roundCounter;
    private int score;

    public skiJumping(String name) {
        this.name = name;
        this.reader = new Scanner(System.in);
        this.participants = new ArrayList<>();
        this.roundCounter = 1;
        random = new Random();
        this.score = 0;
    }
    public void registration(){
        System.out.println(name + " ski jumping week\nWrite the names of the participant one at a time");
        while(true) {
            System.out.println("Participant name:");
            String participant = reader.nextLine();
            if (participant.isEmpty()) break;
            participants.add(new skiJumper(participant));
        }
            beginTournament();
    }
    private void beginTournament() {
        System.out.println("\nThe tournament begins!\n");
        while(true){
            System.out.println("Write \"jump\" to jump; otherwise you quit:");
            String command = reader.nextLine();
            if (command.equals("quit")){
                tournamentResults();
                break;
                }else if (command.equals("jump")) {
                jumpingOrder();
                resultsOfRound();
                roundCounter++;
            }
                else continue;
            }
        }
    private void resultsOfRound() {

        System.out.println("Results of round " + roundCounter);
        for (skiJumper skiJumper : this.participants){
            skiJumper.calculateScore();
            System.out.println("    " + skiJumper.getName());
            System.out.println("        lenght: " + skiJumper.getCurrentJumpLenght());
            System.out.println("        judge votes: " +  skiJumper.getJudgesVotes());
            skiJumper.getJudgesVotes().clear();
        }
    }
    private void tournamentResults() {
        System.out.println("\nThanks!\nTournament results:");
        System.out.println("Position    Name");
        int number = 1;
        for (skiJumper skiJumper : this.participants){
            System.out.println(number +"\t\t\t"+ skiJumper.getName() +" ("+ skiJumper.calculateScore() + " points)" +"\njump lengths: " +skiJumper.getJumpLenghts());
            number++;
            skiJumper.jumpsLenghts.clear();
        }
    }
    private void jumpingOrder() {
        int number = 1;
        System.out.println("\nRound " + roundCounter + "\n");
        System.out.println("Jumping order:");
        Collections.sort(this.participants);
        for (skiJumper skiJumper : this.participants){
                 System.out.println("    " + number + ". " + skiJumper.getName() + " (" + skiJumper.getScore() + " points)");
        }
    }
}


