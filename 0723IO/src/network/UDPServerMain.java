package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerMain {

	public static void main(String[] args) {
		
		try {
			//받는 DatagramSocket 생성
			DatagramSocket ds = new DatagramSocket(5000);
			while(true) {
				//데이터를 저장할 byte배열을 생성
				byte [] b = new byte[1024];
				//DatagramPacket 생성
				DatagramPacket dp =new DatagramPacket(b, 1024);
				//데이터 받기
				ds.receive(dp);
				//데이터를 읽어서 출력
				String msg = new String(b, 0, 1024);
				System.out.println("보낸곳:" + dp.getAddress());
				System.out.println("메세지:" + msg);
				
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
