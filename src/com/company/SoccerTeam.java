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
        System.out.println("WEEK 1");
        System.out.println("Andover " + Andover.points());
        System.out.println("Billerica " + Billerica.points());
        System.out.println("Haverhill " + Haverhill.points());
        System.out.println("Dracut " + Dracut.points());
        System.out.println("Games played: " + getTotalGamesPlayed());
        System.out.println("Goals scored: " + getTotalGoalsScored());

        Andover.reset();
        Billerica.reset();
        Haverhill.reset();
        Dracut.reset();
        startTournament();

        // Andover, Dracut tie
        Andover.played(Dracut,3,3);
        // Haverhill wins, Billerica loses
        Haverhill.played(Billerica,4,2);
        // Billerica, Andover tie
        Billerica.played(Andover,1,1);
        // Dracut wins, Haverhill loses
        Dracut.played(Haverhill,2,0);
        /*
        STANDINGS
        Town        W/L/D - # pts
        Andover     0/0/2 - 2 pts
        Billerica   0/1/1 - 1 pts
        Haverhill   1/1/0 - 3 pts
        Dracut      1/0/1 - 4 pt

        4 Games Played in Total
        16 Goals scored in total
         */
        System.out.println("\nWEEK 2");
        System.out.println("Andover " + Andover.points());
        System.out.println("Billerica " + Billerica.points());
        System.out.println("Haverhill " + Haverhill.points());
        System.out.println("Dracut " + Dracut.points());
        System.out.println("Games played: " + getTotalGamesPlayed());
        System.out.println("Goals scored: " + getTotalGoalsScored());
    }
}

/*
WEEK 1
Andover 3
Billerica 4
Haverhill 3
Dracut 1
Games played: 4
Goals scored: 14

WEEK 2
Andover 2
Billerica 1
Haverhill 3
Dracut 4
Games played: 4
Goals scored: 16
 */
