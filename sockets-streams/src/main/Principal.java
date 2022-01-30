package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import inputs.outputs.PessoasInputStream;
import inputs.outputs.PessoasOutputStream;
import model.Pessoa;

public class Principal {
	public static void main(String[] args) throws Exception{

		// Entrada e Saída Padrão
		System.out.println("\nEntrada Padrão");
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		PessoasInputStream pis = new PessoasInputStream();
		pis.EntradaPadrão(pessoas,10);
		System.out.println();
		
		System.out.println("Saída Padrão\n");
		PessoasOutputStream pos = new PessoasOutputStream(pessoas, null);
		pos.saidaPadrão();
		System.out.println();
		// Fim
		
		Socket socketCliente = new Socket("localhost",7896);
		DataOutputStream outputStream = new DataOutputStream(socketCliente.getOutputStream());
		DataInputStream inputStream = new DataInputStream(socketCliente.getInputStream());
		
		// Envio TCP
		PessoasOutputStream pessoasOutputStream = new PessoasOutputStream(pessoas, outputStream);
		pessoasOutputStream.enviarTCP();
		
		// Recebimento TCP
		System.out.println("Recebendo os dados enviados para o Servidor TCP \n");
		PessoasInputStream pessoasInputStream = new PessoasInputStream(inputStream);
		pessoasInputStream.receberTCP(pessoas.size());
		System.out.println();
		
		socketCliente.close();
		outputStream.close();
		inputStream.close();
		
		// fim
		
		// escrevendo do arquivo e lendo arquivo
		FileOutputStream fileOutputStream = new FileOutputStream("arquivo.txt");
		//escrevendo arquivo
		PessoasOutputStream pessoasOutputStream2 = new PessoasOutputStream(pessoas, fileOutputStream);
		pessoasOutputStream2.escreverArquivo();
		
		//lendo arquivo
		System.out.println("Lendo o arquivo");
		FileInputStream fileInputStream = new FileInputStream("arquivo.txt");
		PessoasInputStream pessoasInputStream2 = new PessoasInputStream(fileInputStream);
		pessoasInputStream2.lerArquivo();
		
		fileOutputStream.close();
		fileInputStream.close();
	
	
	}
}
