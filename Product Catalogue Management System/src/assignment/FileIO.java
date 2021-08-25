package assignment;

import AdminGUI.AdminManagePM;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FileIO {

    //Write Login Records into file
    public void writeLoginRecords(String position, String userID, String action, String validation) throws IOException {
        File filePath = FileIO.searchFilePath("SystemInfo.txt");
        String time = Calendar.getInstance().getTime().toString();
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(position + "\t" + userID + "\t" + action + "\t" + validation + "\t" + time + "\n");
            writer.flush();
            writer.close();
        }
    }

    //to append details to file in  string[] 
    public static boolean writeDetails(File file, String[] newDetails, int ArrayLength) {
        try (FileWriter writer = new FileWriter(file, true)) {
            for (int i = 0; i < ArrayLength; i++) {
                writer.write(newDetails[i]);
                writer.write("\t");
            }
            writer.write("\n");
            writer.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //to retreive details from file according to primary key
    public String[] retrieveDetails(File file, String primaryKey) throws FileNotFoundException {
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String checkRecordsLine = fileScanner.nextLine();
                String[] check = checkRecordsLine.split("\t");
                if (primaryKey.equals(check[0])) {
                    return check;
                }
            }
            fileScanner.close();
        }
        return null;
    }

    //overloaded retrieveDetails
    public String[] retrieveDetails(String fileName, File file, String userID, String userPass) throws IOException {
        try {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String checkRecordsLine = fileScanner.nextLine();
                    String[] check = checkRecordsLine.split("\t");
                    if (userID.equals(check[0]) && userPass.equals(check[1])) {
                        fileScanner.close();
                        return check;
                    }
                }
                fileScanner.close();
                return null;
            }
        } catch (FileNotFoundException ex) {
            File user = new File(fileName);
            user.createNewFile();
            try (FileWriter writer = new FileWriter(user, true)) {
                char[] IDNum = fileName.toCharArray();
                writer.write(IDNum[0] + "001" + "\t" + "master123" + "\t" + "master " + "\t" + "master123" + "\t" + "master " + "\t" + "Active");
                writer.flush();
            }
        }
        return null;
    }

    //Arraylist to retrieve more than 1 detail from text file
    public ArrayList<String> retrieveAllDetails(File file) throws FileNotFoundException {
        ArrayList<String> allDetails = new ArrayList();
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String detailsInLine = fileScanner.nextLine();
                allDetails.add(detailsInLine);
                if (!fileScanner.hasNextLine()) {
                    fileScanner.close();
                    return allDetails;
                }
            }
            fileScanner.close();
        }
        return null;
    }

    //to build table that contains all records in file
    public void buildTable(File file, JTable Table, String[] columnName) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            model.setColumnIdentifiers(columnName);
            Object[] tableLines = br.lines().toArray();
            for (Object tableLine : tableLines) {
                String line = tableLine.toString().trim();
                String[] dataRow = line.split("\t");
                model.addRow(dataRow);
                br.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminManagePM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //to modify a single record in file
    public static boolean modifyFile(String filePath, String primaryKey, String[] changedArray, int arrayLength) throws IOException {
        File currentFile = new File(filePath);
        try (Scanner fileScanner = new Scanner(currentFile)) {
            File temp = new File("temp.txt");
            try (FileWriter tempWrite = new FileWriter(temp)) {
                while (fileScanner.hasNextLine()) {
                    String checkRecordsLine = fileScanner.nextLine();
                    String[] check = checkRecordsLine.split("\t");
                    if (primaryKey.equals(check[0])) {
                        for (int i = 0; i < arrayLength; i++) {
                            tempWrite.write(changedArray[i]);
                            tempWrite.write("\t");
                        }
                        tempWrite.write("\n");
                        continue;
                    }
                    tempWrite.write(checkRecordsLine);
                    tempWrite.write("\n");
                }
                tempWrite.flush();
                tempWrite.close();
            }
            fileScanner.close();

            currentFile.delete();
            temp.renameTo(currentFile);
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    //to remove a single record in file
    public static boolean removeDetail(String filePath, String primaryKey, int arrayLength) throws IOException {
        File currentFile = new File(filePath);
        try (Scanner fileScanner = new Scanner(currentFile)) {
            File temp = new File("temp.txt");
            try (FileWriter tempWrite = new FileWriter(temp)) {
                while (fileScanner.hasNextLine()) {
                    String checkRecordsLine = fileScanner.nextLine();
                    String[] check = checkRecordsLine.split("\t");
                    if (primaryKey.equals(check[0])) {
                        continue;
                    }
                    tempWrite.write(checkRecordsLine);
                    tempWrite.write("\n");
                }
                tempWrite.flush();
                tempWrite.close();
            }
            fileScanner.close();

            currentFile.delete();
            temp.renameTo(currentFile);
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    //to return file path of the file
    public static File searchFilePath(String fileName) {
        String workingDirectory = System.getProperty("user.dir");
        File path = new File(workingDirectory, fileName);
        return path;
    }

}
