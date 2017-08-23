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
//        try (Stream<String> stream = Files.lines(Paths.get("players_homeruns.csv"))) {
//            stream
//                    .map(string -> string.split(","))
//                    .forEach(strArray -> treemap.insert(strArray[0],
//                            Integer.parseInt(strArray[1])));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        treemap.insert(555, 505);
        treemap.insert(444, 506);
        treemap.insert(333, 504);
//        treemap.insert("BARRY", 503);
        treemap.printStructure();
    }
}
