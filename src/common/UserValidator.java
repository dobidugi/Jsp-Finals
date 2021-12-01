package common;

public class UserValidator {
    private User user;
    public UserValidator(User user) {
        this.user = user;
    }

    public boolean RegisterNullCheck() {
        return this.user.getId() != null &&
                this.user.getName() != null &&
                this.user.getAddress() != null &&
                this.user.getPassword() != null &&
                this.user.getPassword2() != null &&
                this.user.getPhone() != null;
    }

    public boolean RegisterEmptyCheck() {
        return this.user.getId().length() != 0 &&
                this.user.getName().length()!= 0 &&
                this.user.getAddress().length() != 0 &&
                this.user.getPassword().length() != 0 &&
                this.user.getPassword2().length() != 0 &&
                this.user.getPhone().length() != 0;
    }

    public boolean isValidRegisterUser() {
        return RegisterNullCheck() && RegisterEmptyCheck();
    }


    public boolean LoginEmptyCheck() {
        return this.user.getId().length() != 0 &&
                this.user.getPassword().length() != 0;
    }

    public boolean LoginNullCheck() {
        return this.user.getId() != null &&
                this.user.getPassword() != null;
    }
    public boolean isValidLoginUser() { return LoginNullCheck() && LoginEmptyCheck(); }
}
