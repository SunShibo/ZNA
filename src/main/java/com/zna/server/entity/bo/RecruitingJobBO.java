package com.zna.server.entity.bo;

import com.zna.server.common.base.BaseModel;

import java.util.Date;

public class RecruitingJobBO extends BaseModel {
    private Integer id; //在招岗位表
    private String jobTitle; //职位名称
    private String jobTitleEnglish; //职位名称（英文）
    private String positionStatement; //岗位职责
    private String positionStatementEnglish; //岗位职责（英文）
    private String qualification; //任职资格
    private String qualificationEnglish; //任职资格（英文）
    private Integer createUserId; //创建人
    private Date createTime; //创建时间
    private Integer updateUserId; //修改人
    private Date updateTime; //修改时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitleEnglish() {
        return jobTitleEnglish;
    }

    public void setJobTitleEnglish(String jobTitleEnglish) {
        this.jobTitleEnglish = jobTitleEnglish;
    }

    public String getPositionStatement() {
        return positionStatement;
    }

    public void setPositionStatement(String positionStatement) {
        this.positionStatement = positionStatement;
    }

    public String getPositionStatementEnglish() {
        return positionStatementEnglish;
    }

    public void setPositionStatementEnglish(String positionStatementEnglish) {
        this.positionStatementEnglish = positionStatementEnglish;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getQualificationEnglish() {
        return qualificationEnglish;
    }

    public void setQualificationEnglish(String qualificationEnglish) {
        this.qualificationEnglish = qualificationEnglish;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "RecruitingJobBO{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobTitleEnglish='" + jobTitleEnglish + '\'' +
                ", positionStatement='" + positionStatement + '\'' +
                ", positionStatementEnglish='" + positionStatementEnglish + '\'' +
                ", qualification='" + qualification + '\'' +
                ", qualificationEnglish='" + qualificationEnglish + '\'' +
                ", createUserId=" + createUserId +
                ", createTime=" + createTime +
                ", updateUserId=" + updateUserId +
                ", updateTime=" + updateTime +
                '}';
    }
}
