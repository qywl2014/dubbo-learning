package com.wulang;

import static org.junit.Assert.assertTrue;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.Test;
import org.springframework.objenesis.ObjenesisStd;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

//    @Test
//    public void t2(){
//        LinkedBuffer buffer=LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
//        WithList withList=getWithList();
//        Schema schema = RuntimeSchema.createFrom(withList.getClass());
//        byte[] byteArray=ProtobufIOUtil.toByteArray(withList, schema, buffer);
//
//        WithList message = new ObjenesisStd(true).newInstance(WithList.class);
//        ProtobufIOUtil.mergeFrom(byteArray, message, schema);
//        System.out.println(message);
//    }
    @Test
    public void t22(){
        LinkedBuffer buffer=LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        WithList withList=getWithList();
        Schema schema = RuntimeSchema.createFrom(withList.getClass());
        byte[] byteArray=ProtobufIOUtil.toByteArray(withList, schema, buffer);

//        WithList message = (WithList) new ObjenesisStd(true).newInstance(WithList.class);
        WithList message = new WithList();
        ProtobufIOUtil.mergeFrom(byteArray, message, schema);
        System.out.println(message);
    }

    public WithList getWithList(){
        WithList withList=new WithList();
        withList.setA(1);
        withList.setList(new ArrayList<Integer>());
        return withList;
    }
}
