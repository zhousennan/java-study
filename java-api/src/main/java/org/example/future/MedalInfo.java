package org.example.future;

/**
 * @Author: zsn
 * @Date: 2024/5/14 14:45
 * @Description: description of this class
 * @Version: 1.0
 */
public class MedalInfo {

    private  Integer medalId;

    private Integer userId;

    private String description;

    public MedalInfo(Integer medalId, Integer userId, String description) {
        this.medalId = medalId;
        this.userId = userId;
        this.description = description;
    }

    @Override
    public String toString() {
        return "MedalInfo{" +
                "medalId=" + medalId +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getMedalId() {
        return medalId;
    }

    public void setMedalId(Integer medalId) {
        this.medalId = medalId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
