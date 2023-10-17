package model;

public class Musica {
    public String nome;
    public String nomeArtista;
    public int duracao;

    public Musica(String nome, String nomeArtista, int duracao) {
        this.nome = nome;
        this.nomeArtista = nomeArtista;
        this.duracao = duracao;
    }

    public Musica() {
        super();
    }

    @Override
    public String toString() {
        return "Musica -> " +
                "'" + nome + '\'' +
                ", Artista :  '" + nomeArtista + '\'' +
                ", Duração : " + duracao + " segundos";
    }
}
