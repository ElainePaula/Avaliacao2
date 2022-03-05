import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        ProdutoDao produtoDao = new ProdutoDao();
        Scanner scanner = new Scanner(System.in);

        int menu = 0;
        while (menu != 4 ){
            System.out.println("1 Insere o produto");
            System.out.println("2 atualiza produto");
            System.out.println("3 Excluir produto");
            System.out.println("4 Sair");
            menu = scanner.nextInt();

            switch (menu){
                case 1:
                    produtoDao.insere();
                    break;
                case 2:
                    produtoDao.atualiza();
                    break;
                case 3:
                    produtoDao.deleta();
                    break;
                case 4:
                    System.out.println("Sair");
                      break;
                default:
                    System.out.println("Numero incorreto!");
                    break;
            }
        }
    }
}
