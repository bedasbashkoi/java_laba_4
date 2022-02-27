package CSV;

import java.util.Random;

public class ID_Generator {
    final Random random = new Random();
    public int generateNewId() {
        return random.nextInt(100_000);
    }
}