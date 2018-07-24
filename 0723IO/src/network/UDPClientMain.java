package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClientMain {

	public static void main(String[] args) {
		try {
			//���� DatagramSocket ����
			DatagramSocket ds = new DatagramSocket();
			//������ ������ �����
			Scanner sc = new Scanner(System.in);
			System.out.println("������ �޽���:");
			String msg = sc.nextLine();
			
			//������ ������ DatagramPacket ���� (���� ������, ������ ����, ���� IP, ���� ��Ʈ��ȣ) 
			DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length,
					InetAddress.getByName("192.168.0.246"), 5000);
			//������ ����
			ds.send(dp);
			
			//Scanner, DatagramSocket �ݱ�
			sc.close();
			ds.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
