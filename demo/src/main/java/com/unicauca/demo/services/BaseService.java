package com.unicauca.demo.services;

import java.util.List;

public interface BaseService<T>{
    List<T> findAll() throws Exception;
    T findById(Long pId) throws  Exception;
    T Save(T pEntity) throws Exception;
    T update (Long pId, T pEntity) throws Exception;
    public boolean delete(Long id) throws Exception;
}
