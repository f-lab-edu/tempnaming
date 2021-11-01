package study.sorting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.sorting.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
