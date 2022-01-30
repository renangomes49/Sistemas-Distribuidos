package inputs.outputs;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

import model.Pessoa;

public class PessoasInputStream extends InputStream{

	private InputStream inputStream;
	
	// construtor
	public PessoasInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public PessoasInputStream() {
		
	}
	
	// getters e setters
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	// métodos
	
	public void EntradaPadrão(List<Pessoa> pessoas, int qtdPessoas) {
		
			try {
				
				Scanner entrada = new Scanner(System.in);
				
				String nome = "";
				String cpf = "";
				int idade = 0;
				
				for(int i = 0; i < qtdPessoas; i++) {
					
					System.out.println("Digite o seu nome: ");
					nome = entrada.nextLine();
					
					System.out.println("Digite o seu CPF: ");
					cpf = entrada.nextLine();
					
					System.out.println("Digite sua idade: ");
					idade =  Integer.parseInt(entrada.nextLine());
					
					Pessoa pessoa = new Pessoa(nome, cpf, idade);
					pessoas.add(pessoa);
				}
			}catch (NumberFormatException e) {
				System.out.println("Entrada Inválida");
			}catch (Exception e) {
				e.printStackTrace();
			}	
		}
	
	public void receberTCP(int qtdPessoasLista){		

		try {
			
			DataInputStream dataInputStream = (DataInputStream) this.getInputStream();
			
			int qtdPessoas = dataInputStream.readInt();
			System.out.println("Quantidade de Pessoas na Lista: " + qtdPessoas + "\n");
			
			for (int i = 0; i < qtdPessoasLista; i++) {
				int qtdBytesPessoa = dataInputStream.readInt();
				System.out.println( "Número de Bytes para escrever o nome da Pessoa: " + qtdBytesPessoa);
				
				String nomePessoa = dataInputStream.readUTF();
				System.out.println("Nome da Pessoa em Maiuscúlo: " + nomePessoa);

				String cpf = dataInputStream.readUTF();
				System.out.println("CPF da Pessoa: " + cpf);
				
				int idade = dataInputStream.readInt();
				System.out.println("Idade da Pessoa: " + idade + "\n");		
				
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void lerArquivo() {
		try {
			
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);	
			
			String linhaArquivo = "";
			while ((linhaArquivo = bufferedReader.readLine()) != null) {
				System.out.println(linhaArquivo);
			}
			
			bufferedReader.close();
			
		}catch (UnknownHostException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (EOFException e) {
			System.out.println("EOF: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("readline: " + e.getMessage());
		}finally {
			try {
				this.inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public int read() throws IOException {
		return 0;
	}
	
	

}
