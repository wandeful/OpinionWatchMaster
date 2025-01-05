package com.xnyesf.opinion.entity;

import java.io.Serializable;
import java.util.Date;

public class SinaMainBodyDO implements Serializable {
    private Integer id;

    private String blogId;

    private String userName;

    private String gender;

    private String followersCount;

    private String followCount;

    private String sources;

    private String commentsCount;

    private String attitudesCount;

    private String repostsCount;

    private Date releaseTime;

    private String statusCountry;

    private String statusProvince;

    private Integer weiboTextlength;

    private String searchKey;

    private Byte flag;

    private String weiboText;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(String followersCount) {
        this.followersCount = followersCount;
    }

    public String getFollowCount() {
        return followCount;
    }

    public void setFollowCount(String followCount) {
        this.followCount = followCount;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(String commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getAttitudesCount() {
        return attitudesCount;
    }

    public void setAttitudesCount(String attitudesCount) {
        this.attitudesCount = attitudesCount;
    }

    public String getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(String repostsCount) {
        this.repostsCount = repostsCount;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getStatusCountry() {
        return statusCountry;
    }

    public void setStatusCountry(String statusCountry) {
        this.statusCountry = statusCountry;
    }

    public String getStatusProvince() {
        return statusProvince;
    }

    public void setStatusProvince(String statusProvince) {
        this.statusProvince = statusProvince;
    }

    public Integer getWeiboTextlength() {
        return weiboTextlength;
    }

    public void setWeiboTextlength(Integer weiboTextlength) {
        this.weiboTextlength = weiboTextlength;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public String getWeiboText() {
        return weiboText;
    }

    public void setWeiboText(String weiboText) {
        this.weiboText = weiboText;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", blogId=").append(blogId);
        sb.append(", userName=").append(userName);
        sb.append(", gender=").append(gender);
        sb.append(", followersCount=").append(followersCount);
        sb.append(", followCount=").append(followCount);
        sb.append(", sources=").append(sources);
        sb.append(", commentsCount=").append(commentsCount);
        sb.append(", attitudesCount=").append(attitudesCount);
        sb.append(", repostsCount=").append(repostsCount);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", statusCountry=").append(statusCountry);
        sb.append(", statusProvince=").append(statusProvince);
        sb.append(", weiboTextlength=").append(weiboTextlength);
        sb.append(", searchKey=").append(searchKey);
        sb.append(", flag=").append(flag);
        sb.append(", weiboText=").append(weiboText);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}