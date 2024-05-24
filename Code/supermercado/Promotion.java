package supermercado;

import java.io.Serializable;

/**
 * Abstract class that manages the promotion
 */
abstract class Promotion implements Serializable {
    private Date initialDate;
    private Date endDate;
    private String Produto;

    /**
     * @param initialDate Receive the date when promotion starts
     * @param endDate     Receive the date when promotion ends
     * @param produto     Due to some errors on working with files, String Produto receives the product with promotion
     */
    public Promotion(Date initialDate, Date endDate, String produto) {
        this.initialDate = initialDate;
        this.endDate = endDate;
        this.Produto = produto;
    }

    /**
     * Getter
     *
     * @return Returns starting date
     */
    public Date getDataInicio() {
        return initialDate;
    }

    /**
     * Setter
     *
     * @param dateInicio Set initial date
     */
    public void setDataInicio(Date dateInicio) {
        this.initialDate = dateInicio;
    }

    /**
     * Getter
     *
     * @return Returns ending date
     */
    public Date getDataFinal() {
        return endDate;
    }

    /**
     * Setter
     *
     * @param dateFinal Set ending date
     */
    public void setDataFinal(Date dateFinal) {
        this.endDate = dateFinal;
    }


    /**
     * Getter
     *
     * @return Returns Produto
     */

    public String getProduto() {
        return Produto;
    }

    /**
     * @param num_produtos Receives the number os products bought
     * @param p            Receive product
     * @return Price with promotion, jumps to the right promotion
     */
    abstract double finalPrice(int num_produtos, Product p);

/*    public boolean verificarDataPromo(Data dataRecebida) {
        boolean correto1=false;
        boolean correto2=false;
        if(data_final.getAno()>dataRecebida.getAno()) {
            correto1=true;
        }
        else if(data_final.getMes()>dataRecebida.getMes() && data_final.getAno() >= dataRecebida.getAno()) {
            correto1=true;
        }
        else if(data_final.getDia() >= dataRecebida.getDia() && data_final.getMes() >= dataRecebida.getMes() && data_final.getAno() >= dataRecebida.getAno()) {
            correto1=true;
        }
        if(data_inicio.getAno() < dataRecebida.getAno()){
            correto2=true;
        }
        else if(data_inicio.getMes() < dataRecebida.getMes() && data_inicio.getAno() <= dataRecebida.getAno()){
            correto2=true;
        }
        else if(data_inicio.getDia() <= dataRecebida.getDia() && data_inicio.getMes() <= dataRecebida.getMes() && data_inicio.getAno() <= dataRecebida.getAno()) {
            correto2=true;
        }
        return (correto1 && correto2);
    }*/

    /**
     * toString
     *
     * @return A string with the characteristics of the promotion. Output string = Data Inicial, Data Final, Produto.
     */

    @Override
    public String toString() {
        return "Promotion -> " + "Start date = " + initialDate + "End date = " + endDate + " Product with the promotion = " + Produto;
    }
}
