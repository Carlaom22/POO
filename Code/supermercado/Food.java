package supermercado;

import java.io.Serializable;

/**
 * Class that extends Produto due to be an subclass
 * Manages Alimentar Product
 */
class Food extends Product implements Serializable {
    private int calories;
    private int fat;


    /**
     * @param identidade Type of product
     * @param nome       Name of product
     * @param preco      Product price
     * @param stock      Number of products on the supermarket
     * @param calories   Number of calories of a product
     * @param fat        Percentage of fat on a product
     */

    public Food(String identidade, String nome, double preco, int stock, int calories, int fat) {
        super(identidade, nome, preco, stock);
        this.calories = calories;
        this.fat = fat;
    }

    /**
     * In case there is a promotion, add it
     *
     * @param identidade Type of product
     * @param nome       Name of product
     * @param preco      Product price
     * @param stock      Number of products on the supermarket
     * @param calories   Number of calories of a product
     * @param fat        Percentage of fat on a product
     * @param promo      Promotion of the product
     */
    public Food(String identidade, String nome, double preco, int stock, int calories, int fat, Promotion promo) {
        super(identidade, nome, preco, stock, promo);
        this.calories = calories;
        this.fat = fat;
    }

    /**
     * Getter
     *
     * @return Returns calories
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Setter
     *
     * @param calories Sets the calories
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * Getter
     *
     * @return Returns the fat percentage
     */

    public int getFat() {
        return fat;
    }

    /**
     * Setter
     *
     * @param fat Sets the percentage of fat
     */
    public void setFat(int fat) {
        this.fat = fat;
    }

    /**
     * toString
     *
     * @return Returns a string with Produto settings plus Alimentar characteristics (Output: Identidade, Nome, Preco, Stock, Calorias, Gordura)
     */


    @Override
    public String toString() {
        return super.toString() + "Calories (per 100g) = " + calories + ", Gordura = (%) " + fat;
    }
}
