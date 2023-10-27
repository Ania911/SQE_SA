package core.dataProvider;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class DP {

    @DataProvider(name = "userLogin")
    public Object[][] userLogin() {
        return new Object[][]{
                {"test&gmail.com", "1&1233"}, {"test1&gmail.com", "1&1234"}
        };
    }

    @DataProvider(name = "userData")
    public Object[][] getUserData() {
        try {
            CSVReader reader = new CSVReaderBuilder(new FileReader("src/main/resources/test_data.csv")).withSkipLines(1).build();
            List<String[]> userData = reader.readAll();

            Object[][] data = new Object[userData.size()][];

            for (int i = 0; i < userData.size(); i++) {
                String[] row = userData.get(i);
                data[i] = new Object[]{row[0], row[1]};
            }

            return data;
        } catch (Exception e) {
            e.printStackTrace();
            // Return an empty array if there's an exception
            return new Object[0][0];
        }
    }

    @DataProvider(name = "petData")
    public Object[][] petData() {
        return new Object[][]{
                {"Buddy", "Available", Arrays.asList("url1")},
                {"Fido", "Pending", Arrays.asList("url2")},
        };
    }

    @DataProvider(name = "petUser")
    public Object[][] petUser() {
        return new Object[][]{
                {"Test", "Test123"},
                {"Test1", "Test1234"},
        };
    }

    @DataProvider(name = "userRegistrationData")
    public Object[][] userDataProvider() {
        return new Object[][]{
                {"username1", "lastName1", "password1", "password1"}
        };
    }

    @DataProvider(name = "login")
    public Object[][] login() {
        return new Object[][]{
                {"STest1234@example.com", "123456789"}
        };
    }

    @DataProvider(name = "sortingOptions")
    public Object[][] sortingOptions() {
        return new Object[][]{
                {"Position"},
                {"Name: A to Z"},
                {"Name: Z to A"},
                {"Price: Low to High"}
        };
    }

    @DataProvider(name = "numberPerPage")
    public Object[][] numberPerPage() {
        return new Object[][]{
                {4},
                {8},
                {12}
        };
    }
}
