package ZadaniaDomowe_14_jan_lists.zad22;

public class Match {
    private final Team teamFirst;
    private final Team teamSecond;

    public Match(Team teamFirst, Team teamSecond) {
        this.teamFirst = teamFirst;
        this.teamSecond = teamSecond;
    }

    public Team getTeamFirst() {
        return teamFirst;
    }

    public Team getTeamSecond() {
        return teamSecond;
    }
}
