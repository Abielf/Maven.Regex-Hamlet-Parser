import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String tester=hamletParser.hamletToLeon();
        Assert.assertFalse(tester.contains("Hamlet"));
    }@Test
    public void testChangeHamletToLeon2() {
        String tester=hamletParser.hamletToLeon();
        Assert.assertFalse(tester.contains("HAMLET"));
    }@Test
    public void testChangeHamletToLeon3() {
        String tester=hamletParser.hamletToLeon();
        Assert.assertTrue(tester.contains("LEON"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        String tester=hamletParser.horatioToTariq();
        Assert.assertFalse(tester.contains("Horatio"));
    }
    @Test
    public void testChangeHoratioToTariq2() {
        String tester=hamletParser.horatioToTariq();
        Assert.assertFalse(tester.contains("HORATIO"));
    }
    @Test
    public void testChangeHoratioToTariq3() {
        String tester=hamletParser.horatioToTariq();
        Assert.assertTrue(tester.contains("TARIQ"));
    }

    @Test
    public void testFindHoratio() {
        Matcher m=hamletParser.horatioFinder();
        Assert.assertTrue(m instanceof Matcher);
    }

    @Test
    public void testFindHamlet() {
        Matcher m=hamletParser.hamletFinder();
        Assert.assertTrue(m instanceof Matcher);
    }

    @Test
    public void testFindName(){
        Matcher m= hamletParser.nameFinder("Hey hey hey");
        Assert.assertTrue(m instanceof Matcher);
    }

/*    @Test
    public void playingWithFire(){
        String text = "Horatio dHjcnjkOanoxinkHznmdkHoratiosnckHORATIOamsn Horatio aksmalk";
        String patternString = "(Horatio)|(HORATIO)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        for (int i = 0; matcher.find(); i++) {
            System.out.println(new StringBuilder()
                    .append("\n-------------------")
                    .append("\nValue = " + matcher.group())
                    .append("\nMatch Number = " + i)
                    .append("\nStarting index = " + matcher.start())
                    .append("\nEnding index = " + matcher.end())
                    .toString());
        }System.out.println(matcher.replaceAll("Tariq"));
    }*/

}