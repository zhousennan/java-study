package com.zsn.disruptorlog.bean;

/**
 * @Author : zhou sen nan
 * @Date : 2021/11/22  14:41
 */
public class ConductAudits {
    int Id;
    int PersonId;
    String name;

    public ConductAudits(int id, int personId, String name) {
        Id = id;
        PersonId = personId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    @Override
    public String toString() {
        return "ConductAudits{" +
                "Id=" + Id +
                ", PersonId=" + PersonId +
                ", name='" + name + '\'' +
                '}';
    }
}
