package com.ubivelox.hiber;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubivelox.hiber.model.exception.HiberException;
import com.ubivelox.hiber.model.repository.DepartmentRepository;
import com.ubivelox.hiber.model.repository.JobRepository;
import com.ubivelox.hiber.model.repository.MemberRepository;
import com.ubivelox.hiber.model.repository.UserRepository;
import com.ubivelox.hiber.model.service.HiberService;
import com.ubivelox.hiber.model.vo.Department;
import com.ubivelox.hiber.model.vo.Job;
import com.ubivelox.hiber.model.vo.Member;

@RunWith(SpringRunner.class)
@SpringBootTest
// @Transactional
// @Rollback(true)
public class RepositoryTest
{
    @Autowired
    private UserRepository       userRepository;
    @Autowired
    private HiberService         hiberService;
    @Autowired
    private MemberRepository     memberRepository;
    @Autowired
    private JobRepository        JobRepository;
    @Autowired
    private DepartmentRepository DepartmentRepository;

    static Logger                LOGGER = LoggerFactory.getLogger(RepositoryTest.class);





    @Test
    public void deleteTest() throws HiberException
    {
        this.memberRepository.deleteById(10l);

        int deleteResult = (int) this.memberRepository.count();

        LOGGER.info("deleteResult : [{}]", deleteResult);
    }





    @Test
    public void updateTest() throws HiberException
    {
        Optional<Job> job = this.JobRepository.findById(2);
        Job mjob = job.get();
        Optional<Department> dept = this.DepartmentRepository.findById(3);
        Department mdept = dept.get();

        Member m = new Member(10l, "김지현", mjob, "010-1111-2222", mdept);

    }





    @Test
    public void insertTest() throws HiberException
    {

        int beforeCount = (int) this.memberRepository.count();

        LOGGER.info("beforeCount : [{}]", beforeCount);

        // 오라클에서 처리 하는 부분
        // FK의 값에 대해서는
        Optional<Job> job = this.JobRepository.findById(1);
        Job mjob = job.get();
        Optional<Department> dept = this.DepartmentRepository.findById(1);
        Department mdept = dept.get();

        Member m = new Member(10l, "김지현", mjob, "010-1111-2222", mdept);

        this.memberRepository.save(m);

        int afterCount = (int) this.memberRepository.count();

        LOGGER.info("afterCount : [{}]", afterCount);

        Optional<Member> insertm = this.memberRepository.findById(10l);

        Member insertMember = insertm.get();

        LOGGER.info("insertMember : [{}]", insertMember);

    }





    @Test
    public void selectTest() throws HiberException
    {
        Member selectOneMember = this.hiberService.findById(1l);
        LOGGER.info("selectOneMember : [{}]", selectOneMember);

        List<Member> selectAllList = this.hiberService.findAll();
        LOGGER.info("selectAllList : [{}]", selectAllList);

    }





    @Test
    public void insertDataTest() throws HiberException
    {
        List<Job> jobList = new ArrayList<>();

        jobList.add(new Job(1, "본부장"));
        jobList.add(new Job(2, "그룹장"));
        jobList.add(new Job(3, "팀장"));
        jobList.add(new Job(4, "수석연구원"));
        jobList.add(new Job(5, "책임연구원"));
        jobList.add(new Job(6, "선임연구원"));
        jobList.add(new Job(7, "주임연구원"));
        jobList.add(new Job(8, "연구원"));

        this.JobRepository.saveAll(jobList);

        List<Department> deptList = new ArrayList<>();

        deptList.add(new Department(1, "디지털개발부", "1그룹", "1팀"));
        deptList.add(new Department(2, "디지털개발부", "1그룹", "2팀"));
        deptList.add(new Department(3, "디지털개발부", "2그룹", "1팀"));
        deptList.add(new Department(4, "디지털개발부", "2그룹", "2팀"));
        deptList.add(new Department(5, "디지털개발부", "3그룹", "1팀"));
        deptList.add(new Department(6, "디지털개발부", "3그룹", "2팀"));
        deptList.add(new Department(7, "디지털개발부", "3그룹", "3팀"));

        this.DepartmentRepository.saveAll(deptList);

    }





