package eni.tp.app.eni_app.repository;

import eni.tp.app.eni_app.bo.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}