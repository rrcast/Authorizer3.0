package main.java.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        Account account = null;
        List<String> violations = new ArrayList<String>();
        OutPut outPut = new OutPut();
        String data = "";
        List<String> lines = new ArrayList<String>();
        try {
            File myObj = new File("./" + args[0] + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                lines.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (String par : lines) {
            String[] parts = par.split("\\\"");
            violations.clear();
            outPut.setViolations(violations);
            if (parts[1].toUpperCase().equals("ACCOUNT")) {
                if (account != null) {
                    violations.add("account-already initialized");
                } else {
                    parts[4] = parts[4].replaceAll(",", "").replaceAll(":", "").replaceAll(" ", "");
                    parts[6] = parts[6].replaceAll(":", "").replaceAll("}", "").replaceAll(" ", "");
                    account = new Account(Boolean.parseBoolean(parts[4]), Integer.parseInt(parts[6]));
                }
            } else {
                parts[8] = parts[8].replaceAll(",", "").replaceAll(":", "").replaceAll(" ", "");
                if (Integer.parseInt(parts[8]) < account.getAvailableLimit()) {
                    account.setAvailableLimit(account.getAvailableLimit() - Integer.parseInt(parts[8]));
                } else {
                    violations.add("Insufficient-Limit");
                }
            }
            outPut.setAccount(account);
            outPut.setViolations(violations);
            System.out.println(outPut);
        }
    }
}
