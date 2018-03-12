package cpp.model;

public class Processo {

	Integer id;
	String comarca;
	String num_processo;
	Integer id_vara;
	String classe;
	String assunto;
	String distribuicao;
	String autor;
	String denunciado;

	public Processo(String num_processo) {
		super();
		this.num_processo = num_processo;
	}

	public void setNumProc(String num_proc) {
		this.num_processo = num_proc;

	}
	
	public String getNumProc() {
		return this.num_processo;
	}

	public void setId(int id) {
		this.id = id;

	}

}
