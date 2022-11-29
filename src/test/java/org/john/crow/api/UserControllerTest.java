package org.john.crow.api;

import org.john.crow.mapper.UserJpaRepository;
import org.john.crow.pojo.bo.UserBo;
import org.john.crow.pojo.entity.Users;
import org.john.crow.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Test
    void createUser() {

        UserController userController = new UserController(new UserServiceImpl(new UserJpaRepository() {
            @Override
            public Optional<Users> findByUsername(String username) {
                return Optional.empty();
            }

            @Override
            public <S extends Users> S save(S entity) {
                return entity;
            }

            @Override
            public <S extends Users> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<Users> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<Users> findAll() {
                return null;
            }

            @Override
            public Iterable<Users> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Users entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Users> entities) {

            }

            @Override
            public void deleteAll() {

            }
        }));

        userController.createUser(new UserBo("test","123456","12345"));
    }
}