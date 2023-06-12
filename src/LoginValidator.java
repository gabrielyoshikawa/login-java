import java.util.List;

public class LoginValidator {
    private CSVReader csvReader;

    public LoginValidator(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    public boolean validateLogin(String username, String password) throws InvalidLoginException {
        List<String[]> data = csvReader.read();

        for (String[] row : data) {
            if (row.length >= 2 && row[0].equals(username) && row[1].equals(password)) {
                return true;
            }
        }

        throw new InvalidLoginException("Invalid username or password");
    }
}
