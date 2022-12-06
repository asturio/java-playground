package bogus.karameikos.leaderboard;

public class Leaderboard {
    int iterations = 0;
    public int findPlacement(int[] ranked, int score) {
        int highest = 0;
        int lowest = ranked.length - 1;
        iterations = 0;
        int pos = 0;
        while (highest <= lowest) {
            iterations++;
            pos = (lowest + highest) / 2;
            int element = ranked[pos];
            System.out.printf("score: %d, pos: %d, value:%d, highest: %d, lowest: %d, iteration: %d%n",
                score, pos, element, highest, lowest,iterations);
            if (score >= element) {
                if (pos == 0 || ranked[pos - 1] > score) {
                    break;
                }
                lowest = pos - 1;
            } else {
                if (pos == ranked.length - 1) {
                    pos++;
                    break;
                }
                highest = pos + 1;
            }
        }
        return pos + 1;
    }
}
