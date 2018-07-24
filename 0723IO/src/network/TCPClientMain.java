package network;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//������ ����
			InetAddress addr = InetAddress.getByName("192.168.0.246");
			Socket socket = new Socket(addr, 9999);
			//������ �޼��� �Է¹ޱ�
			Scanner sc = new Scanner(System.in);
			System.out.println("������ �޼���:");
			String msg = sc.nextLine();
			sc.close();
			
			//������ ��Ʈ�� ����
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			//������ ����
			pw.println(msg);
			pw.flush();
			
			socket.close();

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
