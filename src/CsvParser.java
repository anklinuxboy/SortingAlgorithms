import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import pojos.BlackFridayPojo;
import sortingalgorithms.InsertionSort;
import sortingalgorithms.SelectionSort;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvParser {

    private static String BLACK_FRIDAY_CSV_LOCATION = "data/BlackFriday.csv";

    public static void main(String[] args) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(BLACK_FRIDAY_CSV_LOCATION))) {
            CsvToBean<BlackFridayPojo> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(BlackFridayPojo.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<BlackFridayPojo> data = csvToBean.parse();

            InsertionSort insertionSort = new InsertionSort();
            SelectionSort selectionSort = new SelectionSort();

            long startTime = System.nanoTime();
            selectionSort.sort(data);
            long endTime = System.nanoTime();

            long elapsedTime = endTime - startTime;
            System.out.println("Elapsed Time in seconds: " + elapsedTime / 1000000000);
        }
    }
}
