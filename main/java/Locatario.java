import javax.swing.JOptionPane;

public class Locatario {
    private String nome;
    private String cpf;
    private String telefone;
    private int anoNascimento;
    
    // construtor
    public Locatario() {
    }
    
    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
    
    // métodos
    public void cadastrarLocatario() {
        this.setNome(JOptionPane.showInputDialog("Informe o nome do locatário:"));
        this.setCpf(JOptionPane.showInputDialog("Informe o CPF do locatário:"));
        this.setTelefone(JOptionPane.showInputDialog("Informe o telefone do locatário:"));
        
        int ano = 0;
        while (ano <= 0 || ano > 2023) {
            try {
                String strAno = JOptionPane.showInputDialog("Informe o ano de nascimento do locatário:");
                ano = Integer.parseInt(strAno);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ano de nascimento inválido! Tente novamente.");
            }
        }
        this.setAnoNascimento(ano);
    }
    //atualização
}
