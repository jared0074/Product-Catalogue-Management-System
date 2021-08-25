package assignment;

import java.io.FileNotFoundException;

public class ProductCategory {
    public String CategoryID, CategoryName, CategoryDescription;
    
    public void createObj(String[] details) throws FileNotFoundException{
        this.CategoryID = details[0]; 
        this.CategoryName = details[1];
        this.CategoryDescription = details[2];

    }
}
    
