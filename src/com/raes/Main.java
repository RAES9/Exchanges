package com.raes;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;

public class Main {
    static Queue queue = new Queue();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GetExchange get = new GetExchange();
        for (Currency.select currency : Currency.select.values()) {
            if (!(currency.toString().equals("USD"))) {
                queue.add(get.getExchange("1", Currency.select.USD.toString(), currency.toString()));
            }
        }
        Table table = new Table(queue);
        table.setLocationRelativeTo(null);
        table.setVisible(true);
    }

}


