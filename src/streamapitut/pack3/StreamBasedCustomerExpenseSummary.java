package streamapitut.pack3;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
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

        BinaryOperator<Double> binaryOperator = (a, b) -> a;
        Supplier<LinkedHashMap<String, Double>> supplier = LinkedHashMap::new;

        Map<String, Double> map = orders.stream().filter(b -> b.getPrice() > 400).collect(
                        Collectors.groupingBy(BookOrderRecord::getCustomerName, Collectors.summingDouble(toDoubleFunction)))
                .entrySet().stream().sorted((new CustomCom())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, binaryOperator, supplier));


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

class CustomCom implements Comparator<Map.Entry<String, Double>> {

    @Override
    public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
        return Double.compare(o2.getValue(), o1.getValue());
    }

}