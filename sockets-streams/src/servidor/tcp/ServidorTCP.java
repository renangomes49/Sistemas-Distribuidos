package servidor.tcp;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
	public static void main(String[] args) throws Exception {
		ServerSocket socketServidor = null;
		try {

			System.out.println("Servidor Iniciado");
			int portaServidor = 7896;
			socketServidor = new ServerSocket(portaServidor);
			
			while (true) {
				Socket socketCliente = socketServidor.accept();

				DataOutputStream dataOutputStream = new DataOutputStream(socketCliente.getOutputStream());
				DataInputStream dataInputStream = new DataInputStream(socketCliente.getInputStream());
				Connection connection = new Connection(socketCliente, dataInputStream, dataOutputStream);
				Thread thread = new Thread(connection);
				thread.start();
			}
			
		} catch (Exception e) {
			System.out.println("Listen Socket: " + e.getMessage());
		}finally {
			socketServidor.close();
		}

	}
}
