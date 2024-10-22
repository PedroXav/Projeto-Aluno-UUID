/* Nome: Maria Eduarda Fodor CB3025063
 * Nome: Pedro Xavier Oliveira CB3027376
 */

import java.util.UUID;

class Aluno {
    private String nome;
    private String endereco;
    private int idade;
    private UUID uuid;

    // Construtor
    public Aluno(String nome, String endereco, int idade) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.uuid = UUID.randomUUID(); // Gera um UUID único
    }

    // Métodos get e set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public UUID getUuid() {
        return uuid;
    }

    // Não é necessário um set para UUID, pois ele deve ser gerado automaticamente
}