package co.simplon.exercise.core.repository;

import co.simplon.exercise.core.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.annotation.Resource;

@Resource
public interface MailRepository extends JpaRepository<Mail, Integer> {

    @Query("select m from Mail m where m.id=?1")
    public  Mail findMailById(Integer id);
}