    @Test
    public void test()
    {

        // List<Job> jobList = new ArrayList<>();
        // Job job1 = new Job(1, "본부장");
        // Job job2 = new Job(2, "그룹장");
        // Job job3 = new Job(3, "수석연구원");
        // Job job4 = new Job(4, "책임연구원");
        // Job job5 = new Job(5, "선임연구원");
        // Job job6 = new Job(6, "주임연구원");
        // Job job7 = new Job(7, "연구원");
        // jobList.add(job1);
        // jobList.add(job2);
        // jobList.add(job3);
        // jobList.add(job4);
        // jobList.add(job5);
        // jobList.add(job6);
        // jobList.add(job7);
        // this.userRepository.saveAll(jobList);

    }

    // @Test
    // public void test() throws HiberException
    // {
    // Member m = new Member(null, null, "그룹장", null);
    // Example<Member> example = Example.of(m);
    // this.userRepository.findAll(example);
    // this.userRepository.findAllByOrderByJobAsc();
    // List<Member> list = this.userRepository.findOneByName("김준기");
    // List<Member> list2 = this.userRepository.findOneByJobAndName("그룹장", "김준기");
    //
    //
    // }
    //
    //
    //
    //
    //
    // @Test
    // public void selectTest() throws HiberException
    // {
    //
    // Member m = new Member(2l, "김준기", "그룹장", "010-8895-9676");
    //
    // assertEquals(m, this.hiberService.findById(2l));
    //
    // List<Long> mnoList = new ArrayList<>();
    // mnoList.add(1l);
    // mnoList.add(2l);
    // mnoList.add(3l);
    // mnoList.add(4l);
    // mnoList.add(5l);
    // mnoList.add(6l);
    // List<Member> externalList = new ArrayList<>();
    // externalList.add(new Member(1l, "김장중", "본부장", "010-2522-5325"));
    // externalList.add(new Member(2l, "김준기", "그룹장", "010-8895-9676"));
    // externalList.add(new Member(3l, "임운혁", "팀장", "010-6352-3863"));
    // externalList.add(new Member(4l, "송석일", "수석연구원", "010-8844-6476"));
    // externalList.add(new Member(5l, "정성호", "책임연구원", "010-6358-8536"));
    // externalList.add(new Member(6l, "제영호", "책임연구원", "010-2244-8103"));
    //
    // assertEquals(externalList, this.hiberService.memberFindAllById(mnoList));
    // }
    //
    //
    //
    //
    //
    // @Test
    // public void insertTest()
    // {
    //
    // Member m = new Member(7l, "유영규", "선임연구원", "010-2391-3245");
    // this.userRepository.save(m);
    //
    // List<Member> externalList = new ArrayList<>();
    //
    // externalList.add(new Member(8l, "이태규", "연구원", "010-9367-9720"));
    // externalList.add(new Member(9l, "김동건", "연구원", "010-7118-7551"));
    // externalList.add(new Member(10l, "김원태", "팀장", "010-6523-7580"));
    //
    // this.userRepository.saveAll(externalList);
    //
    // }
    //
    //
    //
    //
    //
    // @Test
    // public void updateTest() throws HiberException
    // {
    // Member m = new Member(3l, "임운혁", "팀장", "010-6352-3863");
    // m.setJob("연구원");
    // this.userRepository.save(m);
    //
    // assertEquals(m, this.hiberService.findById(3l));
    //
    // }
    //
    //
    //
    //
    //
    // @Test
    // public void deleteTest()
    // {
    // Member m = new Member(3l, "임운혁", "연구원", "010-6352-3863");
    // this.userRepository.delete(m);
    //
    // assertEquals(9, this.userRepository.count());
    //
    // }

}
