package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class UsuarioDAO {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/pi_locadoraveiculos?useSSL=false&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "sql01032004!";
        return java.sql.DriverManager.getConnection(url, user, password);
    }

    public Usuario buscarPorLogin(String login) {
        String sql = "SELECT id, login, senha, tipo FROM usuario WHERE login = ?";
        Usuario usuario = null;

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getString("tipo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
