package supermercado;

import java.io.*;
import java.util.ArrayList;


/**
 * Class Ficheiro manages files
 */
public class Files implements Serializable {

    private Object object;
    private String name;

    /**
     * First constructor
     */
    public Files() {
    }

    /**
     * Second constructor
     *
     * @param name
     */
    public Files(String name) {
        this.name = name;
    }

    /**
     * Starts
     *
     * @param object
     * @param name
     */
    public Files(Object object, String name) {
        this.object = object;
        this.name = name;
    }

    /**
     * Getter
     *
     * @return Returns object
     */
    public Object getObject() {
        return object;
    }

    /**
     * Setter
     *
     * @param object Sets object
     */
    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * Getter
     *
     * @return Returns name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     *
     * @param name Sets name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Function to read the objects
     *
     * @return l that keeps Loja
     */
    public Market readObject() {
        File f = new File("C:\\Users\\carli\\IdeaProjects\\ProjetoFinal\\src\\supermercado.obj");
        Market l = null;
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            l = (Market) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error opening file." + ex);
        } catch (IOException ex) {
            System.out.println("Error reading file." + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error converting to file." + ex);
        }
        return l;

    }

    /**
     * Function to write on the objects file
     *
     * @param l l keeps value of Loja
     */

    public void writeObject(Market l) {
        File f = new File("C:\\Users\\carli\\IdeaProjects\\ProjetoFinal\\src\\supermercado.obj");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(l);
            oos.close();
            //System.out.println(object.toString() + "\nregistado com sucesso!");
        } catch (FileNotFoundException ex) {
            System.out.println("Error creating file.\n" + ex);
        } catch (IOException ex) {
            System.out.println("Error writing on file.\n" + ex);
        }

    }

    /**
     * Function to read the text file where every information needed to the supermarket is
     * This function goes to the file and read
     * If a product is being read, the function gets wat is on the array and create a new product
     * On the client part, true means frequent, false means regular
     * On the promotion part, the last part means the product that is associated to that promotion
     *
     * @return Returns l that keeps Loja
     */

    public Market readfile() {
        File f = new File("dados");
        Market l = null;
        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                ArrayList<Product> prod = new ArrayList<>();
                ArrayList<Promotion> prom = new ArrayList<>();
                ArrayList<Client> freq = new ArrayList<>();
                ArrayList<Client> reg = new ArrayList<>();
                int i = 0;
                while ((line = br.readLine()) != null) {
                    if (i == 0) {
                        if (line.length() == 0)
                            i++;
                        else {
                            String[] linha = line.split(" ");
                            if (linha[0].equals("Alimentar")) {
                                prod.add(new Food(linha[0], linha[1], Double.parseDouble(linha[2]), Integer.parseInt(linha[3]), Integer.parseInt(linha[4]), Integer.parseInt(linha[5])));
                            }
                            if (linha[0].equals("Mobiliario")) {
                                prod.add(new Furniture(linha[0], linha[1], Double.parseDouble(linha[2]), Integer.parseInt(linha[3]), Integer.parseInt(linha[4]), Double.parseDouble(linha[5]), Double.parseDouble(linha[6]), Double.parseDouble(linha[7])));

                            }
                            if (linha[0].equals("Limpeza")) {
                                prod.add(new Clean(linha[0], linha[1], Double.parseDouble(linha[2]), Integer.parseInt(linha[3]), Double.parseDouble(linha[4])));
                            }
                        }
                    } else if (i == 1) {
                        if (line.length() == 0)
                            i++;
                        else {
                            String[] linha = line.split(" ");
                            if (Boolean.parseBoolean(linha[0]))
                                freq.add(new Client(linha[1], linha[2], Integer.parseInt(linha[3]), linha[4]));
                            else
                                reg.add(new Client(linha[1], linha[2], Integer.parseInt(linha[3]), linha[4]));
                        }
                    } else if (i == 2) {
                        if (line.length() == 0)
                            i++;
                        else {
                            String[] linha = line.split(" ");
                            prom.add(new PayLess(new Date(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]), Integer.parseInt(linha[2])), new Date(Integer.parseInt(linha[3]), Integer.parseInt(linha[4]), Integer.parseInt(linha[5])), linha[6]));
                        }
                    } else if (i == 3) {
                        if (line.length() != 0) {
                            String[] linha = line.split(" ");
                            prom.add(new Pay3Take4(new Date(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]), Integer.parseInt(linha[2])), new Date(Integer.parseInt(linha[3]), Integer.parseInt(linha[4]), Integer.parseInt(linha[5])), linha[6]));
                        }
                    }
                }

                for (Promotion b : prom) {
                    for (Product p : prod) {
                        if (b.getProduto().equals(p.getName())) {
                            p.setPromotion(b);
                        }
                    }
                }

                l = new Market(prod, prom, freq, reg);
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Error opening text file.");
            } catch (IOException ex) {
                System.out.println("Error opening text file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
        return l;
    }
}