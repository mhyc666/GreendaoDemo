package com.my.greendaotest;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class UserBean {
    public static final int TYPE_LOVE = 0x02;
    @Id
    private Long id;  //自增长的Id一定是Long类型的
    private String name;
    private String text;
    private int type;
    @Generated(hash = 228029195)
    public UserBean(Long id, String name, String text, int type) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.type = type;
    }
    @Generated(hash = 1203313951)
    public UserBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }
}