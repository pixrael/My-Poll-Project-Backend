package com.famicom.mypollproject.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Integer> {}
