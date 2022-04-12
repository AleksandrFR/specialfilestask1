
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        ParserService parserService = new ParserService();
        List<Employee> list1 = parserService.parseCSV(columnMapping, fileName);
        parserService.writeString(parserService.listToJson(list1), "1");
        List<Employee> list2 = parserService.parseXML("data.xml");
        parserService.writeString(parserService.listToJson(list2), "2");
        System.out.println(parserService.jsonToList(parserService.readString("data1.json")));
    }
}



