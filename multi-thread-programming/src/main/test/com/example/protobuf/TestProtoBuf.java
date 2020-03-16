package com.example.protobuf;

import com.example.tutorial.AddressBookProtos.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class TestProtoBuf {

    private final String filePath = "/Users/ask123/Desktop/protobuf.txt";

//    Creating an Instance of Protobuf Defined Messages
    @Test
    public void create() {

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

    // Serializing Protobuf
    @Test
    public void write() throws IOException {

        Person person = Person.newBuilder()
                .setId(169952)
                .setName("chaseshu")
                .setEmail("skjme2006@qq.com")
                .addPhones( Person.PhoneNumber.newBuilder()
                        .setNumber("555-4321")
                        .setType(Person.PhoneType.HOME))
                .build();

        AddressBook addressBook
                = AddressBook.newBuilder().addPeople(person).build();

        FileOutputStream fos = new FileOutputStream(filePath);
        addressBook.writeTo(fos);
    }

    // Deserializing Protobuf
    @Test
    public void read() throws IOException {

        AddressBook deserialized = AddressBook.newBuilder()
                .mergeFrom(new FileInputStream((filePath)))
                .build();

        Assert.assertEquals(deserialized.getPeople(0).getId(), 169952);
        Assert.assertEquals(deserialized.getPeople(0).getName(), "chaseshu");
    }
}
