package paladeans.jsonsemgson.model;

/*Classe Usuario utilizada para gerar novos objetos apartir do JSON*/

public class Usuario {

    private String nome;
    private String titulo;
    private String locacao;

    public Usuario() {
    }

    public Usuario(String nome, String titulo, String locacao) {
        this.nome = nome;
        this.titulo = titulo;
        this.locacao = locacao;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "nome='" + nome + '\'' +
                ", titulo='" + titulo + '\'' +
                ", locacao='" + locacao + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLocacao() {
        return locacao;
    }

    public void setLocacao(String locacao) {
        this.locacao = locacao;
    }
}
