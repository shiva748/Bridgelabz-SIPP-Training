// Custom marker interface for sensitive data
interface SensitiveData {
    // Marker interface - no methods
}

class UserCredentials implements SensitiveData {
    private String username;
    String password;

    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserCredentials{username='" + username + "', password='*****'}";
    }
}

class CreditCardInfo implements SensitiveData {
    private String cardNumber;
    private String expiryDate;
    public String cvv;

    public CreditCardInfo(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "CreditCardInfo{cardNumber='****-****-****-" + cardNumber.substring(cardNumber.length() - 4)
                + "', expiryDate='" + expiryDate + "', cvv='***'}";
    }
}

class RegularData {
    private String publicInfo;

    public RegularData(String publicInfo) {
        this.publicInfo = publicInfo;
    }

    @Override
    public String toString() {
        return "RegularData{publicInfo='" + publicInfo + "'}";
    }
}

class DataEncryptor {
    public static void encryptIfSensitive(Object data) {
        if (data instanceof SensitiveData) {
            System.out.println("Encrypting sensitive data: " + data.toString());
        } else {
            System.out.println("Data is not sensitive, no encryption needed: " + data.toString());
        }
    }

    public static void processData(Object data) {
        if (data instanceof SensitiveData) {
            System.out.println("Processing sensitive data with extra security measures");
        } else {
            System.out.println("Processing regular data");
        }
    }
}

public class SensitiveDataTagging {
    public static void main(String[] args) {
        UserCredentials credentials = new UserCredentials("john_doe", "secret123");
        CreditCardInfo cardInfo = new CreditCardInfo("1234567812345678", "12/25", "123");
        RegularData publicInfo = new RegularData("Public announcement");

        System.out.println("Data Encryption Processing:");
        DataEncryptor.encryptIfSensitive(credentials);
        DataEncryptor.encryptIfSensitive(cardInfo);
        DataEncryptor.encryptIfSensitive(publicInfo);

        System.out.println("\nData Processing:");
        DataEncryptor.processData(credentials);
        DataEncryptor.processData(cardInfo);
        DataEncryptor.processData(publicInfo);
    }
}
