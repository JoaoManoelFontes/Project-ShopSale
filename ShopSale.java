package shopsale;

import java.util.Scanner;

public class ShopSale {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Payment payment = new Payment();
        System.out.println("Bem vindo ao ShopSale!");
        System.out.println("----------------------");
        System.out.println("");
        System.out.println("Qual é o produto?");
        String product = sc.next();
        System.out.println("Qual o preço?");
        String price = sc.next();
        price = price.replace(",", ".");
        double priceDouble = Double.parseDouble(price);
        System.out.println("Qual a quantidade?");
        double quantity = sc.nextDouble();
        double amount = (quantity*priceDouble);
        System.out.println("Total da venda:");
        System.out.println(amount);
        payment.setAmount(amount);
        payment.setPrice(priceDouble);
        payment.setQuantity(quantity);
        payment.setProduct(product);
        System.out.println("Deseja fechar a venda?(apenas sim ou nao)");
        String finishSale = sc.next();
        System.out.println("");
        System.out.println("------------------------------------------");
        System.out.println("");
        if (finishSale.equals("sim")){
            System.out.println("Opções de pagamento:");
            System.out.println("digite 1 se for no dinheiro");
            System.out.println("digite 2 se for no cartão de crédito");
            System.out.println("digite 3 se for no crediário");
            String paymentOptions = sc.next();
            payment.PaymentOptions(paymentOptions);
            System.out.println("");
            System.out.println("---------------------------------------");
            System.out.println("");
        } else if (!finishSale.equals("nao")) {
            System.out.println("Opção inválida!Digite apenas sim ou nao");

        } else {
            System.out.println("Venda cancelada!");
        }
    }

}