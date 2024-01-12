package com.lucas.httpAndhttps.https.entity;

import java.util.List;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-06-14 15:44
 */
public class FileInfo {
    // 审核记录
    private List<AuditInfo> auditInfo;
    // 文件名
    private String fileName;
    // 元数据文件下载地址
    private String fileMetaUrl;
    // 文件guid
    private String fileGuid;
    // 文件级数据项
    private FileDataInfo property;
    // 审核状态
    private String auditStatus;
    // 文件所属标签（项目、目录、阶段）
    private FileTag fileTagList;
    // 文件下载地址
    private String fileUrl;
    // 文件 id
    private String fileId;

    public List<AuditInfo> getAuditInfo() {
        return auditInfo;
    }

    public void setAuditInfo(List<AuditInfo> auditInfo) {
        this.auditInfo = auditInfo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileMetaUrl() {
        return fileMetaUrl;
    }

    public void setFileMetaUrl(String fileMetaUrl) {
        this.fileMetaUrl = fileMetaUrl;
    }

    public String getFileGuid() {
        return fileGuid;
    }

    public void setFileGuid(String fileGuid) {
        this.fileGuid = fileGuid;
    }

    public FileDataInfo getProperty() {
        return property;
    }

    public void setProperty(FileDataInfo property) {
        this.property = property;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public FileTag getFileTagList() {
        return fileTagList;
    }

    public void setFileTagList(FileTag fileTagList) {
        this.fileTagList = fileTagList;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "auditInfo=" + auditInfo +
                ", fileName='" + fileName + '\'' +
                ", fileMetaUrl='" + fileMetaUrl + '\'' +
                ", fileGuid='" + fileGuid + '\'' +
                ", property=" + property +
                ", auditStatus='" + auditStatus + '\'' +
                ", fileTagList=" + fileTagList +
                ", fileUrl='" + fileUrl + '\'' +
                ", fileId='" + fileId + '\'' +
                '}';
    }
}
