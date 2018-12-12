import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import pojos.BlackFridayPojo;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvParser {

    private static String FILE_LOCATION = "/Users/ankitsharma/Documents/code/sorting/BlackFriday.csv";

    public static void main(String[] args) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(FILE_LOCATION))) {
            CsvToBean<BlackFridayPojo> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(BlackFridayPojo.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<BlackFridayPojo> data = csvToBean.parse();

            for (BlackFridayPojo pojo: data) {
                System.out.println(pojo.getProductId());
            }
        }
    }
}
