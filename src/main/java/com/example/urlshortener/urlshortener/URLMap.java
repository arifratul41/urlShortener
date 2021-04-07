package com.example.urlshortener.urlshortener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class URLMap {

    @Id
    @SequenceGenerator(
            name = "url",
            sequenceName = "url",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "url"
    )
    private long id;
    private long baseurl;
    private long mapurl;
    private LocalDateTime createdtime;

    public URLMap() {
    }

    public URLMap(long baseurl, long mapurl) {
        this.baseurl = baseurl;
        this.mapurl = mapurl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(long baseurl) {
        this.baseurl = baseurl;
    }

    public long getMapurl() {
        return mapurl;
    }

    public void setMapurl(long mapurl) {
        this.mapurl = mapurl;
    }

    public LocalDateTime getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(LocalDateTime createdtime) {
        this.createdtime = createdtime;
    }

    @Override
    public String toString() {
        return "URLMap{" +
                "id=" + id +
                ", baseurl=" + baseurl +
                ", mapurl=" + mapurl +
                ", createdtime=" + createdtime +
                '}';
    }
}
