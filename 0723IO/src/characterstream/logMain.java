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
		/* 로그파일을 읽어서 ip 별 접속횟수 출력하기 */
		
		// 1.BufferedReader 객체 만들기 - 문자열 파일이고 네이티브 메소드 호출횟수를 줄이기 위해서
		BufferedReader b = null;
		HashMap<String, Integer> map = new HashMap<>();
		HashMap<String, Integer> traffic = new HashMap<>();

		try {
			b = new BufferedReader(new FileReader("./access_log.txt"));
			//2.줄 단위로 데이터를 읽기 
			while (true) {
				String line = b.readLine();
				if (line == null) {
					break;
				}
				//3.ip-첫번째 데이터만 쓰기 위해 데이터를 공백으로 분할하기
				String[] ar = line.split(" ");
				
				//4.HashMap을 활용해서 첫번째 데이터의 횟수를 저장하고 출력하기
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

			// 맵의 데이터을 출력
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
			System.out.println("예외처리:" + e.getMessage());
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
