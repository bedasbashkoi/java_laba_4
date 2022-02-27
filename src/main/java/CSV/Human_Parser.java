package CSV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Human_Parser {

    public Human_Data parse(String[] line) {
        var record = new ArrayList<>(List.of(line[0].split(";")));

        if (line.length > 1) {
            fixInvalidRecord(line, record);
        }

        Human_Data human = new Human_Data();
        human.setId(Integer.parseInt(record.get(0)));
        human.setName(record.get(1));
        human.setSex(record.get(2));
        human.setDateOfBirth(record.get(3));
        human.setSubdiv(record.get(4));
        human.setSalary(Integer.parseInt(record.get(5)));

        return human;
    }

    private void fixInvalidRecord(String[] line, ArrayList<String> record) {
        String[] piece = new String[0];
        String fullName = "";
        if (line.length == 2) {
            piece = line[1].split(";");
            fullName = record.get(1) + piece[0];
        } else if (line.length == 3) {
            var piece1 = line[1];
            piece = line[2].split(";");
            fullName = record.get(1) + piece1 + piece[0];
        }
        record.set(1, fullName);
        record.addAll(Arrays.asList(piece).subList(1, piece.length));
    }
}