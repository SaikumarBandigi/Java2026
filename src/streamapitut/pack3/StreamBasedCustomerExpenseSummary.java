package streamapitut.pack3;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasedCustomerExpenseSummary {

    public static void main(String[] args) {

        List<BookOrderRecord> orders = Arrays.asList(
                new BookOrderRecord(1, "Alice", "Fiction", 500),
                new BookOrderRecord(2, "Bob", "Science", 700),
                new BookOrderRecord(3, "Alice", "Fiction", 300),
                new BookOrderRecord(4, "Charlie", "History", 400),
                new BookOrderRecord(5, "Bob", "Science", 200),
                new BookOrderRecord(6, "Alice", "History", 600)
        );

        ToDoubleFunction<BookOrderRecord> toDoubleFunction = BookOrderRecord::getPrice;

        Map<String, Double> map = orders.stream().filter(b -> b.getPrice() > 400).
                collect(Collectors.groupingBy(BookOrderRecord::getCustomerName,
                        Collectors.summingDouble(toDoubleFunction))
                ).entrySet().stream().sorted(
                        (e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));


        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }


    }

}

class BookOrderRecord {
    private int orderId;
    private String customerName;

    @Override
    public String toString() {
        return "BookOrderRecord{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String genre;
    private double price;

    public BookOrderRecord(int orderId, String customerName, String genre, double price) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.genre = genre;
        this.price = price;
    }
// constructor, getters, setters, toString

    public BookOrderRecord() {
    }
}