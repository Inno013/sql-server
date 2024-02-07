package uji.sistem.sqlserver.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uji.sistem.sqlserver.model.Mahasiswa;

import java.util.List;

@Repository
public class MahasiswaRepository {
    private final JdbcTemplate jdbcTemplate;


    public MahasiswaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Mahasiswa> getAllMahasiswa() {
        String sql = "SELECT * FROM tb_mahasiswa";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Mahasiswa.class));
    }

    public Mahasiswa getMahasiswaById(Long id) {
        String sql = "SELECT * FROM tb_mahasiswa WHERE id_mhs=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Mahasiswa.class), id);
    }

    public Mahasiswa saveMahasiswa(Mahasiswa mahasiswa) {
        String sql = "INSERT INTO tb_mahasiswa (nama, nim) VALUES (?, ?)";
        jdbcTemplate.update(sql, mahasiswa.getNama(), mahasiswa.getNim());
        return mahasiswa;
    }

    public void deleteMahasiswaById(Long id) {
        String sql = "DELETE FROM tb_mahasiswa WHERE id_mhs=?";
        jdbcTemplate.update(sql, id);
    }
}
