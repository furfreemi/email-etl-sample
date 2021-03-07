package email;

import email.etl.EmailEtl;

import java.io.*;

public class EmailEtlApplication {

    public static final String INPUT_FILE_DEFAULT = "sampleInput.txt";
    public static final String OUTPUT_FILE_DEFAULT = "sampleOutput.txt";

    public static void main(String[] args) {
        switch (args.length) {
            case 0 -> startEtl(INPUT_FILE_DEFAULT, OUTPUT_FILE_DEFAULT);
            case 2 -> startEtl(args[0], args[1]);
            default -> {
                System.err.printf("Please specify exactly two arguments in the form <inputFile> <outputFile>, or specify no arguments to rely on the default input and output files of %s and %s.", INPUT_FILE_DEFAULT, OUTPUT_FILE_DEFAULT);
                System.exit(1);
            }
        }
    }

    private static void startEtl(String inputFile, String outputFile) {
        if (inputFile.equals(outputFile)) {
            System.err.println("Input and output file cannot be the same.");
            System.exit(1);
        }

        try (Reader reader = new FileReader(inputFile); Writer writer = new FileWriter(outputFile)) {
            new EmailEtl(reader, writer).extractTransformLoad();
        } catch (IOException e) {
            System.err.printf("Unable to access file: %s", e.getMessage());
            System.exit(1);
        }
    }
}
