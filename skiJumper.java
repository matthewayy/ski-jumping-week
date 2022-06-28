package Subor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class skiJumper implements Comparable<skiJumper> {
    String name;
    int score;
    Random random;
    ArrayList<String> jumpsLenghts;
    ArrayList<Integer> judgeVotes;
    int lenght;
    public skiJumper(String name) {
        this.name = name;
        this.random = new Random();
        this.jumpsLenghts = new ArrayList<>();
        this.judgeVotes = new ArrayList<>();
    }
    public String getName(){
        return this.name;
    }
    public int getScore(){
        return this.score;
    }

    public int getCurrentJumpLenght(){
        this.lenght = random.nextInt(61) + 60;
        addJumpLenght();
        return lenght;
    }
    public void addJumpLenght(){
        jumpsLenghts.add(this.lenght + " m");
    }

    public ArrayList<String> getJumpLenghts(){
        return jumpsLenghts;
    }
    public void judgeVotes(){
        for (int i = 0; i < 5; i++){
            judgeVotes.add(random.nextInt(10) + 10);
        }
    }
    public ArrayList<Integer> getJudgesVotes(){
        return judgeVotes;
    }
    public int calculateScore(){
        judgeVotes();
        ArrayList<Integer> copyOfJudgeVotes = new ArrayList<>();
        for (int i : judgeVotes) {
            copyOfJudgeVotes.add(i);
        }
        copyOfJudgeVotes.remove(Collections.min(copyOfJudgeVotes));
        copyOfJudgeVotes.remove(Collections.max(copyOfJudgeVotes));
        for (int i = 0; i < copyOfJudgeVotes.size(); i++){
            this.score += copyOfJudgeVotes.get(i);
        }
        this.score += this.lenght;
        return this.score;
    }
    @Override
    public String toString() {
        return this.name + " (" +this.score + "points)";
    }
    @Override
    public int compareTo(skiJumper skiJumper) {
        if (skiJumper.score > this.score) return -1;
        else if (skiJumper.score < this.score) return 1;
        else return 0;
    }
}
