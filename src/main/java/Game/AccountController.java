package Game;

import Database.Database;

public class AccountController {
    public boolean login(String username, String password) {
        String passwordHash = hashPassword(password);
        return Database.checkCredentials(username, passwordHash);
    }

    public boolean register(String username, String password) {
        String passwordHash = hashPassword(password);
        return Database.createAccount(username, passwordHash);
    }

    private String hashPassword(String password) {
        // Simple hash logic (use more secure algorithms in production)
        return Integer.toHexString(password.hashCode());
    }
}