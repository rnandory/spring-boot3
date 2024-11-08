package kr.co.rland.rland_boot3_api.repository;

import kr.co.rland.rland_boot3_api.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);
}
