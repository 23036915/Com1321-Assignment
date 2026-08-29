/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/ 
 */
package main;

import java.util.Scanner;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("BRIGHT FUTURE TECHNOLOGIES APPLICATION");
        System.out.println("**************************************");
        while (true) {
        System.out.println("");
        System.out.print("Enter (1) to launch menu or any other key to exit ");
        String menuEntryOption = input.nextLine();
        System.out.println("");
        if("1".equals(menuEntryOption.trim())){
            int selectedMenuOption = Products.DisplayMenu();
            switch(selectedMenuOption){
                case 1: Products.CaptureProduct();
                    break;
                case 2: Products.SearchProduct();
                    break;
                case 3: Products.UpdateProduct();
                    break;
                case 4: Products.DeleteProduct();
                    break;
                case 5: Products.PrintProductReport();
                    break;
                case 6: Products.ExitApplication();
                    break;
            }
        }
        else{  
            Products.ExitApplication();
        } 
            
        }
    
    }
    
}
 
