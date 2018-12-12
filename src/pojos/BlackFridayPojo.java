package pojos;

import com.opencsv.bean.CsvBindByName;

public class BlackFridayPojo {
    @CsvBindByName(column = "Product_ID")
    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
