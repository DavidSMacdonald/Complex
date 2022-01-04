package com.company;

public class SoccerTeam {

    private static int totalGamesPlayed = 0;
    private static int totalGoalsScored = 0;

    private int w;
    private int l;
    private int d;

    public SoccerTeam() {
        w = 0;
        l = 0;
        d = 0;
    }

    public static int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }
    public static int getTotalGoalsScored() {
        return totalGoalsScored;
    }

    public void reset() {
        w = l = d = 0;
    }

    public static void startTournament() {
        totalGoalsScored = 0;
        totalGamesPlayed = 0;
    }

    public int points() {
        return w*3 + d*1;
    }

    public void played(SoccerTeam other, int myScore, int otherScore) {
        totalGamesPlayed++;
        totalGoalsScored += myScore + otherScore;
        if (myScore > otherScore) {
            w++;
            other.l++;
        }
        else if (myScore < otherScore) {
            l++;
            other.w++;
        }
        else {
            d++;
            other.d++;
        }
    }

    public static void main(String[] args) {
        SoccerTeam Andover = new SoccerTeam();
        SoccerTeam Billerica = new SoccerTeam();
        SoccerTeam Haverhill = new SoccerTeam();
        SoccerTeam Dracut = new SoccerTeam();

        // Billerica wins, Andover loses
        Andover.played(Billerica,0,4);
        // Haverhill wins, Dracut loses
        Haverhill.played(Dracut,4,2);
        // Billerica, Dracut tie
        Billerica.played(Dracut,1,1);
        // Andover wins, Haverhill loses
        Andover.played(Haverhill,2,0);
        /*
        STANDINGS
        Town        W/L/D - # pts
        Andover     1/1/0 - 3 pts
        Billerica   1/0/1 - 4 pts
        Haverhill   1/1/0 - 3 pts
        Dracut      0/1/1 - 1 pt

        4 Games Played in Total
        14 Goals scored in total
         */
        System.out.println("Andover " + Andover.points());
        System.out.println("Billerica " + Billerica.points());
        System.out.println("Haverhill " + Haverhill.points());
        System.out.println("Dracut " + Dracut.points());
        System.out.println("Games played: " + getTotalGamesPlayed());
        System.out.println("Goals scored: " + getTotalGoalsScored());
    }
}
