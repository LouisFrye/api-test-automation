public class User {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String inputUser, String inputPass) {

        if (inputUser == null || inputPass == null) {
            return false;
        }

        String cleanedUser = inputUser.trim();
        String cleanedPass = inputPass.trim();

        return username.equals(cleanedUser) &&
                password.equals(cleanedPass);
    }
}