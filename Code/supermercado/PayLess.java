package supermercado;

/**
 * Class Pague3_Leve4 manages the pay 3 take 4 type of promotion
 */

class PayLess extends Promotion {
    /**
     * @param initialDate Starting date of the promotion
     * @param endDate     Eding date of the promotion
     * @param s           String  keeps the name of the product with promotion
     */

    public PayLess(Date initialDate, Date endDate, String s) {
        super(initialDate, endDate, s);
    }

    /**
     * Gets the price with promotion
     *
     * @param num_produtos Receives the number os products bought
     * @param p            Receive product
     * @return Price after promotion
     */

    public double finalPrice(int num_produtos, Product p) {
        double preco_max = (p.getPrice()) * 0.5;
        double desconto = 0;
        double contador = 0;
        double aux = 0;
        while (desconto < preco_max && contador < num_produtos) {
            aux = desconto;
            desconto = desconto + p.getPrice() * 0.05;
            contador++;
        }
        return (preco_max * 2) - aux;

    }

}
