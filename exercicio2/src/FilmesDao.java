import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.Scanner;

public class FilmesDao {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/exercicio_2?useTimezone=true&serverTimezone=UTC", "root", "253614Ep@");
    ConnectionFactory factory = new ConnectionFactory();
    Connection con = factory.getConnection();

    public void filmesDao() throws SQLException {
    }

    public FilmesDao() throws SQLException {
    }

    public void insere()throws SQLException{
        Statement stm = con.createStatement();
        stm.execute("DROP TABLE IF EXISTS FILME");
        stm.execute("CREATE TABLE FILME (id INT AUTO_INCREMENT, nome VARCHAR(50) NOT NULL, descricao VARCHAR(255), ANO YEAR, PRIMARY KEY (id)) Engine = InnoDB;");
        stm.execute("INSERT INTO FILME (NOME, DESCRICAO, ANO) VALUES ('Crush a Altura', 'Comedia', '2022')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('O Misterio do Farol', 'Drama', '2018')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('O Violino do meu Pai', 'Drama', '2022')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('Time de Coracao', 'Historia real', '2022')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('Mae e Androides', 'Ficcao Cientifica', '2021')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('Nao olhe para cima', 'Comedia com ficcao cientifica', '2021')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('A filha perdida', 'historia real', '2021')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('O paramo', 'Terror', '2022')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('Velozes e Furiosos', 'aventura', '2019')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('Imperdoavel', 'Drama', '2021')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('Lulli', 'Comedia', '2021')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('Juntos para sempre', 'Comedia', '2019')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('Yara', 'Historia real', '2021')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('The trip', 'Drama', '2021')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('Alerta Vermelho', 'Aventura', '2021')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('Prisioneiros', 'Historia real', '2021')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('Ataques dos caes', 'Drama', '2021')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('Refen do jogo', 'Guerra', '2018')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('A batalha esquecida', 'Guerra', '2021')");
        stm.execute("INSERT INTO FILME (nome, descricao, ANO) VALUES ('Exercito de ladroes', 'Drama', '2021')");
    }
    public void listagem()throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a pagina desejada");
        int pagina = sc.nextInt();
        double quantidadePagina = Math.round(20/pagina);
        System.out.println("Pagina acessada é: " + quantidadePagina + "/" + pagina);
        System.out.println("Digite quantidade de filme que deseja assitir");
        int limit = sc.nextInt();
        PreparedStatement stm = con.prepareStatement("SELECT * FROM FILME LIMIT ?");
        stm.setInt(1,limit);
        stm.execute();

        ResultSet rst = stm.getResultSet();
        while (rst.next()) {
            int id = rst.getInt("ID");
            String nome = rst.getString("NOME");
            String desc = rst.getString("DESCRICAO");
            Year ano = Year.of(rst.getInt("ANO"));


            System.out.println("**");
            System.out.println(" Id: " + id);
            System.out.println(" Nome: " + nome);
            System.out.println(" Descricao: " + desc);
            System.out.println(" Ano: " + ano);
            System.out.println("**\n");
        }

    }

    }