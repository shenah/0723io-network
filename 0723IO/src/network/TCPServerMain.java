package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerMain {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(9999) ;
			
			while(true) {
				//클라인언트 접속대기 - 클라이언트가 접속하면
				//Client 와의 통신을 위한 Socket을 리턴하고 다음 줄의 코드 실생
				System.out.println("서버 대기중..");
				Socket socket = ss.accept();
				//한줄의 데이터를 읽어서 출력
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String msg = br.readLine();
				System.out.println("메세지:" + msg);
				System.out.println("접속자:" + socket.getInetAddress());
				br.close();
				socket.close();

			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		

	}

}
