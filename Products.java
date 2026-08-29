package main;

import java.util.Scanner;

public class Products {

    static Scanner inputScanner = new Scanner(System.in);
    static ReportData[] productInventory = new ReportData[10];

    public static int DisplayMenu(){
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new product.");
        System.out.println("(2) Search for a product.");
        System.out.println("(3) Update a product.");
        System.out.println("(4) Delete a product.");
        System.out.println("(5) Print report.");
        System.out.println("(6) Exit Application.");
        int selectedMenuChoice = 0;
        System.out.print("choice >> ");
        while(true){
            selectedMenuChoice = inputScanner.nextInt();
            inputScanner.nextLine();
            if(!(selectedMenuChoice > 0 && selectedMenuChoice < 7)){
                System.out.print("Choice must be between 1 and 6");
                continue;
            }
            System.out.println("");
            return selectedMenuChoice;
        }
    }

    public static void CaptureProduct(){
        if(ReportData.index >= productInventory.length){
            System.out.println("Max number of products has been reached");
            return;
        }
        else{
            System.out.println("CAPTURE A NEW PRODUCT");
            System.out.println("**************************");

            System.out.print("Enter the product code:");
            String productCodeInput = inputScanner.nextLine();
            for(int i=0;i<ReportData.index;i++){
                if(productInventory[i]!=null && productInventory[i].getProductCode().equalsIgnoreCase(productCodeInput)){
                    System.out.println("Product "+productInventory[i].getProductName()+" is already in the system");
                    return;
                }
            }

            System.out.print("Enter the product name:");
            String productNameInput = inputScanner.nextLine();

            System.out.println("");
            System.out.println("Select the product category:");
            System.out.println("Desktop Computer - 1");
            System.out.println("Laptop - 2");
            System.out.println("Tablet - 3");
            System.out.println("Printer - 4");
            System.out.println("Gaming Console - 5");
            System.out.print("Product category >> ");
            int categoryChoice;
            while(true){
                categoryChoice = inputScanner.nextInt();
                inputScanner.nextLine();
                if(categoryChoice < 1 || categoryChoice > 5){
                    System.out.println("Category has to be between 1 and 5");
                    continue;
                }
                break;
            }
            System.out.println("");
            System.out.print("Indicate the product warranty. Enter (1) for 6 months or any other key for 2 years. ");
            String warrantyOption = inputScanner.nextLine();
            double warrantyPeriodInMonths;
            if("1".equals(warrantyOption.trim())){
                warrantyPeriodInMonths = 6.0;
            }
            else{
                warrantyPeriodInMonths = 24.0;
            }
            System.out.println("");
            System.out.print("Enter the price for " + productNameInput + " >> ");
            double productPrice;
            while(true){
                productPrice = inputScanner.nextDouble();
                inputScanner.nextLine();
                if(productPrice < 0){
                    System.out.println("Price cannot be negative,Enter price again:");
                    continue;
                }
                break;
            }

            int stockQuantity;
            while(true){
                System.out.print("Enter Stock level for " + productNameInput + " >> ");
                stockQuantity = inputScanner.nextInt();
                inputScanner.nextLine();
                if(stockQuantity < 0){
                    System.out.println("Stock cannot be negative");
                    continue;
                }
                break;
            }

            System.out.print("Enter the supplier for " + productNameInput + " >> ");
            String supplierName = inputScanner.nextLine();

            ReportData newProductData = new ReportData(productCodeInput.trim(), productNameInput.trim(), warrantyPeriodInMonths, categoryChoice, productPrice, stockQuantity, supplierName);
            SaveProduct(newProductData);
        }
    }

    public static void SaveProduct(ReportData newProductData){
        productInventory[ReportData.index] = newProductData;
        ReportData.index++;
        System.out.println("Product details has been saved successfully!!!");
    }

    public static void SearchProduct(){
        System.out.print("Please enter the product code to search: ");
        String searchProductCode = inputScanner.nextLine();

        for(int i = 0; i < ReportData.index; i++){
            if(productInventory[i]!= null && productInventory[i].getProductCode().equals(searchProductCode)){
                System.out.println("*************************************************");
                System.out.println("PRODUCT SEARCH RESULTS");
                System.out.println("*************************************************");
                System.out.println("PRODUCT CODE: " + productInventory[i].getProductCode());
                System.out.println("PRODUCT NAME: " + productInventory[i].getProductName());
                System.out.println("PRODUCT WARRANTY: " + (productInventory[i].getWarranty() / 12) + " years");
                System.out.println("PRODUCT CATEGORY: " + CategName(productInventory[i].getCategory()));
                System.out.println("PRODUCT PRICE: R" + productInventory[i].getPrice());
                System.out.println("PRODUCT STOCK LEVELS: " + productInventory[i].getstockLevels());
                System.out.println("PRODUCT SUPPLIER: " + productInventory[i].getSupplier());
                return;
            }
        }
        System.out.println("The product cannot be located. Invalid Product");
    }

    public static void DeleteProduct(){
        System.out.print("Please enter the product code to delete: ");
        String deleteProductCode = inputScanner.nextLine();
        boolean isProductFound = false;

        for(int i = 0; i < ReportData.index; i++){
            if(productInventory[i]!= null && productInventory[i].getProductCode().equals(deleteProductCode)){
                isProductFound = true;
                System.out.println("Are you sure that you want to delete? (y) for yes, any other key to cancel");
                String confirmationInput = inputScanner.nextLine();
                if("y".equalsIgnoreCase(confirmationInput.trim())){
                    for (int j = i; j < ReportData.index - 1; j++) {
                        productInventory[j] = productInventory[j + 1];
                    }
                    productInventory[ReportData.index - 1] = null;
                    ReportData.index--;
                    System.out.println("Deletion was successful");
                    break;
                }
                else{
                    System.out.println("Cancellation successful");
                }
            }
        }
        if(!isProductFound){
            System.out.println("The product was not found in the system");
        }
    }

