package study.springstudy1.infrastructure;

import org.springframework.stereotype.Repository;
import study.springstudy1.domain.Member;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcMemberRepository implements MemberRepository{

//    private final DataSource dataSource;
//
//    public JdbcMemberRepository(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Override
    public Member save(Member member) {
//        String sql = "insert into member(name) values(?)";
//
//        Connection connection = dataSource.getConnection();
//
//        PreparedStatement pstmt = connection.prepareStatement(sql);
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public void clearStore() {

    }
}
