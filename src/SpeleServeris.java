import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class SpeleServeris {
	public SpeleServeris() throws IOException{
		//servera socket - 1.
		ServerSocket serverSoc = new ServerSocket(8090);
		
		while(true){
		//client socket - 2.
		Socket clientSoc = serverSoc.accept();
		System.out.println("Connection established");
		// get streams - 3.
		OutputStream oS = clientSoc.getOutputStream();
		InputStream iS = clientSoc.getInputStream();
		
		ObjectOutputStream oOS = new ObjectOutputStream(oS);
		ObjectInputStream oIS = new ObjectInputStream(iS);
		
		//sent message - 4.
		oOS.writeObject("Message from server");
		}
		
//		//close connections - 5.
//		serverSoc.close();
//		clientSoc.close();
//		oS.close();
//		iS.close();
	}
	
	public static void main(String[] args) throws IOException{
		SpeleServeris serveris = new SpeleServeris();
	}
}
