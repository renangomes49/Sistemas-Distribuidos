package inputs.outputs;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;

public class PessoasOutputStream extends OutputStream {

	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private OutputStream outputStream;

	// construtor
	public PessoasOutputStream(List<Pessoa> pessoas, OutputStream outputStream) {
		this.pessoas = pessoas;
		this.outputStream = outputStream;
	}

	// getters e setters
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public OutputStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	// métodos
	public void saidaPadrão() {
		System.out.println("Quantidade de Pessoas na lista: " + this.pessoas.size());
		for (Pessoa pessoa : pessoas) {
			System.out.println("Nome da Pessoa: " + pessoa.getNome() + "," +
					" Quantidade de bytes utilizados para gravar o nome da pessoa: " + pessoa.getNome().getBytes().length + ","
					+ " CPF da Pessoa: " + pessoa.getCpf() + " Idade da Pessoa: " + pessoa.getIdade() + ";\n");
		}
	}

	public void escreverArquivo() {
		try {

			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.outputStream);
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
			
			bufferedWriter.write("Quantidade de Pessoas na lista: " + this.pessoas.size() + "\n");
			
			for (Pessoa pessoa : pessoas) {

				bufferedWriter.write("Nome Pessoa: " + pessoa.getNome() + "," +
						" Quantidade de bytes utilizados para gravar o nome da pessoa: " + pessoa.getNome().getBytes().length + ","
						+ " CPF da Pessoa: " + pessoa.getCpf() + " Idade da Pessoa: " + pessoa.getIdade() + ";\n");
				
			}
			
			bufferedWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enviarTCP() throws Exception {

		DataOutputStream dataOutputStream = (DataOutputStream) this.getOutputStream();

		int qtdPessoas = this.pessoas.size();
		dataOutputStream.writeInt(qtdPessoas);

		try {
			for (Pessoa pessoa : pessoas) {

				dataOutputStream.writeInt(pessoa.getNome().getBytes().length);
				dataOutputStream.writeUTF(pessoa.getNome());
				dataOutputStream.writeUTF(pessoa.getCpf());
				dataOutputStream.writeInt(pessoa.getIdade());

			}

		} catch (UnknownHostException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (EOFException e) {
			System.out.println("EOF: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("readline: " + e.getMessage());
		}

	}
	
	public void write(int b) throws IOException {

	}

}
