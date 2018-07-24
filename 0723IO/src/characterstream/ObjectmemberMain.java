package characterstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectmemberMain {

	public static void main(String[] args) {
		// 객체단위로 데이터를 기록할 수 있는 클래스의 변수
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("./oos.txt"));
			Member member = new Member();
			member.setEmail("shen_aihua@naver.com");
			member.setPw("1234");
			member.setPhone("01099998888");

			oos.writeObject(member);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("./oos.txt"));
			//강제 형변환
			Member member = (Member)ois.readObject();

			System.out.println(member.getEmail());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}

}
