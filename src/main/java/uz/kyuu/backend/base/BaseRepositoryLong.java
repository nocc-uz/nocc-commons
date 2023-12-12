package uz.kyuu.backend.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepositoryLong<R extends BaseEntity> extends JpaRepository<R, Long> {
}
