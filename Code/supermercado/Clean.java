package supermercado;

import java.io.Serializable;

/**
 * Class Limpeza manages clean types products
 */

class Clean extends Product implements Serializable {
    private double toxicity;

    /**
     * Starts variables
     *
     * @param identidade Type of product
     * @param nome       Name of product
     * @param preco      Product price
     * @param stock      Number of products on the supermarket
     * @param toxicity   Toxicity of the product
     */

    public Clean(String identidade, String nome, double preco, int stock, double toxicity) {
        super(identidade, nome, preco, stock);
        this.toxicity = toxicity;
    }

    /**
     * In case there is a promotion, add it
     *
     * @param identidade Type of product
     * @param nome       Name of product
     * @param preco      Product price
     * @param stock      Number of products on the supermarket
     * @param toxicity   Toxicity of the product
     * @param p          Promotion of the product
     */

    public Clean(String identidade, String nome, double preco, int stock, double toxicity, Promotion p) {
        super(identidade, nome, preco, stock, p);
        this.toxicity = toxicity;
    }

    /**
     * Getter
     *
     * @return Returns toxicity
     */

    public double getToxicity() {
        return toxicity;
    }

    /**
     * Setter
     *
     * @param toxicity Sets toxicity
     */

    public void setToxicity(double toxicity) {
        this.toxicity = toxicity;
    }

    /**
     * toString
     *
     * @return Returns a string with Promocao settings plus Limpeza characteristics (Output: Identidade, Nome, Preco, Stock, Toxicity)
     */
    @Override

    public String toString() {
        return super.toString() + "Toxicity (0 - 10) = " + toxicity + ']';
    }
}
