package com.yitiankeji.dao;

import com.yitiankeji.entity.Log;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDao extends MongoRepository<Log, ObjectId> {
}
