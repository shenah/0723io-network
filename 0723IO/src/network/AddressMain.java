package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressMain {

	public static void main(String[] args) {

		try {
			// �ּ� ���� 1�� ��������
			InetAddress addr = InetAddress.getByName("www.choongang.com");
			System.out.println(addr);
			// �ּ� ���� ���� �� ��������
			InetAddress [] add = InetAddress.getAllByName("www.naver.com");
			
			for(InetAddress imsi : add) {
				System.out.println(imsi);
			}
		} catch (UnknownHostException e) {

			e.printStackTrace();
		}
		

	}

}
