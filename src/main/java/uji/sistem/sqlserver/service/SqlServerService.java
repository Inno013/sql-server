package uji.sistem.sqlserver.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import uji.sistem.sqlserver.model.Mahasiswa;
import uji.sistem.sqlserver.repository.MahasiswaRepository;

import java.util.List;

@Service
public class SqlServerService {
    private final MahasiswaRepository mahasiswaRepository;

    public SqlServerService(MahasiswaRepository mahasiswaRepository) {
        this.mahasiswaRepository = mahasiswaRepository;
    }

    public List<Mahasiswa> getAllMahasiswa() {
        return mahasiswaRepository.getAllMahasiswa();
    }

    public Mahasiswa getMahasiswaById(Long id) {
        return mahasiswaRepository.getMahasiswaById(id);
    }

    public Mahasiswa saveMahasiswa(Mahasiswa mahasiswa) {
        return mahasiswaRepository.saveMahasiswa(mahasiswa);
    }

    public void deleteMahasiswaById(Long id) {
        mahasiswaRepository.deleteMahasiswaById(id);
    }
}
