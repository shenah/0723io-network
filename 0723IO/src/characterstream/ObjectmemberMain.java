package characterstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectmemberMain {

	public static void main(String[] args) {
		// ��ü������ �����͸� ����� �� �ִ� Ŭ������ ����
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
			//���� ����ȯ
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
