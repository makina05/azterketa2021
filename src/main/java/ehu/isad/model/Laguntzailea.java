package ehu.isad.model;

public class Laguntzailea {
    private Integer idCMS;
    private String version;
    private String md5;
    private String path;
    private String url;

    public Laguntzailea(Integer idCMS, String version, String md5, String path, String url) {
        this.idCMS = idCMS;
        this.version = version;
        this.md5 = md5;
        this.path = path;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIdCMS() {
        return idCMS;
    }

    public void setIdCMS(Integer idCMS) {
        this.idCMS = idCMS;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

