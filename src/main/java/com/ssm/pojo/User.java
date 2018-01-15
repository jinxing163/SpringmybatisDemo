package com.ssm.pojo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class User implements Serializable{
    private Integer id;

    private String username;//用户名

    private String realName;//真实姓名

    private String nickName;//昵称

    private String password;//密码

    private String eMail;//邮箱

    private Short eMailAuthorityType;

    private String phoneNumber;//手机号

    private String headPicUrl;//头像

    private String idCardsNumber;//身份证

    private String msn;

    private String qq;

    private Integer locationId;

    private Integer hometownId;

    private String companyName;//公司名称

    private String birthday;//生日

    private String sex;//性别 (1、男  0、女)

    private Short subscribe;

    private Short eMailValidator;

    private Short phoneNumberAuthorityType;

    private Short companyNameAuthority;

    private String isDeleted;

    private Date createTime;

    private Date updateTime;

    private Short optCounter;

    private String randomNum;

    private String introduction;

    private String openId;

    private String source;

    private String approvalResultStatus;

    private String approvalQueryStatus;

    private Date approvalResultTime;

    private String knowledgebackground;

    private String bindType;

    private String isauth;

    private Date lastLoginTime;

    private Integer loginCount;

    private String ip;

    private String isLock;

    private Date unlockedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    public Short geteMailAuthorityType() {
        return eMailAuthorityType;
    }

    public void seteMailAuthorityType(Short eMailAuthorityType) {
        this.eMailAuthorityType = eMailAuthorityType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl == null ? null : headPicUrl.trim();
    }

    public String getIdCardsNumber() {
        return idCardsNumber;
    }

    public void setIdCardsNumber(String idCardsNumber) {
        this.idCardsNumber = idCardsNumber == null ? null : idCardsNumber.trim();
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn == null ? null : msn.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getHometownId() {
        return hometownId;
    }

    public void setHometownId(Integer hometownId) {
        this.hometownId = hometownId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Short getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Short subscribe) {
        this.subscribe = subscribe;
    }

    public Short geteMailValidator() {
        return eMailValidator;
    }

    public void seteMailValidator(Short eMailValidator) {
        this.eMailValidator = eMailValidator;
    }

    public Short getPhoneNumberAuthorityType() {
        return phoneNumberAuthorityType;
    }

    public void setPhoneNumberAuthorityType(Short phoneNumberAuthorityType) {
        this.phoneNumberAuthorityType = phoneNumberAuthorityType;
    }

    public Short getCompanyNameAuthority() {
        return companyNameAuthority;
    }

    public void setCompanyNameAuthority(Short companyNameAuthority) {
        this.companyNameAuthority = companyNameAuthority;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getOptCounter() {
        return optCounter;
    }

    public void setOptCounter(Short optCounter) {
        this.optCounter = optCounter;
    }

    public String getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(String randomNum) {
        this.randomNum = randomNum == null ? null : randomNum.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getApprovalResultStatus() {
        return approvalResultStatus;
    }

    public void setApprovalResultStatus(String approvalResultStatus) {
        this.approvalResultStatus = approvalResultStatus == null ? null : approvalResultStatus.trim();
    }

    public String getApprovalQueryStatus() {
        return approvalQueryStatus;
    }

    public void setApprovalQueryStatus(String approvalQueryStatus) {
        this.approvalQueryStatus = approvalQueryStatus == null ? null : approvalQueryStatus.trim();
    }

    public Date getApprovalResultTime() {
        return approvalResultTime;
    }

    public void setApprovalResultTime(Date approvalResultTime) {
        this.approvalResultTime = approvalResultTime;
    }

    public String getKnowledgebackground() {
        return knowledgebackground;
    }

    public void setKnowledgebackground(String knowledgebackground) {
        this.knowledgebackground = knowledgebackground == null ? null : knowledgebackground.trim();
    }

    public String getBindType() {
        return bindType;
    }

    public void setBindType(String bindType) {
        this.bindType = bindType == null ? null : bindType.trim();
    }

    public String getIsauth() {
        return isauth;
    }

    public void setIsauth(String isauth) {
        this.isauth = isauth == null ? null : isauth.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getIsLock() {
        return isLock;
    }

    public void setIsLock(String isLock) {
        this.isLock = isLock == null ? null : isLock.trim();
    }

    public Date getUnlockedTime() {
        return unlockedTime;
    }

    public void setUnlockedTime(Date unlockedTime) {
        this.unlockedTime = unlockedTime;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", realName=" + realName + ", nickName=" + nickName
				+ ", password=" + password + ", eMail=" + eMail + ", phoneNumber=" + phoneNumber + ", headPicUrl="
				+ headPicUrl + ", idCardsNumber=" + idCardsNumber + ", qq=" + qq + ", birthday=" + birthday + ", sex="
				+ sex + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
    
}