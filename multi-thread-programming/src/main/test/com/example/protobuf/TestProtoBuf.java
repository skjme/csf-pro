package com.example.protobuf;

import com.example.tutorial.AddressBookProtos.*;
import org.junit.Assert;
import org.junit.Test;

public class TestProtoBuf {

    @Test
    public void test() {

        Person chaseshu = Person.newBuilder()
                .setId(169952)
                .setName("chaseshu")
                .setEmail("skjme2006@qq.com")
                .addPhones( Person.PhoneNumber.newBuilder()
                        .setNumber("555-4321")
                        .setType(Person.PhoneType.HOME))
                .build();

        Assert.assertEquals(chaseshu.getId(), 169952);
        Assert.assertEquals(chaseshu.getName(), "chaseshu");

    }
}
