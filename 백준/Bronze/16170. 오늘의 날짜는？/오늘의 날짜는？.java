import java.time.LocalDate;
import java.time.ZoneOffset;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now(ZoneOffset.UTC);

        System.out.println(today.getYear());
        System.out.println(today.getMonthValue());
        System.out.println(today.getDayOfMonth());
    }
}
