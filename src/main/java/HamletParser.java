import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public Matcher nameFinder(String nameToFind){
        Pattern findPattern= Pattern.compile(nameToFind);
        return findPattern.matcher(hamletData);
    }
    public Matcher horatioFinder(){
        return nameFinder("(HORATIO)|(Horatio)");
    }
    public Matcher hamletFinder(){
        return nameFinder("(HAMLET)|(Hamlet)");
    }

    public String horatioToTariq(){
        return horatioFinder().replaceAll("TARIQ");
    }
    public String hamletToLeon(){
        return hamletFinder().replaceAll("LEON");
    }

    public void resetHamletText(){hamletData=loadFile();}
    public String getHamletData(){
        return hamletData;
    }

}
