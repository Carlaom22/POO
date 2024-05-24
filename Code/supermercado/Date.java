package supermercado;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Class Data manages the date settings
 */

class Date implements Serializable {
    int day;
    int month;
    int year;

    /**
     * Function to ask and keep the date that user puts
     */

    public Date() {
        //Proteções
        Scanner sc = new Scanner(System.in);
        System.out.println("IInsert date: \n");
        System.out.println("Day (1-31): ");
        int dia = sc.nextInt();
        System.out.println("Month (1-12): ");
        int mes = sc.nextInt();
        System.out.println("Year: ");
        int ano = sc.nextInt();
        if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano <= 2021) {
            this.year = ano;
            this.month = mes;
            this.day = dia;
        } else {
            System.out.println("Invalid date!");
            new Date();
        }

    }

    /**
     * Starts variables
     *
     * @param day   Day part of the date
     * @param month Month part of the date
     * @param year  Year part of the date
     */

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return " Day = " + day + ", Month = " + month + ", Year = " + year + " | ";
    }

}