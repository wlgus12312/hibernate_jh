package com.ubivelox.hiber.model.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;

import com.ubivelox.hiber.model.vo.Member;

public interface UserRepository extends CrudRepository<Member, Long>
{
    <S extends Member> List<S> findAll(Example<S> example);





    @Override
    <S extends Member> Iterable<S> saveAll(final Iterable<S> entities);





    <S extends Member> List<S> findAllByOrderByJobAsc();

}
