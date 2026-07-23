package br.com.cauesobral.screenmatch.desafios;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DesafiosAula1 {
    public static void main(String[] args) {
        //Ex 1 - pegar só os valores numéricos de uma string
        List<String> input = Arrays.asList("10", "abc", "20", "30x");
        input.stream()
                .map(str -> { try {
                    return Optional.of(Integer.parseInt(str));
                } catch (NumberFormatException e) {
                    return Optional.<Integer>empty();
                } })
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        //Aqui eu copiei e colei as entradas mesmo senão demoraria muito pra fazer na mão todas elas

        //Ex 2 - Recebe inteiro em Optional e retorna o quadrado, se não retorna Optional.empty
        System.out.println(processaNumero(Optional.of(5))); // Saída: Optional[25]
        System.out.println(processaNumero(Optional.of(-3))); // Saída: Optional.empty
        System.out.println(processaNumero(Optional.empty())); // Saída: Optional.empty

        //Ex 3 - Recebe String, retorna ultimo nome tirando os espaços
        System.out.println(obterPrimeiroEUltimoNome("  João Carlos Silva   ")); // Saída: "João Silva"
        System.out.println(obterPrimeiroEUltimoNome("Maria   ")); // Saída: "Maria"

        //Ex 4 - verificar se é palindro
        System.out.println(ehPalindromo("socorram me subi no onibus em marrocos")); // Saída: true
        System.out.println(ehPalindromo("Java")); // Saída: false

        //Ex 5 - recebe uma lista de emails e retorna a lista em minúscula
        List<String> emails = Arrays.asList("TESTE@EXEMPLO.COM", "exemplo@Java.com ", "Usuario@teste.Com");
        System.out.println(converterEmails(emails));

        //Ex 6 - Criar metodo que retorna numero de dias do mes
        System.out.println(Mes.FEVEREIRO.getNumeroDeDias()); // 28
        System.out.println(Mes.JULHO.getNumeroDeDias()); // 31

        //Ex 7 - Criar metodo para converter valores de real, dolar e euro
        System.out.println(Moeda.DOLAR.converterPara(100)); // 19.60 (aproximado)
        System.out.println(Moeda.EURO.converterPara(100)); // 18.18 (aproximado)

        //Ex 8 - Criar metodo que recebe codigo e retorna o tipo de erro que ta no enum
        System.out.println(CodigoErro.NOT_FOUND.getCodigo()); // 404
        System.out.println(CodigoErro.BAD_REQUEST.getDescricao()); // Requisição inválida

    }
    //Metodo do ex 2
    public static Optional<Integer> processaNumero(Optional<Integer> numero) {
        return numero
                .filter(n -> n > 0)
                .map(n -> n * n);
    }
    //Metodo do ex 3
    public static String obterPrimeiroEUltimoNome(String nomeCompleto) {
        String[] nomes = nomeCompleto
                .trim()
                .split("\\s+");
        if (nomes.length == 1) {
            return nomes[0];
        }
        return nomes[0] + " " + nomes[nomes.length - 1];
    }
    //Metodo do ex 4
    public static boolean ehPalindromo(String palavra) {
        String s = palavra
                .replace(" ", "")
                .toLowerCase();
        return new StringBuilder(s)
                .reverse()
                .toString()
                .equalsIgnoreCase(s);
    }
    //Metodo do ex 5
    public static List<String> converterEmails(List<String> emails) {
        return emails.stream()
                .map(email -> email
                        .trim()
                        .toLowerCase())
                .toList();
    }


}
