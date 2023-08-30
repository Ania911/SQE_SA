package core.dataProvider;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.util.List;

public class DP {

    @DataProvider(name = "userLogin")
    public Object[][] userLogin() {
        return new Object[][]{
                {"test&gmail.com", "1&1233"}, {"test1&gmail.com","1&1234"}
        };
    }

    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        try {
            CSVReader reader = new CSVReaderBuilder(new FileReader("test_data.csv")).withSkipLines(1).build();
            List<String[]> userData = reader.readAll();

            Object[][] data = new Object[userData.size()][];

            for (int i = 0; i < userData.size(); i++) {
                String[] row = userData.get(i);
                data[i] = new Object[]{row[0], row[1], row[2], row[3]};
            }

            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
