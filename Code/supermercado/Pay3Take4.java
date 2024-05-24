package supermercado;

/**
 * Class Pague3_Leve4 manages the pay 3 take 4 type of promotion
 */

class Pay3Take4 extends Promotion {

    /**
     * @param initialDate Starting date of the promotion
     * @param endDate     Eding date of the promotion
     * @param s           String  keeps the name of the product with promotion
     */

    public Pay3Take4(Date initialDate, Date endDate, String s) {
        super(initialDate, endDate, s);
    }

    /**
     * Gets the price after do the promotion
     *
     * @param num_produtos Receives the number os products bought
     * @param p            Receive product
     * @return Returns the price
     */

    public double finalPrice(int num_produtos, Product p) {
        int total = (int) (num_produtos * p.getPrice());
        for (int i = 1; i <= num_produtos; i++) {
            if (i % 4 == 0) {
                total -= p.getPrice();
            }
        }
        //int pagar = Math.round((num_produtos * 3) / 4);

        //return pagar * p.getPreco();
        return total;
    }
}
