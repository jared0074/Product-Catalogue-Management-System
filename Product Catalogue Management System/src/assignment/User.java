package assignment;

import java.io.File;
import java.io.FileNotFoundException;

public abstract class User {

    private String userIdNum, userPassword, userName, userAddress, userEmail, userPosition, filePath;
    private String userStatus, fileName;

    public User(String userIdNum) {
        this.userIdNum = userIdNum;
    }

    public abstract String generateUserID(File filePath) throws FileNotFoundException;

    public void createObj(String[] details) throws FileNotFoundException {
        this.userIdNum = details[0];
        this.userPassword = details[1];
        this.userName = details[2];
        this.userAddress = details[3];
        this.userEmail = details[4];
        this.userStatus = details[5];
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setUserIdNum(String IdNum) {
        this.userIdNum = IdNum;
    }

    public void setUserPassword(String password) {
        this.userPassword = password;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public void setUserAddress(String address) {
        this.userAddress = address;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }

    public void setUserPosition(String position) {
        this.userPosition = position;
    }

    public void userStatus(String status) {
        this.userStatus = status;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUserIdNum() {
        return userIdNum;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getStatus() {
        return userStatus;
    }

    public String getFileName() {
        return fileName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserStatus() {
        return userStatus;
    }

}
