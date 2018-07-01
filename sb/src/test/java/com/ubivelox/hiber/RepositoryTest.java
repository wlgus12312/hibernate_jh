package com.ubivelox.hiber;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubivelox.hiber.model.exception.HiberException;
import com.ubivelox.hiber.model.repository.UserRepository;
import com.ubivelox.hiber.model.service.HiberService;
import com.ubivelox.hiber.model.vo.Member;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HiberService   hiberService;





    @Test
    public void test() throws HiberException
    {
        Member m = new Member(null, null, "그룹장", null);
        Example<Member> example = Example.of(m);
        this.userRepository.findAll(example);
        this.userRepository.findAllByOrderByJobAsc();
    }





    @Test
    public void selectTest() throws HiberException
    {

        Member m = new Member(2l, "김준기", "그룹장", "010-8895-9676");

        assertEquals(m, this.hiberService.findById(2l));

        List<Long> mnoList = new ArrayList<>();
        mnoList.add(1l);
        mnoList.add(2l);
        mnoList.add(3l);
        mnoList.add(4l);
        mnoList.add(5l);
        mnoList.add(6l);
        List<Member> externalList = new ArrayList<>();
        externalList.add(new Member(1l, "김장중", "본부장", "010-2522-5325"));
        externalList.add(new Member(2l, "김준기", "그룹장", "010-8895-9676"));
        externalList.add(new Member(3l, "임운혁", "팀장", "010-6352-3863"));
        externalList.add(new Member(4l, "송석일", "수석연구원", "010-8844-6476"));
        externalList.add(new Member(5l, "정성호", "책임연구원", "010-6358-8536"));
        externalList.add(new Member(6l, "제영호", "책임연구원", "010-2244-8103"));

        assertEquals(externalList, this.hiberService.memberFindAllById(mnoList));
    }





    @Test
    public void insertTest()
    {

        Member m = new Member(7l, "유영규", "선임연구원", "010-2391-3245");
        this.userRepository.save(m);

        List<Member> externalList = new ArrayList<>();

        externalList.add(new Member(8l, "이태규", "연구원", "010-9367-9720"));
        externalList.add(new Member(9l, "김동건", "연구원", "010-7118-7551"));
        externalList.add(new Member(10l, "김원태", "팀장", "010-6523-7580"));

        this.userRepository.saveAll(externalList);

    }





    @Test
    public void updateTest() throws HiberException
    {
        Member m = new Member(3l, "임운혁", "팀장", "010-6352-3863");
        m.setJob("연구원");
        this.userRepository.save(m);

        assertEquals(m, this.hiberService.findById(3l));

    }





    @Test
    public void deleteTest()
    {
        Member m = new Member(3l, "임운혁", "연구원", "010-6352-3863");
        this.userRepository.delete(m);

        assertEquals(9, this.userRepository.count());

    }

}
