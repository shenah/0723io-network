package characterstream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class logMain {

	public static void main(String[] args) {
		/* �α������� �о ip �� ����Ƚ�� ����ϱ� */
		
		// 1.BufferedReader ��ü ����� - ���ڿ� �����̰� ����Ƽ�� �޼ҵ� ȣ��Ƚ���� ���̱� ���ؼ�
		BufferedReader b = null;
		HashMap<String, Integer> map = new HashMap<>();
		HashMap<String, Integer> traffic = new HashMap<>();

		try {
			b = new BufferedReader(new FileReader("./access_log.txt"));
			//2.�� ������ �����͸� �б� 
			while (true) {
				String line = b.readLine();
				if (line == null) {
					break;
				}
				//3.ip-ù��° �����͸� ���� ���� �����͸� �������� �����ϱ�
				String[] ar = line.split(" ");
				
				//4.HashMap�� Ȱ���ؼ� ù��° �������� Ƚ���� �����ϰ� ����ϱ�
				Integer count = map.get(ar[0]);

				if (count == null) {
					map.put(ar[0], 1);
				} else {
					map.put(ar[0], count + 1);
				}

				Integer traf = map.get(ar[0]);
				if (traf == null) {
					if (!ar[9].equals("\"-\"") && !ar[9].equals("-")) {
						traffic.put(ar[0], Integer.parseInt(ar[9]));
					}
				} else {
					if (!ar[9].equals("\"-\"") && !ar[9].equals("-")) {
						traffic.put(ar[0], Integer.parseInt(ar[9]));
					}
				}
			}

			// ���� �������� ���
			Set<String> keyset = map.keySet();
			for (String key : keyset) {
				System.out.println(key + ":" + map.get(key));
			}
			System.out.println("====================");
			keyset = traffic.keySet();
			for (String key : keyset) {
				System.out.println(key + ":" + traffic.get(key));
			}

		} catch (Exception e) {
			System.out.println("����ó��:" + e.getMessage());
		} finally {
			try {
				if (b != null) {
					b.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
