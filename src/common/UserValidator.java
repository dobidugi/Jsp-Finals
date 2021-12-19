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


    public boolean FindIdNullCheck() {
        return this.user.getName() != null &&
                this.user.getPhone() != null;
    }

    public boolean FindIdEmptyCheck() {
        return this.user.getName().length() != 0 &&
                this.user.getPhone().length() != 0;
    }

    public boolean isValidFindUserId() { return FindIdNullCheck() && FindIdEmptyCheck();}



    public boolean FindPwNullCheck() {
        return this.user.getName() != null &&
                this.user.getPhone() != null &&
                this.user.getId() != null;
    }

    public boolean FindPwEmptyCheck() {
        return this.user.getName().length() != 0 &&
                this.user.getPhone().length() != 0  &&
                this.user.getId().length() != 0;
    }

    public boolean isValidFindUserPw() { return FindPwNullCheck() && FindPwEmptyCheck(); }



    public boolean ResetPasswordNullCheck() {
        return this.user.getName() != null &&
                this.user.getId() != null &&
                this.user.getPhone() != null &&
                this.user.getPassword() != null &&
                this.user.getPassword2() != null;
    }


    public boolean ResetPasswordEmptyCheck() {
        return this.user.getName().length() != 0 &&
                this.user.getId().length() != 0 &&
                this.user.getPhone().length() != 0 &&
                this.user.getPassword().length() != 0 &&
                this.user.getPassword2().length() != 0;
    }

    public boolean isValidResetPassword() { return ResetPasswordNullCheck() && ResetPasswordEmptyCheck(); }



    public boolean EditUserNullCheck() {
        return this.user.getUser_pk() != 0 &&
                this.user.getId() != null &&
                this.user.getPhone() != null &&
                this.user.getAddress() != null;
    }

    public boolean EditUserEmptyCheck() {
        return this.user.getUser_pk() != 0 &&
                this.user.getId().length() != 0 &&
                this.user.getPhone().length() != 0 &&
                this.user.getAddress().length() != 0;

    }


    public boolean isEditUser() { return EditUserNullCheck() && EditUserEmptyCheck(); };
}
