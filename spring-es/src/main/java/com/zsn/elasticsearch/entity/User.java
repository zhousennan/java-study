package com.zsn.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Author: zsn
 * @Date: 2024/5/23 15:28
 * @Description: description of this class
 * @Version: 1.0
 */

@Data
@Document(indexName = "user-demo")
public class User {
    @Id
    private String id;
    private String username;
    private String address;
    private Integer age;
    private String gender;
}