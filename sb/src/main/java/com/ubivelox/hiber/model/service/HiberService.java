package com.ubivelox.hiber.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubivelox.hiber.model.exception.HiberException;
import com.ubivelox.hiber.model.repository.UserRepository;
import com.ubivelox.hiber.model.vo.Member;

@Service
public class HiberService
{
    @Autowired
    private UserRepository userRepository;





    public Long memberCount()
    {
        long result = this.userRepository.count();

        return result;
    }





    public List<Member> memberFindAllById(final List<Long> mnoList)
    {

        return (List<Member>) this.userRepository.findAllById(mnoList);
    }





    public Member findById(final long mno) throws HiberException
    {

        if ( this.userRepository.existsById(mno) )
        {
            Optional<Member> findMember = this.userRepository.findById(mno);

            Member m = findMember.get();

            return m;

        }
        else
        {
            throw new HiberException("GET MEMBER FAILED");
        }

    }





    public List<Member> findAll()
    {

        return (List<Member>) this.userRepository.findAll();

    }





    public Member insertMember(final Member m) throws HiberException
    {

        if ( !this.userRepository.existsById(m.getMno()) )
        {

            return this.userRepository.save(m);
        }
        else
        {
            throw new HiberException("SAME MEMBER INSERTED");

        }

    }





    public Member updateMember(final Member m) throws HiberException
    {

        if ( this.userRepository.existsById(m.getMno()) )
        {
            return this.userRepository.save(m);

        }
        else
        {
            throw new HiberException("UPDATE FAILED MEMBER");
        }
    }





    public void deleteMemberId(final Long mno) throws HiberException
    {
        if ( this.userRepository.existsById(mno) )
        {
            this.userRepository.deleteById(mno);
        }
        else
        {
            throw new HiberException("DELETE FAILED MEMBER");
        }

    }

    // public void deleteMember(final Member m) throws HiberException
    // {
    // if ( this.userRepository.(m.getMno()) )
    // {
    // this.userRepository.delete(m);
    // }
    // else
    // {
    // throw new HiberException("DELETE FAILED MEMBER");
    // }
    //
    // }

}
