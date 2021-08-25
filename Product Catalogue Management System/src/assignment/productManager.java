package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class productManager extends User {

    public productManager(String userIdNum) {
        super(userIdNum);
    }

    @Override
    public String generateUserID(File filePath) throws FileNotFoundException {
        try (Scanner fileScanner = new Scanner(filePath)) {
            int IDNum = 1;
            String userID;
            while (fileScanner.hasNextLine()) {
                String countInLine = fileScanner.nextLine();
                String[] record = countInLine.split("\n");
                IDNum = IDNum + 1;
            }
            userID = "P" + String.format("%03d", IDNum);
            return userID;
        }
    }

}
