package karameikos.bogus.hanoi;

/**
 * Created by claudio on 29.01.17.
 */
public class Stack {

    private final int circles;

    public Stack(int initCircles) {
        this.circles = initCircles;
    }

    public Stack() {
        circles = 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('|');
        for (int i = circles; i > 0; i--)  {
            builder.append(i);
        }
        fillWithEmpty(builder, circles);

        return builder.toString();
    }

    private void fillWithEmpty(StringBuilder builder, int circles) {
        for (int fillUp = 5 - circles; fillUp > 0 ; fillUp--) {
            builder.append('-');
        }
    }
}
