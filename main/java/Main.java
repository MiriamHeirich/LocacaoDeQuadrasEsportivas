public class Main {

    public static void main(String[] args) {
        // Criando locatário
        Locatario locatario = new Locatario();
        locatario.cadastrarLocatario();
        
        // Criando quadra
        Quadra quadra = new Quadra();
        quadra.cadastrarQuadra();
        
        // Criando locação
        Locacao locacao = new Locacao(locatario, quadra, 90, 'S');
        
        // Mostrando resumo da locação
        locacao.mostrarResumoLocacao();
    }
    //atualização

}
    

