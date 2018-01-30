package com.company;
import com.opencsv.CSVReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.opencsv.CSVReaderBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static String getGasType(String choice) {
        if (choice.equals("1")) {
            return "Regular";
        } else if (choice.equals("2")) {
            return "Mid-Grade";
        } else if (choice.equals("3")) {
            return "Premium";
        } else {
            return "false";
        }

    }


    public static void payAfterMethod(List<Gas> inventory, String gasType) throws IOException{
        Scanner gallonamount = new Scanner(System.in);
        System.out.println("How Many Gallons Are You Getting Today!!");
        double gallons = gallonamount.nextDouble();
        Gas gaspump = new Gas(gasType, 0.0, gallons);
        double cash = 0.0;
        if (gasType.equals("Regular")) {
            cash = gaspump.getRegCost(gallons);
            inventory.get(0).gallons -= gallons;
            inventory.get(0).amount += cash;}
        else if (gasType.equals("Mid-Grade")){
            cash = gaspump.getMidCost(gallons);
            inventory.get(1).gallons -= gallons;
            inventory.get(1).amount += cash;
        } else if (gasType.equals("Premium")){
            cash = gaspump.getPremCost(gallons);
            inventory.get(2).gallons -= gallons;
            inventory.get(2).amount += cash;
        } else { cash = 0.0;}

        System.out.println("That will cost $" + cash + " for " + gallons + " gallons of " + gasType + " gas.");

        appendTransactions(gasType, "Prepay", gallons, cash);
        saveInventory(inventory);
    }

    public static void prePayMethod(List<Gas> inventory, String gasType) throws IOException {
        Scanner cashamount = new Scanner(System.in);
        System.out.println("How Much Are You Getting Today!!");
        double cash = cashamount.nextDouble();
        Gas gaspump = new Gas(gasType, cash, 0.0);
        double gallons =0.0;
        if (gasType.equals("Regular")) {
            gallons = gaspump.getRegGallons(cash);
            inventory.get(0).gallons -= gallons;
            inventory.get(0).amount += cash;}
            else if (gasType.equals("Mid-Grade")){
            gallons = gaspump.getMidGallons(cash);
            inventory.get(1).gallons -= gallons;
            inventory.get(1).amount += cash;
        } else if (gasType.equals("Premium")){
            gallons = gaspump.getPremGallons(cash);
            inventory.get(2).gallons -= gallons;
            inventory.get(2).amount += cash;
        } else { gallons = 0.0;}

            System.out.println("You Recieved " + gallons + " gallons of " + gasType + " gas.");
            inventory.get(0).gallons -= gallons;
            inventory.get(0).amount += cash;
            appendTransactions(gasType, "Prepay", gallons, cash);
            saveInventory(inventory);
        }



    public static List<Gas> loadInventory() throws IOException{
        try (
                Reader reader = Files.newBufferedReader(Paths.get("./inventory.csv"));
                CSVReader csvReader = new CSVReader(reader);
        ) {

            String[] rows = csvReader.readNext();

            Gas regGas = new Gas(rows[0].toString(),Double.parseDouble(rows[2]), Double.parseDouble(rows[1]));

            String[] row2 = csvReader.readNext();
            Gas midGas = new Gas(row2[0].toString(),Double.parseDouble(row2[2]), Double.parseDouble(row2[1]));

            String[] row3 = csvReader.readNext();
            Gas premGas = new Gas(row3[0].toString(),Double.parseDouble(row3[2]), Double.parseDouble(row3[1]));

            return new ArrayList<Gas>() {
                {add(regGas); add(midGas); add(premGas);}
            };
        }
    }

    public static void appendTransactions(String gastype, String payType, double gallons, double cash) throws IOException {
        FileWriter writer = new FileWriter("./transactions.txt", true);
        writer.write("\n"+gastype + "|" + payType + "|" + gallons + "|" + cash);
        writer.close();
    }


    public static void saveInventory(List<Gas> inventory) throws IOException {
        FileWriter writer = new FileWriter("./inventory.csv");
        writer.write(inventory.get(0).type +"," + inventory.get(0).gallons +","+ inventory.get(0).amount +"\n");
        writer.write(inventory.get(1).type +"," + inventory.get(1).gallons +","+ inventory.get(1).amount +"\n");
        writer.write(inventory.get(2).type +"," + inventory.get(2).gallons +","+ inventory.get(2).amount);
        writer.close();
    }

    public static void main(String[] args) throws IOException {

        List<Gas> inventory = loadInventory();
//        System.out.println(inventory.get(0).toString());
        System.out.println("Hello Welcome To Jo's Gas Station:");
        Scanner type_input = new Scanner(System.in);
        System.out.println("What Gas Would You Be Purchasing Today:\n\t1) Regular\n\t2) Mid-Grade\n\t3) Premium");
        String gasType = getGasType(type_input.next());

        if (gasType.equals("ADMIN")) {

        } else {
            Scanner payment = new Scanner(System.in);
            System.out.println("What Will Be Your Payment Method Today:\n\t1) Prepay\n\t2) Pay After");
            String paymentType = payment.next();

            while (true) {
                if (paymentType.equals("1")) {
                    prePayMethod(inventory, gasType);
                        break;

                } else if (paymentType.equals("2")){

                payAfterMethod(inventory, gasType);
                break;
                }
            }

        }
    }
        }



