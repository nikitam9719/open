package superUsers;

import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by AnatolyRogov on 20.06.17.
 */
public class SuperUser {
    public String login;
    public String password;

    public SuperUser(String role) throws FileNotFoundException {
        ReadFileSuperUsers(role);
    }

    @Step("Выбрать пользователя")
    public void ReadFileSuperUsers(String role) throws FileNotFoundException {
        String line;
        String[] sSpl;
        ArrayList<String> loginArray = new ArrayList<String>();
        ArrayList<String> passwordArray = new ArrayList<String>();
        try {
            String curDir = new File("").getAbsolutePath();
            BufferedReader br = new BufferedReader(new FileReader(curDir + "\\src\\main\\java\\SuperUsers\\SuperUsers.csv"));
            try {
                while ((line = br.readLine()) != null) {
                    if (line.contains(role)) {
                        sSpl = line.split(";");
                        loginArray.add(sSpl[2]);
                        passwordArray.add(sSpl[3]);
                    }
                }
            } finally {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Assert.assertNotEquals(loginArray.size(), 0);
            Random rnd = new Random();
            int rand = rnd.nextInt(loginArray.size());
            this.login = loginArray.get(rand);
            this.password = passwordArray.get(rand);
        } catch (Throwable e) {
            throw new IllegalStateException("Пользователь с необходимой ролью не найден" + e);
        }
    }
}
