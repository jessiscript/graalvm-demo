package gameoflife;

import java.io.IOException;
import java.util.function.Consumer;

public class Main {

    record Args(
            String patternFile,
            int periodMilliseconds,
            int leftPadding,
            int topPadding,
            int rightPadding,
            int bottomPadding,
            boolean rotate,
            boolean enableBenchmark) {
        static Args parse(String[] args) {
            return new Args(
                    args.length > 0 && !args[0].isEmpty() ? args[0] : "patterns/gosper_glider_gun.txt",
                    args.length > 1 ? Integer.parseInt(args[1]) : 20,
                    args.length > 2 ? Integer.parseInt(args[2]) : 2,
                    args.length > 3 ? Integer.parseInt(args[3]) : 2,
                    args.length > 4 ? Integer.parseInt(args[4]) : 22,
                    args.length > 5 ? Integer.parseInt(args[5]) : 24,
                    args.length > 6 ? Boolean.parseBoolean(args[6]) : false,
                    args.length > 7 ? Boolean.parseBoolean(args[7]) : false);
        }
    }

    public static void main(String[] args) throws IOException {
        Args a = Args.parse(args);

        boolean[][] original = PatternParser.parseFile(a.patternFile);
        boolean[][] rotated = a.rotate ? PatternParser.rotate(original) : original;
        boolean[][] pattern = PatternParser.pad(rotated, a.leftPadding, a.topPadding, a.rightPadding, a.bottomPadding);
    }

}
