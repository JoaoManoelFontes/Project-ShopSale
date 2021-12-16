package shopsale;

import java.util.Scanner;

public class Payment {
 
    Scanner sc = new Scanner(System.in);
    
    protected double amount;
    protected double change;
    protected String client;
    protected String product;
    protected double price;
    protected double quantity;
    private String payment;
    
    public Payment(double a, double p, double q, String pdt){
        this.amount = a;
        this.price = p;
        this.quantity = q;
        this.product = pdt;
    }
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    public void PaymentOptions(String options) {       
        Invoice invoice = new Invoice();
        
        switch (options) {
                
            case "1":
                
                payment = "Á VISTA";                
                System.out.println("Pagamento em dinheiro:");
                
                System.out.println("Quanto o cliente pagou?");
                String clientPayment = sc.next();
                
                clientPayment.replace(",", ".");                
                double clientPaymentDouble = Double.parseDouble(clientPayment);
                
                change = (clientPaymentDouble - amount);                
                if (change >= 0) {
                                        
                    System.out.println("Troco de R$"+change);
                    System.out.println("Fechar venda?(sim para fechar)");
                    String confirmSale = sc.next();
                    
                    if (confirmSale.equals("sim")) {
                        System.out.println("Venda confirmada com sucesso! Emitindo a nota fiscal...");
                        invoice.invoiceSale(product, price, quantity, amount,change,payment);
                                            
                    } else {
                        System.out.println("Venda cancelada com sucesso!");                    
                    }
                                        
                } else {
                    System.out.println("Venda cancelada! Ainda faltam R$" + (amount - clientPaymentDouble));
                }
                
                break;                
            case "2":
                
                System.out.println("Pagamento no cartão de crétido:");             
                
                System.out.println("Digite 1 para pagar no crédito e 2 para pagar no débito ");
                String paymentOptions = sc.next();
                
                switch(paymentOptions){
                    case "1":
                        System.out.println("Pagamento no crédito: ");
                        payment = "CRÉDITO";
                        break;
                    case "2":
                        System.out.println("Pagamento no débito: ");
                        payment = "DÉBITO";
                        break;       
                    default:
                        System.out.println("Venda cancelada: Erro: Não digitou nenhuma das opções");
                }
               
                System.out.println("digite sua senha:");
                String password = sc.nextLine();
                
                if (password.length() > 6) {                    
                        System.out.println("Venda cancelada: Senha deve ter no máximo 6 dígitos");
                    } else {                  
                    
                        System.out.println("Fechar venda?(sim para fechar)");
                        String confirmSale = sc.next();
                        
                        if (confirmSale.equals("sim")) {
                            System.out.println("Venda confirmada com sucesso! Emitindo a nota fiscal...");
                            invoice.invoiceSale(product, price, quantity, amount, change,payment);
                        } else {
                            System.out.println("Venda cancelada com sucesso!");
                        }
                        
                    }                             
                
                break;
            case "3":                   
                System.out.println("Pagamento no crediário:");
                
                System.out.println("Digite o nome do cliente");
                client = sc.next();
                
                payment = "CREDIÁRIO - CONTA DE "+client.toUpperCase();
                
                System.out.println("Abrindo a conta...");
                System.out.println("");
                System.out.println(amount + " reais foram depositados na conta de " + client);
                
                System.out.println("Fechar venda?(apenas sim ou nao)");
                String confirmSale = new Scanner(System.in).next();
                if (confirmSale.equals("sim")) {
                    System.out.println("Venda confirmada com sucesso! Emitindo a nota fiscal...");
                    invoice.invoiceSale(product, price, quantity, amount, change, payment);
                } else  {
                    System.out.println("Venda cancelada com sucesso!");
                }
                
                break;
        }
        
        sc.close();
    }
}
