package com.example.urlshortener.urlshortener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class AccessHistory {

    @Id
    @SequenceGenerator(
            name = "mapurl",
            sequenceName = "mapurl",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "mapurl"
    )
    private long id;
    private long urlid;
    private LocalDateTime accesstime;

    public AccessHistory() {
    }

    public AccessHistory(long urlid, LocalDateTime accesstime) {
        this.urlid = urlid;
        this.accesstime = accesstime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUrlid() {
        return urlid;
    }

    public void setUrlid(long urlid) {
        this.urlid = urlid;
    }

    public LocalDateTime getAccesstime() {
        return accesstime;
    }

    public void setAccesstime(LocalDateTime accesstime) {
        this.accesstime = accesstime;
    }

    @Override
    public String toString() {
        return "AccessHistory{" +
                "id=" + id +
                ", urlid=" + urlid +
                ", accesstime=" + accesstime +
                '}';
    }
}
