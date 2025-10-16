package estufaRestful;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Calculadores {
    
    // CÁLCULO DA MÉDIA
    public double valorMedia(List<Integer> temperaturas) {
        if (temperaturas == null || temperaturas.isEmpty()) {
            return 0;
        }
        
        int soma = 0;
        for (int temp : temperaturas) {
            soma += temp;
        }
        
        return (double) soma / temperaturas.size();
    }
    
    // IDENTIFICA VALOR MÍNIMO
    public int minima(List<Integer> temperaturas) {
        int minimaReg = temperaturas.get(0);
        for(int temp : temperaturas) {
            if (temp < minimaReg) {
                minimaReg = temp;
            }
        }
        return minimaReg;
    }
    
    // IDENTIFICA VALOR MÁXIMO
    public int maxima(List<Integer> temperaturas) {
        int maximaReg = temperaturas.get(0);
        for(int temp : temperaturas) {
            if (temp > maximaReg) {
                maximaReg = temp;
            }
        }
        return maximaReg;
    }
}
