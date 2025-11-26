public enum MonedasDelMundo {
    ARS("Peso Argentino"),
    BOB("Boliviano"),
    BRL("Real Brasileño"),
    CLP("Peso Chileno"),
    CLF("Unidad de Fomento"),
    COP("Peso Colombiano"),
    PYG("Guaraní Paraguayo"),
    PEN("Sol Peruano"),
    UYU("Peso Uruguayo"),
    VES("Bolívar Venezolano"),
    MXN("Peso mexicano"),
    USD("Dólar Estadounidense"),
    EUR("Euro"),
    GBP("Libra Esterlina"),
    CNY("Yuan Chino"),
    RUB("Rublo Ruso");

    private final String descripcion;

    MonedasDelMundo(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
