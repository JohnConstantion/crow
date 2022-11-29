package org.john.crow.pojo.records;

public record User(String id, String nickname, String face, Integer sex) {

    public User{
        if (null == id){
            throw new IllegalStateException("user create error");
        }
    }
}
