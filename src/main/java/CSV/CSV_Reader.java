package CSV;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CSV_Reader {
    private static final String FILE_NAME = "foreign_names.csv";
    CSVReader reader = new CSVReader(new FileReader(FILE_NAME));

    public CSV_Reader() throws IOException, CsvValidationException {
        reader.readNext();
    }

    public String[] readNext() throws CsvValidationException, IOException {
        return reader.readNext();
    }

    public void close() throws IOException {
        reader.close();
    }
}