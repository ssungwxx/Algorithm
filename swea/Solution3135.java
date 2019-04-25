package swea;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution3135 {

	public static class UserSolution {

		private TrieNode[] trieTree;

		public void init() {
			trieTree = new TrieNode[26];
		}

		public void insert(int buffer_size, String buf) {
			int cnt = 0;
			TrieNode[] temp = trieTree;
			while (cnt < buffer_size) {
				if (temp[buf.charAt(cnt) - 'a'] != null) {
					temp[buf.charAt(cnt) - 'a'].cnt++;
					temp = temp[buf.charAt(cnt++) - 'a'].nodes;
				} else {
					temp[buf.charAt(cnt) - 'a'] = new TrieNode();
					temp[buf.charAt(cnt) - 'a'].val = buf.charAt(cnt);
					temp[buf.charAt(cnt) - 'a'].cnt = 1;
					temp = temp[buf.charAt(cnt++) - 'a'].nodes;
				}
			}
		}

		public int query(int buffer_size, String buf) {
			int cnt = 0;
			int result = 0;
			TrieNode[] temp = trieTree;
			while (cnt < buffer_size) {
				if (temp[buf.charAt(cnt) - 'a'] != null) {
					result = temp[buf.charAt(cnt) - 'a'].cnt;
					temp = temp[buf.charAt(cnt++) - 'a'].nodes;
				} else {
					return 0;
				}
			}

			return result;
		}

		public class TrieNode {
			public char val;
			public TrieNode[] nodes = new TrieNode[26];
			public int cnt;
		}
	}

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);

		UserSolution dictManager = new UserSolution();

		for (int TestCase = in.nextInt(), tc = 1; tc <= TestCase; tc = tc + 1) {

			int Query_N = in.nextInt();

			out.print("#" + tc);

			dictManager.init();

			for (int i = 1; i <= Query_N; i++) {
				int type = in.nextInt();

				if (type == 1) {
					String buf = in.next();
					dictManager.insert(buf.length(), buf);
				} else {
					String buf = in.next();
					int answer = dictManager.query(buf.length(), buf);
					out.print(" " + answer);
				}
			}
			out.println("");
		}
		out.close();
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}

}
