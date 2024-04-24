import ack.shapes.Leinwand;

public class SchwanzTest {
    public static void main(String[] args) {
        Leinwand leinwand = new Leinwand();

        Schwanz schwanz = new Schwanz(100, 100, 50, 100);
        schwanz.drawDick(leinwand);
    }
}
