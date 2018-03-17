package cpp.model;

public class Movimento {
	Integer id_processo;
	String manifestacao;
	String destino;
	String responsavel;
	String data;

	public Movimento(Integer id_processo, String manifestacao, String destino, String responsavel) {
		this.id_processo = id_processo;
		this.manifestacao = manifestacao;
		this.destino = destino;
		this.responsavel = responsavel;
		//this.data = data;
	}

	public Integer getIdProcesso() {
		return id_processo;
	}

	public void setIdProcesso(Integer id_processo) {
		this.id_processo = id_processo;
	}

	public String getManifestacao() {
		return manifestacao;
	}

	public void setManifestacao(String manifestacao) {
		this.manifestacao = manifestacao;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	

}
