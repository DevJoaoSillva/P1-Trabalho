import java.time.LocalDateTime;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public abstract class RelatorioTemplate {

    private String titulo;

    public RelatorioTemplate(String titulo) {
        this.titulo = titulo;
    }

    public final void gerarRelatorio() {
        log("Início da geração do relatório: " + titulo);
        LocalDateTime inicio = LocalDateTime.now();

        buscarDados();
        if (!validarDados()) {
            log("Validação falhou. Cancelando geração.");
            return;
        }
        if (!processarDados()) {
            log("Processamento falhou. Cancelando geração.");
            return;
        }
        if (!gerarArquivo()) {
            log("Geração do arquivo falhou. Cancelando geração.");
            return;
        }
        if (salvarCopia()) {
            salvarCopiaNoBanco();
        }

        LocalDateTime fim = LocalDateTime.now();
        long segundos = ChronoUnit.SECONDS.between(inicio, fim);
        log("Relatório gerado com sucesso em " + segundos + " segundos.");
    }

    // Etapas do template (algumas retornam boolean para indicar sucesso/falha)
    protected abstract void buscarDados();
    protected abstract boolean validarDados();
    protected abstract boolean processarDados();
    protected abstract boolean gerarArquivo();

    protected boolean salvarCopia() {
        return false;
    }

    protected void salvarCopiaNoBanco() {
        log("Salvando cópia do relatório no banco de dados.");
    }

    protected void log(String mensagem) {
        System.out.println(LocalDateTime.now() + " - " + mensagem);
    }

    protected String getTitulo() {
        return titulo;
    }

    protected void formatarCabecalho() {
        log("Formatando cabeçalho do relatório: " + titulo);
    }
}
