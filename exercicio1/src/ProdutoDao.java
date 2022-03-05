import java.sql.*;

public class ProdutoDao {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/exercicio_1?useTimezone=true&serverTimezone=UTC", "root", "253614Ep@");
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.getConnection();

    public ProdutoDao() throws SQLException {
    }

        public void insere()throws SQLException{
            Statement stm = con.createStatement();
            stm.execute("DROP TABLE IF EXISTS PRODUTO");
            stm.execute("CREATE TABLE PRODUTO (id INT AUTO_INCREMENT, nome VARCHAR(50) NOT NULL, descricao VARCHAR(255), quantidade INT, preco FLOAT, PRIMARY KEY (id)) Engine = InnoDB;");
            stm.execute("INSERT INTO PRODUTO (NOME, DESCRICAO, QUANTIDADE, PRECO) VALUES ('Teclado', 'Teclado gamer', 6, 120.00)");
            stm.execute("INSERT INTO PRODUTO (nome, descricao, quantidade, preco) VALUES ('Monitor', 'Samsung', 5, 820.00)");
            stm.execute("INSERT INTO PRODUTO (nome, descricao, quantidade, preco) VALUES ('Fone', 'Sem fio', 8, 250.00)");
        listagem();
        }
        public void listagem()throws SQLException{
            PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO, QUANTIDADE, PRECO FROM PRODUTO");
            stm.execute();

            ResultSet rst = stm.getResultSet();
            while(rst.next()){
                Integer id = rst.getInt("ID");
                String nome = rst.getString("NOME");
                String desc = rst.getString("DESCRICAO");
                int quantidade = rst.getInt("Quantidade");
                double preco = rst.getDouble("Preco");

                System.out.println("**");
                System.out.println(" Id: " + id);
                System.out.println(" Nome: " + nome);
                System.out.println(" Descricao: " + desc);
                System.out.println(" Quantidade: " + quantidade);
                System.out.println(" Preco: " + preco);
                System.out.println("**\n");
            }

        }
        public void atualiza()throws SQLException{
            PreparedStatement stm = con.prepareStatement("UPDATE PRODUTO SET NOME = 'Ventilador', DESCRICAO = 'Portatil' WHERE ID = 1");
            stm.execute();
        listagem();
        }
        public void deleta()throws SQLException{
            PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE ID = 2");
            stm.execute();
        listagem();
        }
    }

