package Paypal;

/*
 *  intput : abaxqwx abaxqwax
 *  output : true
 *  explanation : if x is there in dtring remove the previous char and check if both the strings are equal
 */
public class FirstRound {
	public static void main(String[] args) {
		payPalFirstDSA("abaxqwkx", "abaxqwax");
	}

	private static void payPalFirstDSA(String s1, String s2) {
		if (remove(s1).equals(remove(s2))) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

	}

//	TC=O(n) SC=O(n)
	public static String remove(String string) {
		StringBuilder s = new StringBuilder(string);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'x') {
				s.deleteCharAt(i - 1);
			}
		}
		System.out.println(s);
		return s.toString();
	}
}
