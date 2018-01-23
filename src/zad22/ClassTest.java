package ZadaniaDomowe_14_jan_lists.zad22;

import java.util.ArrayList;
import java.util.List;

public class ClassTest {
    static List<Team> teams = new ArrayList<Team>();
    static List<Match> matches = new ArrayList<Match>();
    static List<Match> matchesCopy = new ArrayList<Match>();
    static Match[][] tableMatches = new Match[5][5];
    static final int MaxNumberOfMatch = 2;
    static final int MaxNumberOfQueues = 3;
    static int k = 0,l=0;
    static int x,y;

    public static void main(String[] args) {

//tworzenie zespołów
        teams.add(new Team("TeamA"));
        teams.add(new Team("TeamB"));
        teams.add(new Team("TeamC"));
        teams.add(new Team("TeamD"));
        teams.add(new Team("TeamE"));
        teams.add(new Team("TeamF"));
 /*       teams.add(new Team("TeamG"));
        teams.add(new Team("TeamH"));
*/

//tworzenie listy meczy
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Team team1 = teams.get(i);
                Team team2 = teams.get(j);
                matches.add(new Match(team1, team2));
            }
        }
        matchesCopy.addAll(matches);


        while (k < matches.size()) {
            for (x = 0; x < MaxNumberOfQueues; x++) {
                for (y = 0; y < MaxNumberOfMatch; y++) {
                    if (y == 0) {
                            tableMatches[x][y] = matches.get(k++);
                            matches.remove(k-1);
                            k=0;
                    }
                    if (y > 0) {
                        l=k;
                        chechNext(l);
                        k=0;

                    }


                }

            }
        }
     /*   tableMatches[0][1] = matches.get(1);

        tableMatches[1][0] = matches.get(2);
        tableMatches[1][1] = matches.get(3);

        tableMatches[2][0] = matches.get(4);
        tableMatches[2][1] = matches.get(5);
       */
    }
    private static void chechNext(int m) {

        //Team teamPreviousSet1 = matches.get(l-1).getTeamFirst();
        //Team teamPreviousSet2 = matches.get(l-1).getTeamSecond();

        Team teamPreviousSet1 = tableMatches[x][y-1].getTeamFirst();
        Team teamPreviousSet2 = tableMatches[x][y-1].getTeamSecond();

        Team teamCurrent1 = matches.get(m).getTeamFirst();
        Team teamCurrent2 = matches.get(m).getTeamSecond();

        if (((teamPreviousSet1!=teamCurrent1) && (teamPreviousSet1!=teamCurrent2)) &&
                ((teamPreviousSet2!=teamCurrent1) && (teamPreviousSet2!=teamCurrent2))) {
            tableMatches[x][y] = matches.get(m);
            matches.remove(m);

        }
        else {
            chechNext(++m);

        }

    }




            }




