import javax.swing.JOptionPane;

public class Quadra {
    private String nome;
    private String tipoDaQuadra;
    private double valorMinuto;
    
    // construtor
    public Quadra() {
    }
    
    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoDaQuadra() {
        return tipoDaQuadra;
    }

    public void setTipoDaQuadra(String tipoDaQuadra) {
        this.tipoDaQuadra = tipoDaQuadra;
    }

    public double getValorMinuto() {
        return valorMinuto;
    }

    public void setValorMinuto(double valorMinuto) {
        this.valorMinuto = valorMinuto;
    }
    
    // métodos
    public void cadastrarQuadra() {
        this.setNome(JOptionPane.showInputDialog("Informe o nome da quadra:"));
        this.setTipoDaQuadra(JOptionPane.showInputDialog("Informe o tipo da quadra:"));
        
        double valor = 0.0;
        while (valor <= 0) {
            try {
                String strValor = JOptionPane.showInputDialog("Informe o valor por minuto da quadra:");
                valor = Double.parseDouble(strValor);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido! Tente novamente.");
            }
            //atualização
        }
        this.setValorMinuto(valor);
    }

}
