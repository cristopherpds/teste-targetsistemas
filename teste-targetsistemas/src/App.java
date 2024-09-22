import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class App {
    public static void main(String[] args) throws JSONException {
        int soma = new App().SomaIndice();
        System.out.println("Soma dos índices: " + soma);
        System.out.println("----------");

        // Questão 2
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número para verificar na sequência de Fibonacci: ");
        int num = scanner.nextInt();
        if (new App().isFibonacci(num)) {
            System.out.println(num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(num + " não pertence à sequência de Fibonacci.");
        }
        System.out.println("----------");

        // Questão 3
        new App().calcularFaturamentoDiario();
        System.out.println("----------");

        // Questão 4
        new App().calcularPercentualFaturamento();
        System.out.println("----------");

        // Questão 5
        scanner.nextLine(); // Consumir a nova linha
        System.out.print("Informe uma string para inverter: ");
        String input = scanner.nextLine();
        String invertida = new App().inverterString(input);
        System.out.println("String invertida: " + invertida);
        System.out.println("----------");

        scanner.close();
    }

    public int SomaIndice() {
        int indice = 13, soma = 0, k = 0;
        while (k < indice) {
            k = k + 1;
            soma = soma + k;
        }
        return soma;
    }

    // Questão 2
    public boolean isFibonacci(int num) {
        if (num == 0 || num == 1)
            return true;
        int a = 0, b = 1;
        while (b < num) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b == num;
    }

    // Questão 3
    public void calcularFaturamentoDiario() throws JSONException {
        String jsonData = "[{\"dia\":1,\"faturamento\":1000.0}," +
                "{\"dia\":2,\"faturamento\":2000.0}," +
                "{\"dia\":3,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":4,\"faturamento\":1500.0}," +
                "{\"dia\":5,\"faturamento\":3000.0}," +
                "{\"dia\":6,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":7,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":8,\"faturamento\":2500.0}," +
                "{\"dia\":9,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":10,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":11,\"faturamento\":4000.0}," +
                "{\"dia\":12,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":13,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":14,\"faturamento\":500.0}," +
                "{\"dia\":15,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":16,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":17,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":18,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":19,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":20,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":21,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":22,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":23,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":24,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":25,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":26,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":27,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":28,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":29,\"faturamento\":0.0}," + // Fim de semana
                "{\"dia\":30,\"faturamento\":0.0}]"; // Fim de semana

        JSONArray faturamentoMensal = new JSONArray(jsonData);
        double menor = Double.MAX_VALUE, maior = Double.MIN_VALUE, soma = 0;
        int count = 0, diasAcimaMedia = 0;

        for (int i = 0; i < faturamentoMensal.length(); i++) {
            JSONObject dia = faturamentoMensal.getJSONObject(i);
            double valor = dia.getDouble("faturamento");

            if (valor > 0) { // Ignorar dias sem faturamento
                if (valor < menor)
                    menor = valor;
                if (valor > maior)
                    maior = valor;
                soma += valor;
                count++;
            }
        }

        double media = soma / count;

        for (int i = 0; i < faturamentoMensal.length(); i++) {
            JSONObject dia = faturamentoMensal.getJSONObject(i);
            double valor = dia.getDouble("faturamento");

            if (valor > media)
                diasAcimaMedia++;
        }

        System.out.println("Menor faturamento: " + menor);
        System.out.println("Maior faturamento: " + maior);
        System.out.println("Dias acima da média: " + diasAcimaMedia);
    }

    // Questão 4
    public void calcularPercentualFaturamento() {
        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        double total = sp + rj + mg + es + outros;

        System.out.printf("Percentual de SP: %.2f%%\n", (sp / total) * 100);
        System.out.printf("Percentual de RJ: %.2f%%\n", (rj / total) * 100);
        System.out.printf("Percentual de MG: %.2f%%\n", (mg / total) * 100);
        System.out.printf("Percentual de ES: %.2f%%\n", (es / total) * 100);
        System.out.printf("Percentual de Outros: %.2f%%\n", (outros / total) * 100);
    }

    // Questão 5
    public String inverterString(String input) {
        String invertida = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            invertida += input.charAt(i);
        }
        return invertida;
    }
}