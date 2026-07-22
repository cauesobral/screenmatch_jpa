package br.com.cauesobral.screenmatch.desafios;

public enum CodigoErro {
    NOT_FOUND(404, "Não encontrado"),
    BAD_REQUEST(400, "Request errada"),
    INTERNAL_SERVER_ERROR(500, "Erro interno do servidor");

    private final int codigo;
    private final String descricao;

    CodigoErro(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
