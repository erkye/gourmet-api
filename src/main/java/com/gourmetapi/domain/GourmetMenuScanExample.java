package com.gourmetapi.domain;

import java.util.ArrayList;
import java.util.List;

public class GourmetMenuScanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GourmetMenuScanExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(Integer value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(Integer value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(Integer value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(Integer value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Integer> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Integer> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andPageviewsIsNull() {
            addCriterion("pageviews is null");
            return (Criteria) this;
        }

        public Criteria andPageviewsIsNotNull() {
            addCriterion("pageviews is not null");
            return (Criteria) this;
        }

        public Criteria andPageviewsEqualTo(Long value) {
            addCriterion("pageviews =", value, "pageviews");
            return (Criteria) this;
        }

        public Criteria andPageviewsNotEqualTo(Long value) {
            addCriterion("pageviews <>", value, "pageviews");
            return (Criteria) this;
        }

        public Criteria andPageviewsGreaterThan(Long value) {
            addCriterion("pageviews >", value, "pageviews");
            return (Criteria) this;
        }

        public Criteria andPageviewsGreaterThanOrEqualTo(Long value) {
            addCriterion("pageviews >=", value, "pageviews");
            return (Criteria) this;
        }

        public Criteria andPageviewsLessThan(Long value) {
            addCriterion("pageviews <", value, "pageviews");
            return (Criteria) this;
        }

        public Criteria andPageviewsLessThanOrEqualTo(Long value) {
            addCriterion("pageviews <=", value, "pageviews");
            return (Criteria) this;
        }

        public Criteria andPageviewsIn(List<Long> values) {
            addCriterion("pageviews in", values, "pageviews");
            return (Criteria) this;
        }

        public Criteria andPageviewsNotIn(List<Long> values) {
            addCriterion("pageviews not in", values, "pageviews");
            return (Criteria) this;
        }

        public Criteria andPageviewsBetween(Long value1, Long value2) {
            addCriterion("pageviews between", value1, value2, "pageviews");
            return (Criteria) this;
        }

        public Criteria andPageviewsNotBetween(Long value1, Long value2) {
            addCriterion("pageviews not between", value1, value2, "pageviews");
            return (Criteria) this;
        }

        public Criteria andFavoritesIsNull() {
            addCriterion("favorites is null");
            return (Criteria) this;
        }

        public Criteria andFavoritesIsNotNull() {
            addCriterion("favorites is not null");
            return (Criteria) this;
        }

        public Criteria andFavoritesEqualTo(Long value) {
            addCriterion("favorites =", value, "favorites");
            return (Criteria) this;
        }

        public Criteria andFavoritesNotEqualTo(Long value) {
            addCriterion("favorites <>", value, "favorites");
            return (Criteria) this;
        }

        public Criteria andFavoritesGreaterThan(Long value) {
            addCriterion("favorites >", value, "favorites");
            return (Criteria) this;
        }

        public Criteria andFavoritesGreaterThanOrEqualTo(Long value) {
            addCriterion("favorites >=", value, "favorites");
            return (Criteria) this;
        }

        public Criteria andFavoritesLessThan(Long value) {
            addCriterion("favorites <", value, "favorites");
            return (Criteria) this;
        }

        public Criteria andFavoritesLessThanOrEqualTo(Long value) {
            addCriterion("favorites <=", value, "favorites");
            return (Criteria) this;
        }

        public Criteria andFavoritesIn(List<Long> values) {
            addCriterion("favorites in", values, "favorites");
            return (Criteria) this;
        }

        public Criteria andFavoritesNotIn(List<Long> values) {
            addCriterion("favorites not in", values, "favorites");
            return (Criteria) this;
        }

        public Criteria andFavoritesBetween(Long value1, Long value2) {
            addCriterion("favorites between", value1, value2, "favorites");
            return (Criteria) this;
        }

        public Criteria andFavoritesNotBetween(Long value1, Long value2) {
            addCriterion("favorites not between", value1, value2, "favorites");
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