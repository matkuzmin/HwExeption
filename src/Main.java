import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {


    public static void main(String[] args) {
        String login = "fwEFAFSFAF";
        String password = "dqwfqfre9";
        String confirmPassword = "dgdgqdqwd";


        try {
            validateCredentials(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Длина логина или пароля более 20 символов");
        } catch (WrongPasswordException e) {
            System.out.println("Проверьте правильность написания пароля");
        } finally {
            System.out.println("Проверка выполнена");
        }

    }

    public static boolean validateCredentials(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {

        int maxLoginLength = 20;
        int maxPassLength = 20;

        if (login.length() >= maxLoginLength || password.length() >= maxPassLength) {
            throw new WrongLoginException();
        }
        if (!password.equals(confirmPassword) || !password.matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException();
        }
        return true;
    }
}