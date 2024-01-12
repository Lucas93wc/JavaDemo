package com.lucas.httpAndhttps.https.entity;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-06-14 15:54
 */
public class AuditInfo {
    private String id;
    private String fileId;
    private String auditTime;
    private String opinion;
    private String tenantId;
    private String reviewer;
    private String stageId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getStageId() {
        return stageId;
    }

    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

    @Override
    public String toString() {
        return "AuditInfo{" +
                "id='" + id + '\'' +
                ", fileId='" + fileId + '\'' +
                ", auditTime='" + auditTime + '\'' +
                ", opinion='" + opinion + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", stageId='" + stageId + '\'' +
                '}';
    }
}
