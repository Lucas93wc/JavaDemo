package com.lucas.httpAndhttps.https.entity;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-06-19 15:23
 */
public class UnitInfo {
  private String rowGuid;
  private String id;
  private String unitProjectGuid;
  // 单位工程名称
  private String dwgcmc;
  // 项目代码
  private String xmdm;
  // 建筑面积
  private Double jzmj;
  // 单位工程类型
  private String dwgclx;
  // 档案分类
  private String dafl;
  // 档案属类
  private String dasl;

  // 建筑工程施工许可证号
  private String jzgcsgxkzh;
  // 节能标准类别
  private String jnbzlx;
  // 抗震等级
  private String kzdj;
  // 设防烈度
  private String sfld;
  // 耐火等级
  private String nhdj;
  // 设计使用年限
  private Double sjsynx;
  // 合同开工日期
  private String htkgrq;
  // 合同竣工日期
  private String htjgrq;
  // 合同工期
  private Integer htgq;
  // 实际开工日期
  private String sjkgrq;
  // 实际竣工日期
  private String sjjgrq;
  // 实际工期
  private Integer sjgq;
  // 竣工验收日期
  private String jgysrq;
  // 坐标信息
  private String zbxx;
  // 备注
  private String bz;
  // 地上建筑高度
  private Double dsjzgd;
  // 地下建筑高度
  private Double dxjzgd;
  // 地上层数
  private Integer dscs;
  // 地下层数
  private Integer dxcs;

  public UnitInfo() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUnitProjectGuid() {
    return unitProjectGuid;
  }

  public void setUnitProjectGuid(String unitProjectGuid) {
    this.unitProjectGuid = unitProjectGuid;
  }

  public String getRowGuid() {
    return rowGuid;
  }

  public void setRowGuid(String rowGuid) {
    this.rowGuid = rowGuid;
  }

  public String getXmdm() {
    return xmdm;
  }

  public void setXmdm(String xmdm) {
    this.xmdm = xmdm;
  }

  public String getDwgcmc() {
    return dwgcmc;
  }

  public void setDwgcmc(String dwgcmc) {
    this.dwgcmc = dwgcmc;
  }

  public Double getJzmj() {
    return jzmj;
  }

  public void setJzmj(Double jzmj) {
    this.jzmj = jzmj;
  }

  public String getDwgclx() {
    return dwgclx;
  }

  public void setDwgclx(String dwgclx) {
    this.dwgclx = dwgclx;
  }

  public String getDafl() {
    return dafl;
  }

  public void setDafl(String dafl) {
    this.dafl = dafl;
  }

  public String getDasl() {
    return dasl;
  }

  public void setDasl(String dasl) {
    this.dasl = dasl;
  }

  public String getJzgcsgxkzh() {
    return jzgcsgxkzh;
  }

  public void setJzgcsgxkzh(String jzgcsgxkzh) {
    this.jzgcsgxkzh = jzgcsgxkzh;
  }

  public String getJnbzlx() {
    return jnbzlx;
  }

  public void setJnbzlx(String jnbzlx) {
    this.jnbzlx = jnbzlx;
  }

  public String getKzdj() {
    return kzdj;
  }

  public void setKzdj(String kzdj) {
    this.kzdj = kzdj;
  }

  public String getSfld() {
    return sfld;
  }

  public void setSfld(String sfld) {
    this.sfld = sfld;
  }

  public String getNhdj() {
    return nhdj;
  }

  public void setNhdj(String nhdj) {
    this.nhdj = nhdj;
  }

  public Double getSjsynx() {
    return sjsynx;
  }

  public void setSjsynx(Double sjsynx) {
    this.sjsynx = sjsynx;
  }

  public String getHtkgrq() {
    return htkgrq;
  }

  public void setHtkgrq(String htkgrq) {
    this.htkgrq = htkgrq;
  }

  public String getHtjgrq() {
    return htjgrq;
  }

  public void setHtjgrq(String htjgrq) {
    this.htjgrq = htjgrq;
  }

  public Integer getHtgq() {
    return htgq;
  }

  public void setHtgq(Integer htgq) {
    this.htgq = htgq;
  }

  public String getSjkgrq() {
    return sjkgrq;
  }

  public void setSjkgrq(String sjkgrq) {
    this.sjkgrq = sjkgrq;
  }

  public String getSjjgrq() {
    return sjjgrq;
  }

  public void setSjjgrq(String sjjgrq) {
    this.sjjgrq = sjjgrq;
  }

  public Integer getSjgq() {
    return sjgq;
  }

  public void setSjgq(Integer sjgq) {
    this.sjgq = sjgq;
  }

  public String getJgysrq() {
    return jgysrq;
  }

  public void setJgysrq(String jgysrq) {
    this.jgysrq = jgysrq;
  }

  public String getZbxx() {
    return zbxx;
  }

  public void setZbxx(String zbxx) {
    this.zbxx = zbxx;
  }

  public String getBz() {
    return bz;
  }

  public void setBz(String bz) {
    this.bz = bz;
  }

  public Double getDsjzgd() {
    return dsjzgd;
  }

  public void setDsjzgd(Double dsjzgd) {
    this.dsjzgd = dsjzgd;
  }

  public Double getDxjzgd() {
    return dxjzgd;
  }

  public void setDxjzgd(Double dxjzgd) {
    this.dxjzgd = dxjzgd;
  }

  public Integer getDscs() {
    return dscs;
  }

  public void setDscs(Integer dscs) {
    this.dscs = dscs;
  }

  public Integer getDxcs() {
    return dxcs;
  }

  public void setDxcs(Integer dxcs) {
    this.dxcs = dxcs;
  }

  @Override
  public String toString() {
    return "UnitInfo{" +
        "id='" + id + '\'' +
        ", unitProjectGuid='" + unitProjectGuid + '\'' +
        ", rowGuid='" + rowGuid + '\'' +
        ", xmdm='" + xmdm + '\'' +
        ", dwgcmc='" + dwgcmc + '\'' +
        ", jzmj=" + jzmj +
        ", dwgclx='" + dwgclx + '\'' +
        ", dafl='" + dafl + '\'' +
        ", dasl='" + dasl + '\'' +
        ", jzgcsgxkzh='" + jzgcsgxkzh + '\'' +
        ", jnbzlx='" + jnbzlx + '\'' +
        ", kzdj='" + kzdj + '\'' +
        ", sfld='" + sfld + '\'' +
        ", nhdj='" + nhdj + '\'' +
        ", sjsynx=" + sjsynx +
        ", htkgrq='" + htkgrq + '\'' +
        ", htjgrq='" + htjgrq + '\'' +
        ", htgq=" + htgq +
        ", sjkgrq='" + sjkgrq + '\'' +
        ", sjjgrq='" + sjjgrq + '\'' +
        ", sjgq=" + sjgq +
        ", jgysrq='" + jgysrq + '\'' +
        ", zbxx='" + zbxx + '\'' +
        ", bz='" + bz + '\'' +
        ", dsjzgd=" + dsjzgd +
        ", dxjzgd=" + dxjzgd +
        ", dscs=" + dscs +
        ", dxcs=" + dxcs +
        '}';
  }
}
