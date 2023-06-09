package com.tsu.mslyp.sys.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
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
@TableName("tb_stu")
public class Stu implements Serializable {

    private static final long serialVersionUID = 1L;
    @ExcelIgnore
    @TableId(value = "stu_id", type = IdType.AUTO)
    private Integer stuId;
    @ExcelProperty("学号")
    private String stuNum;
    @ExcelProperty("姓名")
    private String stuName;
    @ExcelProperty("性别")
    private String stuGender;
    @ExcelProperty("手机号")
    private String stuPhone;
    @ExcelProperty("地址")
    private String stuAddress;
    @ExcelProperty("专业")
    private Integer stuMajor;
    @ExcelIgnore
    private String stuPic;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public Integer getStuMajor() {
        return stuMajor;
    }

    public void setStuMajor(Integer stuMajor) {
        this.stuMajor = stuMajor;
    }

    public String getStuPic() {
        return stuPic;
    }

    public void setStuPic(String stuPic) {
        this.stuPic = stuPic;
    }

    @Override
    public String toString() {
        return "Stu{" +
            "stuId = " + stuId +
            ", stuNum = " + stuNum +
            ", stuName = " + stuName +
            ", stuGender = " + stuGender +
            ", stuPhone = " + stuPhone +
            ", stuAddress = " + stuAddress +
            ", stuMajor = " + stuMajor +
            ", stuPic = " + stuPic +
        "}";
    }
}
