package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface LoginMethods {

    public void validCredentialsLogin()throws FileNotFoundException;
    public void invalidCredentialsLogin()throws FileNotFoundException;
    public void readLargeLoginData() throws IOException;
}
