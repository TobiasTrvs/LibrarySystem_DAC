package com.library_system.library.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface ItemEmprestimo  extends JpaRepository <ItemEmprestimo, Long>{
    
}
