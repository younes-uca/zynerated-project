package ma.zs.zyn.unit.dao.facade.core.collaborator;

import ma.zs.zyn.bean.core.collaborator.Member;
import ma.zs.zyn.dao.facade.core.collaborator.MemberDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class MemberDaoTest {

@Autowired
    private MemberDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        Member entity = new Member();
        entity.setId(id);
        underTest.save(entity);
        Member loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Member entity = new Member();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Member loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Member> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Member> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Member given = constructSample(1);
        Member saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Member constructSample(int i) {
		Member given = new Member();
        given.setDescription("description-"+i);
        given.setCollaborator(new Collaborator(1L));
        given.setCredentialsNonExpired(false);
        given.setEnabled(false);
        given.setAccountNonExpired(false);
        given.setAccountNonLocked(false);
        given.setPasswordChanged(false);
        given.setUsername("username-"+i);
        given.setPassword("password-"+i);
        return given;
    }

}
