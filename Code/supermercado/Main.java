package supermercado;

import java.lang.*;
import java.util.Scanner;

/**
 * Class Main, has the main code for the app to work
 */
public class Main {

    /**
     * Function start has the menu for the user to use the menu
     */

    private void start() {

        Purchase cr = new Purchase();

        /*Data d1 = new Data(24, 12, 2021);
        Data d2 = new Data(26, 12, 2021);
        Data d3 = new Data(24, 10, 2021);
        Data d4 = new Data(26, 10, 2021);
        Data d5 = new Data(24, 8, 2021);
        Data d6 = new Data(26, 8, 2021);

        Pague3_Leve4 prom1 = new Pague3_Leve4(d1,d2);
        PagueMenos prom2 = new PagueMenos(d3,d4);

        Alimentar p1 = new Alimentar("Alimentar", "Maça", 2, 20, prom1, 100, 100);
        Mobiliario p2 = new Mobiliario("Mobiliario", "Porta", 15.5, 20, 100, 100, 100, 100);
        Limpeza p3 = new Limpeza("Limpeza", "Ajax", 1, 20, prom2, 9.5);

        Cliente c1 = new Cliente("Carlos", "carlos@gmail.com", 914620992, "Vila Caiz");
        Cliente c2 = new Cliente("Miguel", "miguel@gmail.com", 914620992, "Vila Caiz");
        l.adicionaClienteFrequentes(c1);
        l.adicionaClientesRegulares(c2);
        l.adicionaProdutosDisponiveis(p1);
        l.adicionaProdutosDisponiveis(p2);
        l.adicionaProdutosDisponiveis(p3);
        l.adicionaPromocoes(prom1);
        l.adicionaPromocoes(prom2);*/

        Files f = new Files();

        Market l = f.readfile();

        //l=f.readObject();

        initialMenu(l, cr);

        f.writeObject(l);

    }

    /**
     * Menu inicial is where the user will put his email to log on the app
     *
     * @param l  l is a "pointer" to class Loja
     * @param cr cr is a "pointer" to class Compra
     */

    public static void initialMenu(Market l, Purchase cr) {

        System.out.println("Welcome");
        Scanner sc = new Scanner(System.in);
        String email;
        Client c;

        while (true) {
            //Data dataRecebida = new Data();
            System.out.print("Insert email to login: ");
            email = sc.next();
            c = l.getCliente(email);

            if (c == null) {
                System.out.println("Email does not exist.\n\n");
            } else
                menu(l, cr, c);
        }

    }

    /**
     * Function to give space on the app
     */

    public static void clearScreen() {
        for (int i = 0; i < 2; ++i) {
            System.out.println();
        }
    }

    /**
     * Menu has the main code, where the user can check his purchases, do purchases. Basically menu has the "app".
     *
     * @param l  l is a "pointer" to class Loja
     * @param cr cr is a "pointer" to class Compra
     * @param c  c is a "pointer" to class Cliente
     */

    public static void menu(Market l, Purchase cr, Client c) {

        String nome;
        int opcao = 0;
        String nomeProduto = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("\t\tChose an option:\n\n");
        System.out.print("1.Show products\n");
        System.out.print("2.Show products with promotion\n");
        System.out.print("3.Do a purchase\n");
        System.out.print("4.Show cart\n");
        System.out.print("5.End purchase\n");
        System.out.print("6.Check purchases\n");
        System.out.print("7.Clean cart\n");
        System.out.print("8.Logout\n");
        //cr.listarCompras();
        opcao = sc.nextInt();
        boolean tanto_faz = true;

        while (tanto_faz) {
            switch (opcao) {
                case 1 -> {
                    l.showProducts();
                    clearScreen();
                    menu(l, cr, c);
                    break;
                }
                case 2 -> {
                    l.showPromotions();
                    clearScreen();
                    menu(l, cr, c);
                    break;
                }
                case 3 -> {
                    int unidades = 0;
                    double total = 0;
                    System.out.print("Insert name of the product: \n");
                    nomeProduto = sc.nextLine();
                    Product p = l.retornaProduto(nomeProduto);
                    if (p == null) {
                        System.out.println("Insert a valid name!");
                    } else {
                        System.out.println("Insert number of unities: ");
                        unidades = sc.nextInt();
                        if (l.checkUnities(p, unidades) == false) {
                            System.out.println("Insert a valid number.");
                        } else {
                            //esta conta é sem promoçoes e transportes aplicados-->so aplcias isto na opção finalizar a encomenda
                            total = (double) (unidades * p.getPrice());
                            System.out.printf("Without promotion and transport your total is: %.2f€\n\n", total);
                            cr.addPurchase(p, unidades);
                            clearScreen();
                            menu(l, cr, c);
                        }
                    }
                    break;
                }

                case 4 -> {
                    cr.listPurchases();
                    clearScreen();
                    menu(l, cr, c);
                    break;
                }

                case 5 -> {
                    double total_preco = 0;
                    total_preco = cr.getPrice();
                    for (Product p : cr.getListPurchases()) {

                        if (p.getId().equals("Mobiliario")) {

                            Furniture m = (Furniture) p;

                            if (m.getWeight() > 15) {
                                total_preco += 10;
                            }
                        }
                    }
                    if (!l.checkFrequent(c)) {
                        System.out.println("No free shipping.\n\n");
                        total_preco = total_preco + 20;
                    } else if (total_preco > 40)
                        total_preco = total_preco;
                    else
                        total_preco = total_preco + 15;

                    if (cr.getListPurchases().isEmpty()) {
                        total_preco = 0;
                    }
                    System.out.printf("Your final total is: %.2f€\n\n", total_preco);
                    cr.getListPurchases().clear();
                    clearScreen();
                    menu(l, cr, c);
                    break;
                }

                case 6 -> {
                    cr.listPurchases();
                    clearScreen();
                    menu(l, cr, c);
                }

                case 7 -> {
                    cr.removeProduct();
                    clearScreen();
                    menu(l, cr, c);
                    break;
                }

                case 8 -> {
                    System.exit(1);
                }
            }
        }
        System.out.println("Logout");
        System.exit(1);
    }

    /**
     * Function to get the code to run.
     *
     * @param args
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
}
