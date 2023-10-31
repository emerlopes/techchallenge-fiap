package br.com.ar.arinvest.dto;

public enum StatusPlanoInvestimentoEnum {

    CRIADO("Criado"),
    EM_ANDAMENTO("Em andamento"),
    ENVIADO("Enviado"),
    APROVADO("Aprovado"),
    RECUSADO("Recusado"),
    EM_FORMALIZACAO("EM formalização"),
    CONCLUIDO("Concluído"),
    CANCELADO("Cancelado");

    private final String descricao;

    StatusPlanoInvestimentoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusPlanoInvestimentoEnum fromDescricao(String descricao) {
        for (StatusPlanoInvestimentoEnum status : StatusPlanoInvestimentoEnum.values()) {
            if (status.descricao.equalsIgnoreCase(descricao)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Descrição inválida: " + descricao);
    }
}
