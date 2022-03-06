import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        FilmesDao filmesDao = new FilmesDao();
        try (Scanner scanner = new Scanner(System.in)) {

            int menufilme = 0;
            while (menufilme != 4) {
                System.out.println("****** Menu ********");
                System.out.println("1 Inserir filmes");
                System.out.println("2 Inserir quantidade de filmes que deseja");
                System.out.println("3 Sair");
                menufilme = scanner.nextInt();

                switch (menufilme) {

                    case 1:
                        filmesDao.insere();
                        System.out.println("Inserido com Sucesso");
                        break;

                    case 2:
                        filmesDao.listagem();
                        break;

                    case 3:
                        System.out.println("\nSair");
                        break;

                    default:
                        System.out.println("Opção Invalida");
                        break;

                }


            }
        }
    }
}




