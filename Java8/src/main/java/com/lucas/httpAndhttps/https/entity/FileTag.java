package com.lucas.httpAndhttps.https.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-06-14 16:04
 */
public class FileTag {
    @JsonProperty(value = "ZML")
    private List<String> zml;

    public List<String> getZML() {
        return zml;
    }

    public void setZML(List<String> zml) {
        this.zml = zml;
    }

    @Override
    public String toString() {
        return "FileTag{" +
                "zml=" + zml +
                '}';
    }
}
