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
                System.out.println("Pagamento em dinheiro:");
                System.out.println("Quanto o cliente pagou?");
                String clientPayment = sc.next();
                clientPayment.replace(",", ".");
                double clientPaymentDouble = Double.parseDouble(clientPayment);
                change = (clientPaymentDouble - amount);
                if (change >= 0) {
                    System.out.println("Fechar venda?(apenas sim ou nao)");
                    String confirmSale = sc.next();
                    if (confirmSale.equals("sim")) {
                        System.out.println("Venda confirmada com sucesso! Emitindo a nota fiscal...");
                        invoice.invoiceSale(product, price, quantity, amount);
                    } else if (confirmSale.equals("nao")) {
                        System.out.println("Venda cancelada com sucesso!");
                    } else {
                        System.out.println("Erro! Digite apenas sim ou nao nessa área");
                    }
                } else {
                    System.out.println("Venda cancelada! Ainda faltam R$" + (amount - clientPaymentDouble));
                }
                break;
            case "2":
                System.out.println("Pagamento no cartão de crétido:");             
                    System.out.println("digite sua senha:");
                    String password = sc.nextLine();
                    if (password.length() > 6) {
                        System.out.println("Senha inválida! Uma senha tem, no máximo, 6 dígitos");
                    } else {
                        System.out.println("Digite novamente sua senha");
                        String password2 = sc.nextLine();
                        if (password2.equals(password)) {
                            System.out.println("Fechar venda?(apenas sim ou nao)");
                            String confirmSale = sc.next();
                            if (confirmSale.equals("sim")) {
                                System.out.println("Venda confirmada com sucesso! Emitindo a nota fiscal...");
                                //
                            } else if (confirmSale.equals("nao")) {
                                System.out.println("Venda cancelada com sucesso!");
                            } else {
                                System.out.println("Erro! Digite apenas sim ou nao nessa área");
                            }
                        } else {
                            System.out.println("Erro! as senhas não coincidem ");
                        }
                    }                             
                break;
            case "3":
                System.out.println("Pagamento no crediário:");
                System.out.println("Digite o nome do cliente");
                client = sc.next();
                System.out.println("Abrindo a conta...");
                System.out.println("");
                System.out.println(amount + " reais foram depositados na conta de " + client);
                System.out.println("Fechar venda?(apenas sim ou nao)");
                String confirmSale = sc.next();
                if (confirmSale.equals("sim")) {
                    System.out.println("Venda confirmada com sucesso! Emitindo a nota fiscal...");
                    //
                } else if (confirmSale.equals("nao")) {
                    System.out.println("Venda cancelada com sucesso!");
                } else {
                    System.out.println("Erro! Digite apenas sim ou nao nessa área");
                }
                break;
        }
    }
}
