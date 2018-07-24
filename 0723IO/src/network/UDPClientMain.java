package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClientMain {

	public static void main(String[] args) {
		try {
			//보낼 DatagramSocket 생성
			DatagramSocket ds = new DatagramSocket();
			//전송할 데이터 만들기
			Scanner sc = new Scanner(System.in);
			System.out.println("전송할 메시지:");
			String msg = sc.nextLine();
			
			//데이터 저장한 DatagramPacket 생성 (보낼 데이터, 데이터 길이, 받을 IP, 받을 포트번호) 
			DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length,
					InetAddress.getByName("192.168.0.246"), 5000);
			//데이터 전송
			ds.send(dp);
			
			//Scanner, DatagramSocket 닫기
			sc.close();
			ds.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
