package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestClazz {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while (in.readLine() != null) {
			System.out.println(in.readLine());
		}


	}
}
