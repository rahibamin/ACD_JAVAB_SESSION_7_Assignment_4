package Session7.Assignment4;

import java.util.Scanner;

public class anagramsString {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String userString = "";

		System.out.print("Enter your string: ");

		userString = sc.nextLine();
		if (userString.length() != 0) {

			userString.trim();
			String[] arr = userString.split(", ");
			for(String a: arr) {
				String[] let = a.toLowerCase().split("");
				sort(let, let.length);
				String key = "";
				for (String l: let) {
					key += l;
				}
				int i = sb.indexOf(key);
				if (i > -1) {
					if (sb.indexOf(a) > -1);
					else
						sb.insert(i+key.length()+3, a + ", ");
				} else {
					sb.append(":" +key+":{ " + a + " }");
				}
			}
			userString = sb.toString();
			userString = userString.trim();
			userString = userString.replaceAll(":[a-zA-z]+:", "");
			userString = userString.replaceAll("\\{ [a-zA-z]+ \\}", "");
			System.out.println(userString);
			sb.replace(0, sb.length(), "");
		}
	}

	static void sort(String[] arr, int size) {
		if (size == 0 || size == 1 || arr == null) return;
		int c = arr.length - size;
		int index = -1;
		String min = null;
		for (int i = 0; i < size; i++) {
			if (min == null || arr[c+i].compareToIgnoreCase(min) < 0) {
				min = arr[c+i];
				index = c+i;
			}
		}
		if (index < 0) return;
		String tmp = arr[c];
		arr[c] = arr[index];
		arr[index] = tmp;
		sort(arr, size-1);
	}
}