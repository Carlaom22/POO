package supermercado;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class Loja manages the supermarket
 */
public class Market implements Serializable {
    private ArrayList<Product> availableProducts;
    private ArrayList<Promotion> promotions;
    private ArrayList<Client> regularClients;
    private ArrayList<Client> frequentClients;

    /**
     * Starts variables as an array list
     */

    public Market() {
        availableProducts = new ArrayList<>();
        promotions = new ArrayList<>();
        frequentClients = new ArrayList<>();
        regularClients = new ArrayList<>();
    }

    /**
     * Starts variables
     *
     * @param prod Products available
     * @param prom List of promotions
     * @param freq List of frequent clients
     * @param reg  List of regular clients
     */

    public Market(ArrayList<Product> prod, ArrayList<Promotion> prom, ArrayList<Client> freq, ArrayList<Client> reg) {
        this.availableProducts = prod;
        this.promotions = prom;
        this.frequentClients = freq;
        this.regularClients = reg;
    }

    /**
     * Function to add Regular clients
     *
     * @param c is the variable to work, with type Cliente
     */

    protected void addRegularClients(Client c) {
        regularClients.add(c);
    }

    /**
     * Function to check if the client is frequent
     *
     * @param nome Name of the client
     * @return Returns c if client is frequent, else returns null
     */

    public Client isFrequent(String nome) {
        for (Client c : frequentClients)
            if (c.getName().equals(nome)) {
                return c;
            }
        return null;
    }

    /**
     * Function to print the promotions
     */
    public void showPromotions() {
        for (Promotion pr : promotions) {
            System.out.println(pr);
        }
    }

    /**
     * Fucntion to get client email
     *
     * @param email Email of the client
     * @return Returns c if the email given is equal to the email of the client else returns null
     */

    public Client getCliente(String email) {
        for (Client c : regularClients) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        for (Client c : frequentClients) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Funtion to add frequent client to the list of frequent clients
     *
     * @param c c keeps the client
     */
    protected void addFrequentClient(Client c) {
        frequentClients.add(c);
    }

    /**
     * Function to add new promotions to the list of promotions
     *
     * @param pr pr keeps the promotion
     */
    protected void addPromotions(Promotion pr) {
        promotions.add(pr);
    }

    /**
     * Function to add a available product to the list of available products
     *
     * @param p p keeps the product
     */

    protected void addAvailableProducts(Product p) {
        availableProducts.add(p);
    }

    /**
     * Function to return the product if it is available
     *
     * @param nomeProduto Name of the product
     * @return if the product is available, returns the product, else returns null
     */
    protected Product retornaProduto(String nomeProduto) {
        for (Product p : availableProducts) {
            if (p.getName().equalsIgnoreCase(nomeProduto) == true) {
                return p;
            }
        }
        return null;
    }

    /**
     * Funtion to check the units
     *
     * @param p        p keeps the product
     * @param unidades units bought
     * @return if the units are less or equal to the stock and its the same product, returns true, else returns false
     */
    protected boolean checkUnities(Product p, int unidades) {
        boolean retorna = false;
        for (Product p1 : availableProducts) {
            if (p1.getId() == p.getId() && unidades <= p1.getStock()) {
                retorna = true;
                return retorna;
            }
        }
        return retorna;
    }

    /**
     * Funtion to check if client is frequent
     *
     * @param c c keeps the client
     * @return if the client is frequent returns true, else returns false
     */

    protected boolean checkFrequent(Client c) {
        for (Client c1 : frequentClients) {
            if (c1.getName().equalsIgnoreCase(c.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Function to print the products
     */
    protected void showProducts() {
        for (Product p : availableProducts)
            System.out.println(p);
    }

    /**
     * Getters
     *
     * @return returns the available products
     */
    public ArrayList<Product> getAvailableProducts() {
        return availableProducts;
    }

    /**
     * Setter
     *
     * @param availableProducts Sets the available products
     */

    public void setAvailableProducts(ArrayList<Product> availableProducts) {
        this.availableProducts = availableProducts;
    }


}
