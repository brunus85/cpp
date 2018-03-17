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
	String parte;

	public Processo(String num_processo) {
		super();
		this.num_processo = num_processo;
	}

	public void setId(int id) {
		this.id = id;

	}

	public Integer getId() {
		return this.id;
	}

	public String getComarca() {
		return comarca;
	}

	public void setComarca(String comarca) {
		this.comarca = comarca;
	}

	public void setNumProc(String num_proc) {
		this.num_processo = num_proc;

	}

	public String getNumProc() {
		return this.num_processo;
	}

	public Integer getIdVara() {
		return id_vara;
	}

	public void setIdVara(Integer id_vara) {
		this.id_vara = id_vara;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDistribuicao() {
		return distribuicao;
	}

	public void setDistribuicao(String distribuicao) {
		this.distribuicao = distribuicao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getParte() {
		return parte;
	}

	public void setParte(String parte) {
		this.parte = parte;
	}

}
