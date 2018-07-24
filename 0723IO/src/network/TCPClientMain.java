package network;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//서버에 접속
			InetAddress addr = InetAddress.getByName("192.168.0.246");
			Socket socket = new Socket(addr, 9999);
			//전송할 메세지 입력받기
			Scanner sc = new Scanner(System.in);
			System.out.println("전송할 메세지:");
			String msg = sc.nextLine();
			sc.close();
			
			//전송할 스트림 생성
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			//데이터 전송
			pw.println(msg);
			pw.flush();
			
			socket.close();

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
