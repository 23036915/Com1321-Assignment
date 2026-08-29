package main;

public class ReportData {
    static int index = 0; // tracks number of products saved
    
    private String productCode;
    private String productName;
    private double warranty;
    private int category;
    private double price;
    private int stockLevels;
    private String supplier;
    
    public ReportData(String productCode, String productName, double warranty, int category,
            double price, int stockLevels, String supplier){
        this.productCode = productCode;
        this.productName = productName;
        this.warranty = warranty;
        this.category = category;
        this.price = price;
        this.stockLevels = stockLevels;
        this.supplier = supplier;    
    }
    
    
    public String getProductCode(){
        return this.productCode;
    }
    public String getProductName(){
        return this.productName;
    }
    public double getWarranty(){
        return this.warranty;
    }
    public int getCategory(){
        return this.category;
    }
    public double getPrice(){
        return this.price;
    }
    public int getstockLevels(){   
        return this.stockLevels;
    }
    public String getSupplier(){
        return this.supplier;
    }
    
    
    public void setProductCode(String productCode){
        this.productCode = productCode;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public void setWarranty(int warrantyMonths){
        this.warranty = warrantyMonths;
    }
    public void setCategory(int categoryId){
        this.category = categoryId;
    }
    public void setPrice(double productPrice){
        this.price = productPrice;
    }
    public void setStockLevels(int stockQuantity){
        this.stockLevels = stockQuantity;
    }
    public void setSupplier(String supplierName){
        this.supplier = supplierName;
    }
}