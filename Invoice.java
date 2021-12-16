package shopsale;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Invoice {
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
  public void invoiceSale(String product, double price, double quantity,double amount,double change, String payment){
      
      System.out.println("---------------------------------------");
      System.out.println("      CUPOM FISCAL                     ");
      System.out.println("                                       ");
      System.out.println(dtf.format(LocalDateTime.now())+"                  ");
      System.out.println("--------------------------------------");
      System.out.println("PRODUTO: "+product+"              "+"PREÇO:"+price);
      System.out.println("QUANTIDADE: "+ quantity+"         "+"TROCO:"+change);   
      System.out.println("--------------------------------------");
      System.out.println("");
      System.out.println("PAGAMENTO: "+payment);
      System.out.println("");
      System.out.println("TOTAL: "+amount);
      System.out.println("");
      System.out.println("--------------------------------------");
      
  } 
  
}
