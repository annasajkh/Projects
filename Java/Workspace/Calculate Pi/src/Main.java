import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
		BigDecimal num = new BigDecimal(2000000000);
		System.out.println(num.multiply(new BigDecimal(Math.sin(new BigDecimal(Math.PI).divide(num).doubleValue()))));
	}

}
