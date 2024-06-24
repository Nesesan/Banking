package com.nesesan.banking.services;

import java.util.List;

public interface AbstractService <T> {

     int save(T dto);

     List<T> findAll();

     T findById(int id);

      void delete(int id);
}
