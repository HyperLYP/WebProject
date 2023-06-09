package com.tsu.mslyp.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author monica
 * @since 2023-04-26
 */
@TableName("tb_major")
public class Major implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "major_id", type = IdType.AUTO)
    private Integer majorId;

    private String majorNum;

    private String majorName;

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getMajorNum() {
        return majorNum;
    }

    public void setMajorNum(String majorNum) {
        this.majorNum = majorNum;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public String toString() {
        return "Major{" +
            "majorId = " + majorId +
            ", majorNum = " + majorNum +
            ", majorName = " + majorName +
        "}";
    }
}
