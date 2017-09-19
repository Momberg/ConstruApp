package br.com.fiap.notepadsaas.model;

public class Servico {

    private String tipoServico;
    private String localServico;
    private String idPrestador;

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getLocalServico() {
        return localServico;
    }

    public void setLocalServico(String localServico) {
        this.localServico = localServico;
    }

    public String getIdPrestador() {
        return idPrestador;
    }

    public void setIdPrestador(String idPrestador) {
        this.idPrestador = idPrestador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Servico servico = (Servico) o;

        if (tipoServico != null ? !tipoServico.equals(servico.tipoServico) : servico.tipoServico != null) return false;
        return localServico != null ? localServico.equals(servico.localServico) : servico.localServico == null;
    }

    @Override
    public int hashCode() {
        int result = tipoServico != null ? tipoServico.hashCode() : 0;
        result = 31 * result + (localServico != null ? localServico.hashCode() : 0);
        return result;
    }
}
