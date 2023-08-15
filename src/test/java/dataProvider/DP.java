package dataProvider;
import org.testng.annotations.DataProvider;

public class DP {

    @DataProvider(name = "userLogin")
    public Object[][] userLogin() {
        return new Object[][]{
                {"test&gmail.com", "1&1233"}, {"test1&gmail.com","1&1234"}
        };
    }

}
