package com.library_system.library.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.library_system.library.entity.ItemEmprestimo;
@Repository

public interface ItemEmprestimoRepository  extends JpaRepository <ItemEmprestimo, Long>{

}
