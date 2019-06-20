import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServerSocket serv = null;
		Socket sock = null ;
		DataInputStream in = null;
		DataOutputStream out =null;
		
		InetAddress inet = null;
		
		try {
			serv = new ServerSocket(10001);
			System.out.println("waiting connect...");
			
			while(true) {
				sock = serv.accept();
				inet = sock.getInetAddress();
				
				System.out.println(inet.getHostAddress()+"로부터 접속했습니다.");
				
				in = new DataInputStream(sock.getInputStream());
				out = new DataOutputStream(sock.getOutputStream());
				
				String line = null;
				
				try {
					while((line = in.readUTF()) != null ) {
						System.out.println("클라이언트로부터 밭은 문자열 : "+ line);
						out.writeUTF(line);
					}
				}catch(Exception e) {
					sock.close();
					System.out.println("Discoonect");
				}
				
			}
			
			
		}catch(Exception e ) {
			System.out.println(e);
		}
		
		
	}

}
