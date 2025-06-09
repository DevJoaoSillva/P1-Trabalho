public class RelatorioPDF extends RelatorioTemplate {

    public RelatorioPDF(String titulo) {
        super(titulo);
    }

    @Override
    protected void buscarDados() {
        log("Buscando dados para relatório PDF...");
    }

    @Override
    protected boolean validarDados() {
        log("Validando dados para PDF...");
        return true;
    }

    @Override
    protected boolean processarDados() {
        formatarCabecalho();
        log("Processando dados para PDF...");
        return true;
    }

    @Override
    protected boolean gerarArquivo() {
        log("Gerando arquivo PDF.");
        return true;
    }

    @Override
    protected boolean salvarCopia() {
        return false;
    }
}
