package Data;

import org.testng.annotations.DataProvider;

import java.util.Objects;

public class DataProviderTrello {

    @DataProvider(name = "login")
    public static Object[][] dragAndDrop(){
        String email ="testtesttest@mail.com";
        String password = "12345678";
        String userName = "testtesttest";
        return new Object[][] {{email,
                password,
                userName
        }};
    }

}