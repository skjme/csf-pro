package cn.chaseshu.data.redis.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("people")
public class Person {

  @Id
  String id;
  String firstname;
  String lastname;
  Address address;
}