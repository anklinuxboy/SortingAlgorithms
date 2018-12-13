import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import pojos.BlackFridayPojo;
import sortingalgorithms.InsertionSort;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvParser {

    private static String BLACK_FRIDAY_CSV_LOCATION = "/Users/ankitsharma/Documents/code/sorting/BlackFriday.csv";

    public static void main(String[] args) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(BLACK_FRIDAY_CSV_LOCATION))) {
            CsvToBean<BlackFridayPojo> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(BlackFridayPojo.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<BlackFridayPojo> data = csvToBean.parse();

            System.out.println("Before");
            for (int i = 0; i < 100; i++) {
                System.out.println(data.get(i).getProductId());
            }

            InsertionSort insertionSort = new InsertionSort();
            long startTime = System.nanoTime();
            insertionSort.sort(data);
            long endTime = System.nanoTime();

            long elapsedTime = endTime - startTime;

            System.out.println("Elapsed Time in seconds: " + elapsedTime / 1000000000);

            System.out.println("\nAfter");
            for (int i = 0; i < 100; i++) {
                System.out.println(data.get(i).getProductId());
            }
        }
    }
}
