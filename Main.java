package com.company;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter("./inventory.txt", true);
        writer.write("\nRegular | 5000 | 0.0\n");
        writer.write("Mid-Grade | 5000 | 0.0\n");
        writer.write("Premium | 5000 | 0.0\n");
        writer.close();
    }
}
