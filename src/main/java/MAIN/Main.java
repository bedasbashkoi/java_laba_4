package MAIN;

import com.opencsv.exceptions.CsvValidationException;

import CSV.Human_Parser;
import CSV.Human_Mapper;
import CSV.CSV_Reader;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, CsvValidationException {
        var reader = new CSV_Reader();
        var parser = new Human_Parser();
        var mapper = new Human_Mapper();
        var results = new ArrayList<>();

        String[] record;

        while ((record = reader.readNext()) != null) {
            var humanDto = parser.parse(record);
            var human = mapper.toDomain(humanDto);
            results.add(human);
        }
        reader.close();

        System.out.println(results);
    }
}