
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args){
        String [] candidatosList = {"Ana", "Bruno", "Carlos", "Daniela", "Eduardo"};
        for (String candidato : candidatosList) {
            entrandoEmContato(candidato);
        }
    }
    
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }
        } while (continuarTentando && tentativasRealizadas <  3);
        if(atendeu)
        System.out.println("Conseguimos contato com  " + candidato + " na " + tentativasRealizadas + " realizadas");
        else 
        System.out.println("Não Conseguimos com " + candidato + ", Numero maximo tentativas " + tentativasRealizadas + " realizada");
        
        
    }
    
    static void imprimirSelecionados(){
        String [] candidatosList = {"Ana", "Bruno", "Carlos", "Daniela", "Eduardo"};
        for (String nome : candidatosList) {
            System.out.println(" O candidato selecionado foi " + nome);
        }
    }
    
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    
    
    static void selecaoCandidatos(){
        String [] candidatosList = {"Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda", "Gustavo", "Helena", "Igor", "Juliana",};
        
        int candidatosSelecionados = 0;
        int candidatosAtual= 0;
        double salarioBase = 2000.0;
        
        while (candidatosSelecionados < 5 && candidatosAtual < candidatosList.length){
            String candidato = candidatosList[candidatosAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato +  " Solicitou este valor de salário " + salarioPretendido);
            
            if( salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato +  " Foi Selecionado para a vaga ");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }
    
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }
    
    static void analisarCandidato(double salarioPretendido){
        double valorBase = 2000.0;
        if(valorBase > salarioPretendido){
            System.out.println(" ** Ligar Para Candidato ** ");
        } else if( valorBase == salarioPretendido){
            System.out.println("Ligar para candidato com contra Proposta");
        } else{
            System.out.println("Candidato desqualificado");
        }
    }
}