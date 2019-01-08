package ac.cn.saya.entity;/**
 * Created by Administrator on 2018/9/30 0030.
 */

import java.io.Serializable;

/**
 * @Title: UserEntity
 * @ProjectName spring-boot-dubbo-pro
 * @Description: TODO
 * @Author Administrator
 * @Date: 2018/9/30 0030 12:40
 * @Description:
 */

public class UserEntity  implements Serializable {

    private static final long serialVersionUID = 5156612384141543430L;

    private String user;//用户名
    private String password;//密码
    private String sex;//性别
    private String qq;//qq
    private String email;//邮箱
    private String phone;//电话
    private String birthday;//生日
    private String hometown;//故乡
    private String autograph;//个性签名

    public UserEntity() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

}
