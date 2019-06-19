package com.ozayduman.testhink;

import com.ozayduman.testhink.todo.dto.Todo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.SerializationUtils;

public class TestSerializationUtils {

    @Test
    public void serializationAndDeserilizationObjectSame() {
        var todo = new Todo();
       // dummyObject.setName("Ozay");
        byte[] serializedObj = SerializationUtils.serialize(todo);
        Todo deserializedObj = (Todo) SerializationUtils.deserialize(serializedObj);
        Assert.assertEquals(todo.getClass(),deserializedObj.getClass());
    }
}
