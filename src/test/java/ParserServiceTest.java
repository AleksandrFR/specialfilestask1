import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserServiceTest {
    ParserService parserService;
    List<Employee> expected;

    @BeforeEach
    public void beforeEachMethod() {
        parserService = new ParserService();
        expected = Arrays.asList(new Employee(1, "John", "Smith", "USA", 25),
                new Employee(2, "Inav", "Petrov", "RU", 23));
    }

    @Test
    public void testParseXML() {
        String s = "data.xml";

        List<Employee> result = parserService.parseXML(s);

        assertEquals(expected, result);

    }

    @Test
    public void testParseCSV() {
        String[] cm = {"id", "firstName", "lastName", "country", "age"};
        String fn = "data.csv";

        List<Employee> result = parserService.parseCSV(cm, fn);

        assertEquals(expected, result);
    }

    @Test
    public void testReadString() {
        String fn = "data1.json";

        String expectedStr = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25}," +
                "{\"id\":2,\"firstName\":\"Inav\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";
        String result = parserService.readString(fn);
        assertEquals(result, expectedStr);
    }
}
