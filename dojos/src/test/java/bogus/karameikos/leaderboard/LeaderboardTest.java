package bogus.karameikos.leaderboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeaderboardTest {

    private Leaderboard leaderboard;

    @BeforeEach
    public void beforeEach() {
        leaderboard = new Leaderboard();
    }

    @Test
    void emptyLeaderboard() {
        // given
        int[] ranked = {};
        // when
        int rank = leaderboard.findPlacement(ranked, 3);
        // then
        assertThat(rank).isEqualTo(1);
    }

    @Test
    void oneGreaterLeaderboard() {
        // given
        int[] ranked = {5};
        // when
        int rank = leaderboard.findPlacement(ranked, 6);
        // then
        assertThat(rank).isEqualTo(1);
    }

    @Test
    void oneLowerLeaderboard() {
        // given
        int[] ranked = {5};
        // when
        int rank = leaderboard.findPlacement(ranked, 4);
        // then
        assertThat(rank).isEqualTo(2);
    }

    @Test
    void middleLeaderboard() {
        // given
        int[] ranked = {10, 8, 6, 4, 2, 0};
        // when
        int rank = leaderboard.findPlacement(ranked, 5);
        // then
        assertThat(rank).isEqualTo(4);
    }

    @Test
    void middleExactLeaderboard() {
        // given
        int[] ranked = {10, 8, 6, 4, 2, 0};
        // when
        int rank = leaderboard.findPlacement(ranked, 2);
        // then
        assertThat(rank).isEqualTo(5);
        assertThat(leaderboard.iterations).isLessThan(3);
    }

    @Test
    void hackerRank1() {
        int[] ranked = {100, 50, 40, 20, 10};

        int[] results = new int[4];
        results[0] = leaderboard.findPlacement(ranked, 5);
        results[1] = leaderboard.findPlacement(ranked, 25);
        results[2] = leaderboard.findPlacement(ranked, 50);
        results[3] = leaderboard.findPlacement(ranked, 120);

        assertThat(results).containsExactly(6, 4, 2, 1);
    }

}
