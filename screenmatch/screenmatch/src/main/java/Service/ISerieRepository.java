package Service;

import Model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ISerieRepository extends JpaRepository<Serie,Long> {
}
