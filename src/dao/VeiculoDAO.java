package dao;

import model.Conexao;
import model.Veiculo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
    public void inserirVeiculo(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (modelo, fabricante, tipo, ano_modelo, cor, numero_portas, placa, valor_diaria, disponivel) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getFabricante());
            stmt.setString(3, veiculo.getTipo());
            stmt.setString(4, veiculo.getAnoModelo());
            stmt.setString(5, veiculo.getCor());
            stmt.setString(6, veiculo.getNumeroPortas());
            stmt.setString(7, veiculo.getPlaca());
            stmt.setDouble(8, veiculo.getValorDiaria());
            stmt.setBoolean(9, veiculo.isDisponivel());

            stmt.executeUpdate();
            System.out.println("Veículo inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Veiculo> getVeiculos() {
        List<Veiculo> lista = new ArrayList<>();
        String sql = "SELECT * FROM veiculo";

        try (Connection conn = Conexao.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Veiculo v = new Veiculo();
                v.setId(rs.getInt("id"));
                v.setModelo(rs.getString("modelo"));
                v.setFabricante(rs.getString("fabricante"));
                v.setTipo(rs.getString("tipo"));
                v.setAnoModelo(rs.getString("ano_modelo"));
                v.setCor(rs.getString("cor"));
                v.setNumeroPortas(rs.getString("numero_portas"));
                v.setPlaca(rs.getString("placa"));
                v.setValorDiaria(rs.getDouble("valor_diaria"));
                v.setDisponivel(rs.getBoolean("disponivel"));
                lista.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public void atualizarVeiculo(Veiculo veiculo) {
        String sql = "UPDATE veiculo SET modelo=?, fabricante=?, tipo=?, ano_modelo=?, cor=?, numero_portas=?, placa=?, valor_diaria=?, disponivel=? WHERE id=?";

        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getFabricante());
            stmt.setString(3, veiculo.getTipo());
            stmt.setString(4, veiculo.getAnoModelo());
            stmt.setString(5, veiculo.getCor());
            stmt.setString(6, veiculo.getNumeroPortas());
            stmt.setString(7, veiculo.getPlaca());
            stmt.setDouble(8, veiculo.getValorDiaria());
            stmt.setBoolean(9, veiculo.isDisponivel());
            stmt.setInt(10, veiculo.getId());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Veículo atualizado com sucesso!");
            } else {
                System.out.println("Erro ao atualizar veículo.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar veículo: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Veiculo getVeiculoPorId(int id) {
        String sql = "SELECT * FROM veiculo WHERE id = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Veiculo v = new Veiculo();
                    v.setId(rs.getInt("id"));
                    v.setModelo(rs.getString("modelo"));
                    v.setFabricante(rs.getString("fabricante"));
                    v.setTipo(rs.getString("tipo"));
                    v.setAnoModelo(rs.getString("ano_modelo"));
                    v.setCor(rs.getString("cor"));
                    v.setNumeroPortas(rs.getString("numero_portas"));
                    v.setPlaca(rs.getString("placa"));
                    v.setValorDiaria(rs.getDouble("valor_diaria"));
                    v.setDisponivel(rs.getBoolean("disponivel"));
                    return v;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
