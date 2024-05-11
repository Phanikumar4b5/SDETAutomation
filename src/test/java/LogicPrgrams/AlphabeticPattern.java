package LogicPrgrams;

public class AlphabeticPattern {
	public static void printAlphabeticInOrder() {
		int k=65;
		for(int i=0;i<6;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print((char)k+" ");
				k++;
			}
			System.out.println();
		}
	}
	public static void printSameAlphabeticInEveryLine() {
		int k=65;
		for(int i=0;i<6;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print((char)k+" ");
			}
			System.out.println();
			k++;
		}
	}
	public static void main(String[] args) {
		printAlphabeticInOrder();
		System.out.println();
		printSameAlphabeticInEveryLine();
	}
	

}
