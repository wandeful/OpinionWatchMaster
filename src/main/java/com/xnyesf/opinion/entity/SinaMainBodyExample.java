package com.xnyesf.opinion.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SinaMainBodyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SinaMainBodyExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNull() {
            addCriterion("blog_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNotNull() {
            addCriterion("blog_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogIdEqualTo(String value) {
            addCriterion("blog_id =", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotEqualTo(String value) {
            addCriterion("blog_id <>", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThan(String value) {
            addCriterion("blog_id >", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThanOrEqualTo(String value) {
            addCriterion("blog_id >=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThan(String value) {
            addCriterion("blog_id <", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThanOrEqualTo(String value) {
            addCriterion("blog_id <=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLike(String value) {
            addCriterion("blog_id like", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotLike(String value) {
            addCriterion("blog_id not like", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIn(List<String> values) {
            addCriterion("blog_id in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotIn(List<String> values) {
            addCriterion("blog_id not in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdBetween(String value1, String value2) {
            addCriterion("blog_id between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotBetween(String value1, String value2) {
            addCriterion("blog_id not between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andFollowersCountIsNull() {
            addCriterion("followers_count is null");
            return (Criteria) this;
        }

        public Criteria andFollowersCountIsNotNull() {
            addCriterion("followers_count is not null");
            return (Criteria) this;
        }

        public Criteria andFollowersCountEqualTo(String value) {
            addCriterion("followers_count =", value, "followersCount");
            return (Criteria) this;
        }

        public Criteria andFollowersCountNotEqualTo(String value) {
            addCriterion("followers_count <>", value, "followersCount");
            return (Criteria) this;
        }

        public Criteria andFollowersCountGreaterThan(String value) {
            addCriterion("followers_count >", value, "followersCount");
            return (Criteria) this;
        }

        public Criteria andFollowersCountGreaterThanOrEqualTo(String value) {
            addCriterion("followers_count >=", value, "followersCount");
            return (Criteria) this;
        }

        public Criteria andFollowersCountLessThan(String value) {
            addCriterion("followers_count <", value, "followersCount");
            return (Criteria) this;
        }

        public Criteria andFollowersCountLessThanOrEqualTo(String value) {
            addCriterion("followers_count <=", value, "followersCount");
            return (Criteria) this;
        }

        public Criteria andFollowersCountLike(String value) {
            addCriterion("followers_count like", value, "followersCount");
            return (Criteria) this;
        }

        public Criteria andFollowersCountNotLike(String value) {
            addCriterion("followers_count not like", value, "followersCount");
            return (Criteria) this;
        }

        public Criteria andFollowersCountIn(List<String> values) {
            addCriterion("followers_count in", values, "followersCount");
            return (Criteria) this;
        }

        public Criteria andFollowersCountNotIn(List<String> values) {
            addCriterion("followers_count not in", values, "followersCount");
            return (Criteria) this;
        }

        public Criteria andFollowersCountBetween(String value1, String value2) {
            addCriterion("followers_count between", value1, value2, "followersCount");
            return (Criteria) this;
        }

        public Criteria andFollowersCountNotBetween(String value1, String value2) {
            addCriterion("followers_count not between", value1, value2, "followersCount");
            return (Criteria) this;
        }

        public Criteria andFollowCountIsNull() {
            addCriterion("follow_count is null");
            return (Criteria) this;
        }

        public Criteria andFollowCountIsNotNull() {
            addCriterion("follow_count is not null");
            return (Criteria) this;
        }

        public Criteria andFollowCountEqualTo(String value) {
            addCriterion("follow_count =", value, "followCount");
            return (Criteria) this;
        }

        public Criteria andFollowCountNotEqualTo(String value) {
            addCriterion("follow_count <>", value, "followCount");
            return (Criteria) this;
        }

        public Criteria andFollowCountGreaterThan(String value) {
            addCriterion("follow_count >", value, "followCount");
            return (Criteria) this;
        }

        public Criteria andFollowCountGreaterThanOrEqualTo(String value) {
            addCriterion("follow_count >=", value, "followCount");
            return (Criteria) this;
        }

        public Criteria andFollowCountLessThan(String value) {
            addCriterion("follow_count <", value, "followCount");
            return (Criteria) this;
        }

        public Criteria andFollowCountLessThanOrEqualTo(String value) {
            addCriterion("follow_count <=", value, "followCount");
            return (Criteria) this;
        }

        public Criteria andFollowCountLike(String value) {
            addCriterion("follow_count like", value, "followCount");
            return (Criteria) this;
        }

        public Criteria andFollowCountNotLike(String value) {
            addCriterion("follow_count not like", value, "followCount");
            return (Criteria) this;
        }

        public Criteria andFollowCountIn(List<String> values) {
            addCriterion("follow_count in", values, "followCount");
            return (Criteria) this;
        }

        public Criteria andFollowCountNotIn(List<String> values) {
            addCriterion("follow_count not in", values, "followCount");
            return (Criteria) this;
        }

        public Criteria andFollowCountBetween(String value1, String value2) {
            addCriterion("follow_count between", value1, value2, "followCount");
            return (Criteria) this;
        }

        public Criteria andFollowCountNotBetween(String value1, String value2) {
            addCriterion("follow_count not between", value1, value2, "followCount");
            return (Criteria) this;
        }

        public Criteria andSourcesIsNull() {
            addCriterion("sources is null");
            return (Criteria) this;
        }

        public Criteria andSourcesIsNotNull() {
            addCriterion("sources is not null");
            return (Criteria) this;
        }

        public Criteria andSourcesEqualTo(String value) {
            addCriterion("sources =", value, "sources");
            return (Criteria) this;
        }

        public Criteria andSourcesNotEqualTo(String value) {
            addCriterion("sources <>", value, "sources");
            return (Criteria) this;
        }

        public Criteria andSourcesGreaterThan(String value) {
            addCriterion("sources >", value, "sources");
            return (Criteria) this;
        }

        public Criteria andSourcesGreaterThanOrEqualTo(String value) {
            addCriterion("sources >=", value, "sources");
            return (Criteria) this;
        }

        public Criteria andSourcesLessThan(String value) {
            addCriterion("sources <", value, "sources");
            return (Criteria) this;
        }

        public Criteria andSourcesLessThanOrEqualTo(String value) {
            addCriterion("sources <=", value, "sources");
            return (Criteria) this;
        }

        public Criteria andSourcesLike(String value) {
            addCriterion("sources like", value, "sources");
            return (Criteria) this;
        }

        public Criteria andSourcesNotLike(String value) {
            addCriterion("sources not like", value, "sources");
            return (Criteria) this;
        }

        public Criteria andSourcesIn(List<String> values) {
            addCriterion("sources in", values, "sources");
            return (Criteria) this;
        }

        public Criteria andSourcesNotIn(List<String> values) {
            addCriterion("sources not in", values, "sources");
            return (Criteria) this;
        }

        public Criteria andSourcesBetween(String value1, String value2) {
            addCriterion("sources between", value1, value2, "sources");
            return (Criteria) this;
        }

        public Criteria andSourcesNotBetween(String value1, String value2) {
            addCriterion("sources not between", value1, value2, "sources");
            return (Criteria) this;
        }

        public Criteria andCommentsCountIsNull() {
            addCriterion("comments_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentsCountIsNotNull() {
            addCriterion("comments_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsCountEqualTo(String value) {
            addCriterion("comments_count =", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountNotEqualTo(String value) {
            addCriterion("comments_count <>", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountGreaterThan(String value) {
            addCriterion("comments_count >", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountGreaterThanOrEqualTo(String value) {
            addCriterion("comments_count >=", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountLessThan(String value) {
            addCriterion("comments_count <", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountLessThanOrEqualTo(String value) {
            addCriterion("comments_count <=", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountLike(String value) {
            addCriterion("comments_count like", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountNotLike(String value) {
            addCriterion("comments_count not like", value, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountIn(List<String> values) {
            addCriterion("comments_count in", values, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountNotIn(List<String> values) {
            addCriterion("comments_count not in", values, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountBetween(String value1, String value2) {
            addCriterion("comments_count between", value1, value2, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andCommentsCountNotBetween(String value1, String value2) {
            addCriterion("comments_count not between", value1, value2, "commentsCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountIsNull() {
            addCriterion("attitudes_count is null");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountIsNotNull() {
            addCriterion("attitudes_count is not null");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountEqualTo(String value) {
            addCriterion("attitudes_count =", value, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountNotEqualTo(String value) {
            addCriterion("attitudes_count <>", value, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountGreaterThan(String value) {
            addCriterion("attitudes_count >", value, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountGreaterThanOrEqualTo(String value) {
            addCriterion("attitudes_count >=", value, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountLessThan(String value) {
            addCriterion("attitudes_count <", value, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountLessThanOrEqualTo(String value) {
            addCriterion("attitudes_count <=", value, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountLike(String value) {
            addCriterion("attitudes_count like", value, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountNotLike(String value) {
            addCriterion("attitudes_count not like", value, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountIn(List<String> values) {
            addCriterion("attitudes_count in", values, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountNotIn(List<String> values) {
            addCriterion("attitudes_count not in", values, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountBetween(String value1, String value2) {
            addCriterion("attitudes_count between", value1, value2, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andAttitudesCountNotBetween(String value1, String value2) {
            addCriterion("attitudes_count not between", value1, value2, "attitudesCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountIsNull() {
            addCriterion("reposts_count is null");
            return (Criteria) this;
        }

        public Criteria andRepostsCountIsNotNull() {
            addCriterion("reposts_count is not null");
            return (Criteria) this;
        }

        public Criteria andRepostsCountEqualTo(String value) {
            addCriterion("reposts_count =", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountNotEqualTo(String value) {
            addCriterion("reposts_count <>", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountGreaterThan(String value) {
            addCriterion("reposts_count >", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountGreaterThanOrEqualTo(String value) {
            addCriterion("reposts_count >=", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountLessThan(String value) {
            addCriterion("reposts_count <", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountLessThanOrEqualTo(String value) {
            addCriterion("reposts_count <=", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountLike(String value) {
            addCriterion("reposts_count like", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountNotLike(String value) {
            addCriterion("reposts_count not like", value, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountIn(List<String> values) {
            addCriterion("reposts_count in", values, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountNotIn(List<String> values) {
            addCriterion("reposts_count not in", values, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountBetween(String value1, String value2) {
            addCriterion("reposts_count between", value1, value2, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andRepostsCountNotBetween(String value1, String value2) {
            addCriterion("reposts_count not between", value1, value2, "repostsCount");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNull() {
            addCriterion("release_time is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNotNull() {
            addCriterion("release_time is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeEqualTo(Date value) {
            addCriterion("release_time =", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotEqualTo(Date value) {
            addCriterion("release_time <>", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThan(Date value) {
            addCriterion("release_time >", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("release_time >=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThan(Date value) {
            addCriterion("release_time <", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThanOrEqualTo(Date value) {
            addCriterion("release_time <=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIn(List<Date> values) {
            addCriterion("release_time in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotIn(List<Date> values) {
            addCriterion("release_time not in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeBetween(Date value1, Date value2) {
            addCriterion("release_time between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotBetween(Date value1, Date value2) {
            addCriterion("release_time not between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andStatusCountryIsNull() {
            addCriterion("status_country is null");
            return (Criteria) this;
        }

        public Criteria andStatusCountryIsNotNull() {
            addCriterion("status_country is not null");
            return (Criteria) this;
        }

        public Criteria andStatusCountryEqualTo(String value) {
            addCriterion("status_country =", value, "statusCountry");
            return (Criteria) this;
        }

        public Criteria andStatusCountryNotEqualTo(String value) {
            addCriterion("status_country <>", value, "statusCountry");
            return (Criteria) this;
        }

        public Criteria andStatusCountryGreaterThan(String value) {
            addCriterion("status_country >", value, "statusCountry");
            return (Criteria) this;
        }

        public Criteria andStatusCountryGreaterThanOrEqualTo(String value) {
            addCriterion("status_country >=", value, "statusCountry");
            return (Criteria) this;
        }

        public Criteria andStatusCountryLessThan(String value) {
            addCriterion("status_country <", value, "statusCountry");
            return (Criteria) this;
        }

        public Criteria andStatusCountryLessThanOrEqualTo(String value) {
            addCriterion("status_country <=", value, "statusCountry");
            return (Criteria) this;
        }

        public Criteria andStatusCountryLike(String value) {
            addCriterion("status_country like", value, "statusCountry");
            return (Criteria) this;
        }

        public Criteria andStatusCountryNotLike(String value) {
            addCriterion("status_country not like", value, "statusCountry");
            return (Criteria) this;
        }

        public Criteria andStatusCountryIn(List<String> values) {
            addCriterion("status_country in", values, "statusCountry");
            return (Criteria) this;
        }

        public Criteria andStatusCountryNotIn(List<String> values) {
            addCriterion("status_country not in", values, "statusCountry");
            return (Criteria) this;
        }

        public Criteria andStatusCountryBetween(String value1, String value2) {
            addCriterion("status_country between", value1, value2, "statusCountry");
            return (Criteria) this;
        }

        public Criteria andStatusCountryNotBetween(String value1, String value2) {
            addCriterion("status_country not between", value1, value2, "statusCountry");
            return (Criteria) this;
        }

        public Criteria andStatusProvinceIsNull() {
            addCriterion("status_province is null");
            return (Criteria) this;
        }

        public Criteria andStatusProvinceIsNotNull() {
            addCriterion("status_province is not null");
            return (Criteria) this;
        }

        public Criteria andStatusProvinceEqualTo(String value) {
            addCriterion("status_province =", value, "statusProvince");
            return (Criteria) this;
        }

        public Criteria andStatusProvinceNotEqualTo(String value) {
            addCriterion("status_province <>", value, "statusProvince");
            return (Criteria) this;
        }

        public Criteria andStatusProvinceGreaterThan(String value) {
            addCriterion("status_province >", value, "statusProvince");
            return (Criteria) this;
        }

        public Criteria andStatusProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("status_province >=", value, "statusProvince");
            return (Criteria) this;
        }

        public Criteria andStatusProvinceLessThan(String value) {
            addCriterion("status_province <", value, "statusProvince");
            return (Criteria) this;
        }

        public Criteria andStatusProvinceLessThanOrEqualTo(String value) {
            addCriterion("status_province <=", value, "statusProvince");
            return (Criteria) this;
        }

        public Criteria andStatusProvinceLike(String value) {
            addCriterion("status_province like", value, "statusProvince");
            return (Criteria) this;
        }

        public Criteria andStatusProvinceNotLike(String value) {
            addCriterion("status_province not like", value, "statusProvince");
            return (Criteria) this;
        }

        public Criteria andStatusProvinceIn(List<String> values) {
            addCriterion("status_province in", values, "statusProvince");
            return (Criteria) this;
        }

        public Criteria andStatusProvinceNotIn(List<String> values) {
            addCriterion("status_province not in", values, "statusProvince");
            return (Criteria) this;
        }

        public Criteria andStatusProvinceBetween(String value1, String value2) {
            addCriterion("status_province between", value1, value2, "statusProvince");
            return (Criteria) this;
        }

        public Criteria andStatusProvinceNotBetween(String value1, String value2) {
            addCriterion("status_province not between", value1, value2, "statusProvince");
            return (Criteria) this;
        }

        public Criteria andWeiboTextlengthIsNull() {
            addCriterion("weibo_textLength is null");
            return (Criteria) this;
        }

        public Criteria andWeiboTextlengthIsNotNull() {
            addCriterion("weibo_textLength is not null");
            return (Criteria) this;
        }

        public Criteria andWeiboTextlengthEqualTo(Integer value) {
            addCriterion("weibo_textLength =", value, "weiboTextlength");
            return (Criteria) this;
        }

        public Criteria andWeiboTextlengthNotEqualTo(Integer value) {
            addCriterion("weibo_textLength <>", value, "weiboTextlength");
            return (Criteria) this;
        }

        public Criteria andWeiboTextlengthGreaterThan(Integer value) {
            addCriterion("weibo_textLength >", value, "weiboTextlength");
            return (Criteria) this;
        }

        public Criteria andWeiboTextlengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("weibo_textLength >=", value, "weiboTextlength");
            return (Criteria) this;
        }

        public Criteria andWeiboTextlengthLessThan(Integer value) {
            addCriterion("weibo_textLength <", value, "weiboTextlength");
            return (Criteria) this;
        }

        public Criteria andWeiboTextlengthLessThanOrEqualTo(Integer value) {
            addCriterion("weibo_textLength <=", value, "weiboTextlength");
            return (Criteria) this;
        }

        public Criteria andWeiboTextlengthIn(List<Integer> values) {
            addCriterion("weibo_textLength in", values, "weiboTextlength");
            return (Criteria) this;
        }

        public Criteria andWeiboTextlengthNotIn(List<Integer> values) {
            addCriterion("weibo_textLength not in", values, "weiboTextlength");
            return (Criteria) this;
        }

        public Criteria andWeiboTextlengthBetween(Integer value1, Integer value2) {
            addCriterion("weibo_textLength between", value1, value2, "weiboTextlength");
            return (Criteria) this;
        }

        public Criteria andWeiboTextlengthNotBetween(Integer value1, Integer value2) {
            addCriterion("weibo_textLength not between", value1, value2, "weiboTextlength");
            return (Criteria) this;
        }

        public Criteria andSearchKeyIsNull() {
            addCriterion("search_key is null");
            return (Criteria) this;
        }

        public Criteria andSearchKeyIsNotNull() {
            addCriterion("search_key is not null");
            return (Criteria) this;
        }

        public Criteria andSearchKeyEqualTo(String value) {
            addCriterion("search_key =", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyNotEqualTo(String value) {
            addCriterion("search_key <>", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyGreaterThan(String value) {
            addCriterion("search_key >", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyGreaterThanOrEqualTo(String value) {
            addCriterion("search_key >=", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyLessThan(String value) {
            addCriterion("search_key <", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyLessThanOrEqualTo(String value) {
            addCriterion("search_key <=", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyLike(String value) {
            addCriterion("search_key like", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyNotLike(String value) {
            addCriterion("search_key not like", value, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyIn(List<String> values) {
            addCriterion("search_key in", values, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyNotIn(List<String> values) {
            addCriterion("search_key not in", values, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyBetween(String value1, String value2) {
            addCriterion("search_key between", value1, value2, "searchKey");
            return (Criteria) this;
        }

        public Criteria andSearchKeyNotBetween(String value1, String value2) {
            addCriterion("search_key not between", value1, value2, "searchKey");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Byte value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Byte value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Byte value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Byte value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Byte value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Byte> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Byte> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Byte value1, Byte value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}