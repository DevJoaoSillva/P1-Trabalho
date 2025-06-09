public class RelatorioTXT extends RelatorioTemplate {

    public RelatorioTXT(String titulo) {
        super(titulo);
    }

    @Override
    protected void buscarDados() {
        log("Buscando dados para relatório TXT...");
    }

    @Override
    protected boolean validarDados() {
        log("Validando dados para TXT...");
        return true;
    }

    @Override
    protected boolean processarDados() {
        formatarCabecalho();
        log("Processando dados para TXT...");
        return true;
    }

    @Override
    protected boolean gerarArquivo() {
        log("Gerando arquivo TXT.");
        return true;
    }

    @Override
    protected boolean salvarCopia() {
        return true;
    }
}
