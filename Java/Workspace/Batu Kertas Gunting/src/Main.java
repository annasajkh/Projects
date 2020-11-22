import java.util.Scanner;

enum BatuKertasGunting {
	BATU, KERTAS, GUNTING
}

public class Main {
	public static void main(String[] args) {

		BatuKertasGunting[] choices = { BatuKertasGunting.BATU, BatuKertasGunting.KERTAS, BatuKertasGunting.GUNTING };
		BatuKertasGunting computerChoice = choices[(int) (Math.random() * 3)];
		BatuKertasGunting playerChoice;

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		switch (input.toLowerCase().strip()) {
		case "batu":
			playerChoice = BatuKertasGunting.BATU;
			break;
		case "kertas":
			playerChoice = BatuKertasGunting.KERTAS;
			break;
		case "gunting":
			playerChoice = BatuKertasGunting.GUNTING;
			break;
		default:
			playerChoice = choices[(int) (Math.random() * 3)];
			System.out.println("Kamu tidak memilih maka akan dipilih acak pilihanmu : " + playerChoice);
		}

		if (computerChoice == playerChoice) {
			System.out.println("Komputer memilih : " + computerChoice);
			System.out.println("seri");
		} else if ((computerChoice == BatuKertasGunting.BATU && playerChoice == BatuKertasGunting.GUNTING)
				|| (computerChoice == BatuKertasGunting.KERTAS && playerChoice == BatuKertasGunting.BATU)
				|| (computerChoice == BatuKertasGunting.GUNTING && playerChoice == BatuKertasGunting.KERTAS)) {
			System.out.println("Komputer memilih : " + computerChoice);
			System.out.println("Komputer menang");
		} else if (!(computerChoice == BatuKertasGunting.BATU && playerChoice == BatuKertasGunting.GUNTING)
				|| !(computerChoice == BatuKertasGunting.KERTAS && playerChoice == BatuKertasGunting.BATU)
				|| !(computerChoice == BatuKertasGunting.GUNTING && playerChoice == BatuKertasGunting.KERTAS)) {
			System.out.println("Komputer memilih : " + computerChoice);
			System.out.println("Player menang");
		}
		scanner.close();
	}
}