    public static void UpdateProduct(){
        System.out.print("Please enter the product code to update: ");
        String updateProductCode = inputScanner.nextLine().trim();
        boolean isProductFoundForUpdate = false;

        for(int i = 0; i < ReportData.index; i++){
            if(productInventory[i]!= null && productInventory[i].getProductCode().equals(updateProductCode)){
                isProductFoundForUpdate = true;

                System.out.print("Update the warranty? (y) Yes, (n) No ");
                while(true){
                    String warrantyUpdateInput = inputScanner.nextLine().trim().toLowerCase();
                    if(warrantyUpdateInput.isEmpty()){
                        System.out.print("Please enter 'y' or 'n': ");
                        continue;
                    }
                    char warrantyChoice = warrantyUpdateInput.charAt(0);
                    if(warrantyChoice == 'y'){
                        System.out.print("Indicate the new product warranty. Enter (1) for 6 months or any other key for 2 years. ");
                        String newWarrantyOption = inputScanner.nextLine();
                        if("1".equals(newWarrantyOption.trim())){
                            productInventory[i].setWarranty(6);
                        }
                        else{
                            productInventory[i].setWarranty(24);
                        }
                        break;
                    }
                    else if(warrantyChoice == 'n'){
                        System.out.println("It won't be changed then");
                        break;
                    }
                    else{
                        System.out.print("Invalid character entered! Try again (y/n): ");
                    }
                }

                System.out.print("Update the price? (y) Yes, (n) No ");
                while(true){
                    String priceUpdateInput = inputScanner.nextLine().trim().toLowerCase();
                    if(priceUpdateInput.isEmpty()){
                        System.out.print("Please enter 'y' or 'n': ");
                        continue;
                    }
                    char priceChoice = priceUpdateInput.charAt(0);
                    if(priceChoice == 'y'){
                        System.out.print("Enter the new price for >> " + productInventory[i].getProductName() + " ");
                        double newProductPrice = inputScanner.nextDouble();
                        inputScanner.nextLine();
                        productInventory[i].setPrice(newProductPrice);
                        break;
                    }
                    else if(priceChoice == 'n'){
                        System.out.println("Okay, Moving on");
                        break;
                    }
                    else{
                        System.out.print("Invalid character entered! Try again (y/n): ");
                    }
                }

                System.out.print("Update the stock level? (y) Yes, (n) No ");
                while(true){
                    String stockUpdateInput = inputScanner.nextLine().trim().toLowerCase();
                    if (stockUpdateInput.isEmpty()) {
                        System.out.print("Please enter 'y' or 'n': ");
                        continue;
                    }
                    char stockChoice = stockUpdateInput.charAt(0);
                    if(stockChoice == 'y'){
                        while(true){
                            System.out.print("Enter the new stock level for " + productInventory[i].getProductName() + " >> ");
                            int newStockQuantity = inputScanner.nextInt();
                            inputScanner.nextLine();
                            if(newStockQuantity >= 0){
                                productInventory[i].setStockLevels(newStockQuantity);
                                break;
                            }
                            else{
                                System.out.println("Stock cannot be negative.");
                            }
                        }
                        break;
                    }
                    else if(stockChoice == 'n'){
                        System.out.println("Stock level left unchanged.");
                        break;
                    }
                    else{
                        System.out.print("Invalid character entered! Enter (y) for Yes or (n) for No: ");
                    }
                }
                System.out.println("Product details updated successfully.");
                return;
            }
        }
        if(!isProductFoundForUpdate){
            System.out.println("Product not found");
        }
    }

    public static void PrintProductReport(){
        System.out.println("PRODUCT REPORT");
        System.out.println("=====================================================================================");
        if(ReportData.index == 0){
            System.out.println("No products available.");
            System.out.println("");
            return;
        }
        double totalInventoryValue = 0;
        for(int i = 0; i < ReportData.index; i++){
            totalInventoryValue += productInventory[i].getPrice() * productInventory[i].getstockLevels();
            System.out.println("PRODUCT " + (i + 1));
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("PRODUCT CODE >> " + productInventory[i].getProductCode());
            System.out.println("PRODUCT NAME >> " + productInventory[i].getProductName());
            double warrantyInYears = productInventory[i].getWarranty() / 12;
            System.out.println("PRODUCT WARRANTY >> " + warrantyInYears + " years");
            System.out.println("PRODUCT CATEGORY >> " + CategName(productInventory[i].getCategory()));
            System.out.println("PRODUCT PRICE >> " + productInventory[i].getPrice());
            System.out.println("PRODUCT STOCK LEVELS >> " + productInventory[i].getstockLevels());
            System.out.println("PRODUCT SUPPLIER >> " + productInventory[i].getSupplier());
            System.out.println("-------------------------------------------------------------------------------------");
        }
        System.out.println("==================================================================================");
        System.out.println("TOTAL PRODUCT COUNT: " + ReportData.index);
        System.out.println("TOTAL PRODUCT VALUE: R " + totalInventoryValue);
        double averageProductValue = totalInventoryValue / ReportData.index;
        System.out.println("AVERAGE PRODUCT VALUE: R " + averageProductValue);
        System.out.println("==================================================================================");
    }

    public static String CategName(int categoryId){
        switch (categoryId) {
            case 1: return "Desktop Computer";
            case 2: return "Laptop";
            case 3: return "Tablet";
            case 4: return "Printer";
            case 5: return "Gaming Console";
            default: return "";
        }
    }

    public static void ExitApplication(){
        System.exit(0);
    }
}