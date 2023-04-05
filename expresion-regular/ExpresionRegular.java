import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.regex.Matcher;

public class ExpresionRegular {

    private String[][] cuantificadores = {{"?", "*", "+", "{n}", "{n,}", "{n,m}"},
                                         {"1 vez o 0", "0 o mas", "1 o mas", "exactamente n veces", "al menos n veces", "desde n veces hasta m"}};
    public static void main(String[] args) {

        ExpresionRegular expresionRegular = new ExpresionRegular();

        Scanner scanner = new Scanner(System.in);
        String frase;
        String expRegular;

        while (true) {
            System.out.print("Ingrese la expresion regular: ");
            expRegular = scanner.next();
            Pattern patron = Pattern.compile(expRegular);
            if (expRegular.equals("exit"))
                break;

            if(expRegular.equals("help"))
                expresionRegular.getCuantificadores(expresionRegular.getCuantificadores());

            while (true) {
                System.out.print("Ingrese la frase a ser analizar: ");
                frase = scanner.next();
                Matcher match = patron.matcher(frase);
                boolean coincidencia = match.find();

                System.out.println(coincidencia + "\n");
                if (frase.equals("exit"))
                    break;
            }

        }
        scanner.close();
    }



    public void getCuantificadores(String[][] matriz){
        System.out.println("Cuantiicadores:\n");
        for(int i=0; i<6; i++){
            for(int j=0; j<=1  ;j++){
                System.out.print(matriz[j][i]);
                if(j == 0)
                System.out.print(" --> ");
            }
            System.out.println("");
        }
    }

    public String[][] getCuantificadores() {
        return cuantificadores;
    }
}