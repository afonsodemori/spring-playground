package dev.afonso.springplayground.municipalities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Municipality {
    @Id
    private String code;
    private String name;
    private String idema;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdema() {
        return idema;
    }

    public void setIdema(String idema) {
        this.idema = idema;
    }
}
