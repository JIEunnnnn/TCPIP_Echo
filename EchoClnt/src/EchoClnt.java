import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoClnt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServerSocket serv = null;
		Socket sock = null ;
		DataInputStream in = null;
		DataOutputStream out =null;
		BufferedReader key =null;
		
		try {
			sock = new Socket("127.0.0.1", 10001);
			in = new DataInputStream(sock.getInputStream());
			out = new DataOutputStream(sock.getOutputStream());
			key = new BufferedReader(new InputStreamReader(System.in));
			
			String line = null;
			
			while((line = key.readLine()) !=null ) {
				if(line.equals("quit"))
					break; 
				
				out.writeUTF(line);
				
				String echo = in.readUTF();
				System.out.println("서버로부터 전달받은 문자열 :"+echo);
			}
			sock.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
