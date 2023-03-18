import javax.swing.JOptionPane;

public class Locacao {
    private Locatario locatario;
    private Quadra quadra;
    private int tempoMinuto;
    private char necessitaEquipamento;
    
    // construtor
    public Locacao(Locatario locatario, Quadra quadra, int tempoMinuto, char necessitaEquipamento) {
        this.locatario = locatario;
        this.quadra = quadra;
        this.tempoMinuto = tempoMinuto;
        this.necessitaEquipamento = necessitaEquipamento;
    }
    
    // getters e setters
    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Quadra getQuadra() {
        return quadra;
    }

    public void setQuadra(Quadra quadra) {
        this.quadra = quadra;
    }

    public int getTempoMinuto() {
        return tempoMinuto;
    }

    public void setTempoMinuto(int tempoMinuto) {
        this.tempoMinuto = tempoMinuto;
    }

    public char getNecessitaEquipamento() {
        return necessitaEquipamento;
    }

    public void setNecessitaEquipamento(char necessitaEquipamento) {
        this.necessitaEquipamento = necessitaEquipamento;
    }
    
    // métodos
    public double calcularLocacao() {
        int minutos = this.tempoMinuto;
        double valorMinuto = this.quadra.getValorMinuto();

        // Verifica se a locação tem mais de 2 horas (120 minutos) para aplicar o desconto
        if (minutos > 120) {
            valorMinuto = valorMinuto * 0.9;
        }

        double valorLocacao = minutos * valorMinuto;

        // Adiciona o valor de 50 reais caso necessite de equipamento
        if (this.necessitaEquipamento == 'S') {
            valorLocacao += 50;
        }

        return valorLocacao;
    }
    
    public void mostrarResumoLocacao() {
        String locatarioMsg = "Locatario\n" +
                "Nome: " + this.locatario.getNome() + "\n" +
                "CPF: " + this.locatario.getCpf() + "\n" +
                "Telefone: " + this.locatario.getTelefone() + "\n" +
                "Ano de Nascimento: " + this.locatario.getAnoNascimento();
        
        String quadraMsg = "Quadra\n" +
                "Nome da Quadra: " + this.quadra.getNome() + "\n" +
                "Tipo: " + this.quadra.getTipoDaQuadra() + "\n" +
                "Valor do Minuto: " + this.quadra.getValorMinuto();
        
        String locacaoMsg = "Locação\n" +
                "Tempo em Minutos: " + this.tempoMinuto + "\n" +
                "Necessita Equipamento: " + this.necessitaEquipamento + "\n" +
                "Valor Calculado: " + this.calcularLocacao();
        
        JOptionPane.showMessageDialog(null, locatarioMsg + "\n\n" + quadraMsg + "\n\n" + locacaoMsg);
    }
    
   public void cadastrarLocacao() {
    // Cadastro da quadra
    Quadra quadra = new Quadra();
    quadra.cadastrarQuadra();
    this.setQuadra(quadra);

    // Cadastro do locatário
    Locatario locatario = new Locatario();
    locatario.cadastrarLocatario();
    this.setLocatario(locatario);

    // Cadastro do tempo em minutos
    boolean valido = false;
    int tempoMinutos = 0;
    while (!valido) {
        try {
            tempoMinutos = Integer.parseInt(JOptionPane.showInputDialog("Informe o tempo em minutos:"));
            if (tempoMinutos <= 0) {
                throw new IllegalArgumentException("O tempo deve ser maior que zero.");
            }
            valido = true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O tempo deve ser um número inteiro.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    this.setTempoMinuto(tempoMinutos);

    // Cadastro da necessidade de equipamento
    valido = false;
    char necessitaEquipamento = ' ';
    while (!valido) {
        String resposta = JOptionPane.showInputDialog("Necessita de equipamento? (S/N)");
        if (resposta != null && (resposta.toUpperCase().equals("S") || resposta.toUpperCase().equals("N"))) {
            necessitaEquipamento = resposta.toUpperCase().charAt(0);
            valido = true;
        } else {
            JOptionPane.showMessageDialog(null, "Resposta inválida. Informe S para Sim ou N para Não.");
        }
    }
    this.setNecessitaEquipamento(necessitaEquipamento);
}
//atualização
}