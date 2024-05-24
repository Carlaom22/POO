package supermercado;

import java.io.Serializable;

/**
 * Class Mobiliario manages furniture type of product
 */
public class Furniture extends Product implements Serializable {
    private int weight;
    private double size;
    private double width;
    private double length;


    /**
     * Starts the variables
     *
     * @param identidade Type of product
     * @param nome       Name of product
     * @param preco      Product price
     * @param stock      Number of products on the supermarket
     * @param weight     Weight of the product
     * @param size       Size of the product
     * @param width      Width of the product
     * @param length     Length of the product
     */

    public Furniture(String identidade, String nome, double preco, int stock, int weight, double size, double width, double length) {
        super(identidade, nome, preco, stock);
        this.weight = weight;
        this.size = size;
        this.width = width;
        this.length = length;
    }

    /**
     * In case there is a promotion, add it
     *
     * @param identidade Type of product
     * @param nome       Name of product
     * @param preco      Product price
     * @param stock      Number of products on the supermarket
     * @param weight     Weight of the product
     * @param size       Size of the product
     * @param width      Width of the product
     * @param length     Length of the product
     * @param p          Promotion of the product
     */

    public Furniture(String identidade, String nome, double preco, int stock, int weight, double size, double width, double length, Promotion p) {
        super(identidade, nome, preco, stock, p);
        this.weight = weight;
        this.size = size;
        this.width = width;
        this.length = length;
    }

    /**
     * Getter
     *
     * @return Weight of the product
     */

    public int getWeight() {
        return weight;
    }

    /**
     * Setter
     *
     * @param weight Sets weight of the product
     */

    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Getter
     *
     * @return Size of the product
     */

    public double getSize() {
        return size;
    }

    /**
     * Setter
     *
     * @param size Sets size of the product
     */

    public void setSize(double size) {
        this.size = size;
    }

    /**
     * Getter
     *
     * @return Width of the product
     */

    public double getWidth() {
        return width;
    }

    /**
     * Setter
     *
     * @param width Sets width of the product
     */

    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Getter
     *
     * @return Length of the product
     */

    public double getLength() {
        return length;
    }

    /**
     * Setter
     *
     * @param length Sets length of the product
     */

    public void setLength(double length) {
        this.length = length;
    }

    /**
     * toString
     *
     * @return Returns a string with Produto settings plus Mobiliario characteristics (Output: Identidade, Nome, Preco, Stock, Peso, Altura, Largura, Comprimento)
     */
    @Override
    public String toString() {
        return super.toString() + "Weight (Kg) = " + weight + ", Size (m) = " + size + ", Width (m) = " + width + ", Length (m)  = " + length + ", Volume (m^3)  = " + size * length * width + ']';
    }
}
