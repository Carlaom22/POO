package supermercado;

import java.io.Serializable;
import java.lang.*;

/**
 * Class Produto manages the product characteristics
 */

abstract class Product implements Serializable {
    private String id;
    private String name;
    private double price;
    private int stock;
    private Promotion promotion;

    public Product() {
    }

    /**
     * Starts products characteristics
     *
     * @param id    Type of the product
     * @param name  Name of the product
     * @param price Price of the product
     * @param stock Stock of the product
     */

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * In case product has a promotion associated
     *
     * @param id    Type of the product
     * @param name  Name of the product
     * @param price Price of the product
     * @param stock Stock of the product
     * @param promo Promotion associated to the product
     */

    public Product(String id, String name, double price, int stock, Promotion promo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.promotion = promo;
    }

    /**
     * Getter
     *
     * @return Returns type of the product
     */

    public String getId() {
        return id;
    }

    /**
     * Setter
     *
     * @param id Sets type of the product
     */

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter
     *
     * @return Returns name of the product
     */

    public String getName() {
        return name;
    }

    /**
     * Setter
     *
     * @param name Sets name of the product
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     *
     * @return Returns price of the product
     */

    public double getPrice() {
        return price;
    }

    /**
     * Setter
     *
     * @param price Sets price of the product
     */

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter
     *
     * @return Returns stock of the product
     */

    public int getStock() {
        return stock;
    }

    /**
     * Setter
     *
     * @param stock Sets stock of the product
     */

    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Getter
     *
     * @return Returns promotion associated to the product
     */
    public Promotion getPromotion() {
        return promotion;
    }

    /**
     * Setter
     *
     * @param promotion Sets promotion to a product
     */

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

//    public double getPrecoComQuantidades(int quantidades) {
//        if(this.promocao != null){
//            this.promocao.preco_final(quantidades, this);
//        }
//        return preco * quantidades;
//    }


    /**
     * toString
     *
     * @return String with the characteristics of the product
     */

    @Override
    public String toString() {
        return "Produto ->" + " Type =  " + id + ",  Name = " + name + ",  Price = " + price + ",  Stock = " + stock + " -> Characteristics -> ";
    }
}

