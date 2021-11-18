package desenvolve.unesc.avaliacao.enums;

public enum IdentificadorMesaEnum {

    MESA1("MESA1", 1),
    MESA2("MESA2", 2),
    MESA3("MESA3", 3),
    MESA4("MESA4", 4),
    MESA5("MESA5", 5),
    MESA6("MESA6", 6),
    MESA7("MESA7", 7),
    MESA8("MESA8", 8),
    MESA9("MESA9", 9);

    private String key;
    private Integer indice;

    IdentificadorMesaEnum(final String key, Integer indice) {
        this.key = key;
        this.indice = indice;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }
}
