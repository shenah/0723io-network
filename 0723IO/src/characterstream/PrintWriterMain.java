package characterstream;

import java.io.PrintWriter;

public class PrintWriterMain {

	public static void main(String[] args) {
		//����, ��Ʈ��ũ, �����ͺ��̽� ���� Ŭ�������� 
		//����ó���� �����մϴ�.

		PrintWriter pw = null;
		try {
			//���� ���丮�� ������ ����
			pw = new PrintWriter("./file.txt");
			//���Ͽ� ���ڿ��� ���
			pw.println("�ȳ��ϼ���");
			//�������� ���� ������ ���� ���
			pw.flush();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(pw != null) {
				pw.close();
			}
		}
	}

}
