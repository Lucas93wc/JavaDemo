package com.lucas.httpAndhttps.https.entity;

import java.util.List;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-06-13 16:31
 */
public class ProjectInfo {
    private String rowGuid;
    private String id;
    // 项目名称
    private String xmmc;
    // 行政区划代码
    private String xzqhdm;
    // 项目地址
    private String xmdz;
    // 工程造价
    private Double gczj;
    // 总建筑面积
    private Double zjzmj;
    // 总用地面积
    private Double zydmj;
    // 土地使用年限
    private Integer tdsynx;
    // 计划开工日期
    private String jhkgrq;
    // 计划竣工日期
    private String jhjgrq;
    // 工程类型
    private String gclx;
    // 建设单位
    private String jsdw;
    // 代建单位
    private String djdw;
    // 设计单位
    private String sjdw;
    // 勘察单位
    private String kcdw;
    // 监理单位
    private String jldw;
    // 施工单位
    private String sgdw;
    // 立项批准单位
    private String lxpzdw;
    // 项目代码
    private String xmdm;
    // 立项批准文号
    private String lxpzwh;
    // 建设用地规划许可证号
    private String jsydghxkzh;
    // 建设工程规划许可证号
    private String jsgcghxkzh;
    // 国有土地使用证号
    private String gytdsyzh;
    // 联合验收合格书文号
    private String lhyshgswh;
    // 地上停车位数
    private Integer dstcws;
    // 地下停车位数
    private Integer dxtcws;
    // 移交单位
    private String yjdw;
    // 消防验收日期
    private String xfysrq;
    // 环保验收日期
    private String hbysrq;
    // 人防验收日期
    private String rfysrq;
    // 规划验收日期
    private String ghysrq;
    // 住建验收日期
    private String zjysrq;
    // 联合验收日期
    private String lhysrq;
    // 项目档案负责人
    private String xmdafzr;
    // 项目档案负责人联系电话
    private String xmdafzrlxdh;
    // 土地码
    private String tdm;
    // 归档时间
    private String gdsj;
    // 建筑工程施工许可证号
    private String jsgcsgxkzh;
    // 市代码
    private String cityNum;
    // 区、县代码
    private String countyNum;
    // 建设单位社会信用码
    private String jsdwCode;
    // 建设单位联系人
    private String jsdwLeader;
    // 建设单位联系人电话
    private String jsdwPhone;
    // 索赔人ID？
    private String claimantId;
    private List<UnitInfo> units;

    public ProjectInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRowGuid() {
        return rowGuid;
    }

