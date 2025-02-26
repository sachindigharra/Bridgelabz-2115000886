import org.json.JSONObject;

public class CensorUtils {

    public static void censorMatch(JSONObject match) {
        String team1 = match.getString("team1");
        String team2 = match.getString("team2");
        String playerOfMatch = match.getString("player_of_match");

        match.put("team1", maskTeamName(team1));
        match.put("team2", maskTeamName(team2));
        match.put("player_of_match", "REDACTED");
    }

    private static String maskTeamName(String teamName) {
        String[] parts = teamName.split(" ");
        if (parts.length > 1) {
            return parts[0] + " ***";
        } else {
            return teamName;
        }
    }
}