package supermercado;

import java.util.ArrayList;

/**
 * Class Compra manages the client purchases
 */
public class Purchase {
    private ArrayList<Product> listPurchases;
    //private int[] quantidade;

    /**
     * Starts the arraylist that keep the purchases
     */
    public Purchase() {
        listPurchases = new ArrayList<>();
        //this.quantidade = new int[0];

    }

    /**
     * Function that calculates the total price. If a product has promotion, it will redirect to the right function to calc the price
     *
     * @return Return the total price
     */
    public double getPrice() {
        double total = 0;
        int i = 0;
        for (Product p : listPurchases) {
            //System.out.println(p);
            //System.out.println(p.getPromocao());
            if (p.getPromotion() == null) {
                total += (p.getPrice() * p.getStock());
            } else {
                total += p.getPromotion().finalPrice(p.getStock(), p);
                //System.out.println("Pass");
            }
            //total += p.getPrecoComQuantidades();
            //i++;
        }
        return total;
    }

    /**
     * Function to print the purchases done by the client
     */

    protected void listPurchases() {
        for (Product p : listPurchases) {
            System.out.println(p);
        }
    }

    /**
     * Function to update the stock
     *
     * @param p          p is the variable to represent Produto
     * @param quantidade Number of products bought
     * @return Returns nothing
     */

    private Product update(Product p, int quantidade) {
        p.setStock(p.getStock() - quantidade);
        String identidade = p.getId();
        if (identidade.equals("Alimentar")) {
            Food a = (Food) p;
            return new Food(a.getId(), a.getName(), a.getPrice(), quantidade, a.getCalories(), a.getFat(), a.getPromotion());
        }

        if (identidade.equals("Limpeza")) {
            Clean l = (Clean) p;
            return new Clean(l.getId(), l.getName(), l.getPrice(), quantidade, l.getToxicity(), l.getPromotion());
        }

        if (identidade.equals("Mobiliario")) {
            Furniture m = (Furniture) p;
            return new Furniture(m.getId(), m.getName(), m.getPrice(), quantidade, m.getWeight(), m.getSize(), m.getWidth(), m.getLength(), m.getPromotion());
        }

        return null;
    }


    /**
     * Function to add the product bought to a list of purchases
     *
     * @param p          p is the variable to represent Produto
     * @param quantidade Number of products bought
     */

    protected void addPurchase(Product p, int quantidade) {
        listPurchases.add(update(p, quantidade));

    }

//    public void verifica(Produto p, int quantidade){
//        int i = 0;
//        for (Produto pr : listaCompras){
//            if (pr.getIdentidade().equals(p.getIdentidade())){
//                pr.setStock(pr.getStock() + this.quantidade[i] - quantidade);
//                this.quantidade[i] = quantidade;
//
//            }
//        }
//    }


    /**
     * Getter
     *
     * @return Returns the list of purchases (listaCompras)
     */
    public ArrayList<Product> getListPurchases() {
        return listPurchases;
    }

    /**
     * Setter
     *
     * @param listacompras Sets list of purchases (listaCompras)
     */
    public void setListPurchases(ArrayList<Product> listacompras) {
        this.listPurchases = listacompras;
    }

    /**
     * Function to clean the car, start a new purchase
     */

    public void removeProduct() {
        listPurchases = new ArrayList<>();
    }
//    protected double finalizarCompra( Loja j, Cliente c){
//        System.out.println("Preço dos produtos: %f\n", c.getPrecoTotal());
//    }


//    public void calculaTransport() {
//        int transport = 0;
//        int preco=0;
//        for (Produto p :listacompras) {
//            preco+= p.getPreco();
//
//            if(p.getTipo() == 3){
//                Mobiliario pm = (Mobiliario) p;
//                if(pm.getPeso() > 15)
//                    transporte+=10;
//            }
//
//        }
//        if(cliente.isFrequente()){
//            if(preco <=40)
//                transporte +=15;
//
//        }else if(!cliente.isFrequente())
//            transporte += 20;
//
//        this.preco = preco;
//        this.transporte = transporte;
//    }

//    protected  float finalizarCompras(Cliente c,Loja l){
//        float total_preco = 0;
//        for (Produto p : getListacompras()) {
//            if (p.getIdentidade().equals("Mobiliario")) {
//
//                Mobiliario m = (Mobiliario) p;
//
//                if (m.getPeso() > 15) {
//                    total_preco += 10;
//                }
//                System.out.printf("Mobiliario preço : %f",total_preco);
//            }
//            for(Promocao pr:l.getPromocoes()){
//                if(pr.getProduto().equalsIgnoreCase(p.getNome())){
//                    total_preco+=pr.preco_final(p.getStock(),p);
//
//                }
//                else if(!pr.getProduto().equalsIgnoreCase(p.getNome())){
//                    total_preco += (p.getPreco() * p.getStock());
//
//                }
//            }
//        }
//        if(l.veriicarFrequente(c)){
//            System.out.printf("Cliente frequente \n");
//            if(total_preco>40){
//                total_preco+=0;
//                System.out.printf("Total_preço ( cima de 40 eurs) : %f",total_preco);
//            }
//            else{
//                total_preco+=15;
//                System.out.printf("total_preço (a baixo de 40 euros) : %f",total_preco);
//            }
//        }
//        else{
//            System.out.println("Não tem direito a transporte gratuito.\n\n");
//            total_preco = total_preco + 20;
//        }
//        return total_preco;
//
//    }
}