    public void setRowGuid(String rowGuid) {
        this.rowGuid = rowGuid;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getJsgcsgxkzh() {
        return jsgcsgxkzh;
    }

    public void setJsgcsgxkzh(String jsgcsgxkzh) {
        this.jsgcsgxkzh = jsgcsgxkzh;
    }

    public String getXzqhdm() {
        return xzqhdm;
    }

    public void setXzqhdm(String xzqhdm) {
        this.xzqhdm = xzqhdm;
    }

    public String getXmdz() {
        return xmdz;
    }

    public void setXmdz(String xmdz) {
        this.xmdz = xmdz;
    }

    public Double getGczj() {
        return gczj;
    }

    public void setGczj(Double gczj) {
        this.gczj = gczj;
    }

    public Double getZjzmj() {
        return zjzmj;
    }

    public void setZjzmj(Double zjzmj) {
        this.zjzmj = zjzmj;
    }

    public Double getZydmj() {
        return zydmj;
    }

    public void setZydmj(Double zydmj) {
        this.zydmj = zydmj;
    }

    public Integer getTdsynx() {
        return tdsynx;
    }

    public void setTdsynx(Integer tdsynx) {
        this.tdsynx = tdsynx;
    }

    public String getJhkgrq() {
        return jhkgrq;
    }

    public void setJhkgrq(String jhkgrq) {
        this.jhkgrq = jhkgrq;
    }

    public String getJhjgrq() {
        return jhjgrq;
    }

    public void setJhjgrq(String jhjgrq) {
        this.jhjgrq = jhjgrq;
    }

    public String getGclx() {
        return gclx;
    }

    public void setGclx(String gclx) {
        this.gclx = gclx;
    }

    public String getJsdw() {
        return jsdw;
    }

    public void setJsdw(String jsdw) {
        this.jsdw = jsdw;
    }

    public String getDjdw() {
        return djdw;
    }

    public void setDjdw(String djdw) {
        this.djdw = djdw;
    }

    public String getSjdw() {
        return sjdw;
    }

    public void setSjdw(String sjdw) {
        this.sjdw = sjdw;
    }

    public String getKcdw() {
        return kcdw;
    }

    public void setKcdw(String kcdw) {
        this.kcdw = kcdw;
    }

    public String getJldw() {
        return jldw;
    }

    public void setJldw(String jldw) {
        this.jldw = jldw;
    }

    public String getSgdw() {
        return sgdw;
    }

    public void setSgdw(String sgdw) {
        this.sgdw = sgdw;
    }

    public String getLxpzdw() {
        return lxpzdw;
    }

    public void setLxpzdw(String lxpzdw) {
        this.lxpzdw = lxpzdw;
    }

    public String getXmdm() {
        return xmdm;
    }

    public void setXmdm(String xmdm) {
        this.xmdm = xmdm;
    }

    public String getLxpzwh() {
        return lxpzwh;
    }

    public void setLxpzwh(String lxpzwh) {
        this.lxpzwh = lxpzwh;
    }

    public String getJsydghxkzh() {
        return jsydghxkzh;
    }

    public void setJsydghxkzh(String jsydghxkzh) {
        this.jsydghxkzh = jsydghxkzh;
    }

    public String getJsgcghxkzh() {
        return jsgcghxkzh;
    }

    public void setJsgcghxkzh(String jsgcghxkzh) {
        this.jsgcghxkzh = jsgcghxkzh;
    }

    public String getGytdsyzh() {
        return gytdsyzh;
    }

    public void setGytdsyzh(String gytdsyzh) {
        this.gytdsyzh = gytdsyzh;
    }

    public String getLhyshgswh() {
        return lhyshgswh;
    }

    public void setLhyshgswh(String lhyshgswh) {
        this.lhyshgswh = lhyshgswh;
    }

    public Integer getDstcws() {
        return dstcws;
    }

    public void setDstcws(Integer dstcws) {
        this.dstcws = dstcws;
    }

    public Integer getDxtcws() {
        return dxtcws;
    }

    public void setDxtcws(Integer dxtcws) {
        this.dxtcws = dxtcws;
    }

    public String getYjdw() {
        return yjdw;
    }

    public void setYjdw(String yjdw) {
        this.yjdw = yjdw;
    }

    public String getXfysrq() {
        return xfysrq;
    }

    public void setXfysrq(String xfysrq) {
        this.xfysrq = xfysrq;
    }

    public String getHbysrq() {
        return hbysrq;
    }

    public void setHbysrq(String hbysrq) {
        this.hbysrq = hbysrq;
    }

    public String getRfysrq() {
        return rfysrq;
    }

    public void setRfysrq(String rfysrq) {
        this.rfysrq = rfysrq;
    }

    public String getGhysrq() {
        return ghysrq;
    }

    public void setGhysrq(String ghysrq) {
        this.ghysrq = ghysrq;
    }

    public String getZjysrq() {
        return zjysrq;
    }

    public void setZjysrq(String zjysrq) {
        this.zjysrq = zjysrq;
    }

    public String getLhysrq() {
        return lhysrq;
    }

    public void setLhysrq(String lhysrq) {
        this.lhysrq = lhysrq;
    }

    public String getXmdafzr() {
        return xmdafzr;
    }

    public void setXmdafzr(String xmdafzr) {
        this.xmdafzr = xmdafzr;
    }

    public String getXmdafzrlxdh() {
        return xmdafzrlxdh;
    }

    public void setXmdafzrlxdh(String xmdafzrlxdh) {
        this.xmdafzrlxdh = xmdafzrlxdh;
    }

    public String getTdm() {
        return tdm;
    }

    public void setTdm(String tdm) {
        this.tdm = tdm;
    }

    public String getGdsj() {
        return gdsj;
    }

    public void setGdsj(String gdsj) {
        this.gdsj = gdsj;
    }

    public String getCityNum() {
        return cityNum;
    }

    public void setCityNum(String cityNum) {
        this.cityNum = cityNum;
    }

    public String getCountyNum() {
        return countyNum;
    }

    public void setCountyNum(String countyNum) {
        this.countyNum = countyNum;
    }

    public String getJsdwCode() {
        return jsdwCode;
    }

    public void setJsdwCode(String jsdwCode) {
        this.jsdwCode = jsdwCode;
    }

    public String getJsdwLeader() {
        return jsdwLeader;
    }

    public void setJsdwLeader(String jsdwLeader) {
        this.jsdwLeader = jsdwLeader;
    }

    public String getJsdwPhone() {
        return jsdwPhone;
    }

    public void setJsdwPhone(String jsdwPhone) {
        this.jsdwPhone = jsdwPhone;
    }

    public String getClaimantId() {
        return claimantId;
    }

    public void setClaimantId(String claimantId) {
        this.claimantId = claimantId;
    }

    public List<UnitInfo> getUnits() {
        return units;
    }

    public void setUnits(List<UnitInfo> units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "ProjectInfo{" +
            "id='" + id + '\'' +
            ", rowGuid='" + rowGuid + '\'' +
            ", xmmc='" + xmmc + '\'' +
            ", jsgcsgxkzh='" + jsgcsgxkzh + '\'' +
            ", xzqhdm='" + xzqhdm + '\'' +
            ", xmdz='" + xmdz + '\'' +
            ", gczj=" + gczj +
            ", zjzmj=" + zjzmj +
            ", zydmj=" + zydmj +
            ", tdsynx='" + tdsynx + '\'' +
            ", jhkgrq='" + jhkgrq + '\'' +
            ", jhjgrq='" + jhjgrq + '\'' +
            ", gclx='" + gclx + '\'' +
            ", jsdw='" + jsdw + '\'' +
            ", djdw='" + djdw + '\'' +
            ", sjdw='" + sjdw + '\'' +
            ", kcdw='" + kcdw + '\'' +
            ", jldw='" + jldw + '\'' +
            ", sgdw='" + sgdw + '\'' +
            ", lxpzdw='" + lxpzdw + '\'' +
            ", xmdm='" + xmdm + '\'' +
            ", lxpzwh='" + lxpzwh + '\'' +
            ", jsydghxkzh='" + jsydghxkzh + '\'' +
            ", jsgcghxkzh='" + jsgcghxkzh + '\'' +
            ", gytdsyzh='" + gytdsyzh + '\'' +
            ", lhyshgswh='" + lhyshgswh + '\'' +
            ", dstcws=" + dstcws +
            ", dxtcws=" + dxtcws +
            ", yjdw='" + yjdw + '\'' +
            ", xfysrq='" + xfysrq + '\'' +
            ", hbysrq='" + hbysrq + '\'' +
            ", rfysrq='" + rfysrq + '\'' +
            ", ghysrq='" + ghysrq + '\'' +
            ", zjysrq='" + zjysrq + '\'' +
            ", lhysrq='" + lhysrq + '\'' +
            ", xmdafzr='" + xmdafzr + '\'' +
            ", xmdafzrlxdh='" + xmdafzrlxdh + '\'' +
            ", tdm='" + tdm + '\'' +
            ", gdsj='" + gdsj + '\'' +
            ", cityNum='" + cityNum + '\'' +
            ", countyNum='" + countyNum + '\'' +
            ", jsdwCode='" + jsdwCode + '\'' +
            ", jsdwLeader='" + jsdwLeader + '\'' +
            ", jsdwPhone='" + jsdwPhone + '\'' +
            ", claimantId='" + claimantId + '\'' +
            ", units=" + units +
            '}';
    }
}
