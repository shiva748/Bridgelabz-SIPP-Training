// Marker interface for serializable backup
interface SerializableForBackup {
    // Marker interface - no methods
}

class UserData implements SerializableForBackup {
    private String name;
    private String email;

    public UserData(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserData{name='" + name + "', email='" + email + "'}";
    }
}

class SystemConfig implements SerializableForBackup {
    private String configName;
    private String value;

    public SystemConfig(String configName, String value) {
        this.configName = configName;
        this.value = value;
    }

    @Override
    public String toString() {
        return "SystemConfig{configName='" + configName + "', value='" + value + "'}";
    }
}

class BackupProcessor {
    public static void backupObject(Object obj) {
        if (obj instanceof SerializableForBackup) {
            System.out.println("Backing up: " + obj.toString());
        } else {
            System.out.println("Cannot backup - object not marked as SerializableForBackup");
        }
    }
}

public class DataSerializationBackup {
    public static void main(String[] args) {
        UserData user = new UserData("John Doe", "john@example.com");
        SystemConfig config = new SystemConfig("timeout", "30");
        String nonSerializable = "This is just a string";

        BackupProcessor.backupObject(user);
        BackupProcessor.backupObject(config);
        BackupProcessor.backupObject(nonSerializable);
    }
}
