package servidor.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection implements Runnable {

	private Socket socket;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;

	public Connection(Socket socket, DataInputStream dataInputStream, DataOutputStream dataOutputStream)
			throws IOException {
		this.socket = socket;
		this.dataInputStream = dataInputStream;
		this.dataOutputStream = dataOutputStream;
	}

	public void run() {

		int qtdPessoas = 0;

		try {
			qtdPessoas = this.dataInputStream.readInt();
			this.dataOutputStream.writeInt(qtdPessoas);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {

			int i = 1;

			while (i <= qtdPessoas) {

				int qtdBytesPessoa = this.dataInputStream.readInt();
				this.dataOutputStream.writeInt(qtdBytesPessoa);

				String nomePessoa = this.dataInputStream.readUTF();
				this.dataOutputStream.writeUTF(nomePessoa.toUpperCase());

				String cpf = this.dataInputStream.readUTF();
				this.dataOutputStream.writeUTF(cpf);

				int idade = this.dataInputStream.readInt();
				this.dataOutputStream.writeInt(idade);

				i++;
			}
		} catch (UnknownHostException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (EOFException e) {
			System.out.println("EOF: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("readline: " + e.getMessage());
		} finally {
			try {
				this.dataInputStream.close();
				this.dataOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
