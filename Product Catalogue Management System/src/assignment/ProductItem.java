package assignment;

import java.io.FileNotFoundException;

public class ProductItem {
    
    public String itemID, itemName, itemBrand,itemSupplierID, itemDescription, itemImagePath,itemCategoryID;
    public String fileName;
    public int itemQuantity;
    public double itemPrice;
    
    public void createObj(String[] details) throws FileNotFoundException{
        this.itemID = details[0]; 
        this.itemBrand = details[1];
        this.itemName = details[2];
        this.itemCategoryID = details[3];
        this.itemQuantity = Integer.parseInt(details[4]); 
        this.itemPrice = Double.parseDouble(details[5]);
        this.itemDescription = details[6]; 
        this.itemImagePath = details[7];
        this.itemSupplierID= details[8];
    }
}
