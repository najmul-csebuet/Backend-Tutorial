package MockitoTest;

public class MyService {
    private MyDatabase database;

    public MyService(MyDatabase database) {
        this.database = database;
    }

    public boolean query(String query) {
        return database.isAvailable();
    }


    @Override
    public String toString() {
        return "Using database with id: " + String.valueOf(database.getUniqueId());
    }
}
