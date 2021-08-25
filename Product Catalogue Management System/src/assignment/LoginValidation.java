package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginValidation {

    public boolean checkValidation(String fileName, char checkPos, String userID, String userPass) throws FileNotFoundException, IOException {
        String[] checkVal;
        FileIO readFile = new FileIO();
        switch (checkPos) {
            case 'A':
                File Admin = FileIO.searchFilePath(fileName);
                checkVal = readFile.retrieveDetails(fileName, Admin, userID, userPass);
                return checkVal != null;
            case 'P':
                File PM = FileIO.searchFilePath(fileName);
                checkVal = readFile.retrieveDetails(fileName, PM, userID, userPass);
                return checkVal != null;
            case 'S':
                File SP = FileIO.searchFilePath(fileName);
                checkVal = readFile.retrieveDetails(fileName, SP, userID, userPass);
                return checkVal != null;
            default:
                break;
        }
        boolean validation = true;
        return validation;
    }
}
