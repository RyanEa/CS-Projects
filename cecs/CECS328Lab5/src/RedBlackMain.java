/**
 * Created by Ryan on 4/11/2016.
 */
import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Paths;
        import java.util.Scanner;
        import java.util.stream.Stream;

public class RedBlackMain {
    public static void main(String args[]) {
        RedBlackTreeMap treemap= new RedBlackTreeMap();
        try (Stream<String> stream = Files.lines(Paths.get("players_homeruns.csv")).limit(5)) {
            stream
                    .map(string -> string.split(","))
                    .forEach(strArray -> treemap.insert(strArray[0],
                            Integer.parseInt(strArray[1])));
        } catch (IOException e) {
            e.printStackTrace();
        }
        treemap.printStructure();
        System.out.println("TEST CASES:");
        System.out.println("A)"+"Stan Musial:"+treemap.find("Stan Musial").toString());
        System.out.println("B)"+"Honus Wagner:"+treemap.find("Honus Wagner").toString());
        System.out.println("C)"+"Rogers Hornsby"+treemap.find("Rogers Hornsby").toString());
        System.out.println("D)"+"Ted Williams"+treemap.find("Ted Williams").toString());
    }
}
