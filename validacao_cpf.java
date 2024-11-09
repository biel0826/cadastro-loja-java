public class ValidadorCPF {

    public static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int soma = 0;
            int peso = 10;

            for (int i = 0; i < 9; i++) {
                int num = Character.getNumericValue(cpf.charAt(i));
                soma += num * peso;
                peso--;
            }
            int primeiroDigito = 11 - (soma % 11);
            if (primeiroDigito >= 10) primeiroDigito = 0;

            soma = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                int num = Character.getNumericValue(cpf.charAt(i));
                soma += num * peso;
                peso--;
            }
            int segundoDigito = 11 - (soma % 11);
            if (segundoDigito >= 10) segundoDigito = 0;

            return (primeiroDigito == Character.getNumericValue(cpf.charAt(9)) &&
                    segundoDigito == Character.getNumericValue(cpf.charAt(10)));

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String cpf = "123.456.789-09"; 
        if (validarCPF(cpf)) {
            System.out.println("CPF válido!");
        } else {
            System.out.println("CPF inválido!");
        }
    }
}
